package com.example.developer.MovieProjectApi.service;

import java.util.List;

import com.example.developer.MovieProjectApi.model.User;
import com.example.developer.MovieProjectApi.repository.UserRepo;

public class UserService {

    private UserRepo userRepo;

     public List<User> getAllUsers() {
                return userRepo.findAll();
        }

        public User getUserById(Long id) {
                return userRepo.findById(id).orElse(null);
        }

        public User addUser(User user) {
                return userRepo.save(user);
        }

        public User updateUser(User user) {
                User existingUser = userRepo.findById(user.getId()).orElse(null);
                if (existingUser != null) {
                        existingUser.setName(user.getName());
                        existingUser.setUsername(user.getUsername());
                        existingUser.setPassword(user.getPassword());
                        existingUser.setRole(user.getRole());
                        existingUser.setAge(user.getAge());
                        return userRepo.save(existingUser);
                 
                }
                return null;
        }
    
         public String deleteUser(Long id) {
                userRepo.deleteById(id);
                return "Removido com sucesso!" + id;
        }

}
