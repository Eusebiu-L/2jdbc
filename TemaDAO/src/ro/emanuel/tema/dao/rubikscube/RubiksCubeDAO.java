package ro.emanuel.tema.dao.rubikscube;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.tema.dao.DBHelper;
import ro.emanuel.tema.dao.pojo.RubikCube;



public class RubiksCubeDAO {
		public static RubikCube getById(int id) throws SQLException {
			Connection conn = DBHelper.getConnection();
			String query = "SELECT * FROM rubikscube where id=?";
			PreparedStatement getRubickCube = conn.prepareStatement(query);
			getRubickCube.setInt(1, id);
			
			ResultSet rs = getRubickCube.executeQuery();
			RubikCube rubikCube = null;
			if(rs.next())
				rubikCube = new RubikCube(rs.getInt("id"), rs.getString("brand"), rs.getDouble("weight"), rs.getInt("sides"));
			DBHelper.closeConnection();
			if(rubikCube != null)
				return rubikCube;
			return null;
			
		}
		
		public static ArrayList<RubikCube> getAll() throws SQLException {
			Connection conn = DBHelper.getConnection();
			String query = "SELECT * FROM rubikscube";
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			ArrayList<RubikCube> rubikcubes = new ArrayList<RubikCube>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String brand = rs.getString("brand");
				Double weight = rs.getDouble("weight");
				int sides = rs.getInt("sides");
				rubikcubes.add(new RubikCube(id, brand, weight, sides));
			}
			DBHelper.closeConnection();
			return rubikcubes;
		}
		
		public static boolean create (RubikCube rubikCube) throws SQLException {
			Connection conn = DBHelper.getConnection();
			
			String query = "INSERT INTO `rubikscube`(`brand`, `weight`, `sides`) VALUES (?,?,?)";
			PreparedStatement createRubikCube = conn.prepareStatement(query);
			
			createRubikCube.setString(1, rubikCube.getBrand());
			createRubikCube.setDouble(2, rubikCube.getWeight());
			createRubikCube.setInt(3, rubikCube.getSides());
			boolean response = createRubikCube.executeUpdate() > 0;
			DBHelper.closeConnection();
			return response;
		}
		
		public static boolean delete(int id) throws SQLException {
			Connection conn = DBHelper.getConnection();
			
			String query = "DELETE FROM `rubikscube` WHERE id=?";
			PreparedStatement deleteRubikCube = conn.prepareStatement(query);
			
			deleteRubikCube.setInt(1, id);
			
			boolean response = deleteRubikCube.executeUpdate() > 0;
			DBHelper.closeConnection();
			return response;
		}
		
		public static boolean update(RubikCube rubikCube) throws SQLException {
			Connection conn = DBHelper.getConnection();
			
			String query = "UPDATE `rubikscube` SET `brand`=?,`weight`=?,`price`=? WHERE id=?";
			PreparedStatement updateRubikCube = conn.prepareStatement(query);
			
			updateRubikCube.setString(1, rubikCube.getBrand());
			updateRubikCube.setDouble(2, rubikCube.getWeight());
			updateRubikCube.setInt(3, rubikCube.getSides());
			updateRubikCube.setInt(4, rubikCube.getId());
			
			boolean response = updateRubikCube.executeUpdate() > 0;
			DBHelper.closeConnection();
			return response;
		}
	}
	

