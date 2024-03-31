package com.dhritesh.reviewms.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private long id;

    @NotBlank(message = "content is required")
    private String content;

    @Positive(message = "productId must be positive")
    private long productId;
    
    @Positive(message = "userId must be positive")
    private long userId;
}
