package org.goit.springhw8.model.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.goit.springhw8.model.Manufacturer;
import org.goit.springhw8.model.Product;
import org.goit.springhw8.util.annotations.PriceValid;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class ProductDto extends Product {

    @Id
    @Size(min = 1, max = 50, message = "min = 1, max = 50")
    private final String id;

    @Size(min = 2, max = 25, message = "min = 2, max = 25")
    private final String name;

    @NotBlank
    @PriceValid
    @PositiveOrZero
    @Digits(integer = 5, fraction = 2)
//    @Size(max = 20, message = "max = 20")
    private final Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

}
