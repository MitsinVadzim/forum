package com.vadim.server.entity.enums;

public enum UserRoleEntity {
    USER("USER"),
    ADMIN("ADMIN");

    private final String value;

    UserRoleEntity(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static UserRoleEntity fromValue(final String text) {
        for (final UserRoleEntity role : UserRoleEntity.values()) {
            if (String.valueOf(role.value).equals(text)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
}
