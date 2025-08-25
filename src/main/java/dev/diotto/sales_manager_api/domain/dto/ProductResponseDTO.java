package dev.diotto.sales_manager_api.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductResponseDTO(Long id, String name, String description, BigDecimal unitPrice, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
