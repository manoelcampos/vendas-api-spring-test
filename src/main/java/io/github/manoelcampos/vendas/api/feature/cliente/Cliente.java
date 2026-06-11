package io.github.manoelcampos.vendas.api.feature.cliente;

import io.github.manoelcampos.vendas.api.config.ConstraintKeys;
import io.github.manoelcampos.vendas.api.feature.cidade.Cidade;
import io.github.manoelcampos.vendas.api.shared.model.AbstractBaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente extends AbstractBaseModel {
    @NotNull @NotBlank
    private String nome;

    @CPF @NotNull @NotBlank
    private String cpf;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = ConstraintKeys.FK_CLIENTE_CIDADE))
    private Cidade cidade;

    public Cliente() {
    }

    public Cliente(final String nome, final String cpf, final Cidade cidade) {
        setNome(nome);
        setCpf(cpf);
        setCidade(cidade);
    }

    public Cliente(final long id) {
        setId(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(final Cidade cidade) {
        this.cidade = cidade;
    }
}
