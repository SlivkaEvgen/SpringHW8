package org.goit.springhw8.model;

import jakarta.validation.constraints.Size;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product implements BaseModel<String> {

    private static final long serialVersionUID = 6007665773823540856L;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @Size(min = 1, max = 50, message = "min = 1, max = 50")
    private String id;

    @Column(name = "name")
    @Size(min = 2, max = 25, message = "min = 2, max = 25")
    private String name;

    @Column(name = "price")
    @Size(max = 20, message = "max = 20")
    private Double price;

    @ManyToOne
    private Manufacturer manufacturer;
}
