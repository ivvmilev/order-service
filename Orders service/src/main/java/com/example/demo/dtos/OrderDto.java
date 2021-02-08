package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDate;

public class OrderDto implements Serializable
{
    @JsonIgnore
    private Long id;

    private Long productId;

    private String product;

    private Integer quantity;

    private LocalDate createdDate;

    private LocalDate lastModifiedDate;

    @JsonCreator
    public OrderDto()
    {
    }


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getProductId()
    {
        return productId;
    }

    public void setProductId(Long productId)
    {
        this.productId = productId;
    }

    public String getProduct()
    {
        return product;
    }

    public void setProduct(String product)
    {
        this.product = product;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public LocalDate getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate)
    {
        this.createdDate = createdDate;
    }

    public LocalDate getLastModifiedDate()
    {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate)
    {
        this.lastModifiedDate = lastModifiedDate;
    }


    public OrderDto(@JsonProperty("productId") Long productId,
                    @JsonProperty("product") String product,
                    @JsonProperty("quantity") Integer quantity)
    {
        this.productId = productId;
        this.product = product;
        this.quantity = quantity;
    }
}
