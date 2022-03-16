/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.speedstyle.prj301.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avillX
 */
public class Cart {
    private List<ProductCart> products;
    public Cart(){
        products = new ArrayList<>();
    }

    public List<ProductCart> getProductCart() {
        return products;
    }

    public void setProductCart(List<ProductCart> products) {
        this.products = products;
    }
    public int getQuantityById(int id){
        return getProductById(id).getQuantity();
    }

    public ProductCart getProductById(int id){
        for(ProductCart i: products){
            if (i.getProduct().getId()==id){
                return i; 
            }
        }
        return null;
    }

    public void addProductCart(ProductCart p){
        if(getProductById(p.getProduct().getId())!=null){
            ProductCart m = getProductById(p.getProduct().getId());
            m.setQuantity((m.getQuantity()+m.getQuantity()));
        }else
            products.add(p);  
    }

    public void removeProductCart(int id){
        if(getProductById(id)!=null){
            products.remove(getProductById(id));
        }
    }

    public double getTotalMoney(){
        double t=0;
        for(ProductCart i: products){
            t+=(i.getQuantity()*i.getPrice());
        }
        return t;
    }
    private Product getProductByID(int id,List<Product> list){
        for( Product i:list){
            if(i.getId()==id) return i;    
        }
        return null;
    }
    public Cart (String txt,List<Product> list){      
        try{
            if(txt!=null && txt.length()!=0){
                String[] s = txt.split(".");
                for(String i:s){
                    String[] n = i.split(":");
                        int id = Integer.parseInt(n[0]);
                        int size = Integer.parseInt(n[1]);
                        int quantity = Integer.parseInt(n[2]);
                    Product p = getProductByID(id,list);
                    ProductCart t = new ProductCart (p,size,quantity,p.getPrice());
                    addProductCart(t);
                }
            }
        }catch(NumberFormatException e){
        }   
    } 

}
