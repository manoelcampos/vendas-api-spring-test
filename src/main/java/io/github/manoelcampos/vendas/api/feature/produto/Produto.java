package io.github.manoelcampos.vendas.api.feature.produto;

import io.github.manoelcampos.vendas.api.model.AbstractBaseModel;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Manoel Campos
 */
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Produto extends AbstractBaseModel {
    @NotNull @NotBlank
    private String descricao;

    @NotNull @DecimalMin("0.1")
    private double preco;

    @NotNull @Min(0)
    private int estoque;

    public Produto(final long id) {
        setId(id);
    }

    public Produto(long id, String descricao, double preco, int estoque) {
        setId(id);
        setDescricao(descricao);
        setPreco(preco);
        setEstoque(estoque);
    }
}
