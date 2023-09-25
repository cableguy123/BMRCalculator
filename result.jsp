<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html>

        <head>
            <!-- CSS -->
            <link rel="stylesheet" href="css/result.css">

            <title>Result | BMR Calculator</title>
            <link rel="icon" type="image/png" href="image/logo/bmr-calculator-website-favicon-color.png">
        </head>

        <body>
            <header>
                <div>
                    <a href="main"><img
                            src="image/logo/bmr-calculator-high-resolution-logo-color-on-transparent-background.png"
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
                <h2>Your information</h2>
                <br>
                <table>
                    <tr>
                        <th>Date</th>
                        <th>Total Calories</th>
                        <th>BMR</th>
                        <th>TDEE</th>
                        <th>Result</th>
                    </tr>
                    <c:forEach var="d" items="${result}">
                        <tr>
                            <td>${d.meal_date}</td>
                            <td>${d.meal_calories}</td>
                            <td>${d.bmr}</td>
                            <td>${d.tdee}</td>
                            <td>${d.result}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </body>

        </html>