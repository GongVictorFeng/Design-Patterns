package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class UserMapper {

    private final ObjectMapper mapper = new ObjectMapper();

    public User convertTo(String userJson) throws IOException {
       return mapper.readValue(userJson, User.class);
    }
}
