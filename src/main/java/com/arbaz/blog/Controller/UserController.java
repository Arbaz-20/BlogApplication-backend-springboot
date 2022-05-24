package com.arbaz.blog.Controller;

import com.arbaz.blog.DTO.APIResponse;
import com.arbaz.blog.DTO.UserDTO;
import com.arbaz.blog.Entity.User;
import com.arbaz.blog.Services.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(name = "/")
public class UserController {

    public static final String DEFAULT_ROLE = "ROLE_USER";

    public static final String[] ADMIN_ROLE = {"ROLE_ADMIN","ROLE_USER"};

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    //Create User
    @PostMapping(value = "/user")
    public ResponseEntity<UserDTO> CreateUser(@Valid @RequestBody UserDTO userDTO){
        userDTO.setRole(DEFAULT_ROLE);
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        UserDTO user = this.userService.CreateUser(userDTO);
        return new ResponseEntity<UserDTO>(user, HttpStatus.CREATED);
    }

    //Update User
    @PutMapping(value = "/user/{id}")
    public ResponseEntity<?> UpdateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable("id") int userId){
        userDTO.setRole(DEFAULT_ROLE);
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        UserDTO UpdateUser = this.userService.updateUser(userDTO,userId);
        return new ResponseEntity<>(UpdateUser,HttpStatus.OK);
    }
    
    //Get All Users
    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/getUsers")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
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
    //Admin

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
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


    //Authentication and Authorization of User
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/access/{userId}/{role}")
    public ResponseEntity<APIResponse> giveAccessToUser(@PathVariable("id") int userID, @PathVariable("role") String userRole, Principal principal){
        UserDTO userDTO = userService.getUserById(userID);
        List<String> activeRoles = getRolesByLoggedInUser(principal);
        if(activeRoles.contains(userRole)){
            String newRole = userDTO.getRole()+","+activeRoles;
            userDTO.setRole(newRole);
        }
        userService.updateUser(userDTO,userID);
        return new ResponseEntity<>(new APIResponse("Role Assigned to"+userDTO.getName(),true),HttpStatus.OK);
    }

    private List<String> getRolesByLoggedInUser(Principal principal) {
        String roles = loggedInUser(principal).getUserRole();
        List<String> assignRole = Arrays.stream(roles.split(",")).collect(Collectors.toList());
        if (assignRole.contains(ADMIN_ROLE)) {
            return Arrays.stream(ADMIN_ROLE).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private User loggedInUser(Principal principal){
        UserDTO userDTO = userService.getUserByName(principal.getName());
        User user = this.modelMapper.map(userDTO,User.class);
        return user;
    }

}
