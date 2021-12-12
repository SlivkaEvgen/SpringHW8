package org.goit.springhw8.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.goit.springhw8.model.BaseModel;
import org.goit.springhw8.model.Product;

import javax.persistence.*;
import java.util.Set;

/**
 * The type Manufacturer.
 */
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "manufacturer")
public class Manufacturer implements BaseModel<String> {

    private static final long serialVersionUID = -2363992291788316414L;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Product> products;

}
