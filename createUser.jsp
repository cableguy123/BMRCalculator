<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>

<head>
    <!-- CSS -->
    <link rel="stylesheet" href="css/login.css">

    <title>Create User | BMR Calculator</title>
    <link rel="icon" type="image/png" href="image/logo/bmr-calculator-website-favicon-color.png">
    <script type="text/javascript">
         function isValidID(id) {
          var regex = /^[a-zA-Z0-9]+$/;
          return regex.test(id);  
        }

      function validateForm() {
      var userIDInput = document.getElementsByName('user')[0];
      var userID = userIDInput.value;
      if (!isValidID(userID)) {
        alert('Special characters and symbols not be there');
        return false; 
      }
      return true; 
    }
    </script>
</head>

<body>
    <img class="logo" src="image/logo/bmr-calculator-high-resolution-logo-color-on-transparent-background.png"
        alt="Website logo">
    <h1>Create User</h1>
    <form method="post" action="insertuserservlet" onsubmit="return validateForm()" id="user">
        <div class="block">
            <label class="text">Username</label><input class="input" type="text" name="user" required>
        </div>
        <div class="block">
            <label class="text">Password</label><input class="input" type="password" name="pass" required>
        </div>
        <input class="button" type="submit" value="Join US">
    </form>
    <input class="button" type="submit" value="Back To Login" onclick="location.href='login.jsp'">

  
</body>

</html>
