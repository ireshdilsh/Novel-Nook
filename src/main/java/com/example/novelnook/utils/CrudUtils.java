package com.example.novelnook.utils;

import com.example.novelnook.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CrudUtils {
    public static <T>T execute(String sql, Object...obj){
        try {
            Connection con = DBConnection.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }
            // check querry is executeQuery or executeUpdate
            if (sql.startsWith("SELECT") || sql.startsWith("select")) {
                ResultSet rs = ps.executeQuery();
                return (T) rs;
            }
            // default working execteUpdate
            int i = ps.executeUpdate();
            boolean isSave = i > 0;
            return (T)((Boolean)isSave);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
