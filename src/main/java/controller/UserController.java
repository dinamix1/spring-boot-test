package controller;

import entity.pojo.User;
import logic.UserLogic;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import request.CreateUserRequest;
import request.UpdateCustomerRequest;

@RestController(value = "/user")
public class UserController {
    private static final String APP_JSON = "application/json";
    @Autowired
    @Setter private UserLogic userLogic;

    @RequestMapping(method = RequestMethod.POST, produces = {APP_JSON})
    public User createUser(@RequestBody CreateUserRequest ur) {
        return userLogic.createUser(ur);
    }

    @RequestMapping(method = RequestMethod.GET, produces = {APP_JSON})
    public User getUser(@RequestParam(required = true) String userId) {
        return userLogic.getUserById(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = {APP_JSON}, value = "/{id}")
    public User updateUser(@RequestBody UpdateCustomerRequest ur, @PathVariable String id) {
        return userLogic.updateUser(id, ur);
    }
}