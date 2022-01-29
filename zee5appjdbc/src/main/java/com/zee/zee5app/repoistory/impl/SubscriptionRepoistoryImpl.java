package com.zee.zee5app.repoistory.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repoistory.SubscriptionRepoistory;
import com.zee.zee5app.utils.DBUtils;

public class SubscriptionRepoistoryImpl implements SubscriptionRepoistory {

	DBUtils dbUtils = null;
	private static SubscriptionRepoistory subscriptionRepoistory;

	private SubscriptionRepoistoryImpl() throws IOException {
		dbUtils = DBUtils.getInstance();
	}

	public static SubscriptionRepoistory getInstance() throws IOException {
		if (subscriptionRepoistory == null)
			subscriptionRepoistory = new SubscriptionRepoistoryImpl();
		return subscriptionRepoistory;
	}

	@Override
	public String addSubscription(subscription Sub) {
		
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement;

		String insertStatetment = "insert into subscription"
				+ "(id,dop,expiry,amount,paymentMode,status,type,autoRenewal,regId)" + "values(?,?,?,?,?,?,?,?,?)";

		try {
			preparedStatement = connection.prepareStatement(insertStatetment);

			preparedStatement.setString(1, Sub.getId());
			preparedStatement.setString(2, Sub.getDateOfPurchase());
			preparedStatement.setString(3, Sub.getExpiryDate());
			preparedStatement.setInt(4, Sub.getAmount());
			preparedStatement.setString(5, Sub.getPaymentMode());
			preparedStatement.setString(6, Sub.getStatus());
			preparedStatement.setString(7, Sub.getType());
			preparedStatement.setString(8, Sub.getAutoRenewal());
			preparedStatement.setString(9, Sub.getRegId());

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

	@Override
	public String updateSubscription(String id, subscription Subscription) throws IdNotFoundException {
		return null;
	}

	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {
		
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement;
		String deleteStatetment = "delete from login where userName=?";
		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(deleteStatetment);
			preparedStatement.setString(1, id);

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
		} finally {
			dbUtils.closeConnection(connection);
		}
	}

	
	@Override
	public Optional<subscription> getSubscriptionById(String id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidAmountException {

		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String selectStatement = "select * from subscription where id=?";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				subscription Sub = new subscription();
				Sub.setId(resultSet.getString("id"));
				Sub.setDateOfPurchase(resultSet.getString("dop"));
				Sub.setExpiryDate(resultSet.getString("expiry"));
				Sub.setAmount(resultSet.getInt("amount"));
				Sub.setPaymentMode(resultSet.getString("paymentMode"));
				Sub.setStatus(resultSet.getString("status"));
				Sub.setType(resultSet.getString("type"));
				Sub.setAutoRenewal(resultSet.getString("autoRenewal"));
				Sub.setRegId(resultSet.getString("regId"));
				return Optional.of(Sub);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

	@Override
	public Optional<ArrayList<subscription>> getAllSubscription()
			throws InvalidIdLengthException, InvalidAmountException {
		
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<subscription> arrayList = new ArrayList<>();

		String selectStatement = "select * from subscription";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				subscription Sub = new subscription();
				Sub.setId(resultSet.getString("id"));
				Sub.setDateOfPurchase(resultSet.getString("dop"));
				Sub.setExpiryDate(resultSet.getString("expiry"));
				Sub.setAmount(resultSet.getInt("amount"));
				Sub.setPaymentMode(resultSet.getString("paymentMode"));
				Sub.setStatus(resultSet.getString("status"));
				Sub.setType(resultSet.getString("type"));
				Sub.setAutoRenewal(resultSet.getString("autoRenewal"));
				Sub.setRegId(resultSet.getString("regId"));
				arrayList.add(Sub);

			}

			return Optional.ofNullable(arrayList); // since we are not 100% sure abt the outcome

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

}
