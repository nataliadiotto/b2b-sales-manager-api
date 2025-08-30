package dev.diotto.sales_manager_api.controller;

import dev.diotto.sales_manager_api.domain.dto.ProductDTO;
import dev.diotto.sales_manager_api.domain.dto.ProductResponseDTO;
import dev.diotto.sales_manager_api.domain.dto.UpdtProductRequestDTO;
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
        ProductResponseDTO responseDTO = productService.createProduct(productDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responseDTO);

    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        List<ProductResponseDTO> responseDTOS = productService.getAllProducts();

        return ResponseEntity.ok(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable Long id) {
        ProductResponseDTO responseDTO = productService.findProductById(id);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/search/{query}")
    public ResponseEntity<List<ProductResponseDTO>> getProductByName(@PathVariable String query) {
        List<ProductResponseDTO> responseDTOS = productService.findProductByName(query);

        return ResponseEntity.ok(responseDTOS);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id, @RequestBody UpdtProductRequestDTO requestDTO) {
        ProductResponseDTO updateResponseDTO = productService.updateProduct(id, requestDTO);

        return ResponseEntity.ok(updateResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }

}
