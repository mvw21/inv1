package utils;

public interface ValidationService {

    boolean isUsernameTaken(String username);
    boolean isEmailValid(String email);
    boolean passwordMatches(String password, String confirmPassword);

}
