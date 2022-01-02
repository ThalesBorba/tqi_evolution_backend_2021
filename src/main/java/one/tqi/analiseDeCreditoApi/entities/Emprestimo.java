package one.tqi.analiseDeCreditoApi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double valorDoEmprestimo;

    @Column
    private String dataDaPrimeiraParcela;

    @Column(nullable = false)
    private int quantidadeDeParcelas;

}
