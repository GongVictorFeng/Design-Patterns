package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class UserController {
    //Store used by controller
    private final Store store = new Store();
    private final UserValidator userValidator = new UserValidator();

    public String createUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(userJson, User.class);

        if (!userValidator.validateUser(user)) return "ERROR";

        store.store(user);
        return "SUCCESS";
    }

}
