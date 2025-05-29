package com.example.MS_1_UserServise.repositories;

import com.example.MS_1_UserServise.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User,String> {



}
