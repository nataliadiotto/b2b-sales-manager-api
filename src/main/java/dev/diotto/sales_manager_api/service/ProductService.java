package dev.diotto.sales_manager_api.service;

import dev.diotto.sales_manager_api.domain.dto.ProductDTO;
import dev.diotto.sales_manager_api.domain.dto.ProductResponseDTO;
import dev.diotto.sales_manager_api.domain.dto.UpdtProductRequestDTO;
import dev.diotto.sales_manager_api.domain.entity.Product;
import dev.diotto.sales_manager_api.mapper.ProductMapper;
import dev.diotto.sales_manager_api.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponseDTO createProduct(ProductDTO productDTO) {
        Product newProduct = productMapper.toProductEntity(productDTO);
        newProduct = productRepository.save(newProduct);
        return productMapper.toProductResponseDTO(newProduct);
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
