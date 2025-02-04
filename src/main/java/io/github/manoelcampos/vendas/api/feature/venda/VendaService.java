package io.github.manoelcampos.vendas.api.feature.venda;

import io.github.manoelcampos.vendas.api.feature.produto.ProdutoRepository;
import io.github.manoelcampos.vendas.api.shared.service.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VendaService extends AbstractCrudService<Venda, VendaRepository> {
    @Autowired
    private ProdutoRepository produtoRepository;

    public VendaService(final VendaRepository repository) {
        super(repository);
    }

    /**
     * O método não leva em consideração que múltiplos clientes podem estar
     * comprando o mesmo produto ao mesmo tempo, e portanto,
     * a implementação pode acabar permitindo que o estoque fique negativo
     * nesses casos.
     */
    @Override
    public Venda save(final Venda venda) {
        System.out.println("Salvando a venda");
        for (ItemVenda item : venda.getItens()) {
            System.out.println("Verificando estoque para o item " + item);
            final Long id = item.getProduto().getId();
            if (id == null) {
                throw new IllegalStateException("Produto não informado");
            }

            final var prod = produtoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Produto não encontrado"));
            if(item.getQuant() > prod.getEstoque()){
                throw new IllegalStateException("Produto %s não tem estoque suficiente".formatted(prod.getDescricao()));
            }
        }

        return super.save(venda);
    }
}
