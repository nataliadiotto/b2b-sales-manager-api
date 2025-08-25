package dev.diotto.sales_manager_api.service;

import dev.diotto.sales_manager_api.domain.dto.UpdtProductRequestDTO;
import dev.diotto.sales_manager_api.domain.entity.Product;
import dev.diotto.sales_manager_api.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Long id, UpdtProductRequestDTO updateDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        if (updateDTO.name() != null) existingProduct.setName(updateDTO.name());
        if (updateDTO.description() != null) existingProduct.setDescription(updateDTO.description());
        if (updateDTO.unitPrice() != null) existingProduct.setUnitPrice(updateDTO.unitPrice());

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


}
