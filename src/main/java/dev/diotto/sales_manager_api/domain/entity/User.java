package dev.diotto.sales_manager_api.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;
    //private UserRole role;

    @OneToMany(mappedBy = "user")
    private List<Sale> sales;


}
