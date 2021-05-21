package sistemas.logique.clube.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Deprecated
public class Socio extends RepresentationModel<Socio> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Size(min = 9)
    private String rg;

    @NotBlank
    @Size(min = 11)
    private String cpf;

    @NotBlank
    @Size(max = 11)
    private String telefone;

    @NotBlank
    private String endereco;

    @NotBlank
    private String banco;

    @NotBlank
    private String agencia;

    @NotBlank
    private String conta;

    @NotBlank
    private String tipo;

    private String dependencia;
}
