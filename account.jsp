<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

  <!DOCTYPE html>
  <html>

  <head>
    <!-- CSS -->
    <link rel="stylesheet" href="css/account.css">

    <title>Account setting | BMR Calculator</title>
    <link rel="icon" type="image/png" href="image/logo/bmr-calculator-website-favicon-color.png">
  </head>

  <body>
    <header>
      <div>
        <a href="main"><img src="image/logo/bmr-calculator-high-resolution-logo-color-on-transparent-background.png"
            alt="Website logo" width="50%"></a>
      </div>
      <nav>
        <ul>
          <li><a class="link" href="main">TOP</a></li>
          <li><a class="link" href="showresultservlet">RESULT</a></li>
          <li><a class="link" href="account">ACCOUNT</a></li>
          <li><a class="link" href="aboutus">ABOUT AS</a></li>
        </ul>
      </nav>
    </header>

    <div class="content">
      <h2>Account setting</h2>

      <h3>Password change</h3>
      <form method="post" action="passwordchangeservlet">
        Old password<input class="input" type="password" name="old_password" required>
        <br>
        New password<input class="input" type="password" name="new_password" required>
        <br>
        New password confirm<input class="input" type="password" name="new_password_confirm" required>
        <br>
        <input class="button" type="submit" value="Submit">
        <input class="button" type="reset" value="Reset">
      </form>
    </div>
  </body>

  </html>