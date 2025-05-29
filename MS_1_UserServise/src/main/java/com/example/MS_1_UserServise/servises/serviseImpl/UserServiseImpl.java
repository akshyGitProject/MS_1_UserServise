package com.example.MS_1_UserServise.servises.serviseImpl;

import com.example.MS_1_UserServise.DTO.UserDto;
import com.example.MS_1_UserServise.entities.User;
import com.example.MS_1_UserServise.exceptions.ResourseNotFoundException;
import com.example.MS_1_UserServise.repositories.UserRepo;
import com.example.MS_1_UserServise.servises.UserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiseImpl implements UserServise {
    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDto saveUser(UserDto userDto) {
        //Creating unique UserId:
        String RandomId= UUID.randomUUID().toString();
        User user=DtoToUser(userDto);

        user.setUserId(RandomId);

        User save=userRepo.save(user);

        return userToDto(save);
    }

    @Override
    public List<UserDto> getAllUser() {

        List<User> patients=userRepo.findAll();
        List<UserDto> userDtos=new ArrayList<>();

        for(User user:patients){
            UserDto userDto=userToDto(user);
            userDtos.add(userDto);
        }

        return userDtos;

    }

    @Override
    public UserDto getUser(String userId) {
        User user=userRepo.findById(userId).
                orElseThrow(()->new ResourseNotFoundException("User is NotPresent"));
        return userToDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        User user=userRepo.findById(userId).
                orElseThrow(()->new ResourseNotFoundException("User not present"));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());

        User saved=userRepo.save(user);
        return userToDto(saved);
    }

    @Override
    public UserDto deleteUser(String userId) {
        User user=userRepo.findById(userId).
                orElseThrow(()->new ResourseNotFoundException("User is NotPresent"));
        userRepo.delete(user);

        return userToDto(user);
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
