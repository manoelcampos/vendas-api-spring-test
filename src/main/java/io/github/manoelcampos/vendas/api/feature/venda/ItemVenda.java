package io.github.manoelcampos.vendas.api.feature.venda;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.manoelcampos.vendas.api.feature.produto.Produto;
import io.github.manoelcampos.vendas.api.model.AbstractBaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * @author Manoel Campos
 */
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class ItemVenda extends AbstractBaseModel {
    @NotNull @ManyToOne @JsonIgnore
    private Venda venda;

    @NotNull @ManyToOne
    private Produto produto;

    @NotNull @Min(1)
    private int quant;

    public ItemVenda(final long id) {
        this.setId(id);
    }

    public ItemVenda(final long produtoId, final int quant) {
        setProduto(new Produto(produtoId));
        setQuant(quant);
    }

    public ItemVenda(final Produto produto) {
        setProduto(produto);
    }
}
