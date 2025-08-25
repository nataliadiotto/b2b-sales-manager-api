package dev.diotto.sales_manager_api.mapper;

import dev.diotto.sales_manager_api.domain.dto.ProductDTO;
import dev.diotto.sales_manager_api.domain.dto.UpdtProductRequestDTO;
import dev.diotto.sales_manager_api.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface ProductMapper {
    //For converting entity to response DTO
    ProductDTO toProductDTO(Product product);

    //For converting creation DTO to entity
    Product toProductEntity(ProductDTO productDTO);

    //For converting update DTO to entity
    void updateProductEntity(UpdtProductRequestDTO updateDTO, @MappingTarget Product product);
}
