package dev.diotto.sales_manager_api.controller;

import dev.diotto.sales_manager_api.domain.dto.ProductDTO;
import dev.diotto.sales_manager_api.domain.dto.ProductResponseDTO;
import dev.diotto.sales_manager_api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody @Valid ProductDTO productDTO) {
        ProductResponseDTO productResponseDTO = productService.createProduct(productDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productResponseDTO);

    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        List<ProductResponseDTO> productResponseDTOS = productService.getAllProducts();

        return ResponseEntity.ok(productResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable Long id) {
        ProductResponseDTO productResponseDTO = productService.findProductById(id);

        return ResponseEntity.ok(productResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }

}
