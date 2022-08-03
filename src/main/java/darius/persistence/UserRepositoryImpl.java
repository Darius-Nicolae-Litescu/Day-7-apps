package darius.persistence;

import darius.database.ShoppingDatabaseStatement;
import darius.dto.UserInsertDTO;
import darius.dto.UserLoginDTO;
import darius.hashing.SHA256Utils;
import darius.model.User;
import darius.model.UserRole;

import java.security.NoSuchAlgorithmException;

public class UserRepositoryImpl implements UserRepository {
	private final ShoppingDatabaseStatement shoppingDatabaseStatement;

	public UserRepositoryImpl(ShoppingDatabaseStatement shoppingDatabaseStatement) {
		this.shoppingDatabaseStatement = shoppingDatabaseStatement;
	}

	@Override
	public void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS User " + "(id BIGINT NOT NULL AUTO_INCREMENT,"
				+ " username VARCHAR(255) NOT NULL," + " password VARCHAR(255) NOT NULL,"
				+ " role VARCHAR(255) NOT NULL," + " PRIMARY KEY (id)," + " UNIQUE KEY username (username)" + ")";

		shoppingDatabaseStatement.execute(sql, "");
	}

	@Override
	public void insert(UserInsertDTO userInsertDTO) throws NoSuchAlgorithmException {
		String sha256HashedPassword = SHA256Utils.toHexString(SHA256Utils.getSHA(userInsertDTO.getPassword()));
		User userToInsert = new User(userInsertDTO.getUsername(), sha256HashedPassword, UserRole.USER);
		String sql = "INSERT INTO User(username, password, role) VALUES (?,?,?)";
		shoppingDatabaseStatement.execute(sql, userToInsert.getUsername(), userToInsert.getHashedPassword(),
				userToInsert.getUserRole().getRoleType());
	}

	@Override
	public boolean validateUser(UserLoginDTO userLoginDTO) throws NoSuchAlgorithmException {
		String sha256HashedPassword = SHA256Utils.toHexString(SHA256Utils.getSHA(userLoginDTO.getPassword()));
		String sql = "SELECT * FROM User WHERE username = ?";
		User user = shoppingDatabaseStatement.executeGetUserByUsername(sql, userLoginDTO.getUsername());
		if (user != null) {
			return user.getHashedPassword().equals(sha256HashedPassword);
		} else {
			return false;
		}
	}

}
