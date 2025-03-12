package io.github.manoelcampos.vendas.api.feature.cidade;

import io.github.manoelcampos.vendas.api.feature.AbstractControllerTest;
import io.github.manoelcampos.vendas.api.feature.estado.Estado;
import io.github.manoelcampos.vendas.api.shared.util.PathUtil;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Testes para a API REST de {@link Cidade} implementada pelo {@link CidadeController}.
 * A classe testa apenas os métodos do controller, ignorando a camada de serviço (para a qual um mock é criado).
 * Ela é diferente de {@link CidadeControllerIntegrationTest} que implementa testes de integração.
 * Logo, não usa mocks e testa todas as camadas da aplicação funcionando de forma integrada.
 *
 * <p>Os nomes dos testes incluem o sufixo "test" para evitar conflito
 * com métodos de mesmo nome na classe {@link MockMvcResultMatchers}.</p>
 *
 * <p>Pode-se usar a anotação {@code @SpringBootTest} (sem indicar a propriedade webEnvironment para iniciar
 * um servidor HTTP real em uma porta específica) no lugar de {@link WebMvcTest}.
 * Neste caso, como não é criado um servidor real,
 * temos que usar um objeto {@link MockMvc} da mesma forma,
 * para simular as requisições HTTP.
 * No entanto, a anotação {@code @SpringBootTest} não configura
 * o {@link MockMvc}, exigindo a adição da anotação {@code @AutoConfigureMockMvc}.</p>
 *
 * <p>Portanto, é muito mais fácil usar {@link WebMvcTest} no lugar, já recebendo tudo pré-configurado.</p>
 * @author Manoel Campos
 */
@WebMvcTest(CidadeController.class)
class CidadeControllerTest extends AbstractControllerTest {
    private static final String RELATIVE_URL = "/cidade";
    private static final String BY_ID_URL = PathUtil.concat(RELATIVE_URL, "/{id}");

    /**
     * Cria um mock para o objeto CidadeService e injeta ele dentro
     * da instância da classe controller (indicada a anotação {@link WebMvcTest} acima)
     * que é criada internamente pelo Spring para receber as requisições HTTP enviadas nos testes.
     */
    @MockitoBean // Substitui a anotação obsoleta @MockBean
    private CidadeService service;

    @Test
    void findByIdTest() throws Exception {
        final long id = 1;
        final var cidade = new Cidade(id, "Cidade 1");
        Mockito.when(service.findById(id)).thenReturn(Optional.of(cidade));
        mockMvc().perform(get(BY_ID_URL, id)).andExpect(status().isOk()).andExpect(content().json(objectToJson(cidade)));
    }

    @Test
    void insertTest() throws Exception {
        final var cidade = new Cidade("Nova Cidade", new Estado(1));
        final var novaCidade = new Cidade(1, cidade);
        Mockito.when(service.save(cidade)).thenReturn(novaCidade);
        mockMvc()
                .perform(post(RELATIVE_URL).contentType(MediaType.APPLICATION_JSON).content(objectToJson(cidade)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectToJson(novaCidade)));
    }

    @Test
    void deleteTest() throws Exception {
        final long id = 1;
        Mockito.when(service.deleteById(id)).thenReturn(true);
        mockMvc().perform(delete(BY_ID_URL, id)).andExpect(status().isNoContent());
    }
}
