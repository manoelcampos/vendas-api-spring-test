package io.github.manoelcampos.vendas.api.feature.cidade;


import io.github.manoelcampos.vendas.api.config.ConstraintKeys;
import io.github.manoelcampos.vendas.api.feature.estado.Estado;
import io.github.manoelcampos.vendas.api.shared.model.AbstractBaseModel;
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
