package io.github.manoelcampos.vendas.api.feature.cliente;

import io.github.manoelcampos.vendas.api.shared.service.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends AbstractCrudService<Cliente, ClienteRepository> {
    public ClienteService(final ClienteRepository repository) {
        super(repository);
    }
}
