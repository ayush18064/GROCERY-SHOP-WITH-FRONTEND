package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Items;

@Repository
public interface ItemRepo extends JpaRepository<Items,Integer> {

}
