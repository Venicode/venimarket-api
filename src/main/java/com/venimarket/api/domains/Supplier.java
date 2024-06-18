package com.venimarket.api.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity(name = "Supplier")
@Table(name = "TB_SUPPLIERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String cnpj;
    @Column(unique = true)
    private String corporateName;
    private String tradeName;
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    @Email
    private String email;
}
