package dev.diotto.sales_manager_api.service;

import dev.diotto.sales_manager_api.domain.entity.Product;
import dev.diotto.sales_manager_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

}
