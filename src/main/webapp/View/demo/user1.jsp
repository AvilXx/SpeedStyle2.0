<%-- 
    Document   : user1
    Created on : Mar 18, 2022, 1:19:37 PM
    Author     : Nhut Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <title>Admin User Management</title>
    </head>
     <style>
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 15px;
        }
        

    </style>
    <body>
        <%@include file="/View/layout/header.jsp" %>
    <div class="hero-wrap hero-bread" style="background-image: url('images/bg_6.jpg');">
        <div class="container">
            <div class="row no-gutters slider-text align-items-center justify-content-center">
                <div class="col-md-9 ftco-animate text-center">
                    <p class="breadcrumbs"><span class="mr-2"><a href="home">Home</a></span> <span>Shop</span></p>
                    <h1 class="mb-0 bread">Shop</h1>
                </div>
            </div>
        </div>
    </div>
    <section>
        <div class="manager-user">
            <h3 style="margin: 30px 30px;"><a href="" >Manager</a> > <a href="">User</a> > <a href="" style="color: green">nhutminh</a></h3>
        </div>
        <div class="infor">
            <table style="margin: 4% 24%;">
                <tr>
                    <td><label for="name">Name</label>:</td>
                    <td><input type="text" value="Nguyễn Minh Nhựt" /></td>
                </tr>
                <tr>
                    <td><label for="phone">Phone</label>:</td>
                    <td><input type="text" value="0213831122" size="30" maxlength="10" pattern="[0-9]{10}" /></td>
                </tr>
                <tr>
                    <td>
                        <label for="address">Address</label>:
                    </td>
                    <td><input type="text" size="80"
                               value="Lô E2a-7, Đường D1 Khu Công Nghệ cao, P. Long Thạnh Mỹ, Tp.Thủ Đức, TP. Hồ Chí Minh" />
                    </td>
                </tr>
                <tr>
                    <td><label for="email">Email</label>:</td>
                    <td><input type="text" id="email" name="email" size="30" value="nhutminh211@gmail.com" /></td>
                </tr>
                
                    
                   
                
            </table>
            <input style="margin: 0 48%"type="submit" name="submit" value="Submit" />
        </div>
        <div class="manager-user">
            <h3><a href="" style="margin-left: 30px; ">Order History</a></h3>
        </div>
        <div style="margin: 4% 14%;">
            <table style="text-align: center; width:100%; font-weight: bold; color: black;" border="1" >
                <tr>
                    <th>ID</th>
                    <th>Order date</th>
                    <th>Amount</th>
                    <th>Control</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>10-02-2022</td>
                    <td>3.500.000 VND</td>
                    <td><a href=""style="color: Green;">View</a></td>
                </tr>
                
            </table>
        </div>
    </section>
    <%@include file="/View/layout/footer.jsp" %>
    </body>

</html>