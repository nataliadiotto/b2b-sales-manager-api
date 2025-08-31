package dev.diotto.sales_manager_api.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ServiceItemResponseDTO(Long id, String name, String description, BigDecimal unitPrice, String duration, LocalDateTime createdAt, LocalDateTime updatedAt, boolean active) {
}
