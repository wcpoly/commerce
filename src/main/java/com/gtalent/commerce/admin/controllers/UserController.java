package com.gtalent.commerce.admin.controllers;



import com.gtalent.commerce.admin.dtos.UserRequest;
import com.gtalent.commerce.admin.dtos.UserResponse;
import com.gtalent.commerce.admin.mappers.UserMapper;
import com.gtalent.commerce.admin.models.User;
import com.gtalent.commerce.admin.repositories.UserRepository;
import com.gtalent.commerce.admin.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Tag(name = "User", description = "User management APIs")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Operation(summary = "Get all users", description = "Returns a list of all users")
    @GetMapping
    public List<UserResponse> getAllUsers() {

        return userService.getAllUsers().stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    @Operation(summary = "Get all users pagination", description = "Returns a page of users")
    @GetMapping("/page")
    public Page<UserResponse> getAllUsersPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return userService.getAllUsers(pageRequest).map(userMapper::toUserResponse);
    }

    @Operation(summary = "Get user by ID", description = "Returns a single user by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved user"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable int id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            ResponseEntity.ok(userMapper.toUserResponse(user.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Create a new user", description = "Creates a new user and returns the created user")
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(userMapper.toUserResponse(createdUser));
    }

    @Operation(summary = "Update an existing user", description = "Updates an existing user by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated user"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable int id, @RequestBody UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userMapper.toUserResponse(updatedUser));
    }

    @Operation(summary = "Delete a user", description = "Deletes a user by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted user")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/segments/{segmentId}")
    public ResponseEntity<Void> assignSegmentToUser(@PathVariable int id, @PathVariable int segmentId) {
        userService.assignSegmentToUser(id, segmentId);
        //對user_segments insert rows
        return ResponseEntity.noContent().build();
    }




}
