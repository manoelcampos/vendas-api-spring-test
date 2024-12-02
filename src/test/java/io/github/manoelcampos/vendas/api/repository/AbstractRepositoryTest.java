package io.github.manoelcampos.vendas.api.repository;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/** Classe base para a implementação de testes de integração dos {@link org.springframework.stereotype.Repository}
 * usando <a href="http://testcontainers.com">Test Containers</a>.
 * É preciso ter o Docker rodando na máquina local para rodar tais testes.
 * AVISO: As subclasses não devem ser final. Incluindo final é gerado um warning.
 * @author Manoel Campos
 */
@DataJpaTest
abstract class AbstractRepositoryTest {

}
