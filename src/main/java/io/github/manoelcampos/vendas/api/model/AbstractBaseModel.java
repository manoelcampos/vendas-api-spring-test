package io.github.manoelcampos.vendas.api.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

/**
 * @author Manoel Campos
 */
@MappedSuperclass @Getter @Setter @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class AbstractBaseModel implements BaseModel {
    /**
     * Identificador único do objeto, gerado pelo banco de dados.
     * {@code @Column(nullalbe = false)} indica que o campo não pode ser nulo no banco.
     * {@code @Nullable} (usado no getter na interface) indica que o campo pode ser nulo na aplicação, pois ao inserir,
     * o registro é enviado sem um ID, que é gerado no banco.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private Long id;

    /**
     * {@return Obtém o ID de uma entidade associada (representada por um atributo), ou 0 caso o atributo ou seu id seja nulo}
     * O método evitar {@link NullPointerException} ao acessar o id do atributo que pode ser nula.
     *
     * <p><b>AVISO:</b> Os métodos criados que simplesmente chamam este não devem seguir
     * a convenção de nomes do Java Beans.
     * Se por exemplo for criado um método para obter o id de um atributo (associação) regional
     * em uma entidade qualquer, tal método não deve se chamar getRegional(),
     * mas qualquer nome que não inicie com get, como regional().
     * Isto para evitar problemas na convenção de nomes usados pelo Spring Data Repository
     * e evitar que o Spring tente localizar um campo chamado nivelOrganizacionalId
     * que não existe na entidade (mas apenas regional).</p>
     * O erro que pode ocorrer é por exemplo: Unable to locate Attribute with the given name [regionalId] on this ManagedType
     * @param associationAttribute objeto que representa a associação para a qual deseja-se obter o ID de forma null-safe
     */
    protected long associationId(@Nullable final BaseModel associationAttribute){
        return associationAttribute == null || associationAttribute.getId() == null ?  0 : associationAttribute.getId();
    }

    /**
     * Verifica, de forma segura para Null Pointer Exception, se o ID da entidade é igual a um determinado valor.
     * @return true se o id da entidade for igual ao ID passado
     */
    public boolean isSameId(final long id){
        return this.id != null && this.id == id;
    }

}
