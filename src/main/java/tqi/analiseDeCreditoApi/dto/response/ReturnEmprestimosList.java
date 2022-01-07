package tqi.analiseDeCreditoApi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tqi.analiseDeCreditoApi.entities.Cliente;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReturnEmprestimosList {

    private Cliente cliente;

    private Long id;
    private Double valor;
    private int parcelas;
   // Na listagem, devemos retornar no mínimo o código do empréstimo, o valor e a quantidade de parcelas.



    public ReturnEmprestimosList(Cliente cliente) {

    }


}
