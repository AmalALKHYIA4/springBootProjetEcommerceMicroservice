package com.ecom.app.service;

import com.ecom.app.dto.UserRequest;
import com.ecom.app.dto.UserResponse;
import com.ecom.app.mapper.UserMapper;
import com.ecom.app.models.User;
import com.ecom.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserResponse> fetchAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList());
    }

    // Récupérer un utilisateur par ID
    public UserResponse fetchUser(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toResponse)
                .orElse(null);
    }

    // Ajouter un nouvel utilisateur
    public UserResponse addUser(UserRequest request) {
        User user = userMapper.toEntity(request);
        User saved = userRepository.save(user);
        return userMapper.toResponse(saved);
    }

    // Mettre à jour un utilisateur
    public UserResponse updateUser(Long id, UserRequest request) {
        return userRepository.findById(id)
                .map(existing -> {
                    User updatedUser = userMapper.toEntity(request);
                    updatedUser.setId(id);
                    User saved = userRepository.save(updatedUser);
                    return userMapper.toResponse(saved);
                })
                .orElse(null);
    }

    // Supprimer un utilisateur
    public boolean deleteUser(Long id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
