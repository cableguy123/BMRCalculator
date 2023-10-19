<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

    <!DOCTYPE html>
    <html>

    <head>
        <!-- CSS -->
        <link rel="stylesheet" href="css/main.css">

        <title>BMR Calculator</title>
        <link rel="icon" type="image/png" href="image/logo/bmr-calculator-website-favicon-color.png">
    </head>

    <body>
        <div>
            <header>
                <div>
                    <a href="main?user_id=<% String s = request.getParameter("user_id"); %><%=s %>"><img
                            src="image/logo/bmr-calculator-high-resolution-logo-color-on-transparent-background.png"
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

            <section class="container">
                <div class="left-half">
                    <article>
                        <h2>BMR</h2>
                        <p>BMR(Basal Metabolic Rate) is an acronym to describe basal metabolic rate, or the
                            energy(calories)
                            your
                            body
                            needs to perform basic
                            functions such as breathing, blood circulation, cellular growth, body temperature
                            regulation,
                            hair
                            growth
                            and hormone production. </p>
                        <h2>TDEE</h2>
                        <p>TDEE(Total Daily Energy Expenditure) is the total energy(calories) that a person uses in a
                            day.
                            TDEE
                            is
                            hard to measure accurately and varies day by day. More often, it is estimated using factors
                            such
                            as
                            a
                            person's BMR, activity level, and the thermic effect of food.</p>
                    </article>
                </div>

                <div class="right-half">
                    <article>
                        <form method="post" action="insertmealdataservlet?user_id=<%=s %>">
                            <div>
                                <h3>Activity Level</h3>
                                <input id="1" type="radio" name="activity_level" value="1" required>
                                <label for="1">Sedentary: Little or no exercise</label>
                                <br>
                                <input id="2" type="radio" name="activity_level" value="2" required>
                                <label for="2">Light: Exercise 1-2 times/week</label>
                                <br>
                                <input id="3" type="radio" name="activity_level" value="3" required>
                                <label for="3">Moderate: Exercise 3-5 times/week</label>
                                <br>
                                <input id="4" type="radio" name="activity_level" value="4" required>
                                <label for="4">Active: Daily exercise or intense exercise 6-7 times/week</label>
                                <br>
                                <input id="5" type="radio" name="activity_level" value="5" required>
                                <label for="5">Extra Active: Very intense xercise daily, or physical job</label>
                                <br>
                            </div>

                            <div>
                                <h3>Calories Data</h3>
                                Calories(kcal)<input class=" input" type="text" name="calories" required><br>
                                <input class="button" type="submit" value="Calculate"><br>
                            </div>
                        </form>
                    </article>
                </div>
            </section>
        </div>

        <% if(request.getAttribute("message")!=null){ String message=(String)request.getAttribute("message"); %>
            <script type="text/javascript">
                var msg = "<%=message%>";
                alert(msg);
            </script>
            <%}%>

    </body>

    </html>