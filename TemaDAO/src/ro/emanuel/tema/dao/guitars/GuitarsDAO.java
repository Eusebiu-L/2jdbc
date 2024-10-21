package ro.emanuel.tema.dao.guitars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.tema.dao.DBHelper;
import ro.emanuel.tema.dao.pojo.Guitar;





public class GuitarsDAO {
	public static Guitar getbyId (int id) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "SELECT * FROM guitars where id=?";
		PreparedStatement getGuitar = conn.prepareStatement(query);
		getGuitar.setInt (1, id);
		
		ResultSet rs = getGuitar.executeQuery();
		Guitar guitar = null;
		if(rs.next()) 
			guitar = new Guitar (rs.getInt("id"), rs.getString("brand"), rs.getDouble("strings"), rs.getInt("number_strings"));
		DBHelper.closeConnection();
		if(guitar != null)
			return guitar;
		return null;
		
	}
	public static ArrayList <Guitar> getAll() throws SQLException{
		Connection conn = DBHelper.getConnection();
		String query = "SELECT * FROM guitars";
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Guitar> guitar = new ArrayList<Guitar>();
	
		while(rs.next()) {
			int id = rs.getInt("id");
			String brand = rs.getString("brand");
			Double strings = rs.getDouble("strings");
			int number_strings = rs.getInt("number_strings");
			guitar.add(new Guitar(id, brand, strings, number_strings));
		}
		DBHelper.closeConnection();
		return guitar;
			
		
	}
	public static boolean create (Guitar guitar) throws SQLException {
		Connection conn = DBHelper.getConnection();
		
		String query = "INSERT INTO `guitars`(`brand`, `strings`, `number_strings`) VALUES (?,?,?)";
		PreparedStatement createGuitar = conn.prepareStatement(query);
		
		createGuitar.setString(1, guitar.getBrand());
		createGuitar.setDouble(2, guitar.getStrings());
		createGuitar.setInt(3, guitar.getNumber_strings());
		
		boolean response = createGuitar.executeUpdate() > 0;
		DBHelper.closeConnection();
		return response;
	}
	public static boolean delete(int id) throws SQLException {
		Connection conn = DBHelper.getConnection();
		
		String query = "DELETE FROM `guitars` WHERE id=?";
		PreparedStatement deleteGuitar = conn.prepareStatement(query);
		
		deleteGuitar.setInt(1, id);
		
		boolean response = deleteGuitar.executeUpdate() > 0;
		DBHelper.closeConnection();
		return response;
	}
	
	public static boolean update(Guitar guitar) throws SQLException {
		Connection conn = DBHelper.getConnection();
		
		String query = "UPDATE `guitar` SET `brand`=?,`strings`=?,`number_strings`=? WHERE id=?";
		PreparedStatement updateGuitar = conn.prepareStatement(query);
		
		updateGuitar.setString(1, guitar.getBrand());
		updateGuitar.setDouble(2, guitar.getStrings());
		updateGuitar.setInt(3, guitar.getNumber_strings());
		updateGuitar.setInt(4, guitar.getId());
		
		boolean response = updateGuitar.executeUpdate() > 0;
		DBHelper.closeConnection();
		return response;
	}
}
