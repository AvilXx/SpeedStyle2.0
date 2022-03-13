<%-- 
    Document   : admin
    Created on : Mar 13, 2022, 8:30:02 PM
    Author     : avillX
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Minishop - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">    
    <link rel="stylesheet" href="css/styleadmin.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.css">
    
</head>
<body>
    <%@include file="/View/layout/header.jsp" %>
    <div class="hero-wrap hero-bread" style="background-image: url('images/bg_6.jpg');">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
                    
        </div>
      </div>
    </div>
    
    <div class="row containern">
            <div class="row item-title">
                    <div class="col-md-6">
                        <button class="btn btn-1">USER MANAGEMENT</button>
                    </div>
                    <div class="col-md-6">
                            <button class="btn btn-2">ORDER MANAGEMENT</button>
                    </div>
            </div>
            <div class="row item-title">
                    <div class="col-md-6">
                            <button class="btn btn-3">PRODUCT MANAGEMENT</button>
                    </div>
                    <div class="col-md-6">
                            <button class="btn btn-4">ADD NEW PRODUCT</button>
                    </div>
            </div>
    </div>
    <%@include file="/View/layout/footer.jsp" %>
</body>
</html>
