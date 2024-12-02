package io.github.manoelcampos.vendas.api.model;


import io.github.manoelcampos.vendas.api.config.ConstraintKeys;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (uniqueConstraints = {
        @UniqueConstraint(name = ConstraintKeys.UC_CIDADE_DESCRICAO, columnNames = "descricao"),
})
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Cidade extends AbstractBaseModel {
    @NotNull @NotBlank
    private String descricao;

    @NotNull
    @JoinColumn(foreignKey = @ForeignKey(name = ConstraintKeys.FK_CIDADE__ESTADO))
    @ManyToOne
    private Estado estado;

    public Cidade(final long id) {
        this.setId(id);
    }

    public Cidade(final String descricao) {
        this.setDescricao(descricao);
    }
}
