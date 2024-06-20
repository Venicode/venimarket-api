package com.venimarket.api.domains;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "ProductCategory")
@Table(name = "TB_PRODUCTCATEGORY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descriptionCategory;
}
