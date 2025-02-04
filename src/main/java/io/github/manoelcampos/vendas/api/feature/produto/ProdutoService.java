package io.github.manoelcampos.vendas.api.feature.produto;

import io.github.manoelcampos.vendas.api.shared.service.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends AbstractCrudService<Produto, ProdutoRepository> {
    public ProdutoService(final ProdutoRepository repository) {
        super(repository);
    }
}
