package com.example.MS_1_UserServise.DTO;

import com.example.MS_1_UserServise.entities.Rating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String userId;
    private String name;
    private String email;
    private String about;
    private List<Rating> rating=new ArrayList<>();
}
