package com.arbaz.blog.ServiceImplementation;

import com.arbaz.blog.Entity.User;
import com.arbaz.blog.Exceptions.ResourceNotFoundException;
import com.arbaz.blog.DTO.UserDTO;
import com.arbaz.blog.Repository.UserRepository;
import com.arbaz.blog.Services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    //Save User
    @Override
    public UserDTO CreateUser(UserDTO userDTO) {
        User user = this.DTOtoUser(userDTO);
        User savedUser = userRepository.save(user);
        return this.UsertoUserDTO(savedUser);
    }

    //Update User
    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));

        //user Details
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAbout(userDTO.getAbout());

        User updatedUser = this.userRepository.save(user);

        UserDTO dto = this.UsertoUserDTO(updatedUser);
        return dto;
    }

    //Get User By Id
    @Override
    public UserDTO getUserById(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
        return this.UsertoUserDTO(user);
    }

    @Override
    public UserDTO getUserByName(String name) {
        Optional<User> user = userRepository.findByUserName(name);
        UserDTO userDTO = this.modelMapper.map(user,UserDTO.class);
        return userDTO;
    }

    //Get All Users
    @Override
    public List<UserDTO> getAllUser() {
        List<User> users = this.userRepository.findAll();
        List<UserDTO> userDTOS = users.stream().map(user -> this.UsertoUserDTO(user)).collect(Collectors.toList());
        return userDTOS;
    }

    //Delete User
    @Override
    public void DeleteUser(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        this.userRepository.delete(user);
    }

    @Override
    public void DeleteAllUsers() {
        this.userRepository.deleteAll();
    }


    public User DTOtoUser(UserDTO userDTO){
          User user = this.modelMapper.map(userDTO,User.class);
//        user.setId(userDTO.getId());
//        user.setName(userDTO.getName());
//        user.setEmail(userDTO.getEmail());
//        user.setAbout(userDTO.getAbout());
//        user.setPassword(userDTO.getPassword());
          return user;
    }


    public UserDTO UsertoUserDTO(User user){

        UserDTO userDTO = this.modelMapper.map(user,UserDTO.class);
//        userDTO.setId(user.getId());
//        userDTO.setName(user.getName());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setPassword(user.getPassword());
//        userDTO.setAbout(user.getAbout());
        return userDTO;
    }
}
