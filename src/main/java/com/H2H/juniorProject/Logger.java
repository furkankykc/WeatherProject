package com.H2H.juniorProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.sql.DataSource;

public class Logger {
	private DataSource dataSource;
	Log log = null;
	ArrayList<Log> logList= null;
	public void setDataSource(DataSource dataSource) {
	
		this.dataSource = dataSource;
	}
	public void delete(int id) {
		String sql  = "DELETE FROM log WHERE id=?";
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
	/*
					rs.getInt("id"),
					rs.getInt("userId"),
					rs.getInt("locaitonId"),
					rs.getTimestamp("time"),
					rs.getString("ip"),
					rs.getLong("queryTime"),
					rs.getBoolean("resultStatus")
	*/
	public void insert(Log log){

		String sql = "INSERT INTO log " +
				"(userId,locationId,time,ip,queryTime,resultStatus) VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = null;


		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, log.getUserId());
			ps.setInt(2, log.getLocationId());
			ps.setTimestamp(3, log.getTime());
			ps.setString(4, log.getIp());
			ps.setDouble(5, log.getQueryTime());
			ps.setBoolean(6, log.getResultStatus());
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
	public void update(Log log){
		String sql = "UPDATE log SET  userId = ?, locationId = ?, time = ?, ip = ?, queryTime = ?, resultStatus = ? WHERE id = ? ";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, log.getUserId());
			ps.setInt(2, log.getLocationId());
			ps.setTimestamp(3, log.getTime());
			ps.setString(4, log.getIp());
			ps.setDouble(5, log.getQueryTime());
			ps.setBoolean(6, log.getResultStatus());
			ps.setInt(7, log.getId());
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
	
	public Log getLog(int id){

		String sql = "SELECT * FROM log WHERE id = ?";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				this.log = new Log(
					rs.getInt("id"),
					rs.getInt("userId"),
					rs.getInt("locaitonId"),
					rs.getTimestamp("time"),
					rs.getString("ip"),
					rs.getLong("queryTime"),
					rs.getBoolean("resultStatus")
				);
			}
			rs.close();
			ps.close();
			return log;
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
//	public Log getLog(Log log){
//
//		String sql = "SELECT * FROM log WHERE locationId = ? ";
//		
//		Connection conn = null;
//
//		try {
//			conn = dataSource.getConnection();
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, locationID);
//			
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				this.log = new Log(
//						rs.getInt("id"),
//						rs.getInt("userId"),
//						rs.getInt("locaitonId"),
//						rs.getTimestamp("time"),
//						rs.getString("ip"),
//						rs.getLong("queryTime"),
//						rs.getBoolean("resultStatus")
//				);
//			}
//			rs.close();
//			ps.close();
//			return log;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		} finally {
//			if (conn != null) {
//				try {
//				conn.close();
//				} catch (SQLException e) {}
//			}
//		}
//	}
	public ArrayList<Log> getLog(){
		logList = new ArrayList<Log>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from log");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
				this.logList.add(new Log(
						rs.getInt("id"),
						rs.getInt("userId"),
						rs.getInt("locaitonId"),
						rs.getTimestamp("time"),
						rs.getString("ip"),
						rs.getLong("queryTime"),
						rs.getBoolean("resultStatus")
				));
			
			rs.close();
			ps.close();
			return logList;
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
	public ArrayList<Log> getLog(Log log){
		logList = new ArrayList<Log>();
		Connection conn = null;
		if(log == null) log =new Log();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = 
					conn.prepareStatement("select * from log where (userId = ? or ?) "
					+ "and (locationId = ? or ?) "
					+ "and (time > ? or ?) "
					+ "and (ip = ? or ? ) "
					+ "and (resultStatus = ? or ?)"
					+"order by time desc");
			ps.setInt(1, log.getUserId());
			ps.setBoolean(2, !(log.getUserId()!=0));
			ps.setInt(3, log.getLocationId());
			ps.setBoolean(4, !(log.getLocationId()!=0));
			ps.setTimestamp(5,log.getTime());
			ps.setBoolean(6, !(log.getTime()!=null));
			ps.setString(7, log.getIp());
			ps.setBoolean(8, !(log.getIp()!=""));
			if(log.getResultStatus()!=null)
				ps.setBoolean(9, log.getResultStatus());
			else
				ps.setBoolean(9, false);
			ps.setBoolean(10, !(log.getResultStatus()!=null));
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
				this.logList.add(new Log(
						rs.getInt("id"),
						rs.getInt("userId"),
						rs.getInt("locationId"),
						rs.getTimestamp("time"),
						rs.getString("ip"),
						rs.getLong("queryTime"),
						rs.getBoolean("resultStatus")
				));
			
			rs.close();
			ps.close();
			return logList;
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
