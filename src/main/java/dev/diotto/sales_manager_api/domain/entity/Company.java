package dev.diotto.sales_manager_api.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "companies")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @NotBlank @Size(min = 2, max = 255) private String legalName;
    @Setter @NotBlank @Size(min = 2, max = 255) private String cnpj;
    @Setter @NotBlank @Size(min = 2, max = 255) @Email private String email;
    @Setter @NotBlank @Size(min = 2, max = 255) private String address;
    @Setter @NotBlank @Size(min = 2, max = 255) private String phone;


}
