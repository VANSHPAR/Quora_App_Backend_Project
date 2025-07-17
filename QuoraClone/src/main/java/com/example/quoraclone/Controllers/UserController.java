package com.example.quoraclone.Controllers;

import com.example.quoraclone.dtos.UserDto;
import com.example.quoraclone.models.Question;
import com.example.quoraclone.models.User;
import com.example.quoraclone.services.UserFeedService;
import com.example.quoraclone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final  UserService userService;

    private final UserFeedService userFeedService;


    public UserController(UserService userService, UserFeedService userFeedService) {
        this.userService = userService;
        this.userFeedService = userFeedService;
    }
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.CREATED);
    }

    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUserId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{userId}/followTag/{tagId}")
    public ResponseEntity<Void> followTag(@PathVariable Long userId, @PathVariable Long tagId) {
        userService.followTag(userId, tagId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/feed")
    public ResponseEntity<List<Question>> getUserFeed(@PathVariable Long userId,@RequestParam int page,@RequestParam int size){
        return ResponseEntity.ok(userFeedService.getUserFeed(userId,page,size));


    }

}
