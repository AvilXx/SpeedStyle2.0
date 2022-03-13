/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.speedstyle.prj301.dao;

import com.speedstyle.prj301.dto.User;
import com.speedstyle.prj301.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author avillX
 */
public class UserDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null; 

    private final static String CHECKLOGIN = "SELECT * FROM dbo.Users WHERE user_name=? AND password=?";

    public User checkLogin(String username, String password){
        User result = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = CHECKLOGIN;
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String fullname = rs.getString("name");
                    String roleid = rs.getString("isAdmin");
                    result = new User("",username, password, fullname,"","","", roleid);
                }
            }
        } catch (Exception e) {
        } 
        return result;
    }   

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        User list = dao.checkLogin("hung","hung");
        
            System.out.println(list);

    } 
}
