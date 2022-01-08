package tqi.analiseDeCreditoApi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tqi.analiseDeCreditoApi.entities.Cliente;
import tqi.analiseDeCreditoApi.entities.Emprestimo;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReturnEmprestimoDetailsDTO {

    private Long id;
    private Double valor;
    private int parcelas;
    private Cliente cliente;
    private String dataDaPrimeiraParcela;
    private String email;
    private Double renda;

    public ReturnEmprestimoDetailsDTO(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.valor = emprestimo.getValorDoEmprestimo();
        this.parcelas = emprestimo.getQuantidadeDeParcelas();
        this.dataDaPrimeiraParcela = String.valueOf(emprestimo.getDataDaPrimeiraParcela());
        this.email = emprestimo.getCliente().getEmail();
        this.renda = emprestimo.getCliente().getRenda();
    }

}
