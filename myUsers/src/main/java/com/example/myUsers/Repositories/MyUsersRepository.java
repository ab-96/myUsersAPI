package com.example.myUsers.Repositories;

import com.example.myUsers.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUsersRepository extends JpaRepository <User, String> {


    String deleteGreetingByid(int id);


}
