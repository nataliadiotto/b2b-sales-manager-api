package dev.diotto.sales_manager_api.domain.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "saleItems")
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private Integer quantity;
    private BigDecimal priceAtSale;

    @ManyToOne
    private Sale sale;

}
