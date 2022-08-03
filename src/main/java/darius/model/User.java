package darius.model;

import java.util.Objects;

public class User {
    private String username;
    private String hashedPassword;
    private UserRole userRole;

    public User() {
    }

    public User(String username, String hashedPassword, UserRole userRole) {
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.userRole = userRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(hashedPassword, user.hashedPassword) && userRole == user.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, hashedPassword, userRole);
    }
}
