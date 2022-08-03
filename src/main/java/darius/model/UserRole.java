package darius.model;

public enum UserRole {

    ADMIN(Role.ADMIN),
    USER(Role.USER);
    private final String roleType;

    UserRole(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleType() {
        return this.roleType;
    }

    public static class Role {
        public static final String ADMIN = "ADMIN";
        public static final String USER = "USER";

    }
}
