package com.example.onlineshop.controller;

import com.example.onlineshop.domain.AuthenticationRequest;
import com.example.onlineshop.domain.AuthenticationResponse;
import com.example.onlineshop.domain.RegisterRequest;
import com.example.onlineshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    @GetMapping
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getAllUsers(){
        return ResponseEntity.ok("hello!");
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(userService.register(request));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(userService.authenticate(request));
    }
   /* @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String updateUser(@RequestBody UserDTO userDTO, @PathVariable String id){
        return userService.updateUser(userDTO);
    }*/

}
