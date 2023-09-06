<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

    <!DOCTYPE html>
    <html>

    <head>
        <!-- CSS -->
        <link rel="stylesheet" href="css/data_input.css">

        <title>Data Input | BMR Calculator</title>
        <link rel="icon" type="image/png" href="image/logo/bmr-calculator-website-favicon-color.png">
    </head>

    <body>
        <img class="logo" src="image/logo/bmr-calculator-high-resolution-logo-color-on-transparent-background.png"
            alt="Website logo">
        <h1>Personal Data Input</h1>
        <form method="post" action="datacalculator">
            Gender<input class="radio" type="radio" name="gender" value="M">Male
            <input class="radio" type="radio" name="gender" value="F">Female<br>
            Age<input class=" input" type="text" name="age" required><br>
            Height<input class=" input" type="text" name="height" required><br>
            Weight<input class=" input" type="text" name="weight" required><br>
            <input class="button" type="submit" value="Submit">
            <input class="button" type="reset" value="Reset">
        </form>
    </body>

    </html>