package com.gemini.database.script;

public interface InsertTemplate {

    public static String INSERT_GPDB_FILM = "INSERT INTO gpadmin.film VALUES ('UA%03d', %d, 'title UA%03d', %d, make_date(2021,12,20), 'Comedy');";
    //                                       INSERT INTO gpadmin.film VALUES ('UA100',   1, 'title UA100', 100, make_date(2021,12,20), 'Comedy');
}
