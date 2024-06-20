package com.venimarket.api.domains;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "MethodPayment")
@Table(name = "TB_METHODSPAYMENTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MethodPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descriptionMethodPayment;
}
