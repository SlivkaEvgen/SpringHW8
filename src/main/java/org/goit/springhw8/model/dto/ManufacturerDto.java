package org.goit.springhw8.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.goit.springhw8.model.dto.ProductDto;

import java.io.Serializable;
import java.util.Set;

@Data
public class ManufacturerDto implements Serializable {

    @Size(min = 1, max = 50, message = "min = 1, max = 50")
    private final String id;

    @NotBlank
    @Size(min = 2, max = 25, message = "min = 2, max = 25")
    private final String name;

    private final Set<ProductDto> products;
}
