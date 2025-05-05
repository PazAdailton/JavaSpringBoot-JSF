package br.com.pazimports.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ApplicationUsers {

    public List<UserData> getUsersCredentials() {
        return Arrays.asList(
            new UserData("admin", "admin123", Arrays.asList("ADMIN", "USER")),
            new UserData("joao", "123", Arrays.asList("USER")),
            new UserData("maria", "456", Arrays.asList("USER"))
        );
    }
}