package dev.diotto.sales_manager_api.service;

import dev.diotto.sales_manager_api.repository.ServiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceItemService {

    private final ServiceItemRepository serviceItemRepository;

    @Autowired
    public ServiceItemService(ServiceItemRepository serviceItemRepository) {
        this.serviceItemRepository = serviceItemRepository;
    }



}
