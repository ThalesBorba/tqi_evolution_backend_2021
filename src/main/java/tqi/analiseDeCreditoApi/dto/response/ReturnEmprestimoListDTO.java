package tqi.analiseDeCreditoApi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tqi.analiseDeCreditoApi.entities.Emprestimo;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReturnEmprestimoListDTO {
    private Emprestimo emprestimo;

    private Long id;
    private Double valor;
    private int parcelas;

}
