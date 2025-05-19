package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.consumer;

@Repository
public interface ConsumerRepo extends JpaRepository<consumer,Integer>{

}
