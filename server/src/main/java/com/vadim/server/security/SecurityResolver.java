package com.vadim.server.security;

import com.vadim.server.utility.SecurityUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("securityResolver")
public class SecurityResolver {

    public boolean isResourceOwner(final UUID userId) {

        return userId != null
                && SecurityUtils.isAuthenticated()
                && userId.equals(SecurityUtils.getUserId());
    }

    public boolean isAnonymous(final UUID userId) {

        return userId == null
                && !SecurityUtils.isAuthenticated();
    }
}
