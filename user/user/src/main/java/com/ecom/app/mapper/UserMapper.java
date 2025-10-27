package com.ecom.app.mapper;

import com.ecom.app.dto.UserRequest;
import com.ecom.app.dto.UserResponse;
import com.ecom.app.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring" , uses = {AdressMapper.class}) //mapper va générer le code pour convertir entity en dto et componentModel pour utiliser UserMapper sans le faire manuellement
public interface UserMapper {

    User toEntity (UserRequest dto);
    UserResponse toResponse (User entity);




}
