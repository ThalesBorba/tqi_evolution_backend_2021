package one.tqi.analiseDeCreditoApi.controller;

import one.tqi.analiseDeCreditoApi.dto.response.MessageResponseDTO;
import one.tqi.analiseDeCreditoApi.entities.Cliente;
import one.tqi.analiseDeCreditoApi.exceptions.ClienteNotFoundException;
import one.tqi.analiseDeCreditoApi.repository.ClienteRepository;
import one.tqi.analiseDeCreditoApi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ClienteService clientService;


    @GetMapping("search/byEmail")
    public Cliente getByEmail(@Param("email") String email) {

        return clientService.findByEmail(email);
    }

    //busca por cpf
    @GetMapping("search/byCpf")
    public Cliente getByCpf(@Param("cpf") String cpf) {

        return clientService.findByCpf(cpf);
    }

    @PostMapping
    public ResponseEntity<ClientDto> save(@RequestBody CreateClientDto createClientDto) {

        ClientDto clientDto = clientService.save(createClientDto);
        if (clientDto == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(clientDto, HttpStatus.CREATED);
        }
    }
}