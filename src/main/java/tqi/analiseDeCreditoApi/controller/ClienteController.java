package tqi.analiseDeCreditoApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tqi.analiseDeCreditoApi.dto.response.MessageResponseDTO;
import tqi.analiseDeCreditoApi.entities.Cliente;
import tqi.analiseDeCreditoApi.exceptions.ClienteNotFoundException;
import tqi.analiseDeCreditoApi.service.ClienteService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('cliente:create')")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createCliente(@RequestBody @Valid Cliente cliente) {
        return clienteService.createcliente(cliente);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('cliente:read')")
    public List<Cliente> listAll() {
        return clienteService.listAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('cliente:read')")
    public Cliente findById(@PathVariable Long id) throws ClienteNotFoundException {
        return clienteService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('cliente:modify')")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid Cliente cliente)
            throws ClienteNotFoundException {
        return clienteService.updateById(id, cliente);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('cliente:modify')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ClienteNotFoundException {
        clienteService.delete(id);
    }
}
