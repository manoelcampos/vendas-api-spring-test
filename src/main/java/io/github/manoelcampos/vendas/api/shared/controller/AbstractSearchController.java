package io.github.manoelcampos.vendas.api.shared.controller;

import io.github.manoelcampos.vendas.api.model.AbstractBaseModel;
import io.github.manoelcampos.vendas.api.shared.EntityRepository;
import io.github.manoelcampos.vendas.api.shared.service.AbstractCrudService;
import io.github.manoelcampos.vendas.api.shared.util.PathUtil;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Classe base para a implementação de {@link RestController} que irão fornecer apenas operações de consulta
 * (a serem implementadas pelas classes filhas).
 * Cada classe filha deve incluir a anotação {@link RestController} e {@link RequestMapping}.
 * @param <T> tipo da entidade que o controller irá manipular
 *
 * @author Manoel Campos
 */
public class AbstractSearchController<T extends AbstractBaseModel, R extends EntityRepository<T>, S extends AbstractCrudService<T, R>> {
    /**
     * Caminho relativo do controller na anotação {@link RequestMapping}.
     */
    protected final String basePath;

    @Getter
    private final S service;

    public AbstractSearchController(@NonNull final S service) {
        this.service = service;
        this.basePath = findBasePath();
    }

    protected URI createdUri(final T entity) {
        return PathUtil.createUri(basePath, entity.getId().toString());
    }

    /**
     * Procura o valor da anotação {@link RequestMapping} na classe controller filha,
     * que representa o caminho do controller.
     *
     * @return caminho do controller
     */
    protected String findBasePath() {
        final var handlerClass = getClass();
        final var requestMapping = findAnnotation(handlerClass, RequestMapping.class);
        return requestMapping == null ? "" : requestMapping.value()[0];
    }

    protected ResponseStatusException newNotFoundException(final long id) {
        final var msg = "%s não encontrado(a) com id " + id;
        return newNotFoundException(msg);
    }

    /**
     * Cria uma exceção de recurso não encontrado.
     * @param msgFormat uma String contendo o formato da mensagem, podendo ter um %s para ser substituído pelo nome da entidade.
     *                  Se não existir %s, a mensagem será exibida como passada, sem formatação.
     * @return a exceção criada
     */
    protected ResponseStatusException newNotFoundException(final String msgFormat) {
        final var msg = msgFormat.contains("%s") ? msgFormat.formatted(service.getEntityClassName()) : msgFormat;
        return new ResponseStatusException(NOT_FOUND, msg);
    }

    protected R getRepository() {
        return service.getRepository();
    }
}
