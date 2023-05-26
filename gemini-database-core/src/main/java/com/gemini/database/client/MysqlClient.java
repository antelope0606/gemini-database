package com.gemini.database.client;

import java.sql.Connection;

import com.gemini.database.IDatabaseCategory;
import com.gemini.database.conn.DBConnFactory;
import com.gemini.database.util.DBUtil;

public class MysqlClient {

    public static void main(String[] args) {
	try {
	    Connection conn = DBConnFactory.getInstance().getconn(IDatabaseCategory.DB_VENDOR_MYSQL);
	    DBUtil.printConn(conn);
	    DBUtil.testConn(conn, "");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
