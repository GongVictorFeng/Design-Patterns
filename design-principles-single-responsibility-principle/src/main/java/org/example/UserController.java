package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class UserController {
    //Store used by controller
    private final UserPersistenceService userPersistenceService = new UserPersistenceService();
    private final UserValidator userValidator = new UserValidator();
    private final UserMapper userMapper = new UserMapper();

    public String createUser(String userJson) throws IOException {
        User user = userMapper.convertTo(userJson);
        if (!userValidator.validateUser(user)) return "ERROR";
        userPersistenceService.SaveUser(user);
        return "SUCCESS";
    }

}
