package tqi.analiseDeCreditoApi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Mesmo quando o POST falha, o ID é usado?

    @Column(nullable = false)
    private String nome;

    @Email
    private String email;

    @Column(nullable = false, unique = true)
    @CPF
    private String cpf;

    @Column(nullable = false, unique = true)
    private String rg;

    @Column(nullable = false)
    private String enderecoCompleto;

    @Column(nullable = false)
    private double renda;

    @Column(nullable = false)
    private String senha;

    @Valid
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Emprestimo> emprestimos;

}

