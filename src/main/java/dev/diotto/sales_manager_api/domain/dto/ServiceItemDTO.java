package dev.diotto.sales_manager_api.domain.dto;

import java.math.BigDecimal;

public record ServiceItemDTO(String name, String description, BigDecimal unitPrice, String duration) {
}
