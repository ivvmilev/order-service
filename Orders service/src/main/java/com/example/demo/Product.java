package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
public class Product
{

    private Long id;

    private String name;

    private String category;

    private String description;

    private int quantity = 0;

    private LocalDate createdDate;

    private LocalDate lastModifiedDate;
}
