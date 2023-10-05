<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

  <!DOCTYPE html>
  <html>

  <head>
    <!-- CSS -->
    <link rel="stylesheet" href="css/about_us.css">

    <title>Account setting | BMR Calculator</title>
    <link rel="icon" type="image/png" href="image/logo/bmr-calculator-website-favicon-color.png">
  </head>

  <body>
    <header>
      <div>
        <a href="main?user_id=<% String s = request.getParameter("user_id"); %><%=s %>"><img src="image/logo/bmr-calculator-high-resolution-logo-color-on-transparent-background.png"
            alt="Website logo" width="50%"></a>
      </div>
      <nav>
        <ul>
          <li><a class="link" href="main?user_id=<%=s %>">TOP</a></li>
          <li><a class="link" href="showresultservlet?user_id=<%=s %>">RESULT</a></li>
          <li><a class="link" href="account?user_id=<%=s %>">ACCOUNT</a></li>
          <li><a class="link" href="aboutus?user_id=<%=s %>">ABOUT US</a></li>
        </ul>
      </nav>
    </header>

    <div class="content">
      <h2>About us</h2>
      <p>Welcome to BMR CALCULATOR, your trusted source for accurate and personalized Basal Metabolic Rate calculations.
        Our mission is to empower individuals on their journey towards a healthier lifestyle by providing precise
        insights into their daily energy expenditure.</p>
      <h2>Our Commitment</h2>
      <p>At BMR CALCULATOR, we believe that understanding your Basal Metabolic Rate is a fundamental step in
        achieving your health and fitness goals. We are dedicated to offering a user-friendly platform that delivers
        reliable BMR calculations tailored to your unique profile.</p>
      <div class="button_center"><a class="button" href="main?user_id=<% s = request.getParameter("user_id"); %><%=s %>">Back</a></div>
    </div>
  </body>

  </html>