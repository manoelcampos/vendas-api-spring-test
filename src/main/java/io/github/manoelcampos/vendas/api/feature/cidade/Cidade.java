package io.github.manoelcampos.vendas.api.feature.cidade;


import io.github.manoelcampos.vendas.api.config.ConstraintKeys;
import io.github.manoelcampos.vendas.api.feature.estado.Estado;
import io.github.manoelcampos.vendas.api.shared.model.AbstractBaseModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (uniqueConstraints = {
        @UniqueConstraint(name = ConstraintKeys.UC_CIDADE_DESCRICAO, columnNames = "descricao"),
})
public class Cidade extends AbstractBaseModel {
    @NotNull @NotBlank
    private String descricao;

    @NotNull
    @JoinColumn(foreignKey = @ForeignKey(name = ConstraintKeys.FK_CIDADE__ESTADO))
    @ManyToOne
    private Estado estado;

    public Cidade() {
    }

    public Cidade(final String descricao, final Estado estado) {
        setDescricao(descricao);
        setEstado(estado);
    }

    public Cidade(final long id) {
        this.setId(id);
    }

    public Cidade(final String descricao) {
        this(null, descricao);
    }

    public Cidade(final Long id, final String descricao) {
        this.setDescricao(descricao);
        this.setId(id);
    }

    /**
     * Copy constructor que cria uma cidade a partir de dados de outra.
     * @param id id da nova cidade
     * @param outra outra cidade para copiar os dados (exceto o id)
     */
    public Cidade(final long id, final Cidade outra) {
        this.setId(id);
        this.setDescricao(outra.descricao);
        this.setEstado(outra.estado);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public Estado getEstado() {
        return estado;
    }

    public Cidade setEstado(final Estado estado) {
        this.estado = estado;
        return this;
    }
}
