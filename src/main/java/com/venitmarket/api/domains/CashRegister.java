package com.venitmarket.api.domains;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "CashRegister")
@Table(name="TB_CASHREGISTER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CashRegister {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private double balance;
}
