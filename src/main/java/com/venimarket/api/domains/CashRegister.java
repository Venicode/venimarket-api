package com.venimarket.api.domains;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    private LocalDateTime initialDate;
    private double balance = 0;
    private LocalDateTime finalDate;
    private String isClosed = "NÃO";

    public void closeCashRegister(){
        finalDate = LocalDateTime.now();
        isClosed = "SIM";
    }
}
