package com.example.cardealerxml.services;

import com.example.cardealerxml.models.dtos.SupplierSeedDto;
import com.example.cardealerxml.models.dtos.SupplierViewRootDto;
import com.example.cardealerxml.models.entities.Supplier;

import java.util.List;

public interface SupplierService {
    void seedSuppliers(List<SupplierSeedDto> supplierSeedDtos);

    Supplier getRandomSupplier();

    SupplierViewRootDto getAllLocalSuppliers();
}
