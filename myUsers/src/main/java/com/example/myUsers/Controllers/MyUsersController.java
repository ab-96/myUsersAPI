package com.example.myUsers.Controllers;

import com.example.myUsers.Models.User;
import com.example.myUsers.Repositories.MyUsersRepository;
import com.example.myUsers.Services.MyUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MyUsersController {

    private final MyUsersService service;

    @Autowired
    MyUsersRepository repository;

    public MyUsersController(MyUsersService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @PostMapping("/add-user")
    public ResponseEntity<User> addUser(@RequestBody User user)  {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(user));
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> removeUser(@PathVariable String id) {
        service.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer id) {

        User currentUser = repository.findById(id);

//        currentUser.setId(user.getId());
        currentUser.setName(user.getName());
        currentUser.setJobTitle(user.getJobTitle());
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(currentUser));
    }




}
