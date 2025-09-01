package dev.diotto.sales_manager_api.repository;

import dev.diotto.sales_manager_api.domain.entity.Product;
import dev.diotto.sales_manager_api.domain.entity.ServiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceItemRepository extends JpaRepository<ServiceItem, Long> {

    List<ServiceItem> findByNameContainingIgnoreCase(String query);
}
