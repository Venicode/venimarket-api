package com.venimarket.api.domains;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private LocalDate productionDate;
    private int quantity;
    @JoinColumn(name = "id_productCategory")
    @ManyToOne
    private ProductCategory productCategory;
    @Column(unique = true)
    private Long barCode;
    private String brand;
    private boolean isActive = true;
}
