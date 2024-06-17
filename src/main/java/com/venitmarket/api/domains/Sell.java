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
    @JoinColumn(name = "id_customer")
    @ManyToOne
    private Customer customer;
    @JoinColumn(name = "id_product")
    @ManyToOne
    private Product product;
    @JoinColumn(name = "id_methodPayment")
    @ManyToOne
    private MethodPayment methodPayment;
    private double amount;
    private int quantity;
}
