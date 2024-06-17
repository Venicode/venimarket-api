package com.venitmarket.api.domains;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Sell")
@Table(name = "TB_SELLS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Sell {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Long id_customer;
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Long id_product;
    @ManyToOne
    @JoinColumn(name = "id_payment")
    private Long id_payment;
    private double amount;
    private int quantity;
}
