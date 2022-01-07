package tqi.analiseDeCreditoApi.service;

import tqi.analiseDeCreditoApi.dto.request.CreateEmprestimoDTO;
import tqi.analiseDeCreditoApi.dto.response.ReturnEmprestimoDetailsDTO;
import tqi.analiseDeCreditoApi.dto.response.MessageResponseDTO;
import tqi.analiseDeCreditoApi.entities.Emprestimo;
import tqi.analiseDeCreditoApi.exceptions.EmprestimoNotFoundException;
import tqi.analiseDeCreditoApi.mapper.EmprestimoMapper;
import tqi.analiseDeCreditoApi.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmprestimoService {

    private EmprestimoRepository emprestimoRepository;

    private final EmprestimoMapper emprestimoMapper = EmprestimoMapper.INSTANCE;

    @Autowired
    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public MessageResponseDTO createEmprestimo(CreateEmprestimoDTO createEmprestimoDTO) {
        Emprestimo savedEmprestimo = getEmprestimo(createEmprestimoDTO);
        return createMessageResponse(savedEmprestimo.getId(), "Created ");
    }

    public MessageResponseDTO updateById(Long id, CreateEmprestimoDTO createEmprestimoDTO) throws EmprestimoNotFoundException {
        verifyIfExists(id);
        Emprestimo updatedEmprestimo = getEmprestimo(createEmprestimoDTO);
        return createMessageResponse(updatedEmprestimo.getId(), "Updated ");
    }

    public List<ReturnEmprestimoDetailsDTO> listAll() {
        List<Emprestimo> allEmprestimos = emprestimoRepository.findAll();
        return EmprestimosList(allEmprestimos);
    }

    public ReturnEmprestimoDetailsDTO findById(Long id) throws EmprestimoNotFoundException {
        Emprestimo emprestimo = verifyIfExists(id);
        return emprestimoMapper.toDTO(emprestimo);
    }

    public void delete(Long id) throws EmprestimoNotFoundException {
        verifyIfExists(id);
        emprestimoRepository.deleteById(id);
    }

    private Emprestimo getEmprestimo(CreateEmprestimoDTO createEmprestimoDTO) {
        Emprestimo emprestimoToSave = emprestimoMapper.toModel(createEmprestimoDTO);
        return emprestimoRepository.save(emprestimoToSave);
    }

    private MessageResponseDTO createMessageResponse(Long id, String s) {
        return MessageResponseDTO.builder()
                .message(s + "Emprestimo with the ID " + id)
                .build();
    }

    private Emprestimo verifyIfExists(Long id) throws EmprestimoNotFoundException {
        return emprestimoRepository.findById(id)
                .orElseThrow(() -> new EmprestimoNotFoundException(id));
    }

    private List<ReturnEmprestimoDetailsDTO> EmprestimosList(List<Emprestimo> allEmprestimos) {
        return allEmprestimos.stream()
                .map(emprestimoMapper::toDTO)
                .collect(Collectors.toList());
    }
}