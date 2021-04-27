<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

    <head>
        <title>Sign Up</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="style/style.css">
    </head>

    <body>
        <div class="login">
            <h1>Sign Up</h1>
            <form action="user_verify" method="POST">
                <h5 style="color:red; font-weight: bold; font-size: 14px; text-align: center">${requestScope.ERROR_STRING}</h5>
                <input type="email" name="txtEmail" value="" placeholder="Email" required="required" />
                <input id = "txtPassword" type="password" name="txtPassword" value="" placeholder="Password" required="required" />
                <input id = "txtConfirmPassword" type="password" placeholder="Confirm Password" required="required" onkeyup="
                        var password = document.getElementById('txtPassword').value;
                        if (document.getElementById('txtConfirmPassword').value !== password) {
                            document.getElementById('errorString').style.display = 'block';
                            document.getElementById('txtConfirmPassword').style.color = 'red';
                            document.getElementById('txtConfirmPassword').style.border = '1px solid red';
                            document.getElementById('submit-button').disabled = true;
                            document.getElementById('submit-button').style.opacity = 0.5;
                        } else {
                            document.getElementById('errorString').style.display = 'none';
                            document.getElementById('txtConfirmPassword').style.color = 'white';
                            document.getElementById('txtConfirmPassword').style.border = '1px solid rgba(0, 0, 0, 0.3)';
                            document.getElementById('submit-button').disabled = false;
                            document.getElementById('submit-button').style.opacity = 1;
                        }
                       ">
                <h5 id="errorString" style="color:red; font-weight: bold; font-size: 11px; text-align: center; display:none">Confirm password is invalid</h5>
                <input type="text" name="txtFullname" value="" placeholder="Fullname" required="required" />
                <br/>
                <input type="text" maxlength="15" name="txtPhone" value="" placeholder="0-000-000-000" required="required" />
                <input type="text" maxlength="50" name="txtAddress" value="" placeholder="Home number, Street, District, City" required="required" />
                <input id="submit-button"type="submit" value="Submit"> 
            </form>
            <div style="text-align: center">
                <a href="login_page"><i class="fas fa-window-close"></i> Cancel</a><br/>
            </div>
            <div style="text-align: center">
                <a href="loadcar"><i class="fas fa-home"></i> Home</a>
            </div>
        </div>
        <style>
            a{
                margin-top: 20px;
                font-weight: bold;
                text-align: center;
            }
            a:hover{
                text-decoration: none;
                font-size: 20px;
                transition: all 120ms ease-in-out;
            }
        </style>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>

</html>