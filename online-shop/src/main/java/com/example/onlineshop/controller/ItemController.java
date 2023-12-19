package com.example.onlineshop.controller;

import com.example.onlineshop.domain.ImageModel;
import com.example.onlineshop.dto.ItemDto;
import com.example.onlineshop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemDto>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public ResponseEntity<ItemDto> createNewItems(@RequestPart("imageData") MultipartFile file, @RequestPart("product") ItemDto itemDto) {
        //return ResponseEntity.ok(itemService.createNewItem(itemDto));
        try {
            itemDto.setImages(itemService.uploidImages(file));
            return ResponseEntity.ok(itemService.createNewItem(itemDto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



}
