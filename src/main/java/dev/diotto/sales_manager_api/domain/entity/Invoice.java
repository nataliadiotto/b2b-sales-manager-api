package dev.diotto.sales_manager_api.domain.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    private Long saleId;
    private String invoiceNumber;
    private LocalDateTime generatedAt;
    private String status;
    private String nfeReference;
    private String xmlPath;
    private String danfePath;

    @OneToOne
    @MapsId
    @JoinColumn(name = "sale_id")
    private Sale sale;

}
