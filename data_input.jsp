<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

    <!DOCTYPE html>
    <html>
    <script type="text/javascript">
      function validate() {
        var regExp1 = /^(1[4-9]|[2-9]\d|10\d|11\d|12\d|130)$/
        var regExp2 = /^(4|[4-9]\d|1\d{2}|200|280|\d*\.\d+)$/
        var regExp3 = /^(3[0-9]|[4-9][0-9]|1[0-9]{2}|240|\d*\.\d+)$/
        var age_Valid = document.form1.age.value.match(regExp1);
        var height_Valid = document.form1.height.value.match(regExp2);
        var weight_Valid = document.form1.weight.value.match(regExp3);
        if(age_Valid == "" || age_Valid == null) {
          alert("Please Enter age 14 ~ 130");
          document.form1.age.value = "";
          return false;
        }else if(height_Valid == "" || height_Valid == null) {
          alert("Please Enter height 4 ~ 280");
          document.form1.height.value = "";
          return false;
        }else if(weight_Valid == "" || weight_Valid == null) {
          alert("Please Enter Weight 30 ~ 240 ");
          document.form1.weight.value = "";
          return false;
        }else {
          document.form1.submit();
        }
        
      }
      </script>
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

        <form method="post" name="form1" onsubmit="return validate()" action="datainputservlet?user_id=<% String s = request.getParameter("user_id"); %><%=s %>">
            Gender<input id="1" class="radio" type="radio" name="gender" value="Male" required>
            <label for="1">Male</label>
            <input id="2" class="radio" type="radio" name="gender" value="Female" required>
            <label for="2">Female</label>
            <br>
            Age<input class="input" type="text" name="age" id="input01" >
            <br>
            Height(cm)<input class="input" type="text" name="height" >
            <br>
            Weight(kg)<input class="input" type="text" name="weight" >
            <br>
            <input class="button" type="submit" value="Submit">
            <input class="button" type="reset" value="Reset">
        </form>
    </body>

    </html>