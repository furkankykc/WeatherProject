package com.H2H.juniorProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class LocationDao {
	private DataSource dataSource;
	Location location = null;
	ArrayList<Location> locationList= null;
	
	
	public void setDataSource(DataSource dataSource) {
		
		this.dataSource = dataSource;
	}
	public void delete(int id) {
		String sql  = "DELETE FROM location WHERE id=?";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
			ps.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public boolean insert(Location location){

		String sql = "INSERT INTO location " +
				"(locationName) VALUES (?)";
		Connection conn = null;
		

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, location.getLocationName());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			return false;

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {return false;}
			}
		}
		return true;
	}
	public void update(Location location){
		String sql = "UPDATE location SET  locationName = ? WHERE id = ? ";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, location.getLocationName());
			ps.setInt(2, location.getId());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public Location getLocation(int id){

		String sql = "SELECT * FROM location WHERE id = ?";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				this.location = new Location(
					rs.getInt("id"),
					rs.getString("locationName")
					
				);
			}
			rs.close();
			ps.close();
			return location;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	public Location getLocation(String locationName){

		String sql = "SELECT * FROM location WHERE locationName = ? ";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, locationName);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				this.location = new Location(
					rs.getInt("id"),
					rs.getString("locationName")
				);
			}
			rs.close();
			ps.close();
			return location;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	public ArrayList<Location> getLocation(){
		locationList = new ArrayList<Location>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from location");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
				this.locationList.add(new Location(
						rs.getInt("id"),
						rs.getString("locationName")
				));
			
			rs.close();
			ps.close();
			return locationList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}
}
