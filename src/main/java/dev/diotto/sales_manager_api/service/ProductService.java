package dev.diotto.sales_manager_api.service;

import dev.diotto.sales_manager_api.domain.dto.ProductDTO;
import dev.diotto.sales_manager_api.domain.dto.ProductResponseDTO;
import dev.diotto.sales_manager_api.domain.dto.UpdtProductRequestDTO;
import dev.diotto.sales_manager_api.domain.entity.Product;
import dev.diotto.sales_manager_api.mapper.ProductMapper;
import dev.diotto.sales_manager_api.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
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
        log.info("New product created: {}", newProduct.getName());
        return productMapper.toProductResponseDTO(newProduct);
    }

    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(productMapper::toProductResponseDTO)
                .collect(Collectors.toList());
    }

    public ProductResponseDTO findProductById(Long id) {
        Optional<Product> productResponseEntity = productRepository.findById(id);

        if(productResponseEntity.isEmpty()) {
            throw new EntityNotFoundException("Product not found");
        }
        return productMapper.toProductResponseDTO(productResponseEntity.get());
    }

    public List<ProductResponseDTO> findProductByName(String query) {
        List<Product> products = productRepository.findByNameContainingIgnoreCase(query);

        return products.stream()
                .map(productMapper::toProductResponseDTO)
                .collect(Collectors.toList());

    }

    public ProductResponseDTO updateProduct(Long id, UpdtProductRequestDTO updateDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        productMapper.updateProductEntityFromDTO(updateDTO, existingProduct);

        productRepository.save(existingProduct);

        return productMapper.toProductResponseDTO(existingProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


}
