package io.github.manoelcampos.vendas.api.feature.venda;

import io.github.manoelcampos.vendas.api.feature.cliente.Cliente;
import io.github.manoelcampos.vendas.api.feature.produto.Produto;
import io.github.manoelcampos.vendas.api.feature.produto.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Para rodar testes que usam mocks do Mockito,
 * é preciso usar a anotação @ExtendWith
 * para que os mocks sejam criados corretamente.
 */
@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT) // usado para ignorar quando um método do mock não é chamado como esperado
class VendaServiceTest {
    /**
     * @InjectMocks instancia o serviço,
     * mas pegando os objetos fake anotados com
     * @Mock e armazenando eles nos atributos
     * de mesmo tipo dentro do serviço.
     * Assim, o serviço não vai usar um objeto
     * real para tais atributos, mas o
     * fantoche (mock) que criamos.
     */
    @InjectMocks
    private VendaService service;

    /**
     * @Autowired é usada apenas pra instanciar objetos reais
     * @Mock cria um objeto fake, um fantoche que
     * você define como ele vai se comportar
     */
    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private VendaRepository repository;
    private final Venda venda = new Venda(new Cliente(1));

    @BeforeEach
    void setUp() {
        final var prod1 = new Produto("Prod 1", 100.0, 10);
        final var prod2 = new Produto("Prod 2", 200.0, 5);

        // Mockito é a biblioteca de mock incluída no Spring
        Mockito
            .when(produtoRepository.findById(1L))
            .thenReturn(Optional.of(prod1));

        // Como no nosso teste, já dá erro de estoque pro 1o item, o produto 2 nunca é buscado
        //Mockito.when(produtoRepository.findById(2L)).thenReturn(Optional.of(prod2));

        // Não precisa, pois como não vai ter estoque para o teste save(),
        // ele não chega até o final do método testado e não chama o saveAndFlush
        // (pois lança a exceção de falta de estoque antes).
        //Mockito.when(repository.saveAndFlush(Mockito.any())).thenReturn(new Venda());
    }

    @Test
    void saveProdutoSemEstoque() {
        final var itens = List.of(new ItemVenda(1, 20), new ItemVenda(2, 5));
        venda.setItens(itens);

        assertThrows(IllegalStateException.class, () -> service.save(venda));
    }

    @Test
    void saveProdutoNaoInformado() {
        final var itens = List.of(new ItemVenda(1, 2), new ItemVenda());
        venda.setItens(itens);

        assertThrows(IllegalStateException.class, () -> service.save(venda));
    }

    @Test
    void saveIdProdutoNaoInformado() {
        final var itens = List.of(new ItemVenda(1, 2), new ItemVenda(new Produto()));
        venda.setItens(itens);
        assertThrows(IllegalStateException.class, () -> service.save(venda));
    }

    @Test
    void saveProdutoNaoLocalizado() {
        final var itens = List.of(new ItemVenda(3, 2));
        venda.setItens(itens);
        assertThrows(NoSuchElementException.class, () -> service.save(venda));
    }

}
