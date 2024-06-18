package com.venimarket.api.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity(name = "Customer")
@Table(name = "TB_CUSTOMERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String cpf;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    @Email
    private String email;
}
