package dev.diotto.sales_manager_api.service;

import dev.diotto.sales_manager_api.domain.dto.ServiceItemDTO;
import dev.diotto.sales_manager_api.domain.dto.ServiceItemResponseDTO;
import dev.diotto.sales_manager_api.domain.dto.ProductUpdtRequestDTO;
import dev.diotto.sales_manager_api.domain.dto.ServiceItemUpdtRequestDTO;
import dev.diotto.sales_manager_api.domain.entity.Product;
import dev.diotto.sales_manager_api.domain.entity.ServiceItem;
import dev.diotto.sales_manager_api.mapper.ServiceItemMapper;
import dev.diotto.sales_manager_api.repository.ServiceItemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ServiceItemService {

    private final ServiceItemRepository serviceItemRepository;
    private final ServiceItemMapper serviceItemMapper;

    @Autowired
    public ServiceItemService(ServiceItemRepository serviceItemRepository, ServiceItemMapper serviceItemMapper) {
        this.serviceItemRepository = serviceItemRepository;
        this.serviceItemMapper = serviceItemMapper;
    }

    public ServiceItemResponseDTO createServiceItem(ServiceItemDTO serviceItemDTO) {
        ServiceItem newServiceItem = serviceItemMapper.toServiceItemEntity(serviceItemDTO);
        newServiceItem = serviceItemRepository.save(newServiceItem);
        log.info("New service item created: {}", newServiceItem.getName());
        return serviceItemMapper.toServiceItemResponseDTO(newServiceItem);
    }

    public List<ServiceItemResponseDTO> getAllServiceItems() {
        List<ServiceItem> serviceItems = serviceItemRepository.findAll();

        return serviceItems.stream()
                .map(serviceItemMapper::toServiceItemResponseDTO)
                .collect(Collectors.toList());
    }

    public ServiceItemResponseDTO findServiceItemById(Long id) {
        Optional<ServiceItem> serviceItemResponseEntity = serviceItemRepository.findById(id);

        if(serviceItemResponseEntity.isEmpty()) {
            throw new EntityNotFoundException("Service item not found");
        }
        return serviceItemMapper.toServiceItemResponseDTO(serviceItemResponseEntity.get());
    }

    public List<ServiceItemResponseDTO> findServiceItemByName(String query) {
        List<ServiceItem> serviceItems = serviceItemRepository.findByNameContainingIgnoreCase(query);

        return serviceItems.stream()
                .map(serviceItemMapper::toServiceItemResponseDTO)
                .collect(Collectors.toList());

    }

    public ServiceItemResponseDTO updateServiceItem(Long id, ServiceItemUpdtRequestDTO updateDTO) {
        ServiceItem existingServiceItem = serviceItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Service item not found with id: " + id));

        serviceItemMapper.updateServiceItemEntityFromDTO(updateDTO, existingServiceItem);

        serviceItemRepository.save(existingServiceItem);

        return serviceItemMapper.toServiceItemResponseDTO(existingServiceItem);
    }

    public void deleteServiceItem(Long id) {
        serviceItemRepository.deleteById(id);
    }


}
