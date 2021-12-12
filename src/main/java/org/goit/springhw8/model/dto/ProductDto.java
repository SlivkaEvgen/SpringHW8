package org.goit.springhw8.model.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.goit.springhw8.model.Product;

/**
 * The type Product dto.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
public class ProductDto extends Product {

    @Size(min = 1, max = 50, message = "min = 1, max = 50")
    private final String id;

    @Size(min = 2, max = 25, message = "min = 2, max = 25")
    private final String name;

    @Digits(integer = 6, fraction = 2)
    @NotBlank
    @PositiveOrZero
    @Size(max = 20, message = "max = 20")
    private final Double price;
}
