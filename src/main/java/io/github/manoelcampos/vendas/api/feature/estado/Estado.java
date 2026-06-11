package io.github.manoelcampos.vendas.api.feature.estado;

import io.github.manoelcampos.vendas.api.config.ConstraintKeys;
import io.github.manoelcampos.vendas.api.shared.model.AbstractBaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = ConstraintKeys.UC_ESTADO_DESCRICAO, columnNames = "descricao"),
})
public class Estado extends AbstractBaseModel {
    @NotNull @NotBlank
    private String descricao;

    @NotNull @NotBlank
    private String sigla;

    public Estado() {
    }

    public Estado(final String descricao, final String sigla) {
        setDescricao(descricao);
        setSigla(sigla);
    }

    public Estado(final long id) {
        this.setId(id);
    }

    public Estado(final String descricao) {
        this.setDescricao(descricao);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(final String sigla) {
        this.sigla = sigla;
    }
}
