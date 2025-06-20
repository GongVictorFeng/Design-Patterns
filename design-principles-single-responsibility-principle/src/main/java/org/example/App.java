package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    // A valid User JSON String
    private static final String VALID_USER_JSON = "{\"name\": \"Randy\", \"email\": \"randy@email.com\", \"address\":\"110 Sugar lane\"}";

    //Invalid USER JSON String - email format wrong
    private static final String INVALID_USER_JSON = "{\"name\": \"Sam\", \"email\": \"sam@email\", \"address\":\"111 Sugar lane\"}";
    public static void main( String[] args )
    {
        UserController controller = new UserController();
        //Check with valid JSON
        String response = controller.createUser(VALID_USER_JSON);
        if (!response.equalsIgnoreCase("SUCCESS")) System.err.println("Failed");
        System.out.println("Valid JSON received response: " + response);

        //Check with invalid JSON
        response = controller.createUser(INVALID_USER_JSON);
        if (!response.equalsIgnoreCase("ERROR")) System.err.println("Failed");
        System.out.println("Invalid JSON received response: " + response);

    }
}
