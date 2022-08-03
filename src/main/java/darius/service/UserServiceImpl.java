package darius.service;

import darius.dto.UserInsertDTO;
import darius.dto.UserLoginDTO;
import darius.logger.Logger;
import darius.logger.LoggingType;
import darius.logger.console.ConsoleLogger;
import darius.persistence.UserRepository;

import java.security.NoSuchAlgorithmException;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Logger logger;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.logger = new ConsoleLogger();
    }

    public UserServiceImpl(UserRepository userRepository, Logger logger) {
        this.userRepository = userRepository;
        this.logger = logger;
    }

    @Override
    public void createTable() {
        userRepository.createTable();
    }

    @Override
    public void insert(UserInsertDTO userInsertDTO) {
        try {
            userRepository.insert(userInsertDTO);
        } catch (NoSuchAlgorithmException exception) {
            logger.logMessage(exception.getMessage(), LoggingType.ERROR);
        }
    }

    @Override
    public boolean validateUser(UserLoginDTO userLoginDTO) {
        try {
            return userRepository.validateUser(userLoginDTO);
        } catch (NoSuchAlgorithmException exception) {
            logger.logMessage(exception.getMessage(), LoggingType.ERROR);
        }
        return false;
    }
}
