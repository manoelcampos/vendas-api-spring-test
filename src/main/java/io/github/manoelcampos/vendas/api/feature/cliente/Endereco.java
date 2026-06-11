package io.github.manoelcampos.vendas.api.feature.cliente;

import java.util.Objects;

/**
 * @author Manoel Campos
 */
public class Endereco {
    private String logradouro;
    private String numero;
    private String cep;
    private String cidade;
    private String uf;

    public Endereco() {
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(final String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(final String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(final String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(final String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(final String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco endereco)) return false;
        return Objects.equals(logradouro, endereco.logradouro)
                && Objects.equals(numero, endereco.numero)
                && Objects.equals(cep, endereco.cep)
                && Objects.equals(cidade, endereco.cidade)
                && Objects.equals(uf, endereco.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logradouro, numero, cep, cidade, uf);
    }

    @Override
    public String toString() {
        return "Endereco(logradouro=%s, numero=%s, cep=%s, cidade=%s, uf=%s)".formatted(logradouro, numero, cep, cidade, uf);
    }
}
