package com.zee.zee5app.repoistory.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.movies;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repoistory.MovieRepoistory;
import com.zee.zee5app.utils.DBUtils;

@Repository

public class MovieRepositoryImpl implements MovieRepoistory {

	DBUtils dbUtils = null;

	public MovieRepositoryImpl() throws IOException {
//		dbUtils = DBUtils.getInstance();
	}

	@Override
	public String addMovie(movies movie) {

		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement;

		String insertStatetment = "insert into movies"
				+ "(id,name,ageLimit,genre,language,trailer,cast,length,releaseDate)" + "values(?,?,?,?,?,?,?,?,?)";

		try {
			preparedStatement = connection.prepareStatement(insertStatetment);

			preparedStatement.setString(1, movie.getId());
			preparedStatement.setString(2, movie.getMovieName());
			preparedStatement.setInt(3, movie.getAgeLimit());
			preparedStatement.setString(4, movie.getGenre());
			preparedStatement.setString(5, movie.getLanguage());
			preparedStatement.setString(6, movie.getTrailer());
			preparedStatement.setString(7, movie.getCast());
			preparedStatement.setInt(8, movie.getLength());
			preparedStatement.setString(9, movie.getReleaseDate());

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
	public String updateMovie(String id, movies movie) throws IdNotFoundException {
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement;

		String updateStatetment = "update movies"
				+ "set name=?,ageLimit=?,genre=?,language=?,trailer=?,cast=?,length=?,releaseDate=? where id=?";

		try {
			preparedStatement = connection.prepareStatement(updateStatetment);

			preparedStatement.setString(1, movie.getMovieName());
			preparedStatement.setInt(2, movie.getAgeLimit());
			preparedStatement.setString(3, movie.getGenre());
			preparedStatement.setString(4, movie.getLanguage());
			preparedStatement.setString(5, movie.getTrailer());
			preparedStatement.setString(6, movie.getCast());
			preparedStatement.setInt(7, movie.getLength());
			preparedStatement.setString(8, movie.getReleaseDate());
			
			preparedStatement.setString(9, movie.getId());

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
	public String deleteMovie(String id) throws IdNotFoundException {
		
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement;
		String deleteStatetment = "delete from movies where id=?";
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
	public Optional<movies> getMovieById(String id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {

		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String selectStatement = "select * from movies where id=?";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				movies Movie = new movies();
				Movie.setId(resultSet.getString("id"));
				Movie.setMovieName(resultSet.getString("name"));
				Movie.setAgeLimit(resultSet.getInt("ageLimit"));
				Movie.setGenre(resultSet.getString("genre"));
				Movie.setLanguage(resultSet.getString("language"));
				Movie.setTrailer(resultSet.getString("trailer"));
				Movie.setCast(resultSet.getString("cast"));
				Movie.setLength(resultSet.getInt("length"));
				Movie.setReleaseDate(resultSet.getString("releaseDate"));
				return Optional.of(Movie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

	@Override
	public Optional<movies> getMovieByName(String name)
			throws NameNotFoundException, InvalidIdLengthException, InvalidNameException {
		
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String selectStatement = "select * from movies where id=?";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, name);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				movies Movie = new movies();
				Movie.setId(resultSet.getString("id"));
				Movie.setMovieName(resultSet.getString("name"));
				Movie.setAgeLimit(resultSet.getInt("ageLimit"));
				Movie.setGenre(resultSet.getString("genre"));
				Movie.setLanguage(resultSet.getString("language"));
				Movie.setTrailer(resultSet.getString("trailer"));
				Movie.setCast(resultSet.getString("cast"));
				Movie.setLength(resultSet.getInt("length"));
				Movie.setReleaseDate(resultSet.getString("releaseDate"));
				return Optional.of(Movie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

	@Override
	public String watchMovie(String moviename) throws NameNotFoundException, LocationNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ArrayList<movies>> getAllMovie() throws InvalidIdLengthException, InvalidNameException {
		
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<movies> arrayList = new ArrayList<>();
		String selectStatement = "select * from movies";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				movies Movie = new movies();
				Movie.setId(resultSet.getString("id"));
				Movie.setMovieName(resultSet.getString("name"));
				Movie.setAgeLimit(resultSet.getInt("ageLimit"));
				Movie.setGenre(resultSet.getString("genre"));
				Movie.setLanguage(resultSet.getString("language"));
				Movie.setTrailer(resultSet.getString("trailer"));
				Movie.setCast(resultSet.getString("cast"));
				Movie.setLength(resultSet.getInt("length"));
				Movie.setReleaseDate(resultSet.getString("releaseDate"));
				arrayList.add(Movie);
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
