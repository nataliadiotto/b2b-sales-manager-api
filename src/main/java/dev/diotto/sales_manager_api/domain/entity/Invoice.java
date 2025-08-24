package dev.diotto.sales_manager_api.domain.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleId;
    private String invoiceNumber;
    private LocalDateTime generatedAt;
    private String status;
    private String nfeReference;
    private String xmlPath;
    private String danfePath;

    @OneToOne
    private Sale sale;
}
