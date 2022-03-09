<%-- 
    Document   : signup
    Created on : Feb 18, 2022, 9:15:03 PM
    Author     : Nhut Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
  <link rel="stylesheet" type="text/css" href="../css/signup.css">

  <title>Sign Up</title>
</head>
<body>
 <div class="container">
  <h2>Sign up</h2>
  <div class="row">
    <form class="col s12">
      <div class="row">
        <div class="input-field col s6">
          <input id="first_name" type="text" class="validate">
          <label for="first_name">First Name</label>
        </div>
        <div class="input-field col s6">
          <input id="last_name" type="text" class="validate">
          <label for="last_name">Last Name</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="email" type="email" class="validate" >
          <label for="email" data-error="wrong" data-success="right">Email</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="password" type="password" class="validate">
          <label for="password">Password</label>
        </div>
      </div>
      <button class="btn btn-flat btn-large waves-effect waves-dark white grey-text text-darken-3" type="submit"><a href="signin.jsp">Signup</button></a>
    </form>
  </div>
</div>
<footer id="footer">
  <div class="container center">
    <p>Made with <i class="material-icons red-text text-lighten-3 tiny">favorite</i> By <a href="../home.jsp" class="green-text text-lighten-2" target="_blank">SpeedStyle Shop</a></p>
  </div>
</footer>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script>
</body>

</html>