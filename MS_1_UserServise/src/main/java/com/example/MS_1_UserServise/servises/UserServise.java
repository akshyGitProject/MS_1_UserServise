package com.example.MS_1_UserServise.servises;

import com.example.MS_1_UserServise.DTO.UserDto;
import com.example.MS_1_UserServise.entities.User;

import java.util.List;

public interface UserServise {
    //create
    UserDto saveUser(UserDto userDto);

    //getAllUser
    List<UserDto> getAllUser();

    //getAllUser
    UserDto getUser(String userId);

    //updateUser
    UserDto updateUser(UserDto userDto,String userId);

    //deleteUser
    UserDto deleteUser(String userId);


}
