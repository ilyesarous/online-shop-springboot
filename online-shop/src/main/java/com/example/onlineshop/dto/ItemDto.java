package com.example.onlineshop.dto;

import com.example.onlineshop.domain.ImageModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private String id;
    private Set<ImageModel> images;
    private String name;
    private String price;
    private String description;
    private String date;
}
