package dev.diotto.sales_manager_api.mapper;

import dev.diotto.sales_manager_api.domain.dto.ProductDTO;
import dev.diotto.sales_manager_api.domain.dto.ProductResponseDTO;
import dev.diotto.sales_manager_api.domain.dto.UpdtProductRequestDTO;
import dev.diotto.sales_manager_api.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

//Add the correct componentModel attribute to the @Mapper annotation.
//This tells MapStruct to generate the mapper implementation as a Spring component.
@Mapper(componentModel = "spring")
public interface ProductMapper {
    //For converting entity to response DTO
    ProductDTO toProductDTO(Product product);

    //For converting creation DTO to entity
    Product toProductEntity(ProductDTO productDTO);

    //For converting update DTO to entity
    void updateProductEntityFromDTO(UpdtProductRequestDTO updateDTO, @MappingTarget Product product);

    //For converting Product to ProductResponseDTO
    ProductResponseDTO toProductResponseDTO(Product product);
}
