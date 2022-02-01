package com.zee.zee5app.repoistory.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repoistory.LoginRepoistory;
import com.zee.zee5app.repoistory.UserRepoistory;
import com.zee.zee5app.utils.PasswordUtils;

@Repository // it will create singleton object

public class UserRepositoryImpl implements UserRepoistory {

	@Autowired // it will bring already created object by using name / type
	DataSource dataSource;
	@Autowired
	LoginRepoistory loginRepoistory ;
	@Autowired
	PasswordUtils passwordUtils;

	public UserRepositoryImpl() throws IOException {
		
	}

	@Override
	public String addUser(Register register) {
		// Add user details to the table

		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		PreparedStatement preparedStatement = null;

		String insertStatetment = "insert into register" + "(regId,firstName,lastName,email,contactNumber,password)"
				+ "values(?,?,?,?,?,?)";

		try {
			preparedStatement = connection.prepareStatement(insertStatetment);
			String salt = passwordUtils.getSalt(30);
			String enrcyptedPassword = passwordUtils.generateSecurePassword(register.getPassword(), salt);

			// adding fields to the '?' placeholder
			preparedStatement.setString(1, register.getId());
			preparedStatement.setString(2, register.getFirstName());
			preparedStatement.setString(3, register.getLastName());
			preparedStatement.setString(4, register.getEmail());
			preparedStatement.setBigDecimal(5, register.getContactNumber());
			preparedStatement.setString(6, enrcyptedPassword);

			int result = preparedStatement.executeUpdate();
			// the no of rows afftected by the DML statement
			// 1 : one row is inserted

			if (result > 0) {
				connection.commit();
				Login login = new Login(register.getEmail(), enrcyptedPassword, register.getId(), ROLE.ROLE_USER);
				String status = loginRepoistory.addCredentials(login);
				if (status.equals("success")) {
					return "success";
				} else {
					System.out.println("hi");
					connection.rollback();
					return "fail";
				}
			} else {
				connection.rollback();
				return "fail";
			}

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {

		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		PreparedStatement preparedStatement = null;

		String insertStatetment = "UPDATE register SET firstName=?,lastName=? where regId=?";

		try {
			preparedStatement = connection.prepareStatement(insertStatetment);

			// adding fields to the '?' placeholder
			preparedStatement.setString(1, register.getFirstName());
			preparedStatement.setString(2, register.getLastName());
			preparedStatement.setString(3, register.getId());

			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
				return "success";
			} else {
				connection.rollback();
				return "fail";
			}

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		}
	}

	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException,
			InvalidNameException, InvalidEmailException, InvalidPasswordException, javax.naming.InvalidNameException {

		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String selectStatement = "select * from register where regId=?";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);

			// to retrieve the data
			// RS will hold the complete result

			resultSet = preparedStatement.executeQuery();

			// RS object its a single one which is holding all the records
			// do we need to traverse it? ===> yes

			if (resultSet.next()) {
				// next method is used to traverse the RS
				/// initially RS will be places just above the 1st rec.
				// when u will call 1st time rs will retrieve the 1st rec &
				// it will refer the 2nd one.
				Register register = new Register();
				register.setId(resultSet.getString("regId"));
				register.setFirstName(resultSet.getString("firstName"));
				register.setLastName(resultSet.getString("lastName"));
				register.setEmail(resultSet.getString("email"));
				register.setPassword(resultSet.getString("password"));
				register.setContactNumber(resultSet.getBigDecimal("contactNumber"));
				return Optional.of(register);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

	@Override
	public Register[] getAllUsers() throws javax.naming.InvalidNameException, InvalidIdLengthException,
			InvalidEmailException, InvalidPasswordException {

		Optional<List<Register>> optional = getAllUserDetails();
		if (optional.isEmpty()) {
			return null;
		} else {
			List<Register> list = optional.get();
			Register[] registers = new Register[list.size()];
			return list.toArray(registers);
		}
	}

	@Override
	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException,
			javax.naming.InvalidNameException, InvalidEmailException, InvalidPasswordException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Register> arrayList = new ArrayList<>();

		String selectStatement = "select * from register";

		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
//			preparedStatement.setString(1, id);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Register register = new Register();
				register.setId(resultSet.getString("regId"));
				register.setFirstName(resultSet.getString("firstName"));
				register.setLastName(resultSet.getString("lastName"));
				register.setEmail(resultSet.getString("email"));
				register.setPassword(resultSet.getString("password"));
				register.setContactNumber(resultSet.getBigDecimal("contactNumber"));
				arrayList.add(register);
			}
			return Optional.ofNullable(arrayList); // since we are not 100% sure abt the outcome

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteStatetment = "delete from register where regId=?";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			preparedStatement = connection.prepareStatement(deleteStatetment);
			preparedStatement.setString(1, id);

			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				String status = loginRepoistory.deleteCredentials(id);
				if (status.equals("success")) {
					return "success";
				} else {
					connection.rollback();
					return "fail";
				}
			} else {
				connection.rollback();
				return "fail";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "fail";
		}
	}

}// end of class
