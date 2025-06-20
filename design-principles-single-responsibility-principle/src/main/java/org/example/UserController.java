package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {
    //Store used by controller
    private Store store = new Store();

    public String createUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(userJson, User.class);

        if (!isValidUser(user)) return "ERROR";

        store.store(user);
        return "SUCCESS";
    }

    //Validates the user object
    private boolean isValidUser(User user) {
        if (!isPresent(user.getName())) return false;
        user.setName(user.getName().trim());

        if (!isValidAlphaNumeric(user.getName())) return false;

        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) return false;
        user.setEmail(user.getEmail().trim());

        return isValidEmail(user.getEmail());
    }

    //Simple checks if value is null or empty
    private boolean isPresent(String value) {
        return value !=null && !value.trim().isEmpty();
    }

    //check string for special characters
    private boolean isValidAlphaNumeric(String value) {
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(value);
        return !matcher.find();
    }

    //Check string for valid email address - this is not for prod.
    //Just for demo. This fails for lots of valid emails.
    private boolean isValidEmail(String value) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }
}
