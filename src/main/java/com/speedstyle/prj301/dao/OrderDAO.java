/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.speedstyle.prj301.dao;

import com.speedstyle.prj301.dto.Order;
import com.speedstyle.prj301.dto.OrderDetail;
import com.speedstyle.prj301.dto.ProductCart;
import com.speedstyle.prj301.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avillX
 */
public class OrderDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    private final static String ALLORDERS = "Select * from dbo.Orders";
    private final static String ALLORDERSOFUSER = "Select * from dbo.Orders where user_id = ?";    
    private final static String ORDERS_ID = "select * from dbo.Orders where transaction_id = ?";

    private final static String GETORDERDETAIL ="select * from dbo.OrderDetail where transaction_id = ?";
    private final static String UPDATE_STATUS = "UPDATE dbo.Orders set status = ? where transaction_id = ?";

    public List<Order> getAllOrder(String search){
        List<Order> list = new ArrayList<>();        
        try{
            String query = ALLORDERS;
            if(!search.equals("")){
                query+= " Where transaction_id LIKE = "+search;
            }
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Order(rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getInt(4),
                                    rs.getString(5),
                                    rs.getDouble(6),
                                    rs.getString(7),
                                    rs.getDate(8)));
            }
        }catch(Exception e){}
        return list;
    }
    public List<Order> getAllOrderOfUser(String userid,String search){
        List<Order> list = new ArrayList<>();        
        try{
            String query = ALLORDERSOFUSER;
            if(!search.equals("")){
                query+= " and transaction_id LIKE = "+search;
            }
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userid);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Order(rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getInt(4),
                                    rs.getString(5),
                                    rs.getDouble(6),
                                    rs.getString(7),
                                    rs.getDate(8)));
            }
        }catch(Exception e){}
        return list;
    }
    public Order getOrderByID(String Oid){
        List<Order> list = new ArrayList<>();        
        try{
            String query = ORDERS_ID;          
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Oid);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Order(rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getInt(4),
                                    rs.getString(5),
                                    rs.getDouble(6),
                                    rs.getString(7),
                                    rs.getDate(8));
            }
        }catch(Exception e){}
        return null;
    }
    public List<ProductCart> getAllOrderDetail(String TransactionID){
        ProductDAO dao = new ProductDAO();
        List<ProductCart> list = new ArrayList<>();        
        try{
            String query = GETORDERDETAIL;           
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, TransactionID);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new ProductCart(dao.getProductByID(rs.getString(3)),
                                        rs.getInt(4),
                                        rs.getInt(5),
                                        rs.getDouble(6)));
            }
        }catch(Exception e){}
        return list;
    }
    public String getUserIDbyTransaction(String TransactionID){
        ProductDAO dao = new ProductDAO();
        List<ProductCart> list = new ArrayList<>();        
        try{
            String query = ORDERS_ID;           
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, TransactionID);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getString(3);
            }
        }catch(Exception e){}
        return null;
    }
    public boolean UpdateStatusOrder(String TransactionID, String status) {
        String query = UPDATE_STATUS;
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);            
            ps.setString(1, status);          
            ps.setString(2, TransactionID);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
        }
        return false;
    }












































    public static void main(String[] args) {
        OrderDAO dao = new OrderDAO();
        Order list = dao.getOrderByID("1");
//        System.out.println(n);
//        ProductSize list = dao.getProductAllSize("1");
//        for(Order o :list){
            System.out.println(list);
//        }
        
    }
    }











