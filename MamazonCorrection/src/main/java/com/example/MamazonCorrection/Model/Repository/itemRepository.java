package com.example.MamazonCorrection.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MamazonCorrection.Model.Entity.Item;

@Repository
public interface itemRepository extends JpaRepository<Item, Long> {

}
