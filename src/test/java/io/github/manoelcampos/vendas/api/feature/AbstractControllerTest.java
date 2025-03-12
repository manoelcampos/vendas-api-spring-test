package io.github.manoelcampos.vendas.api.feature;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.io.UncheckedIOException;

/**
 * Classe abstrata para implementar testes exclusivos para a camada de controller, realizando mock da camada service.
 * As classes filhas precisam ser anotadas com {@link WebMvcTest}, indicando qual controller será testado.
 * @author Manoel Campos
 * @see AbstractControllerIntegrationTest
 */
public abstract class AbstractControllerTest {
    /** @see #mockMvc() */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Converte um objeto Java para sua representação em JSON.
     * @param object objeto a ser convertido
     * @return String com a representação em JSON do objeto Java
     */
    protected String objectToJson(final Object object)  {
        final var writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return writer.writeValueAsString(object);
        } catch (final JsonProcessingException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Objeto que simula o envio de requisições HTTP para o controller
     * que atende requisições numa determinada URL requisitada
     * por meio do método {@link MockMvc#perform(RequestBuilder)}.
     * Assim, o controller estará sendo testado enviando-se requisições
     * seguindo o formato do protocolo HTTP, mas nenhuma comunicação de rede estará realmente
     * sendo feita. Todas as requisições serão processadas internamente pela aplicação
     * para um objeto controller instanciado automaticamente.
     */
    protected MockMvc mockMvc() {
        return mockMvc;
    }
}
