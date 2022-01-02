package one.tqi.analiseDeCreditoApi.controller;

import one.tqi.analiseDeCreditoApi.dto.response.MessageResponseDTO;
import one.tqi.analiseDeCreditoApi.entities.Cliente;
import one.tqi.analiseDeCreditoApi.exceptions.ClienteNotFoundException;
import one.tqi.analiseDeCreditoApi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createcliente(@RequestBody @Valid Cliente cliente) {
        return clienteService.createcliente(cliente);
    }

    @GetMapping
    public List<Cliente> listAll() {
        return clienteService.listAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id) throws ClienteNotFoundException {
        return  clienteService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid Cliente cliente)
            throws ClienteNotFoundException {
        return clienteService.updateById(id, cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ClienteNotFoundException {
        clienteService.delete(id);
    }

}