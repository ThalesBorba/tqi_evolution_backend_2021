package tqi.analiseDeCreditoApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tqi.analiseDeCreditoApi.dto.request.CreateEmprestimoDTO;
import tqi.analiseDeCreditoApi.dto.response.MessageResponseDTO;
import tqi.analiseDeCreditoApi.dto.response.ReturnEmprestimoDetailsDTO;
import tqi.analiseDeCreditoApi.entities.Emprestimo;
import tqi.analiseDeCreditoApi.exceptions.EmprestimoNotFoundException;
import tqi.analiseDeCreditoApi.exceptions.IllegalDateException;
import tqi.analiseDeCreditoApi.exceptions.IllegalQuotaException;
import tqi.analiseDeCreditoApi.service.EmprestimoService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private final EmprestimoService emprestimoService;

    @Autowired
    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('emprestimo:create')")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createEmprestimo(@RequestBody @Valid CreateEmprestimoDTO createEmprestimoDTO)
            throws IllegalArgumentException, IllegalQuotaException, IllegalDateException {
        return emprestimoService.createEmprestimo(createEmprestimoDTO);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('emprestimo:read')")
    public List<Emprestimo> listAll() {
        return emprestimoService.listAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('emprestimo:read')")
    public ReturnEmprestimoDetailsDTO findById(@PathVariable Long id) throws EmprestimoNotFoundException {
        return emprestimoService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('emprestimo:modify')")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid CreateEmprestimoDTO emprestimoDTO)
            throws EmprestimoNotFoundException, IllegalQuotaException, IllegalDateException {
        return emprestimoService.updateById(id, emprestimoDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('emprestimo:modify')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws EmprestimoNotFoundException {
        emprestimoService.delete(id);
    }
}
