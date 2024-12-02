package io.github.manoelcampos.vendas.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Cliente extends AbstractBaseModel {
    private String nome;
    private String cpf;

    @ManyToOne
    private Cidade cidade;
}
