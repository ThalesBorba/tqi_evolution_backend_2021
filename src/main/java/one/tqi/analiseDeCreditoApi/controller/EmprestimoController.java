package one.tqi.analiseDeCreditoApi.controller;

import one.tqi.analiseDeCreditoApi.dto.request.EmprestimoDTO;
import one.tqi.analiseDeCreditoApi.dto.response.MessageResponseDTO;
import one.tqi.analiseDeCreditoApi.exceptions.EmprestimoNotFoundException;
import one.tqi.analiseDeCreditoApi.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createEmprestimo(@RequestBody @Valid EmprestimoDTO emprestimoDTO) {
        return emprestimoService.createEmprestimo(emprestimoDTO);
    }

    @GetMapping
    public List<EmprestimoDTO> listAll() {
        return emprestimoService.listAll();
    }

    @GetMapping("/{id}")
    public EmprestimoDTO findById(@PathVariable Long id) throws EmprestimoNotFoundException {
        return emprestimoService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid EmprestimoDTO emprestimoDTO)
            throws EmprestimoNotFoundException {
        return emprestimoService.updateById(id, emprestimoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws EmprestimoNotFoundException {
        emprestimoService.delete(id);
    }
}
