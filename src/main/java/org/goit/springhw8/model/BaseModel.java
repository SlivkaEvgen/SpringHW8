package org.goit.springhw8.model;

import java.io.Serializable;

/**
 * The interface Base model.
 *
 * @param <ID> the type parameter
 */
@FunctionalInterface
public interface BaseModel<ID> extends Serializable {

    /**
     * Gets id.
     *
     * @return the id
     */
    ID getId();
}
