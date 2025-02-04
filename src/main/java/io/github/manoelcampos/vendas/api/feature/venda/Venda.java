package io.github.manoelcampos.vendas.api.feature.venda;

import io.github.manoelcampos.vendas.api.feature.cliente.Cliente;
import io.github.manoelcampos.vendas.api.model.AbstractBaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Manoel Campos
 */
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Venda extends AbstractBaseModel {
    @NotNull @ManyToOne
    private Cliente cliente;

    @Column(nullable = false)
    private LocalDateTime dataHora = LocalDateTime.now();

    @OneToMany(mappedBy = "venda")
    private List<ItemVenda> itens = new ArrayList<>();

    public Venda(final long id) {
        this.setId(id);
    }
}
