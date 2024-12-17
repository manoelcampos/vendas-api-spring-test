package io.github.manoelcampos.vendas.api.feature.estado;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * A anotação @DataJpaTest é usada para testes de repositórios.
 * Ela vai criar uma conexão com o banco de dados
 * e permitir testar os repositórios.
 */
@DataJpaTest
class EstadoRepositoryTest {
    /* Anotação @Autowired para injetar a instância do repositório.
    * Ou seja, ela cria uma instância do objeto pra gente. */
    @Autowired
    private EstadoRepository repository;

    @Test
    void findById() {
        final long id = 1;
        Estado estado = repository.findById(id).orElseThrow();
        final var nomeEsperado = "São Paulo";
        assertEquals(nomeEsperado, estado.getDescricao());
    }

    @Test
    void deleteById() {
        final long id = 1; // São Paulo

        assertThrows(DataIntegrityViolationException.class, () -> {
            repository.deleteById(id);
            // Envia o comando SQL imediatemente para o banco
            repository.flush();
        });
    }
}
