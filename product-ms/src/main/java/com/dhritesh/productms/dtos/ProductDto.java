package com.dhritesh.productms.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private long id;
    @NotBlank(message = "product name is required")
    @Size(min = 3, message = "num must be greater then 3 chars")
    private String name;
    private String description;

    @DecimalMin(value = "1.00",message = "minimun price must be 1.00")
    private double price;
    private double discountPercentage;

}
