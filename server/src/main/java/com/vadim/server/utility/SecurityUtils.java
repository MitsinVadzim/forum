package com.vadim.server.utility;

import com.vadim.server.entity.enums.UserRoleEntity;
import com.vadim.server.security.UserDetailsImpl;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.UUID;

import static com.vadim.server.entity.enums.UserRoleEntity.ADMIN;

@UtilityClass
public class SecurityUtils {

    public static boolean isAuthenticated() {

        return SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
                && SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetailsImpl;
    }

    public static UUID getUserId() {

        final UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext()
                .getAuthentication().getDetails();

        return userDetails.getUserId();
    }

    public static boolean isAdmin() {

        return isAuthenticated() && getUserRole().equals(ADMIN);
    }

    public static UserRoleEntity getUserRole() {

        final UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext()
                .getAuthentication().getDetails();

        return userDetails.getRole();
    }
}
