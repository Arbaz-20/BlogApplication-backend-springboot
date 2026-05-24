package com.arbaz.blog.Services;


import com.arbaz.blog.DTO.UserDTO;

import java.util.List;

public interface UserService {

    //Create User
    public UserDTO CreateUser(UserDTO userDTO);

    //Update User
    public UserDTO updateUser(UserDTO userDTO,Integer userId);

    //Get User by ID
    public UserDTO getUserById(Integer userId);

    public UserDTO getUserByName(String name);

    //Get All Users
    List<UserDTO> getAllUser();

    //Delete User
    void DeleteUser(Integer userId);

    //Delete All Users
    void DeleteAllUsers();
}
