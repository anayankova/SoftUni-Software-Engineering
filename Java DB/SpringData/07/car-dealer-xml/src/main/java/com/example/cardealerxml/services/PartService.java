package com.example.cardealerxml.services;


import com.example.cardealerxml.models.dtos.PartSeedDto;
import com.example.cardealerxml.models.entities.Part;

import java.util.List;
import java.util.Set;

public interface PartService {
    void seedParts(List<PartSeedDto> partSeedDtos);

    Set<Part> getRandomParts();
}
