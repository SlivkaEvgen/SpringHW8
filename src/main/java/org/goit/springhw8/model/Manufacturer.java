package org.goit.springhw8.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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
    @Size(min = 1, max = 50, message = "min = 1, max = 50")
    private String id;

    @NotBlank
    @Column(name = "name")
    @Size(min = 2, max = 25, message = "min = 2, max = 25")
    private String name;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Product> products;
}
