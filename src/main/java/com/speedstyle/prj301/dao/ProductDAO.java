/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.speedstyle.prj301.dao;

import com.speedstyle.prj301.dto.Product;
import com.speedstyle.prj301.dto.ProductSize;
import com.speedstyle.prj301.dto.Size;
import com.speedstyle.prj301.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AvillX
 */
public class ProductDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;  

    private final static String NEWARRIVAL =" Select top (4) *  from dbo.Product ORDER BY product_id DESC";
    private final static String PRODUCT_DETAIL = "Select * from dbo.Product Where product_id = ?";
    private final static String SIZE = "Select * from dbo.Size";
    private final static String PRODUCT_QUANTITY = "Select * from dbo.ProductSize Where product_id = ?";
    private final static String SIMILAR_PRODUCT = "Select * from dbo.Product where category = (select category from dbo.Product where product_id = ? )"
                                                        +" except Select * from dbo.Product where product_id = ?";

    public List<Product> getNewArrival(){
        List<Product> list = new ArrayList<>();
        String query = NEWARRIVAL;
        try{
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getDouble(4),
                                    rs.getString(5)));
            }
        }catch(Exception e){}
        return list;
    }
//    public List<Product> getAllProductHome(String sortCategory,String search){
//        List<Product> list = new ArrayList<>();
//        String query = "Select * from dbo.Product";
//
//        if(!sortCategory.equals("")){
//            query+= " Where category LIKE '"+sortCategory+"'";
//        }
//        if(!search.equals("")){
//            query+= " Where name LIKE '%"+search+"%'";
//        }
//        try{
//            conn = new DBUtils().getConnection();
//            ps = conn.prepareStatement(query);
//            rs = ps.executeQuery();
//            while(rs.next()){
//                list.add(new Product(rs.getInt(1),
//                                    rs.getString(2),
//                                    rs.getString(3),
//                                    rs.getDouble(4),
//                                    rs.getString(5)));
//            }
//        }catch(Exception e){}
//        return list;
//    }

    public Product getAllProduct(String id){
        String query = PRODUCT_DETAIL;
        try{
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getDouble(4),
                                    rs.getString(5),
                                    rs.getString(6));
            }
        }catch(Exception e){}
        return null;
    }

    public List<Size> getSize(){
        List<Size> list = new ArrayList<>();
        String query = SIZE;
        try{
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Size(rs.getString(1)));
            }
        }catch(Exception e){}
    return list;
    }


    public List<Product> getSimilarProduct(String id){
        List<Product> list = new ArrayList<>();
        String query = SIMILAR_PRODUCT;
        try{
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, id);
            rs = ps.executeQuery();          
            while(rs.next()){
                list.add(new Product(rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getDouble(4),
                                    rs.getString(5)));
            }
        }catch(Exception e){}
    return list;
    }

    public ProductSize getSizeProduct(String id){
        String query = PRODUCT_QUANTITY;
        try{
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                return new ProductSize(rs.getInt(1),
                                    rs.getInt(2),
                                    rs.getInt(3),
                                    rs.getInt(4),
                                    rs.getInt(5),
                                    rs.getInt(6),
                                    rs.getInt(7));
            }
        }catch(Exception e){}
    return null;
}

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.getNewArrival();
        for(Product o :list){
            System.out.println(o);
        }
    }

}
