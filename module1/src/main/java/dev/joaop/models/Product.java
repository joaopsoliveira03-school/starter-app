package dev.joaop.models;

import dev.joaop.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
public class Product {
    private String code;
    private String description;
    private Category category;
    private float price;
}
