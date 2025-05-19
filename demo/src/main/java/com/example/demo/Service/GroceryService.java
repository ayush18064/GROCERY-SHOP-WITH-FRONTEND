package com.example.demo.Service;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Repository.ConsumerRepo;
import com.example.demo.Repository.ItemRepo;
import com.example.demo.model.Items;
import com.example.demo.model.consumer;

@Service
public class GroceryService {

    @Autowired
    ConsumerRepo consumerRepo;

    @Autowired
    ItemRepo itemRepo;

    public consumer register(consumer c) { // done
        return consumerRepo.save(c);
    }

    public consumer getConsumerById(int id) { // done
        return consumerRepo.findById(id).orElse(null);
    }

    public List<consumer> getAllConsumer() { // done
        return consumerRepo.findAll();
    }

    public Items addItem(Items item) {
        return itemRepo.save(item);
    }

    public List<Items> getAllItems() {
        return itemRepo.findAll();
    }

    public consumer validateConsumer(String email, String password) {
        List<consumer> consumers = consumerRepo.findAll();
        for (consumer c : consumers) {
            if (c.getEmail().equals(email) && c.getPassword().equals(password)) {
                return c;
            }
        }
        return null;
    }

    // add an item

}
