package io.github.manoelcampos.vendas.api.feature.produto;

import io.github.manoelcampos.vendas.api.shared.model.AbstractBaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Manoel Campos
 */
@Entity
public class Produto extends AbstractBaseModel {
    @NotNull @NotBlank @Column(unique = true)
    private String descricao;

    @NotNull @DecimalMin("0.1")
    private double preco;

    @NotNull @Min(0)
    private int estoque;

    public Produto() {
    }

    public Produto(final String descricao, final double preco, final int estoque) {
        setDescricao(descricao);
        setPreco(preco);
        setEstoque(estoque);
    }

    public Produto(final long id) {
        setId(id);
    }

    public Produto(long id, String descricao, double preco, int estoque) {
        setId(id);
        setDescricao(descricao);
        setPreco(preco);
        setEstoque(estoque);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(final double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(final int estoque) {
        this.estoque = estoque;
    }
}
