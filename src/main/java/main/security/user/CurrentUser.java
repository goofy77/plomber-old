package main.security.user;

import org.springframework.security.core.context.SecurityContextHolder;

public final class CurrentUser {

    public static String getName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
