package dev.diotto.sales_manager_api.mapper;

import dev.diotto.sales_manager_api.domain.dto.*;
import dev.diotto.sales_manager_api.domain.entity.Product;
import dev.diotto.sales_manager_api.domain.entity.ServiceItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

//Add the correct componentModel attribute to the @Mapper annotation.
//This tells MapStruct to generate the mapper implementation as a Spring component.
@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ServiceItemMapper {
    //For converting entity to response DTO
    ServiceItemDTO toServiceItemDTO(ServiceItem serviceItem);

    //For converting creation DTO to entity
    ServiceItem toServiceItemEntity(ServiceItemDTO serviceItemDTO);

    //For converting update DTO to entity
    @Mapping(target = "id", ignore = true)
    void updateServiceItemEntityFromDTO(ServiceItemUpdtRequestDTO updateDTO, @MappingTarget ServiceItem serviceItem);

    //For converting Product to ProductResponseDTO
    ServiceItemResponseDTO toServiceItemResponseDTO(ServiceItem serviceItem);
}
