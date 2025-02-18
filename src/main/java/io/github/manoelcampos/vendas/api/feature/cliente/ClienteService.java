package io.github.manoelcampos.vendas.api.feature.cliente;

import io.github.manoelcampos.vendas.api.shared.service.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends AbstractCrudService<Cliente, ClienteRepository> {
    public ClienteService(final ClienteRepository repository) {
        super(repository);
    }

    /*
    TODO: Incluir campo senha (hash) e ao alterar um cliente,
    não permitir alterar a senha,
    pois isso normalmente é feito separadamente:
    Desta forma, permite-se que o cliente altere seus dados pessoais,
    sem necessariamente ter que alterar a senha.
    E se ele não informar a senha ao alterar seus dados,
    o campo senha virá vazio, substituindo a senha atual.
    Assim, o usuário não conseguiria logar novamente.
    Isso pode ser feito com @Column(updatable = false).
    Mas vamos fazer manualmente para praticar a implementação de regras de negócio.
    */
}
