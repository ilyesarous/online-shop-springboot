package com.example.onlineshop.service;

import com.example.onlineshop.domain.ImageModel;
import com.example.onlineshop.dto.ItemDto;
import com.example.onlineshop.factory.ItemFactory;
import com.example.onlineshop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public List<ItemDto> getAllItems() {
        return ItemFactory.itemsToItemsDto(itemRepository.findAll());
    }

    public ItemDto createNewItem(ItemDto itemDto) {
        return ItemFactory.itemToItemDto(itemRepository.save(ItemFactory.itemDtoToItem(itemDto)));
    }

    /*public long addPhoto(String name, MultipartFile file) throws IOException {
        ImageModel photo = new ImageModel();
        photo.setImageByte(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        //photo = .insert(photo); return photo.getId();
    }*/
    public Set<ImageModel> uploidImages(MultipartFile multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<>();

        ImageModel photo = new ImageModel();
        photo.setImageByte(
                new Binary(BsonBinarySubType.BINARY, multipartFiles.getBytes()));
        photo.setType(multipartFiles.getContentType());
        photo.setType(multipartFiles.getName());

        imageModels.add(photo);


        return imageModels;
    }

}
