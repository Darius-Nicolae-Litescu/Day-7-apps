package darius.service;

import darius.dto.UserInsertDTO;
import darius.dto.UserLoginDTO;

public interface UserService {
    void createTable();

    void insert(UserInsertDTO userInsertDTO);

    boolean validateUser(UserLoginDTO userLoginDTO);
}
