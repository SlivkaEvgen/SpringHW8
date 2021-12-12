package org.goit.springhw8.model;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * The type Product.
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product implements BaseModel<String> {

    private static final long serialVersionUID = 6007665773823540856L;

    @Id
    @Column(name = "id", unique = true, nullable = false)
//    @Size(min = 1, max = 50, message = "min = 1, max = 50")
    private String id;

    @Column(name = "name")
//    @Size(min = 2, max = 25, message = "min = 2, max = 25")
    private String name;

//    @Digits(integer=6, fraction=2)
//    @NotBlank
//    @PositiveOrZero
    @Column(name = "price")
//    @Size(max = 20, message = "max = 20")
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
}
