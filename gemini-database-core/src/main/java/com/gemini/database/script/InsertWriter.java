package com.gemini.database.script;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InsertWriter {

    public static void main(String[] args) {
	String filePath = "C:\\Users\\ylin2\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\01Greenplum\\";
	String fileName = "insertFilm.txt";
	String template = InsertTemplate.INSERT_GPDB_FILM;
	int rowCount = 80;
	try {
	    InsertWriter.createFile(filePath + fileName, template, rowCount);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    private static void createFile(String filePath, String sql, int row) throws IOException {
	System.out.println(String.format("file path : %s", filePath));
	System.out.println(String.format("sql templete : %s", sql));
	System.out.println(String.format("record row account : %d", row));
	File file = new File(filePath);
	FileWriter fw = null;
	BufferedWriter bw = null;
	if (file.exists()) {
	    file.delete();
	}
	if (!file.exists()) {
	    file.createNewFile();
	    fw = new FileWriter(file);
	    bw = new BufferedWriter(fw);
	    for (int i = 1; i <= row; i++) {
//		Integer[] arg = new Integer[] { Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(i),
//			Integer.valueOf(i) };
		Object[] arg2 = new Integer[] { Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(i),
			Integer.valueOf(i) };
		bw.append(String.format(sql, arg2)).append("\n").flush();
	    }
	    bw.close();
	    fw.close();
	}
    }

    public void comment() {
	// String[] arg = new String[] { "1", "2", "3", "4" };
	// System.out.println(String.format("'UA%03d'", 1));
	// String str = String.format("this is %d",1);
	// System.out.println(String.format(INSERT_TEMPLET, 1));
	// String[] arg = new String[] { String.valueOf(i), String.valueOf(i),
	// String.valueOf(i), String.valueOf(i) };
	// bw.append(String.format(INSERT_TEMPLET, i,i,i,i));
    }

}
