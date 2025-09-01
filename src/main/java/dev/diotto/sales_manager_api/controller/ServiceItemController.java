package dev.diotto.sales_manager_api.controller;

import dev.diotto.sales_manager_api.domain.dto.*;
import dev.diotto.sales_manager_api.service.ServiceItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/service_items")
public class ServiceItemController {

    private final ServiceItemService serviceItemService;

    @Autowired
    ServiceItemController(ServiceItemService serviceItemService) {
        this.serviceItemService = serviceItemService;
    }

    @PostMapping
    public ResponseEntity<ServiceItemResponseDTO> createProduct(@RequestBody @Valid ServiceItemDTO serviceItemDTO) {
        ServiceItemResponseDTO responseDTO = serviceItemService.createServiceItem(serviceItemDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responseDTO);

    }

    @GetMapping
    public ResponseEntity<List<ServiceItemResponseDTO>> getAllServiceItems() {
        List<ServiceItemResponseDTO> responseDTOS = serviceItemService.getAllServiceItems();

        return ResponseEntity.ok(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceItemResponseDTO> getServiceItem(@PathVariable Long id) {
        ServiceItemResponseDTO responseDTO = serviceItemService.findServiceItemById(id);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/search/{query}")
    public ResponseEntity<List<ServiceItemResponseDTO>> getServiceItemByName(@PathVariable String query) {
        List<ServiceItemResponseDTO> responseDTOS = serviceItemService.findServiceItemByName(query);

        return ResponseEntity.ok(responseDTOS);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceItemResponseDTO> updateServiceItem(@PathVariable Long id, @RequestBody ServiceItemUpdtRequestDTO requestDTO) {
        ServiceItemResponseDTO updateResponseDTO = serviceItemService.updateServiceItem(id, requestDTO);

        return ResponseEntity.ok(updateResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceItemById(@PathVariable Long id) {
        serviceItemService.deleteServiceItem(id);

        return ResponseEntity.noContent().build();
    }

}
