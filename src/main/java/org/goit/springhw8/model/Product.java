package org.goit.springhw8.model;

import io.swagger.annotations.ApiModel;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import lombok.*;
import org.goit.springhw8.util.annotations.PriceValid;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Product.
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@ApiModel
@ToString(exclude = "products")
@Table(name = "product")
public class Product implements BaseModel<String> {

    private static final long serialVersionUID = 6007665773823540856L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @PriceValid
    @Column(name = "price")
    @DecimalMin(value = "0.00", inclusive = false)
    @Digits(integer=5, fraction=2)
    private Double price;

    @ManyToOne (fetch = FetchType.EAGER)
//    @ToString.Exclude
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
}
