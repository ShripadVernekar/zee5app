package com.zee.zee5app.repoistory.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repoistory.SeriesRepoistory;
import com.zee.zee5app.utils.DBUtils;

public class SeriesRepositoryImpl implements SeriesRepoistory {

	private static SeriesRepoistory seriesRepoistory;
	DBUtils dbUtils = null;

	private SeriesRepositoryImpl() throws IOException {
		dbUtils = DBUtils.getInstance();
	}

	public static SeriesRepoistory getInstance() throws IOException {
		if (seriesRepoistory == null)
			seriesRepoistory = new SeriesRepositoryImpl();
		return seriesRepoistory;
	}

	@Override
	public String addSeries(series Series) {
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement;

		String insertStatetment = "insert into series"
				+ "(id,ageLimit,cast,genre,length,releaseDate,language,noOfEpisodes)" + "values(?,?,?,?,?,?,?,?)";

// "(id,ageLimit,cast,genre,length,trailer,releaseDate,language,noOfEpisodes)" 
		try {
			preparedStatement = connection.prepareStatement(insertStatetment);

			preparedStatement.setString(1, Series.getId());
			preparedStatement.setInt(2, Series.getAgeLimit());
			preparedStatement.setString(3, Series.getCast());
			preparedStatement.setString(4, Series.getGenre());
			preparedStatement.setInt(5, Series.getLength());
//			preparedStatement.setString(6, Series.getTrailer());
			preparedStatement.setString(6, Series.getReleaseDate());
			preparedStatement.setString(7, Series.getLanguage());
			preparedStatement.setInt(8, Series.getNoOfEpisodes());

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
	public String updateSeries(String id, series Series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement;
		String deleteStatetment = "delete from series where id=?";
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
	public Optional<series> getSeriesById(String id)
			throws IdNotFoundException, IdNotFoundException, InvalidIdLengthException {

		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String selectStatement = "select * from series where id=?";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				series Series = new series();
				Series.setId(resultSet.getString("id"));
				Series.setAgeLimit(resultSet.getInt("ageLimit"));
				Series.setCast(resultSet.getString("cast"));
				Series.setGenre(resultSet.getString("genre"));
				Series.setLength(resultSet.getInt("length"));
				Series.setReleaseDate(resultSet.getString("releaseDate"));
				Series.setLanguage(resultSet.getString("language"));
				Series.setNoOfEpisodes(resultSet.getInt("noOfEpisodes"));
				return Optional.of(Series);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

	@Override
	public Optional<ArrayList<series>> getAllSeries() throws InvalidIdLengthException {

		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<series> arrayList = new ArrayList<>();

		String selectStatement = "select * from series";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				series Series = new series();
				Series.setId(resultSet.getString("id"));
				Series.setAgeLimit(resultSet.getInt("ageLimit"));
				Series.setCast(resultSet.getString("cast"));
				Series.setGenre(resultSet.getString("genre"));
				Series.setLength(resultSet.getInt("length"));
				Series.setReleaseDate(resultSet.getString("releaseDate"));
				Series.setLanguage(resultSet.getString("language"));
				Series.setNoOfEpisodes(resultSet.getInt("noOfEpisodes"));
				arrayList.add(Series);
			}
			return Optional.ofNullable(arrayList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

}
