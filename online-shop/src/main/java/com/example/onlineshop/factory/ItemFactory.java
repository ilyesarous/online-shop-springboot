package com.example.onlineshop.factory;

import com.example.onlineshop.domain.Item;
import com.example.onlineshop.dto.ItemDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ItemFactory {

    public static ItemDto itemToItemDto(Item item){
        return ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .images(item.getImages())
                .description(item.getDescription())
                .date(item.getDate())
                .build();
    }
    public static Item itemDtoToItem(ItemDto itemDto){
        return Item.builder()
                .id(UUID.randomUUID().toString())
                .name(itemDto.getName())
                .price(itemDto.getPrice())
                .images(itemDto.getImages())
                .description(itemDto.getDescription())
                .date(LocalDateTime.now().toString())
                .build();
    }

    public static List<ItemDto> itemsToItemsDto(List<Item> items){
        return items.stream().map(ItemFactory::itemToItemDto).toList();
    }

}
