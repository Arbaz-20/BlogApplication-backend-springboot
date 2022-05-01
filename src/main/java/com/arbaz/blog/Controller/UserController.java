package com.arbaz.blog.Controller;

import com.arbaz.blog.DTO.UserDTO;
import com.arbaz.blog.Services.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //Create User
    @PostMapping(value = "/user")
    public ResponseEntity<UserDTO> CreateUser(@Valid @RequestBody UserDTO userDTO){
        UserDTO user = this.userService.CreateUser(userDTO);
        return new ResponseEntity<UserDTO>(user, HttpStatus.CREATED);
    }

    //Update User
    @PutMapping(value = "/user/{id}")
    public ResponseEntity<?> UpdateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable("id") int userId){
        UserDTO UpdateUser = this.userService.updateUser(userDTO,userId);
        return new ResponseEntity<>(UpdateUser,HttpStatus.OK);
    }
    
    //Get All Users
    @GetMapping(value = "/getUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> userDTOS = this.userService.getAllUser();
        return new ResponseEntity<List<UserDTO>>(userDTOS,HttpStatus.ACCEPTED);
    }

    //Get User By Id
    @GetMapping(value = "/getUser/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") int userId){
        UserDTO user = this.userService.getUserById(userId);
        return new ResponseEntity<UserDTO>(user,HttpStatus.ACCEPTED);
    }

    //Delete User by Id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") int userId){
        this.userService.DeleteUser(userId);
        String message = "Successfully Deleted User";
        return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
    }

    //Delete All Users
    @DeleteMapping("/del")
    public ResponseEntity<?> deleteAllUsers(){
        this.userService.DeleteAllUsers();
        String message = "Deleted All Users";
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

}
