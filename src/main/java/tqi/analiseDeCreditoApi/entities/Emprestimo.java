package tqi.analiseDeCreditoApi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @Column(nullable = false)
    private double valorDoEmprestimo;

    @Column
    private LocalDate dataDaPrimeiraParcela;

    @Column(nullable = false)
    private int quantidadeDeParcelas;

}
