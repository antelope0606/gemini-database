package com.gemini.database.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

public class DBUtil {

    public static void testConn(Connection conn, String sql) {
	try {
	    Statement s = conn.createStatement();
	    s.execute(sql);
	    s.close();
	    printWarning(conn.getWarnings());
	} catch (SQLException e) {
	    printException(e);
	    e.printStackTrace();
	} finally {
	    if (conn != null) {
		try {
		    conn.close();
		} catch (SQLException e) {
		    DBUtil.printException(e);
		    e.printStackTrace();
		}
	    }
	}
    }

    public static void printConn(Connection conn) {
	try {
	    System.out.println("user:" + conn.getMetaData().getUserName());
	    System.out.println("url:" + conn.getMetaData().getURL());
	} catch (SQLException e) {
	    printException(e);
	    e.printStackTrace();
	}
    }

    public static void printException(SQLException e) {
	System.err.println("SQLException: " + e.getMessage());
	System.err.println("SQLState: " + e.getSQLState());
	System.err.println("Vendor code: " + e.getErrorCode());
    }

    public static void printWarning(SQLWarning w) {
	while (w != null) {
	    System.err.println("SQLWarning: " + w.getMessage());
	    System.err.println("SQLState: " + w.getSQLState());
	    System.err.println("Vendor code: " + w.getErrorCode());
	    w = w.getNextWarning();
	}
    }

}
