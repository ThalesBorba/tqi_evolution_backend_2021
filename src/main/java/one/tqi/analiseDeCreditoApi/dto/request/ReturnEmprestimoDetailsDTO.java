package one.tqi.analiseDeCreditoApi.dto.request;

import one.tqi.analiseDeCreditoApi.entities.Emprestimo;

import java.time.LocalDate;

public class ReturnEmprestimoDetailsDTO {
    private Emprestimo emprestimo;

    private Long id;
    private Double valor;
    private int parcelas;
    private LocalDate dataPrimeiraParcela;
    private String email;
    private Double renda;

    public ReturnEmprestimoDetailsDTO(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.valor = emprestimo.getValorDoEmprestimo();
        this.parcelas = emprestimo.getQuantidadeDeParcelas();
        this.dataPrimeiraParcela = emprestimo.getDataDaPrimeiraParcela();
        this.email = emprestimo.getCliente().getEmail();
        this.renda = emprestimo.getCliente().getRenda();
    }

    public Long getId() {
        return id;
    }

    public Double getValor() {
        return valor;
    }

    public int getParcelas() {
        return parcelas;
    }

    public LocalDate getDataPrimeiraParcela() {
        return dataPrimeiraParcela;
    }

    public String getEmail() {
        return email;
    }

    public Double getRenda() {
        return renda;
    }
}
