package com.example.cardealerxml.services.impl;

import com.example.cardealerxml.models.dtos.SupplierSeedDto;
import com.example.cardealerxml.models.dtos.SupplierViewDto;
import com.example.cardealerxml.models.dtos.SupplierViewRootDto;
import com.example.cardealerxml.models.entities.Supplier;
import com.example.cardealerxml.repositories.SupplierRepository;
import com.example.cardealerxml.services.SupplierService;
import com.example.cardealerxml.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Random random;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Random random) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.random = random;
    }

    @Override
    public void seedSuppliers(List<SupplierSeedDto> supplierSeedDtos) {
        supplierSeedDtos
                .forEach(supplierSeedDto -> {
                    if(this.validationUtil.isValid(supplierSeedDto)){
                        if(this.supplierRepository
                                .findByName(supplierSeedDto.getName()) == null){

                            Supplier supplier = this.modelMapper
                                    .map(supplierSeedDto, Supplier.class);

                            this.supplierRepository.saveAndFlush(supplier);

                        }else {
                            System.out.println("Already in DB");
                        }
                    }else {
                        this.validationUtil
                                .violations(supplierSeedDto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                });
    }

    @Override
    public Supplier getRandomSupplier() {
        long randomId = this.random
                .nextInt((int) this.supplierRepository.count()) + 1;

        return this.supplierRepository.getOne(randomId);
    }

    @Override
    public SupplierViewRootDto getAllLocalSuppliers() {
        SupplierViewRootDto supplierViewRootDto = new SupplierViewRootDto();

        List<SupplierViewDto> supplierViewDtos = this.supplierRepository.findAllByImporterFalse()
                .stream().map(s -> this.modelMapper.map(s, SupplierViewDto.class))
                .collect(Collectors.toList());

        for (int i = 0; i < supplierViewDtos.size(); i++) {
            supplierViewDtos.get(i).setPartsCount(
                    this.supplierRepository.findAllByImporterFalse().get(i).getParts().size());
        }

        supplierViewRootDto.setSuppliers(supplierViewDtos);

        return supplierViewRootDto;
    }
}
