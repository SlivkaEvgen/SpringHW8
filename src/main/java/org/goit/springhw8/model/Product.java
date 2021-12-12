package org.goit.springhw8.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.goit.springhw8.util.annotations.PriceValid;

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
    private String id;

    @Column(name = "name")
    private String name;

    @PriceValid
    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
}
