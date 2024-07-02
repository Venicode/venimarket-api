package com.venimarket.api.domains;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Order")
@Table(name = "TB_ORDERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "id_customer")
    @ManyToOne
    private Customer customer;
    @JoinColumn(name = "id_methodPayment")
    @ManyToOne
    private MethodPayment methodPayment;
    private LocalDateTime sellDate;
}
