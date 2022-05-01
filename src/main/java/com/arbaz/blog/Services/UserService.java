package com.arbaz.blog.Services;


import com.arbaz.blog.DTO.UserDTO;

import java.util.List;

public interface UserService {

    public UserDTO CreateUser(UserDTO userDTO);

    public UserDTO updateUser(UserDTO userDTO,Integer userId);

    public UserDTO getUserById(Integer userId);

    List<UserDTO> getAllUser();

    void DeleteUser(Integer userId);

    void DeleteAllUsers();
}
