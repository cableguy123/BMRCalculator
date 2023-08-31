<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

    <!DOCTYPE html>
    <html>

    <head>
        <!-- CSS -->
        <link rel="stylesheet" href="css/login.css">

        <title>Log In | BMR Calculator</title>
        <link rel="icon" type="image/png" href="image/logo/bmr-calculator-website-favicon-color.png">
    </head>

    <body>
        <img class="logo" src="image/logo/bmr-calculator-high-resolution-logo-color-on-transparent-background.png"
            alt="Website logo">
        <h1>Log In</h1>
        <form method="post" action="">
            <div class="block">
                <lable class="text">Username</lable><input class="input" type="text" name="user" required>
            </div>
            <div class="block">
                <lable class="text">Password</lable><input class="input" type="password" name="pass" required>
            </div>
            <input class="button" type="submit" value="Log In">
        </form>
    </body>

    </html>