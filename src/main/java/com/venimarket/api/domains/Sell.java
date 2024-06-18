package com.venimarket.api.domains;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Sell")
@Table(name = "TB_SELLS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Sell {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
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
    private LocalDateTime sellDate;
}
