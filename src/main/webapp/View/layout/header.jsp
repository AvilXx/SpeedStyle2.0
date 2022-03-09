<%-- 
    Document   : header
    Created on : Mar 9, 2022, 4:34:01 PM
    Author     : avillX
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <jsp:useBean id="a" class="com.speedstyle.prj301.dao.ProductDAO" scope="request"></jsp:useBean>        
    </head>
    <body>
        <div class="py-1 bg-black">
    	<div class="container">
    		<div class="row no-gutters d-flex align-items-start align-items-center px-md-0">
	    		<div class="col-lg-12 d-block">
		    		<div class="row d-flex">
		    			<div class="col-md-5 pr-4 d-flex topper align-items-center">
<!--					    	<div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-phone2"></span></div>
						    <span class="text">+ 1235 2355 98</span>-->
                                        </div>
                                        <div class="col-md-5 pr-4 d-flex topper align-items-center">
<!--					    	<div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-paper-plane"></span></div>
                                                <span class="text">speyle081222@email.com</span>-->
                                        </div>
                                    <c:set var="login" value="${sessionScope.LOGIN_USER.username}"></c:set>
                                    <c:if test="${ empty login}">
                                        <div class="col-md-2 pr-4 d-flex topper align-items-right text-lg-right">
                                                <a href="login">Sign In     | </a>
                                                <a href="signup">   Sign Up</a>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty login}">
                                        <div class="col-md-2 pr-4 d-flex topper align-items-right text-lg-right">
                                                <a href="user/${sessionScope.LOGIN_USER.username}">${sessionScope.LOGIN_USER.username}    | </a>
                                                <a href="logout">   Log Out</a>
                                        </div> 
                                    </c:if>
				</div>
			    </div>
		    </div>
		  </div>
    </div>
    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="home">SpeedStyle</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item active"><a href="home" class="nav-link">Home</a></li>
	          <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="shop" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Category</a>
              
              <div class="dropdown-menu" aria-labelledby="dropdown04">                  
                <c:forEach items="${a.category}" var="o">
                        <a class="dropdown-item" href="shop?sortCategory=${o.category}">${o.category}</a>                
                </c:forEach> 
              </div>
            </li>
	          <li class="nav-item"><a href="about.html" class="nav-link">About</a></li>
	          <li class="nav-item"><a href="blog.html" class="nav-link">Blog</a></li>
	          <li class="nav-item"><a href="contact.html" class="nav-link">Contact</a></li>
	          <li class="nav-item cta cta-colored"><a href="cart.html" class="nav-link"><span class="icon-shopping_cart"></span>[0]</a></li>

	        </ul>
	      </div>
	    </div>
	  </nav>
    </body>
</html>



