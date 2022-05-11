package com.example.myUsers.Services;

import com.example.myUsers.Models.User;
import com.example.myUsers.Repositories.MyUsersRepository;
import org.springframework.stereotype.Service;

@Service
public class MyUsersService {

    private final MyUsersRepository repository;

    public MyUsersService(MyUsersRepository repository) {
        this.repository = repository;
    }

    public void deleteUser(String userId) {
        repository.deleteUserByid(Integer.parseInt(String.valueOf(userId)));
    }

}
