package one.tqi.analiseDeCreditoApi.service;

import one.tqi.analiseDeCreditoApi.dto.response.MessageResponseDTO;
import one.tqi.analiseDeCreditoApi.entities.Cliente;
import one.tqi.analiseDeCreditoApi.exceptions.ClienteNotFoundException;
import one.tqi.analiseDeCreditoApi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public MessageResponseDTO createcliente(Cliente cliente) {
        Cliente savedcliente = getCliente(cliente);
        return createMessageResponse(savedcliente.getId(), "Created ");
    }

    public MessageResponseDTO updateById(Long id, Cliente cliente) throws ClienteNotFoundException {
        verifyIfExists(id);
        Cliente updatedcliente = getCliente(cliente);
        return createMessageResponse(updatedcliente.getId(), "Updated ");
    }

    public List<Cliente> listAll() {
        List<Cliente> allclientes = clienteRepository.findAll();
        return allclientes;
    }

    public void delete(Long id) throws ClienteNotFoundException {
        verifyIfExists(id);
        clienteRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(Long id, String s) {
        return MessageResponseDTO.builder()
                .message(s + "cliente with the ID " + id)
                .build();
    }

    private Cliente verifyIfExists(Long id) throws ClienteNotFoundException {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }

    private Cliente getCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente findById(Long id) throws ClienteNotFoundException {
        Cliente cliente = verifyIfExists(id);
        return cliente;
    }
}