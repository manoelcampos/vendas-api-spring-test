package io.github.manoelcampos.vendas.api.feature.venda;

import io.github.manoelcampos.vendas.api.feature.cliente.Cliente;
import io.github.manoelcampos.vendas.api.feature.cliente.Endereco;
import io.github.manoelcampos.vendas.api.shared.model.AbstractBaseModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.requireNonNullElse;

/**
 * @author Manoel Campos
 */
@Entity
public class Venda extends AbstractBaseModel {
    public enum Status{ REGISTRADA, AGUARDANDO_PAGAMENTO, PAGA, PREPARANDO_ENVIO, ENVIADA, ENTREGUE }

    @NotNull @ManyToOne
    private Cliente cliente;

    @Column(nullable = false)
    private LocalDateTime dataHora = LocalDateTime.now();

    @Enumerated(EnumType.STRING) @NotNull
    private Status status;

    @Embedded
    private Endereco enderecoEntregua;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVenda> itens = new ArrayList<>();

    public Venda() {
    }

    public Venda(final Cliente cliente, final LocalDateTime dataHora, final Status status, final Endereco enderecoEntregua, final List<ItemVenda> itens) {
        setCliente(cliente);
        setDataHora(dataHora);
        setStatus(status);
        setEnderecoEntregua(enderecoEntregua);
        setItens(itens);
    }

    public Venda(final long id) {
        this.setId(id);
    }

    public Venda(final long id, final List<ItemVenda> itens) {
        this(id);
        setItens(itens);
    }

    public Venda(final Cliente cliente) {
        setCliente(cliente);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(final Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(final LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public Endereco getEnderecoEntregua() {
        return enderecoEntregua;
    }

    public void setEnderecoEntregua(final Endereco enderecoEntregua) {
        this.enderecoEntregua = enderecoEntregua;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(final List<ItemVenda> itens) {
        this.itens = requireNonNullElse(itens, new LinkedList<>());
        this.itens.forEach(item -> item.setVenda(this));
    }

    @Override
    public String toString() {
        return "Venda{id: %d cliente: %d}".formatted(getId(), cliente == null ? cliente : cliente.getId());
    }
}
