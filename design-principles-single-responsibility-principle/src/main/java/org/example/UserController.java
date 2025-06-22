package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class UserController {
    //Store used by controller
    private final UserPersistenceService userPersistenceService = new UserPersistenceService();
    private final UserValidator userValidator = new UserValidator();

    public String createUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(userJson, User.class);

        if (!userValidator.validateUser(user)) return "ERROR";

        userPersistenceService.SaveUser(user);
        return "SUCCESS";
    }

}
