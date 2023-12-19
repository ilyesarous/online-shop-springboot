package com.example.onlineshop.repository;

import com.example.onlineshop.domain.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item,String> {
}
