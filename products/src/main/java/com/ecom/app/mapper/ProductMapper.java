package com.ecom.app.mapper;


import com.ecom.app.dtos.ProductRequest;
import com.ecom.app.dtos.ProductResponse;
import com.ecom.app.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring") //componentModel permet d'injecter le mapper via autowired ou via constructeur
public interface ProductMapper {

    Product toEntity(ProductRequest dto) ;
    ProductResponse toResponse(Product entity);
    void updateEntityFromDto(ProductRequest dto, @MappingTarget Product entity);


}
