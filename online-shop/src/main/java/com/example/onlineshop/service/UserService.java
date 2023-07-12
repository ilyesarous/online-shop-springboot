package com.example.onlineshop.service;

import com.example.onlineshop.config.JwtService;
import com.example.onlineshop.domain.AuthenticationRequest;
import com.example.onlineshop.domain.AuthenticationResponse;
import com.example.onlineshop.domain.RegisterRequest;
import com.example.onlineshop.domain.User;
import com.example.onlineshop.dto.UserDTO;
import com.example.onlineshop.factory.UserFactory;
import com.example.onlineshop.repository.UserRepository;
import com.example.onlineshop.tools.enumeration.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;



    public List<UserDTO> getAllUsers() {
        return UserFactory.usersToUsersDTO(userRepository.findAll());
    }

   /* public UserDTO addUser(UserDTO userDTO) {
        if(userRepository.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword()).isPresent())
            throw new ResourceAlreadyExistsException(userDTO.getEmail());
        return UserFactory.userToUserDTO(userRepository.save(UserFactory.userDtoToUser(userDTO)));
    }

    public String updateUser(UserDTO userDTO){
        Optional<User> user = userRepository.findById(userDTO.getId());
        if (user.isPresent()) {
            user.get().setEmail(userDTO.getEmail());
            user.get().setPassword(userDTO.getPassword());
            userRepository.save(user.get());
            return "user updated";
        }
        return "user is not found!";
    }*/

    public AuthenticationResponse register(RegisterRequest request) {
        UserDTO userDTO = UserDTO.builder()
                .id(UUID.randomUUID().toString())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CLIENT)
                .build();
        System.out.println("**************UserDto Created**********************");
        userRepository.save(UserFactory.userDtoToUser(userDTO));
        System.out.println("**********************User saved**********************");
        String jwtToken = jwtService.generateToken(userDTO);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        UserDTO userDTO = UserFactory.userToUserDTO(user);

        var jwtToken = jwtService.generateToken(userDTO);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
