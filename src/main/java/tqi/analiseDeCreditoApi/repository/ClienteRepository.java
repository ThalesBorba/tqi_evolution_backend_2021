package tqi.analiseDeCreditoApi.repository;

import tqi.analiseDeCreditoApi.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
