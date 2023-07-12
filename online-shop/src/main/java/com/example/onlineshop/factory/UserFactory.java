package com.example.onlineshop.factory;

import com.example.onlineshop.domain.User;
import com.example.onlineshop.dto.UserDTO;

import java.util.List;
import java.util.UUID;

import static com.example.onlineshop.tools.enumeration.Role.*;

public class UserFactory {

    public static UserDTO userToUserDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(switch (user.getRole()) {
                    case 1 -> ADMIN;
                    case 3 -> SELLER;
                    default -> CLIENT;
                })
                .build();
    }

    public static User userDtoToUser(UserDTO userDTO){
        return User.builder()
                .id(userDTO.getId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .age(userDTO.getAge())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .role(switch (userDTO.getRole()) {
                    case ADMIN -> 1;
                    case CLIENT -> 2;
                    case SELLER -> 3;
                })
                .build();
    }

    public static List<UserDTO> usersToUsersDTO(List<User> users){
        return users.stream().map(UserFactory::userToUserDTO).toList();
    }

}
