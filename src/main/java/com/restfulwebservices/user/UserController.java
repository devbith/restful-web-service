package com.restfulwebservices.user;

import com.restfulwebservices.exception.UserNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable  Long id) {
        User user =  userService.findOne(id);
        if (user == null)  throw new UserNotFoundException(String.format("id-%s not found", id));

        WebMvcLinkBuilder linkToUsers = WebMvcLinkBuilder.linkTo( methodOn(this.getClass()).retrieveAllUsers());

        return EntityModel.of(user).add(linkToUsers.withRel("all-users"));
    }

    @PostMapping(path = "/users")
    public ResponseEntity <Object> saveUser(@Valid @RequestBody User user) {
       User savedUser =  userService.save(user);

       URI uri =  ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(savedUser.getId()).toUri();

       return ResponseEntity.created(uri).build();
    }


    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        User deletedUser = userService.deleteUser(id);
        if (deletedUser == null) throw new UserNotFoundException(String.format("id-%s not found", id));
    }
}
