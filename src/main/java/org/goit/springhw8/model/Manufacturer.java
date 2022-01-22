package org.goit.springhw8.model;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * The type Manufacturer.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel
@Table(name = "manufacturer")
public class Manufacturer implements BaseModel<String> {

    private static final long serialVersionUID = -2363992291788316414L;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Product> products;
}
