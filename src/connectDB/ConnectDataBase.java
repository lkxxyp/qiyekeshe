package connectDB;

import java.sql.*;
import java.text.Normalizer.Form;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ConnectDataBase {
	String driver = "com.mysql.jdbc.Driver";
	String jdbcURL = "jdbc:mysql://localhost/qiye?user=root&password=root&useUnicode=true&characterEncoding=gbk";

	public Connection conn;
	ResultSet rs;
	public Statement stmt;
	String username;
	static int i;

	public void connectdatabase() {
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(jdbcURL);
			System.out.println("已成功启动服务器\n连接数据库成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean selectdata(String name, String password) {
		int a;
		boolean b = false;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from information where username=\"" + name
					+ "\"");
			while (rs.next()) {
				System.out.println(12);
				if (rs.getString("password").equals(password)) {
					b = true;
					username = rs.getString("username");
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;

	}

	public boolean selectdata(String name) {
		boolean b = false;
		try {
			stmt = conn.createStatement();
			System.out.println(name);
			rs = stmt.executeQuery("select * from information where username=\"" + name
					+ "\"");
			while (rs.next()) {
				b = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}

	public String showword(int i) {
		String word = "";
		this.i = i;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from guessword where id=\"" + i
					+ "\"");
			while (rs.next()) {
				word = rs.getString("word");
			}
			System.out.println("添加了文字库" + word);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return word;
	}

	public int getlenght() {
		int i = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from guessword ");
			while (rs.next()) {
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}
	public void delete() {
		String s = "delete  from guessword where id=\""+i+"\"";
		try {
			System.out.println(i);
			stmt = conn.createStatement();
//			st = (Statement) conn.createStatement();
			int index =0;
			int ss = stmt.executeUpdate(s);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addgrad(String str) {
		try {

			int i = getgrad(str) + 1;
			System.out.println(i);
			String s = "update information set score=\"" + i + "\"where username=\"" + str
					+ "\"";
			System.out.println(str + "加了一分");
			stmt = conn.prepareStatement(s);
			stmt.executeUpdate(s);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public int getgrad(String str) {
		int g = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from information where username=\"" + str
					+ "\"");
			while (rs.next()) {
				g = rs.getInt("score");
				System.out.println(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}
}
