package com.example.onlineshop.domain;

import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "image_model")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageModel {

    @Id
    private long id;
    private String name;
    private String type;
    private Binary imageByte;

}
