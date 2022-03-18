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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author avillX
 */
public class UserDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null; 

    private final static String CHECKLOGIN = "SELECT * FROM dbo.Users WHERE user_name=? AND password=? ";
    private final static String CHECKLOGINBYUSERNAME = "SELECT * FROM dbo.Users WHERE user_name=? ";
    private final static String CHECKLOGINBYID = "SELECT * FROM dbo.Users WHERE user_id = ? ";
    private final static String SIGNUP = "INSERT INTO dbo.Users VALUES (?, ?, ?, null, null, null, null, 0) ";

    private final static String ALL_USER = "Select * from dbo.Users ";
    private final static String DELETE =" Delete from dbo.Users where user_id = ?";

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
    public User checkLoginByUserName(String username){
        User result = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = CHECKLOGINBYUSERNAME;
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String fullname = rs.getString("name");
                    String roleid = rs.getString("isAdmin");
                    result = new User("",username,"", fullname,"","","", roleid);
                }
            }
        } catch (Exception e) {
        } 
        return result;
    }
    public User checkLoginByID(String id){
        User result = null;
        try {
            conn = DBUtils.getConnection();
            String sql = CHECKLOGINBYID;
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String username = rs.getString("user_name");
                String password = rs.getString("password");
                String fullname = rs.getString("name");
                String roleid = rs.getString("isAdmin");
                result = new User(id,username, password, fullname,"","","", roleid);
                }            
        } catch (Exception e) {
        } 
        return result;
    }

    public boolean signUp(String user, String pass) {
//        String RandomID = Integer.toString(RandomID());
        String query = SIGNUP;
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, RandomID());
            ps.setString(2, user);
            ps.setString(3, pass);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
        }
        return false;
    }   

    public List<User> AllUser(String search) {
        List<User> list = new ArrayList();
        try {
            String query = ALL_USER;
            
            if(!search.equals("")){
                query+= " Where user_name LIKE '%"+search+"%' ";
            }
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public void DeleteUser(String id){
        try{
                String query = DELETE;
                conn = new DBUtils().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, id);
                ps.executeUpdate();         
        }catch(Exception e){}
    }

    public int RandomID() {
        UserDAO dao = new UserDAO();
        int ranNum = ThreadLocalRandom.current().nextInt(1,999999);
        User us = dao.checkLoginByID(Integer.toString(ranNum));
        if (us==null){
            return ranNum;
        }
        return RandomID();
    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        List<User> list = dao.AllUser("");
        for (User o: list){
            System.out.println(o);
        }
    } 
}
