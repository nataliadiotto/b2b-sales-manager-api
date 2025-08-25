package dev.diotto.sales_manager_api.domain.dto;

import java.math.BigDecimal;

public record ProductDTO (String name, String description, BigDecimal unitPrice) {
}
