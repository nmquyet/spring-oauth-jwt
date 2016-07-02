package com.example;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Internal user service
 */
public class UserService {
    private static final Map<String, User> inMemoryUserRepository = new HashMap<String, User>(){{
        put("nmquyet", new User("nmquyet", Arrays.asList("ROLE_USER")));
        put("longnc", new User("longnc", Arrays.asList("ROLE_ADMIN")));
    }};

    public User getUser(String userName) {
        return inMemoryUserRepository.get(userName);
    }
}
