package tqi.analiseDeCreditoApi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tqi.analiseDeCreditoApi.entities.Cliente;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmprestimoDTO {

    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;
    private double valorDoEmprestimo;
    private String dataDaPrimeiraParcela;
    private int quantidadeDeParcelas;
}
