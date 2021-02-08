package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Product id cannot be empty")
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product")
    @NotNull(message = "Product name cannot be empty")
    private String product;

    @NotNull(message = "Quantity should be at least 1")
    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "last_modified_date")
    @JsonProperty("lastModifiedDate")
    private LocalDate lastModifiedDate;
}
