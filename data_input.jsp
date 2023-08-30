<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

    <!DOCTYPE html>
    <html>

    <head>
        <title>Data Input | BMR Calculator</title>
        <link rel="icon" type="image/png" href="image/logo/bmr-calculator-website-favicon-color.png">
    </head>

    <body>
        <h1>Personal Data Input</h1>
        <form method="post" action="">
            Gender<input type="radio" id="html" name="gender" value="M">Male
            <input type="radio" id="css" name="gender" value="F">Female<br>
            Age<input type="text" name="age" required><br>
            Height<input type="text" name="height" required><br>
            Weight<input type="text" name="weight" required><br>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </form>
    </body>

    </html>