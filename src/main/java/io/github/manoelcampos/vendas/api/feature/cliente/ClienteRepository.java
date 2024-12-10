package io.github.manoelcampos.vendas.api.feature.cliente;

import io.github.manoelcampos.vendas.api.shared.EntityRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends EntityRepository<Cliente> {
    Optional<Cliente> findByCpf(String cpf);
}
