package com.example.MS_1_UserServise.Controller;

import com.example.MS_1_UserServise.DTO.UserDto;
import com.example.MS_1_UserServise.Payload.ApiResponse;
import com.example.MS_1_UserServise.servises.UserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServise userServise;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable String userId){

        UserDto userDto=userServise.getUser(userId);

        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAlUser(){

        List<UserDto> userDtos=userServise.getAllUser();

        return new ResponseEntity<>(userDtos,HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){

        UserDto userDto1=userServise.saveUser(userDto);

        return new ResponseEntity<>(userDto1,HttpStatus.CREATED);

    }

    @PostMapping("/{userId}")
    public  ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable String userId){
        UserDto userDto1=userServise.updateUser(userDto,userId);

        return new ResponseEntity<UserDto>(userDto1,HttpStatus.OK);
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable String userId){

        userServise.deleteUser(userId);

        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",false,HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }
}
