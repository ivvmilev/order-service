package com.example.demo;

import liquibase.pro.packaged.L;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class ProductOrder
{
    @NotNull
    private long productId;

    @NotNull
    @Min(1)
    private int quantity;

    @NotNull
    private String productName;
}
