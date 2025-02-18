package io.github.manoelcampos.vendas.api.feature.venda;

import io.github.manoelcampos.vendas.api.feature.produto.Produto;
import io.github.manoelcampos.vendas.api.feature.produto.ProdutoRepository;
import io.github.manoelcampos.vendas.api.shared.service.AbstractCrudService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

import static java.util.Objects.requireNonNullElse;

@Service
public class VendaService extends AbstractCrudService<Venda, VendaRepository> {
    private final ProdutoRepository produtoRepository;

    public VendaService(final VendaRepository repository, final ProdutoRepository produtoRepository) {
        super(repository);
        this.produtoRepository = produtoRepository;
    }

    /**
     * O método não leva em consideração que múltiplos clientes podem estar
     * comprando o mesmo produto ao mesmo tempo, e portanto,
     * a implementação pode acabar permitindo que o estoque fique negativo
     * nesses casos.
     */
    @Override
    public Venda save(final Venda venda) {
        for (ItemVenda item : venda.getItens()) {
            final var produto = item.getProduto();

            // requireNonNullElse é uma forma simplificada de escrever um if-else
            final Long prodId = requireNonNullElse(produto, new Produto()).getId();
            //if (produto == null || produto.getId() == null) {
            if (prodId == null) {
                throw new IllegalStateException("Produto não informado");
            }

            final var prod =
                    produtoRepository
                            .findById(prodId)
                            .orElseThrow(() -> new NoSuchElementException("Produto não encontrado"));
            if(item.getQuant() > prod.getEstoque()){
                throw new IllegalStateException("Produto %s não tem estoque suficiente".formatted(prod.getDescricao()));
            }
        }

        return super.save(venda);
    }
}
