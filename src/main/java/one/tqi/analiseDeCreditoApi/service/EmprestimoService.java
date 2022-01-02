package one.tqi.analiseDeCreditoApi.service;

import one.tqi.analiseDeCreditoApi.dto.request.EmprestimoDTO;
import one.tqi.analiseDeCreditoApi.dto.response.MessageResponseDTO;
import one.tqi.analiseDeCreditoApi.entities.Emprestimo;
import one.tqi.analiseDeCreditoApi.exceptions.EmprestimoNotFoundException;
import one.tqi.analiseDeCreditoApi.mapper.EmprestimoMapper;
import one.tqi.analiseDeCreditoApi.repository.EmprestimoRepository;
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

    public MessageResponseDTO createEmprestimo(EmprestimoDTO emprestimoDTO) {
        Emprestimo savedEmprestimo = getEmprestimo(emprestimoDTO);
        return createMessageResponse(savedEmprestimo.getId(), "Created ");
    }

    public MessageResponseDTO updateById(Long id, EmprestimoDTO emprestimoDTO) throws EmprestimoNotFoundException {
        verifyIfExists(id);
        Emprestimo updatedEmprestimo = getEmprestimo(emprestimoDTO);
        return createMessageResponse(updatedEmprestimo.getId(), "Updated ");
    }

    public List<EmprestimoDTO> listAll() {
        List<Emprestimo> allEmprestimos = emprestimoRepository.findAll();
        return EmprestimosList(allEmprestimos);
    }

    public EmprestimoDTO findById(Long id) throws EmprestimoNotFoundException {
        Emprestimo emprestimo = verifyIfExists(id);
        return emprestimoMapper.toDTO(emprestimo);
    }

    public void delete(Long id) throws EmprestimoNotFoundException {
        verifyIfExists(id);
        emprestimoRepository.deleteById(id);
    }

    private Emprestimo getEmprestimo(EmprestimoDTO emprestimoDTO) {
        Emprestimo EmprestimoToSave = emprestimoMapper.toModel(emprestimoDTO);
        return emprestimoRepository.save(EmprestimoToSave);
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

    private List<EmprestimoDTO> EmprestimosList(List<Emprestimo> allEmprestimos) {
        return allEmprestimos.stream()
                .map(emprestimoMapper::toDTO)
                .collect(Collectors.toList());
    }
}