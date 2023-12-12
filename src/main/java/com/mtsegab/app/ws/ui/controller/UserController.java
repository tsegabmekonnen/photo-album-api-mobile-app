package com.mtsegab.app.ws.ui.controller;

import com.mtsegab.app.ws.ui.model.response.UserRest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {

    @GetMapping()
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "limit") int limit) {
        return "get user was called with page = " + page +
                " limit " + limit;
    }

    @GetMapping(path = "/{userId}",
            produces = {MediaType.APPLICATION_XML_VALUE
                    , MediaType.APPLICATION_JSON_VALUE
            })
    public UserRest getUser(@PathVariable String userId) {
        UserRest returnVal = new UserRest();
        returnVal.setUserId(userId);
        returnVal.setFirstName("John");
        returnVal.setLastName("Doe");
        returnVal.setEmail("JD****@gmail.com");


        return returnVal;
    }

    @PostMapping
    public String creatUser() {
        return "create user was called";
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
