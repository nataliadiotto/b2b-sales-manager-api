package dev.diotto.sales_manager_api.controller;

import dev.diotto.sales_manager_api.domain.dto.ProductDTO;
import dev.diotto.sales_manager_api.domain.dto.ProductResponseDTO;
import dev.diotto.sales_manager_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductResponseDTO productResponseDTO = productService.createProduct(productDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productResponseDTO);

    }

//    Pet newPet = petService.registerPet(petDTO);
//
//    PetResponseDTO petResponseDTO = new PetResponseDTO(newPet);
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//            .body(petResponseDTO);

}
