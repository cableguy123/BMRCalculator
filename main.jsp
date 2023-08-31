<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

    <!DOCTYPE html>
    <html>

    <head>
        <!-- CSS -->
        <link rel="stylesheet" href="css/main.css">

        <title>BMR Calculator</title>
        <link rel="icon" type="image/png" href="image/logo/bmr-calculator-website-favicon-color.png">
        <header>
            <a class="logo" href="main.html"><img class="logo"
                    src="image/logo/bmr-calculator-high-resolution-logo-color-on-transparent-background.png"
                    alt="Website logo"></a>
            <nav>
                <ul>
                    <li><a class="link" href="">TOP</a></li>
                    <li><a class="link" href="">ACCOUNT</a></li>
                    <li><a class="link" href="">ABOUT AS</a></li>
                </ul>
            </nav>
        </header>
    </head>

    <body>
        <h2>BMR</h2>
        <p>BMR(Basal Metabolic Rate) is an acronym to describe basal metabolic rate, or the energy(calories) your body
            needs to perform basic
            functions such as breathing, blood circulation, cellular growth, body temperature regulation, hair growth
            and hormone production. </p>
        <h2>TDEE</h2>
        <p>TDEE(Total Daily Energy Expenditure) is the total energy(calories) that a person uses in a day. TDEE is
            hard to measure accurately and varies day by day. More often, it is estimated using factors such as a
            person's BMR, activity level, and the thermic effect of food.</p>
        <form method="post" action="">
            <h3>Activity Level</h3><input type="radio" id="html" name="activity_level" value="1">Sedentary: Little or no
            exercise
            <input type="radio" id="css" name="activity_level" value="2">Light: Exercise 1-2 times/week
            <input type="radio" id="html" name="activity_level" value="3">Moderate: Exercise 3-5 times/week
            <input type="radio" id="html" name="activity_level" value="4">Active: Daily exercise or intense exercise 6-7
            times/week
            <input type="radio" id="html" name="activity_level" value="5">Extra Active: Very intense exercise daily, or
            physical job<br>
            <input type="submit" value="Calculate">
        </form>
    </body>

    </html>