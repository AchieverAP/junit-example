package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
