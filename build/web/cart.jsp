<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>

    <head>
        <title>Home</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>
        <div class="header-container">
            <nav class="navbar navbar-dark bg-dark">
                <div class="logo" style="color:green; font-weight: bold; font-family: fantasy">
                    <h1><i class="fas fa-car-side"></i> CAR RENTAL</h1>
                </div>
                <div class="information">
                    <p><i class="fas fa-envelope"></i> carrentalvietnam@gmail.com</p>
                    <p><i class="fas fa-phone"></i> 0774839222</p>
                    <p><i class="fas fa-map-marker-alt"></i> Sky9 Apartment, District 9, HCM City</p>
                </div>
                <div class="tool-button">
                    <c:if test="${empty sessionScope.ACCOUNT}">
                        <div class="login-button button" >
                            <a href="login_page" class="form-control btn-success btn">Login</a>
                        </div>
                        <div class="signup-button button">
                            <a href="signup_page" class="form-control btn-success btn">Sign up</a>
                        </div>
                        <div class="home-button button">
                            <a href="loadcar" class="form-control btn-success btn"><i class="fas fa-home"></i></a>
                        </div>
                    </c:if>
                    <c:if test="${not empty sessionScope.ACCOUNT}">
                        <div class="login-button button" >
                            <button class="form-control btn-success btn" style="opacity: 1" disabled>Welcome, ${sessionScope.ACCOUNT.fullname}</button>
                        </div>
                        <div class="logout-button button">
                            <a href="logout" class="form-control btn-success btn">Logout</a>
                        </div>
                        <div class="home-button button">
                            <a href="loadcar" class="form-control btn-success btn"><i class="fas fa-home"></i></a>
                        </div>
                    </c:if>
                </div>
            </nav>
        </div>
        <div class="slide-container">
            <div class="row"> 
                <div id="carouselExampleControls1" class="carousel slide col" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block w-100" src="https://i.xeoto.com.vn/auto/mini/cooper/2020/ngoai-that-mini-cooper-99842.png" alt="">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="https://i.xeoto.com.vn/auto/toyota/camry/2021/ngoai-that-toyota-camry-71349.jpg" alt="">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="https://i.xeoto.com.vn/auto/toyota/camry/2021/noi-that-toyota-camry-12985.jpg" alt="">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleControls1" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleControls1" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
                <div id="carouselExampleControls2" class="carousel slide col" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block w-100" src="https://i.xeoto.com.vn/auto/ford/fiesta/2020/ngoai-that-ford-fiesta-34-front-glamour-38828.png" alt="">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="https://i.xeoto.com.vn/auto/ford/fiesta/2020/ngoai-that-ford-fiesta-34-rear-glamour-56995.png" alt="">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="https://i.xeoto.com.vn/auto/ford/fiesta/2020/ngoai-that-ford-fiesta-rear-profile-13576.png" alt="">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleControls2" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleControls2" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
                <div id="carouselExampleControls3" class="carousel slide col" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block w-100" src="https://i.xeoto.com.vn/auto/suzuki/xl7/2021/mau-xe-suzuki-xl7-rising-orange-black.png" alt="">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="https://i.xeoto.com.vn/auto/suzuki/xl7/2021/ngoai-that-suzuki-xl7-63172.jpg" alt="">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="https://i.xeoto.com.vn/auto/suzuki/xl7/2021/noi-that-suzuki-xl7-46779.jpg" alt="">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleControls3" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleControls3" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
                <div id="carouselExampleControls4" class="carousel slide col" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block w-100" src="https://i.xeoto.com.vn/auto/honda/city/2021/ngoai-that-honda-city.jpg" alt="">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="https://i.xeoto.com.vn/auto/honda/city/2021/noi-that-honda-city-26688.jpg" alt="">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="https://i.xeoto.com.vn/auto/honda/city/2021/ngoai-that-honda-city-53195.jpg" alt="">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleControls4" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleControls4" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </div>

        <div class="body-container" style="background: white; min-height: 400px;z-index: 0; position: relative">
            <c:if test="${not empty sessionScope.CART}">
                <table class="table">
                    <thead class="thead-dark">
                        <tr style="text-align: center; font-family: cursive">
                            <th scope="col">License Plate</th>
                            <th scope="col">Rental Date</th>
                            <th scope="col">Return Date</th>
                            <th scope="col">Car Name</th>
                            <th scope="col">Image</th>
                            <th scope="col">Color</th>
                            <th scope="col">Manufacturer</th>
                            <th scope="col">Year</th>
                            <th scope="col">Price ($/day)</th>
                            <th scope="col">Day(s)</th>
                            <th scope="col">Total</th>
                            <th scope="col">Remove</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach items="${sessionScope.CART.items.values()}" var="car">
                            <tr style="text-align: center; font-family: cursive; background: white">
                        <form action="delete_car_in_cart">
                            <td>${car.licensePlate}</td>
                            <td>${car.rental_date}</td>
                            <td>${car.return_date}</td>
                            <td>${car.name}</td>
                            <td style="width:400px"><img src="${car.image}" style="border-radius:10% ;box-shadow: 5px 5px 5px 5px" width="50%"></td>
                            <td>
                                <div class="shape" style="border: 2px solid green; background: ${car.color}">

                                </div>
                            </td>
                            <td>${car.category}</td>
                            <td>${car.year}</td>
                            <td>${car.price} $</td>
                            <td>${car.daysRented}</td>
                            <td>${car.totalPrice} $</td>
                            <td><p>
                                    <a class="btn btn-primary btn-success" data-toggle="collapse" href="#collapseExample${car.licensePlate}" role="button" aria-expanded="false" aria-controls="collapseExample">
                                        Delete
                                    </a>
                                </p>
                                <div class="collapse" id="collapseExample${car.licensePlate}">
                                    <div class="card card-body" style="font-size: 14px">
                                        Really ? <input class="form-control btn-danger btn" type="submit" value="OK" />
                                    </div>
                                </div>
                            </td>
                            <input type="hidden" name="pk_remove" value="${car.licensePlate}" />
                            <input type="hidden" name="url" value="${param.url.trim()}" />
                        </form>
                        </tr>
                    </c:forEach>
                    <tr style="text-align: center; font-weight: bold">
                        <td colspan="10">Total</td>
                        <td colspan="1">${sessionScope.CART.totalPrice} $</td>
                    </tr>
                    </tbody>
                </table>
                <div style="display: flex; float: right;">
                    <div style="margin-right: 30px;">
                        <a href="${param.url.trim().replace("~","&")}" class="form-control btn-success btn">Continue to rent</a>
                    </div>
                    <div style="margin-right: 30px;">
                        <p>
                            <a class="form-control btn-success btn" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                Fill information to check out
                            </a>
                        </p>
                        <div class="collapse" id="collapseExample">
                            <div class="card card-body">
                                <form action="check_out">
                                    <input type="hidden" name="totalPrice" value="${sessionScope.CART.totalPrice}" />
                                    <span>Customer Name</span><input class="form-control form-control-sm" name="customer_name" type="text" value="" placeholder="Input renter name" required>
                                    <span>Customer Phone</span><input class="form-control form-control-sm" name="customer_phone" type="text" value="" placeholder="Input renter phone" required>
                                    <span>Customer Address</span><input class="form-control form-control-sm" name="customer_address" type="text" value="" placeholder="Input renter address" required>
                                    <button type="submit" class="btn-success btn btn-sm" style="margin-top:10px">Confirm</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
        <div class="footer-container" style="background:#333333 ; min-height: 200px">

        </div>
        <style>
            .tool-container .navbar-light{
                display: flow-root;
                position: absolute;
                z-index: 1;
                width: 1000px;
            }
            .header-container .tool-button .btn:not(:first-child):hover{
                text-decoration: none;
                font-weight: bold;
                color:green;
            }
            .header-container .tool-button{
                display: flex;
            }
            .header-container .information{
                display: contents;
                color: aliceblue;
                font-weight: bold;
                margin: 0px auto;
                font-family: cursive;
            }
            .header-container .tool-button .button{
                margin-left: 10px;
            }
            .panel a:hover{
                text-decoration: none;
                font-weight: bold;
                color:green;
            }
            .panel a{
                font-family: cursive;
            }
            .panel .fa{
                font-size: 24px;
            }
            .panel .panel-body{
                border: 3px solid green;
                padding: 10px;
                border-radius: 20px;
                font-weight: bold;
                font-family: cursive;
                color: green;
                background: white;
            }
            .tool-container .title{
                height: max-content;
            }
            .tool-container .title:hover{
                border: 3px solid green;
            }
            .tool-container .fa{
                border: 2px solid green;
                border-radius: 50%;
                padding: 3px;
                color: green;
            }
            .table td{
                vertical-align: middle;
                font-size: 18px;
            }
            .shape{
                margin: 0px auto;
                border-radius: 100%;
                padding: 30px;
                width: 10px;
            }
            .table img:hover{
                border-radius: 0%;
                width: 60%;
                transition: all 120ms ease-in-out;
            }
            .slide-container{
                width: 90%;
                margin: 10px auto;
            }
            .slide-container img{
                border-radius: 10px;
            }
        </style>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>

</html>