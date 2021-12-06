package org.goit.springhw8.model;

import java.io.Serializable;

@FunctionalInterface
public interface BaseModel<ID> extends Serializable {

    ID getId();
}
