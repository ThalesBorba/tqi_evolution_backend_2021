package tqi.analiseDeCreditoApi.dto.request;

import tqi.analiseDeCreditoApi.entities.Cliente;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CreateEmprestimoDTO {

    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;
    private double valorDoEmprestimo;
    private String dataDaPrimeiraParcela;
    private int quantidadeDeParcelas;
}
