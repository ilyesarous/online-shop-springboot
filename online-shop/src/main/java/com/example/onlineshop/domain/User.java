package com.example.onlineshop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(value = "user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User  {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String password;
    private int role;


}
