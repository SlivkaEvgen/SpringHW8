package org.goit.springhw8.model;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @ToString.Exclude
    @Transient
    private Set<Product> products;
}
