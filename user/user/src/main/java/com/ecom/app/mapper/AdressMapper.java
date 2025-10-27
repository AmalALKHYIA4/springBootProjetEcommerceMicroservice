package com.ecom.app.mapper;

import com.ecom.app.dto.AdressDto;
import com.ecom.app.models.Adresses;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdressMapper {

    Adresses toEntity(AdressDto dto);
    AdressDto toDto(Adresses entity);  // <-- corriger le retour
}

