package one.tqi.analiseDeCreditoApi.repository;

import one.tqi.analiseDeCreditoApi.entities.Cliente;
import one.tqi.analiseDeCreditoApi.entities.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
