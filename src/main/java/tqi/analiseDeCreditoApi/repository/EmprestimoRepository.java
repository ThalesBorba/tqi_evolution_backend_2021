package tqi.analiseDeCreditoApi.repository;

import tqi.analiseDeCreditoApi.entities.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}
