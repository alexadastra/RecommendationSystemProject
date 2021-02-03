package io.project.userservice.controller;

import io.project.userservice.model.ApiResponse;
import io.project.userservice.model.User;
import io.project.userservice.model.UserDto;
import io.project.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/register={login}&password={password}")
    public ResponseEntity addUser(@PathVariable String login, @PathVariable String password)
            throws ResponseStatusException {
        User newUser = new User(login, password);
        if (userService.getByEmail(newUser.getEmail()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user already exists");
        }

        newUser.encryptPassword();
        userService.add(newUser);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping(path = "/login={login}&password={password}")
    void loginUser(@PathVariable String login, @PathVariable String password){

    }
}

 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ApiResponse<User> saveUser(@RequestBody UserDto user){
        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",userService.save(user));
    }

    @GetMapping
    public ApiResponse<List<User>> listUser(){
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",userService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getOne(@PathVariable int id){
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",userService.findById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<UserDto> update(@RequestBody UserDto userDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",userService.update(userDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
        userService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }
}