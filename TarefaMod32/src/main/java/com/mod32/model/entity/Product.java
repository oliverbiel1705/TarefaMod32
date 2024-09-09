package com.mod32.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Entity
@Table(name = "TB_PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    @Size(max = 50, message = "\n *** Maximum 50 characters *** \n")
    @NotBlank(message = "\n *** The field is blank *** \n")
    private String name;

    @Column(nullable = false, length = 100)
    @Size(max = 50, message = "\n *** Maximum 100 characters *** \n")
    @NotBlank(message = "\n *** The field is blank *** \n")
    private String description;
}
