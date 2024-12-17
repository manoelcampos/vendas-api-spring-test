package io.github.manoelcampos.vendas.api.feature.cliente;

import io.github.manoelcampos.vendas.api.feature.cidade.Cidade;
import io.github.manoelcampos.vendas.api.model.AbstractBaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Cliente extends AbstractBaseModel {
    private String nome;
    @CPF
    private String cpf;

    @ManyToOne
    private Cidade cidade;
}
