package com.example.quoraclone.services;

import com.example.quoraclone.Repositories.TagRepository;
import com.example.quoraclone.Repositories.UserRepository;
import com.example.quoraclone.dtos.UserDto;
import com.example.quoraclone.models.Tag;
import com.example.quoraclone.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final TagRepository tagRepository;

    public UserService(UserRepository userRepository, TagRepository tagRepository) {
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(UserDto userDto) {
       User user=new User();

       user.setUsername(userDto.getUsername());
       user.setPassword(userDto.getPassword());
       return userRepository.save(user);
    }

    public void deleteUserId(Long userId){
        userRepository.deleteById(userId);
    }

    public void followTag(Long userId, Long tagId){
        User user=userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Tag tag=tagRepository.findById(tagId).orElseThrow(() -> new RuntimeException("Tag not found"));
        user.getFollowedTags().add(tag);
        userRepository.save(user);

    }

}
