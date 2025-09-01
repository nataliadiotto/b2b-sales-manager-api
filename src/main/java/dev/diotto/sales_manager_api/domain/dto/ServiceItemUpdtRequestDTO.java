package dev.diotto.sales_manager_api.domain.dto;

import java.math.BigDecimal;

public record ServiceItemUpdtRequestDTO(String name, String description, BigDecimal unitPrice, String duration, boolean active) {

}
