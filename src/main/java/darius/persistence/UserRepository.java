package darius.persistence;

import darius.dto.UserInsertDTO;
import darius.dto.UserLoginDTO;

import java.security.NoSuchAlgorithmException;

public interface UserRepository {
    void createTable();

    void insert(UserInsertDTO userInsertDTO) throws NoSuchAlgorithmException;

    boolean validateUser(UserLoginDTO userLoginDTO) throws NoSuchAlgorithmException;
}
