package dev.diotto.sales_manager_api.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String legalName;
    private String cnpj;
    private String email;
    private String address;
    private String phone;


}
