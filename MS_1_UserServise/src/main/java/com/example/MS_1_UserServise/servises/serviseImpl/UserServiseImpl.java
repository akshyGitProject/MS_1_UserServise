package com.example.MS_1_UserServise.servises.serviseImpl;

import com.example.MS_1_UserServise.DTO.UserDto;
import com.example.MS_1_UserServise.entities.User;
import com.example.MS_1_UserServise.repositories.UserRepo;
import com.example.MS_1_UserServise.servises.UserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiseImpl implements UserServise {
    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDto saveUser(UserDto userDto) {
        return null;
    }

    @Override
    public List<UserDto> getAllUser() {
        return List.of();
    }

    @Override
    public UserDto getUser(String userId) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        return null;
    }

    @Override
    public UserDto deleteUser(String userId) {
        return null;
    }
    //User to UserDto
    public UserDto userToDto(User user){
        UserDto userDto=new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setAbout(user.getAbout());

        return userDto;
    }

    public User DtoToUser(UserDto userDto){

        User user=new User();
        user.setUserId(userDto.getUserId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());

        return user;

    }

}
