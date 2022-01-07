package tqi.analiseDeCreditoApi.controller;

import tqi.analiseDeCreditoApi.dto.request.CreateEmprestimoDTO;
import tqi.analiseDeCreditoApi.dto.response.MessageResponseDTO;
import tqi.analiseDeCreditoApi.dto.response.ReturnEmprestimoDetailsDTO;
import tqi.analiseDeCreditoApi.exceptions.EmprestimoNotFoundException;
import tqi.analiseDeCreditoApi.service.EmprestimoService;
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
    public MessageResponseDTO createEmprestimo(@RequestBody @Valid CreateEmprestimoDTO createEmprestimoDTO) {
        //se quantidade de parcelas maior que 60, quebra
        return emprestimoService.createEmprestimo(createEmprestimoDTO);
    }

    @GetMapping
    public List<ReturnEmprestimoDetailsDTO> listAll() {
        return emprestimoService.listAll();
    }

    @GetMapping("/{id}")
    public ReturnEmprestimoDetailsDTO findById(@PathVariable Long id) throws EmprestimoNotFoundException {
        return emprestimoService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid CreateEmprestimoDTO emprestimoDTO)
            throws EmprestimoNotFoundException {
        return emprestimoService.updateById(id, emprestimoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws EmprestimoNotFoundException {
        emprestimoService.delete(id);
    }
}
