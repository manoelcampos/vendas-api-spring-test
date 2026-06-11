package io.github.manoelcampos.vendas.api.shared.util;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Manoel Campos
 */
public final class ListUtil {
    /** Construtor privado para impedir instanciar a classe */
    private ListUtil() {/**/}

    /**
     * Cria um LinkedList mutável a partir dos valores passados por parâmetro
     * @param items itens a serem adicionados na lista
     * @return o novo LinkedList
     * @param <T> tipo dos elementos da lista
     */
    @SafeVarargs
    public static <T> List<T> of(final T ...items){
        Objects.requireNonNull(items, "items não pode ser nulo");
        final var list = new LinkedList<T>();
        Collections.addAll(list, items);
        return list;
    }

    /**
     * Adiciona um item a uma lista e retorna a própria lista.
     * @param list lista para adicionar um item
     * @param item item a ser adicioknado
     * @return a lista passada por parâmetro
     * @param <T> tipo dos elementos da lista
     */
    public static <T> List<T> add(final List<T> list, final T item){
        Objects.requireNonNull(list, "list não pode ser nulo");
        Objects.requireNonNull(item, "item não pode ser nulo");
        list.add(item);
        return list;
    }
}
