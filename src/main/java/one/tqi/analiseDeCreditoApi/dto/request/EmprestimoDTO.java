package one.tqi.analiseDeCreditoApi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoDTO {

    private Long id;

    @NotEmpty
    private double valorDoEmprestimo;

    @NotEmpty
    private String dataDaPrimeiraParcela;

    @NotEmpty
    @Max(60)
    private int quantidadeDeParcelas;
}
