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
import java.text.DecimalFormat;
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
    
    private final static String ALLPRODUCT = "Select * from dbo.Product";
    private final static String ALLPRODUCT_PART_SEARCH = " Where name LIKE %?%";
    private final static String ALLPRODUCT_PART_CATEGORY = " Where category LIKE ?";

    private final static String PRODUCT_DETAIL = "Select * from dbo.Product Where product_id = ?";
    private final static String SIZE = "Select * from dbo.Size";
    private final static String CATEGORY = "Select * from dbo.Category";
    private final static String PRODUCT_QUANTITY = "Select * from dbo.ProductSize Where product_id = ?";
    private final static String SIMILAR_PRODUCT = "Select * from dbo.Product where category = (select category from dbo.Product where product_id = ? )"
                                                        +" except Select * from dbo.Product where product_id = ?";
    
    private final static String DELETE =" Delete from dbo.Product where product_id = ?";

    public List<Product> getNewArrival(){
        List<Product> list = new ArrayList<>();       
        try{
            String query = NEWARRIVAL;
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
    public List<Product> getCategory(){
        List<Product> list = new ArrayList<>();       
        try{
            String query = CATEGORY;
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getString(1)));
            }
        }catch(Exception e){}
        return list;
    }
    public List<Product> getAllProduct(String sortCategory,String search){
        List<Product> list = new ArrayList<>();        
        try{
            String query = ALLPRODUCT;
            if(!sortCategory.equals("")){
                query+= " Where category LIKE '"+sortCategory+"'";
            }
            if(!search.equals("")){
                query+= " Where name LIKE '%"+search+"%'";
            }
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

    public Product getAllProduct(String id){       
        try{
            String query = PRODUCT_DETAIL;
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
        try{
            String query = SIZE;
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
        try{
            String query = SIMILAR_PRODUCT;
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
        try{
            String query = PRODUCT_QUANTITY;
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

    public void DeleteProduct(String id){
        try{
                String query = DELETE;
                conn = new DBUtils().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, id);
                ps.executeUpdate();         
        }catch(Exception e){}
    }


    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.getAllProduct("Adidas","");
        for(Product o :list){
            System.out.println(o);
        }
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        System.out.println(formatter.format(1000000.0000));
    }

}
