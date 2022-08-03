package darius.validator;

import darius.dto.UserInsertDTO;
import darius.dto.UserLoginDTO;

public class UserValidator {

    public static String validateUserLoginDTO(UserLoginDTO userLoginDTO){
        if(userLoginDTO.getUsername() == null){
            return "Username field should not be empty";
        } else if(userLoginDTO.getUsername().length() > 12){
            return "Username should have less than 12 characters";
        } else if(userLoginDTO.getPassword() == null){
            return "Password field should not be empty";
        } else if (userLoginDTO.getPassword().length() < 8){
            return "Password should not have less than 8 characters";
        }
        return null;
    }

    public static String validateUserInsertDTO(UserInsertDTO userInsertDTO){
        if(userInsertDTO.getUsername() == null){
            return "Username field should not be empty";
        } else if(userInsertDTO.getUsername().length() > 12){
            return "Username should have less than 12 characters";
        } else if(userInsertDTO.getPassword() == null){
            return "Password field should not be empty";
        } else if (userInsertDTO.getPassword().length() < 8){
            return "Password should not have less than 8 characters";
        }
        return null;
    }
}
