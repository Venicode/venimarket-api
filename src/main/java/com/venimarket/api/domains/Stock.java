package com.venimarket.api.domains;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Stock")
@Table(name = "TB_STOCK")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "id_product")
    @ManyToOne
    private Product product;
    private int quantity;
}
