package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountPostgres {
	
	public AccountPostgres(User user) {
		super();
		this.user = user;
	}

	String URL = "jdbc:postgresql://" + "localhost" + ":5432/" + "postgres" + "?";
	String USERNAME = "postgres";
	String PASSWORD = "password";
	User user;
	
	public void setStartDateByUsername(String startDate, String username) {		
		String sql ="UPDATE c_data SET start_date = ? WHERE c_id = (select c_id from customers where username = ?)";
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, startDate);
				stmt.setString(2, username);
				stmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void setEndDateByUsername(String endDate, String username) {		
		String sql ="UPDATE c_data SET end_date = ? WHERE c_id = (select c_id from customers where username = ?)";
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, endDate);
				stmt.setString(2, username);
				stmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void setBalanceByUsername(float balance, String username) {
		
		
		String sql ="UPDATE c_data SET balance = ? WHERE c_id = (select c_id from customers where username = ?)";

		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setFloat(1, balance);
				stmt.setString(2, username);
				stmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public float getBalanceByUsername(String username) {		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){			
			String sql ="select balance from c_data WHERE c_id = (select c_id from customers where username = ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
			        String columnValue = rs.getString(i);
			        if (columnValue != null) {
			        	return Float.valueOf(columnValue);
			        }					        
			    }					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
public void setRoomNumberByUsername(int balance, String username) {
		
		
		String sql ="UPDATE c_data SET room_number = ? WHERE c_id = (select c_id from customers where username = ?)";

		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, balance);
				stmt.setString(2, username);
				stmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

public void setRoomTypeByUsername(String type, String username) {
	
	
	String sql ="UPDATE c_data SET room_type = ? WHERE c_id = (select c_id from customers where username = ?)";

	Connection conn;
	try {
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, type);
			stmt.setString(2, username);
			stmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
}
	
	public void updateBalance(float balance, String username) {		
		AccountPostgres acc = new AccountPostgres(user);
		balance+=acc.getBalanceByUsername(user.getUsername());

		String sql ="UPDATE c_data SET balance = ? WHERE c_id = (select c_id from customers where username = ?)";

		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setFloat(1, balance);
				stmt.setString(2, username);
				stmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void withdraw(float balance, String username) {		
		AccountPostgres acc = new AccountPostgres(user);
		balance=acc.getBalanceByUsername(user.getUsername())-balance;

		String sql ="UPDATE c_data SET balance = ? WHERE c_id = (select c_id from customers where username = ?)";

		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setFloat(1, balance);
				stmt.setString(2, username);
				stmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	public User getUserByUsername(String username) throws UserNotFound {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load Driver");
		}

		User user = null;
				
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "select * from customers where username = ?";
						
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			conn.close();
		
			while (rs.next()) {
				//log.info("User found in DB");
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("pass_word"));
			}
			
		} catch (SQLException e) {
			//log.error("Failure to connect to DB", e);
		}
		
		return user;
	}
	
	public String getUserDataByUsername(String username) throws UserNotFound {
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){			
			String sql ="select * from c_data WHERE c_id = (select c_id from customers where username = ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
			        String columnValue = rs.getString(i);
			        if (columnValue != null) {
			        	return columnValue;
			        }					        
			    }					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		}
	
public String getTierByUsername(String username) throws UserNotFound {
		
	try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){			
		String sql ="select tier from c_data WHERE c_id = (select c_id from customers where username = ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		
		while (rs.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
		        String columnValue = rs.getString(i);
		        if (columnValue != null) {
		        	return columnValue;
		        }					        
		    }					
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "";
	}

public void setTierByUsername(String tier, String username) throws UserNotFound {
	
	String sql ="UPDATE c_data SET tier = ? WHERE c_id = (select c_id from customers where username = ?)";

	Connection conn;
	try {
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, tier);
			stmt.setString(2, username);
			stmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}
}
