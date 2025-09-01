package dev.diotto.sales_manager_api.domain.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleItem>  saleItems;

    @ManyToOne
    private Company company;

    @ManyToOne
    private User user;

    @OneToOne(mappedBy = "sale")
    private Invoice invoice;

}
