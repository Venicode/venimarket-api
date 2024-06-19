package com.venimarket.api.domains;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Product")
@Table(name = "TB_PRODUCTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private double costPrice;
    private double sellingPrice;
    @JoinColumn(name = "id_supplier")
    @ManyToOne
    private Supplier supplier;
    private String productionDate;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;
    @Column(unique = true)
    private Long barCode;
    private String brand;
    private boolean isActive = true;
}
