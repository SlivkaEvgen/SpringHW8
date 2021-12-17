package org.goit.springhw8.model;

import jakarta.validation.Constraint;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.goit.springhw8.util.annotations.PriceValid;

import javax.persistence.*;
import java.math.BigDecimal;

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
    @DecimalMin(value = "0.00", inclusive = false)
    @Digits(integer=5, fraction=2)
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
}
