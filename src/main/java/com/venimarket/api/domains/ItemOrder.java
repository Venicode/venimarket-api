package com.venimarket.api.domains;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Sell")
@Table(name = "TB_SELLS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ItemOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @JoinColumn(name = "id_product")
    @ManyToOne
    private Product product;
    @JoinColumn(name = "id_order")
    @ManyToOne
    private Order order;
    private double amount;
    private int quantity;
}
