package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Service.GroceryService;
import com.example.demo.model.Items;
import com.example.demo.model.consumer;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GroceryController {

    @Autowired
    GroceryService groceryService;

    @PostMapping("/register")
    public consumer registerConsumer(@RequestBody consumer c) {
        return groceryService.register(c);
    }

    @GetMapping("/consumer/{id}")
    public consumer getConsumerById(@PathVariable int id) {
        return groceryService.getConsumerById(id);
    }

    @GetMapping("/getAllConsumer")
    public List<consumer> getAllConsumer() {
        return groceryService.getAllConsumer();
    }

    @PostMapping("/addItem")
    public Items addItem(@RequestBody Items item) {
        return groceryService.addItem(item);
    }

    @GetMapping("/getAllItems")
    public List<Items> getAllItems() {
        return groceryService.getAllItems();
    }

    // validate the user
    @PostMapping("/login")
    public consumer loginConsumer(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");
        consumer c = groceryService.validateConsumer(email, password);
        if (c != null) {
            return c;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password");

        }
    }

}
