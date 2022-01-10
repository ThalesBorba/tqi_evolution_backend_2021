package tqi.analiseDeCreditoApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tqi.analiseDeCreditoApi.dto.request.CreateEmprestimoDTO;
import tqi.analiseDeCreditoApi.dto.response.MessageResponseDTO;
import tqi.analiseDeCreditoApi.dto.response.ReturnEmprestimoDetailsDTO;
import tqi.analiseDeCreditoApi.entities.Emprestimo;
import tqi.analiseDeCreditoApi.exceptions.EmprestimoNotFoundException;
import tqi.analiseDeCreditoApi.exceptions.IllegalDateException;
import tqi.analiseDeCreditoApi.exceptions.IllegalQuotaException;
import tqi.analiseDeCreditoApi.mapper.EmprestimoMapper;
import tqi.analiseDeCreditoApi.repository.EmprestimoRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EmprestimoService {

    private EmprestimoRepository emprestimoRepository;

    private final EmprestimoMapper emprestimoMapper = EmprestimoMapper.INSTANCE;

    @Autowired
    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public MessageResponseDTO createEmprestimo(CreateEmprestimoDTO createEmprestimoDTO)
            throws IllegalQuotaException, IllegalDateException {
        Emprestimo savedEmprestimo = getEmprestimo(createEmprestimoDTO);
        return createMessageResponse(savedEmprestimo.getId(), "Created ");
    }

    public ReturnEmprestimoDetailsDTO findById(Long id) throws EmprestimoNotFoundException {
        Emprestimo emprestimo = verifyIfExists(id);
        return emprestimoMapper.toDTO(emprestimo);
    }

    public List<Emprestimo> listAll() {
        List<Emprestimo> allEmprestimos;
        allEmprestimos = emprestimoRepository.findAll();
        return allEmprestimos;
    }

    public MessageResponseDTO updateById(Long id, CreateEmprestimoDTO createEmprestimoDTO)
            throws EmprestimoNotFoundException, IllegalQuotaException, IllegalDateException {
        verifyIfExists(id);
        CreateEmprestimoDTO validEmprestimo = emprestimoIsValid(createEmprestimoDTO);
        Emprestimo updatedEmprestimo = getEmprestimo(validEmprestimo);
        return createMessageResponse(updatedEmprestimo.getId(), "Updated ");
    }

    public void delete(Long id) throws EmprestimoNotFoundException {
        verifyIfExists(id);
        emprestimoRepository.deleteById(id);
    }

    private Emprestimo getEmprestimo(CreateEmprestimoDTO createEmprestimoDTO)
            throws IllegalQuotaException, IllegalDateException {
        CreateEmprestimoDTO validEmprestimo = emprestimoIsValid(createEmprestimoDTO);
        Emprestimo emprestimoToSave = emprestimoMapper.toModel(validEmprestimo);
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

    private CreateEmprestimoDTO emprestimoIsValid(CreateEmprestimoDTO createEmprestimoDTO)
            throws IllegalQuotaException, IllegalDateException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if(createEmprestimoDTO.getValorDoEmprestimo() > 60) {
            throw new IllegalQuotaException();
        } else if(LocalDate.parse(createEmprestimoDTO.getDataDaPrimeiraParcela(), formatter).isAfter(date.plusMonths(3))) {
            throw new IllegalDateException();
        } else return createEmprestimoDTO;
    }

}