package com.example;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured")
public class SecuredResource {

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/user")
    public ResponseEntity<?> user() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok("{\n" +
                "  \"userName\": \"" + userName + "\"\n" +
                "}");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin")
    public ResponseEntity<?> admin() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok("{\n" +
                "  \"userName\": \"" + userName + "\"\n" +
                "}");
    }
}
