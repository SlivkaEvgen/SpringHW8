package org.goit.springhw8.model.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDto implements Serializable {

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
