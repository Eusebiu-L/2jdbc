package ro.emanuel.tema.dao.computers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.tema.dao.DBHelper;
import ro.emanuel.tema.dao.pojo.Computer;




public class ComputersDAO {
	public static Computer getbyId (int id) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "SELECT * FROM computers where id=?";
		PreparedStatement getComputer = conn.prepareStatement(query);
		getComputer.setInt (1, id);
		
		ResultSet rs = getComputer.executeQuery();
		Computer computer = null;
		if(rs.next()) 
			computer = new Computer (rs.getInt("id"), rs.getString("brand"), rs.getDouble("price"), rs.getInt("stock"));
		DBHelper.closeConnection();
		if(computer != null)
			return computer;
		return null;
		
	}
	public static ArrayList <Computer> getAll() throws SQLException{
		Connection conn = DBHelper.getConnection();
		String query = "SELECT * FROM computers";
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Computer> computer = new ArrayList<Computer>();
	
		while(rs.next()) {
			int id = rs.getInt("id");
			String brand = rs.getString("brand");
			Double price = rs.getDouble("price");
			int stock = rs.getInt("stock");
			computer.add(new Computer(id, brand, price, stock));
		}
		DBHelper.closeConnection();
		return computer;
	}
	public static boolean create (Computer computer) throws SQLException {
		Connection conn = DBHelper.getConnection();
		
		String query = "INSERT INTO `computers`(`brand`, `price`, `stock`) VALUES (?,?,?)";
		PreparedStatement createComputer = conn.prepareStatement(query);
		
		createComputer.setString(1, computer.getBrand());
		createComputer.setDouble(2, computer.getPrice());
		createComputer.setInt(3, computer.getStock());
		
		boolean response = createComputer.executeUpdate() > 0;
		DBHelper.closeConnection();
		return response;
	}
	public static boolean delete(int id) throws SQLException {
		Connection conn = DBHelper.getConnection();
		
		String query = "DELETE FROM `computers` WHERE id=?";
		PreparedStatement deleteComputer= conn.prepareStatement(query);
		
		deleteComputer.setInt(1, id);
		
		boolean response = deleteComputer.executeUpdate() > 0;
		DBHelper.closeConnection();
		return response;
	}
	public static boolean update(Computer computer) throws SQLException {
		Connection conn = DBHelper.getConnection();
		
		String query = "UPDATE `computers` SET `brand`=?,`price`=?,`stock`=? WHERE id=?";
		PreparedStatement updateComputer = conn.prepareStatement(query);
		
		updateComputer.setString(1, computer.getBrand());
		updateComputer.setDouble(2, computer.getPrice());
		updateComputer.setInt(3, computer.getStock());
		updateComputer.setInt(4, computer.getId());
		
		boolean response = updateComputer.executeUpdate() > 0;
		DBHelper.closeConnection();
		return response;
	}
	
}
