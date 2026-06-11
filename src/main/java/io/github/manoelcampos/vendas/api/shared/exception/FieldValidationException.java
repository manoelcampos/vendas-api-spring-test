package io.github.manoelcampos.vendas.api.shared.exception;

import java.util.Objects;

/**
 * @author Manoel Campos
 */
public class FieldValidationException extends RuntimeException {
    private final String fieldName;

    /**
     * Cria uma exceção de validação de campo.
     * @param message mensagem de erro de validação
     * @param fieldName nome do campo sendo validado
     */
    public FieldValidationException(final String message, final String fieldName) {
        super(Objects.requireNonNull(message, "message não pode ser nulo"));
        Objects.requireNonNull(fieldName, "fieldName não pode ser nulo");
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
