package org.goit.springhw8.model;

import java.io.Serializable;

@FunctionalInterface
public interface BaseEntity<ID> extends Serializable {

    ID getId();
}
