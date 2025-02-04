package io.github.manoelcampos.vendas.api.feature.venda;

import io.github.manoelcampos.vendas.api.shared.service.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class VendaService extends AbstractCrudService<Venda, VendaRepository> {
    public VendaService(final VendaRepository repository) {
        super(repository);
    }
}
