<%-- 
    Document   : user
    Created on : Mar 18, 2022, 1:18:42 PM
    Author     : Nhut Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>User Management</title>
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
                <h3><a href="">Manager</a> > <a href="">User</a></h3>
            </div>
            <div style="margin: 4% 4%;">
                <table style="text-align: center; width:100%; height: 100%; font-weight: bold; color: black; " border="1">
                    <tr >
                        <th>ID</th>
                        <th>Username</th>
                        <th>Phone</th>
                        <th>More Information</th>
                        <th>Order History</th>
                        <th>Control</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>minhtri</td>
                        <td>1212112333</td>
                        <td><a href="user1.jsp" style="color: green;">View</a></td>
                        <td class="orderH"><a href="" style="color: black;">9</a></td>
                        <td class="control" ><a href="" style="color: red;">Delete</a></td>
                    </tr>

                </table>
            </div>
        </section>
        <%@include file="/View/layout/footer.jsp" %>
    </body>
</html>
