package com.example;

import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.bouncycastle.cms.RecipientId.password;

/**
 * ZingId SSO authentication provider which checks for session (password) validity on SSO
 */
public class ZingSSOAuthenticationProvider implements AuthenticationProvider {

    private static final Map<String, String> inMemorySSOConfig = new HashMap<String, String>() {{
        put("nmquyet", "random_token");
        put("longnc", "random_token");
    }};

    private UserService userService;

    public ZingSSOAuthenticationProvider(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Validate sso session against Zing SSO server
        String userName = authentication.getName();
        String sessionKey = authentication.getCredentials().toString();
        String token = inMemorySSOConfig.get(userName);
        if (token == null || !sessionKey.equalsIgnoreCase(token)) {
            throw new BadCredentialsException("Not valid password");
        }

        // Load user from internal system
        User user = this.userService.getUser(userName);
        if (user == null) {
            // TODO auto register user
            throw new UsernameNotFoundException("User not exist");
        }

        return new UsernamePasswordAuthenticationToken(
                userName,
                password,
                user.authorities()
                        .stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()));
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
