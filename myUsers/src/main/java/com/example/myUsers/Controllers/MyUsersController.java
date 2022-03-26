package com.example.myUsers.Controllers;

import com.example.myUsers.Models.User;
import com.example.myUsers.Repositories.MyUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.List;

@RestController
public class MyUsersController {

    @Autowired
    MyUsersRepository repository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllAnime() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @PostMapping("/add-user")
    public ResponseEntity addAnime(@RequestBody User user)  {
        repository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body( user.getName() + " was added");
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeUser(@PathVariable String id) {
        repository.deleteGreetingByid(Integer.parseInt(id));
        return ResponseEntity.status(HttpStatus.OK).body("Greeting with ID " + id + " has been deleted");
    }
}
