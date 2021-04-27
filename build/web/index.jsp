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
                        <div class="cart-button button">
                            <c:if test="${not empty param.txtSearch}">
                                <c:set var="url" value="filter?txtSearch=${param.txtSearch.trim()}~rental_date=${param.rental_date.trim()}~rental_time=${param.rental_time.trim()}~return_date=${param.return_date.trim()}~return_time=${param.return_time.trim()}~amount=${param.amount.trim()}~typeFilter=${param.typeFilter.trim()}"></c:set>
                            </c:if>
                            <c:if test="${not empty param.carCategory}">
                                <c:set var="url" value="filter?carCategory=${param.carCategory}~rental_date=${param.rental_date}~rental_time=${param.rental_time}~return_date=${param.return_date}~return_time=${param.return_time}~amount=${param.amount}~typeFilter=${param.typeFilter}"></c:set>
                            </c:if>
                            <c:if test="${empty param.carCategory and empty param.txtSearch}">
                                <c:set var="url" value="loadcar"></c:set>
                            </c:if>
                            <a href="your_cart?url=${url}" class="form-control btn-success btn">Cart</a>
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
        <div class="tool-container" style="min-height: 100px">
            <div class="row">
                <div class="col">
                    <nav class="navbar navbar-light">
                        <div class="panel-group row" id="accordion">
                            <div class="panel panel-default col-sm-6" style="margin: 0px auto;">
                                <div class="panel-heading">
                                    <h4 class="panel-title" style="text-align:center; font-weight: bold; font-size: 16px; text-decoration: none; text-transform: uppercase">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse1" class="form-control title">
                                            <i class="fa fa-car"></i><br/> Rent By Name</a>
                                    </h4>
                                </div>
                                <div id="collapse1" class="panel-collapse collapse in">
                                    <div class="panel-body">
                                        <form action="filter">
                                            <span>Car Name:</span><input class="form-control form-control-sm" name="txtSearch" type="text" value="${param.txtSearch}" placeholder="Input keyword to search" required>
                                            <span>Rental Date:</span>
                                            <div class="row" style="margin: 1px">
                                                <input class="form-control form-control-sm col-6" name="rental_date" type="date" value="" placeholder=".form-control-sm" required>
                                                <input class="form-control form-control-sm col-6" name="rental_time" type="time" value="" placeholder=".form-control-sm" required>
                                            </div>
                                            <span>Return Date:</span>
                                            <div class="row" style="margin: 1px">
                                                <input class="form-control form-control-sm col-6" name="return_date" type="date" value="" placeholder=".form-control-sm" required>
                                                <input class="form-control form-control-sm col-6" name="return_time" type="time" value="" placeholder=".form-control-sm" required>
                                            </div>
                                            <span>Amount:</span><input class="form-control form-control-sm" name="amount" type="number" value="" placeholder="Amount of car" required>
                                            <button type="submit" class="btn-success btn btn-sm" name="typeFilter" value="byName" style="margin-top:10px">Search</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </nav>
                </div>
                <div class="col">
                    <nav class="navbar navbar-light">
                        <div class="panel-group row" id="accordion">
                            <div class="panel panel-default col-sm-6" style="margin: 0px auto;">
                                <div class="panel-heading">
                                    <h4 class="panel-title" style="text-align:center; font-weight: bold; font-size: 16px; text-decoration: none; text-transform: uppercase">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse2" class="form-control title">
                                            <i class="fa fa-car"></i><br/> Rent By Category</a>
                                    </h4>
                                </div>
                                <div id="collapse2" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <form action="filter">
                                            <div class="form-group row">
                                                <label for="Category" class="col-sm-4 col-form-label">Category:</label>
                                                <div class="col-sm-8">
                                                    <select name ="carCategory" class="combo form-control">
                                                        <c:forEach items="${applicationScope.CATEGORY}" var="category">
                                                            <option value="${category.name.trim()}">${category.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>  
                                            <span>Rental Date:</span>
                                            <div class="row" style="margin: 1px">
                                                <input class="form-control form-control-sm col-6" name="rental_date" type="date" value="" placeholder=".form-control-sm" required>
                                                <input class="form-control form-control-sm col-6" name="rental_time" type="time" value="" placeholder=".form-control-sm" required>
                                            </div>
                                            <span>Return Date:</span>
                                            <div class="row" style="margin: 1px">
                                                <input class="form-control form-control-sm col-6" name="return_date" type="date" value="" placeholder=".form-control-sm" required>
                                                <input class="form-control form-control-sm col-6" name="return_time" type="time" value="" placeholder=".form-control-sm" required>
                                            </div>
                                            <span>Amount:</span><input class="form-control form-control-sm" name="amount" type="number" value="" placeholder="Amount of car" required>
                                            <button type="submit" class="btn-success btn btn-sm" name="typeFilter" value="byCategory" style="margin-top:10px">Search</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
        <div class="body-container" style="background: white; min-height: 300px;z-index: 0; position: relative">
            <c:if test="${not empty requestScope.LIST_CAR}">
                <table class="table">
                    <thead class="thead-dark">
                        <tr style="text-align: center; font-family: cursive">
                            <th scope="col">License Plate</th>
                            <th scope="col">Car Name</th>
                            <th scope="col">Image</th>
                            <th scope="col">Color</th>
                            <th scope="col">Manufacturer</th>
                            <th scope="col">Year</th>
                            <th scope="col">Price ($/day)</th>
                            <th scope="col">Add to cart</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.LIST_CAR}" var="car">
                            
                                <tr style="text-align: center; font-family: cursive; background: white" >
                            <form>
                                <td>${car.licensePlate}</td>
                                <td>${car.name}</td>
                                <td style="width:400px"><img src="${car.image}" style="border-radius:10% ;box-shadow: 5px 5px 5px 5px" width="50%"></td>
                                <td>
                                    <div class="shape" style="border: 2px solid green; background: ${car.color}">

                                    </div>
                                </td>
                                <td>${car.category}</td>
                                <td>${car.year}</td>
                                <td>${car.price} $</td>
                                <c:if test="${empty sessionScope.ACCOUNT}">
                                    <td><a href="login_page" class="form-control btn-success btn"><i class="fas fa-cart-plus"></i></a></td>
                                        </c:if>
                                        <c:if test="${not empty sessionScope.ACCOUNT}">
                                            <c:if test="${not empty param.txtSearch}"><c:set var="valueSearch" value="${param.txtSearch}"></c:set></c:if>
                                            <c:if test="${not empty param.carCategory}"><c:set var="valueSearch" value="${param.carCategory}"></c:set></c:if>
                                        <td><c:if test="${not empty sessionScope.CART.items.get(car.licensePlate.trim())}">This car is existed in your cart <br/> Please delete before rent new</c:if> 
                                        <a  href="addToCart?searchValue=${valueSearch}&typeFilter=${param.typeFilter}&rental_date=${param.rental_date}&rental_time=${param.rental_time}&return_date=${param.return_date}&return_time=${param.return_time}&carLicensePlate=${car.licensePlate.trim()}&carName=${car.name}&carColor=${car.color}&carCategory=${car.category}&carImage=${car.image}&carYear=${car.year}&carPrice=${car.price}&amount=${param.amount}" 
                                            class="form-control btn-success btn <c:if test="${not empty sessionScope.CART.items.get(car.licensePlate.trim())}"> disabled </c:if>"><i class="fas fa-cart-plus"></i></a></td>
                                        </c:if>
                            </form>
                            </tr>
                        
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty requestScope.LIST_CAR}">
                <div class="row" style="grid-gap: 50px;margin-top: 50px;margin-bottom: 100px;margin-left: 10px;margin-right: 10px; font-family: cursive">
                    <c:forEach items="${requestScope.RESULT_SEARCH}" var="car">
                        <div class="card col" style="width: 18rem; max-width: 300px;margin: 0px auto">
                            <div id="${car.name.trim()}" class="carousel-fade slide col" data-ride="carousel" style="padding: 10px; min-width: 100px;">
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <img class="d-block w-100" src="${requestScope.IMAGES_CAR.get(car.name.trim()).get(0)}" alt="">
                                    </div>
                                    <c:forEach items="${requestScope.IMAGES_CAR.get(car.name.trim())}" var="image">
                                        <div class="carousel-item">
                                            <img class="d-block w-100" src="${image}" alt="">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="card-body">
                                <h5 class="card-title" style="text-align: center; font-weight: bold; font-size: 16px">${car.name}</h5>
                            </div>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item" style="display: flex">
                                    <c:forEach items="${requestScope.COLORS_CAR.get(car.name.trim())}" var="color">
                                        <div class="shape" style="border: 2px solid black;padding: inherit; background: ${color}; ">
                                        </div>
                                    </c:forEach>
                                </li>
                                <li class="list-group-item"><span style="font-weight: bold">Year:</span> ${car.year}</li>
                                <li class="list-group-item"><span style="font-weight: bold">Category:</span> ${car.category}</li>
                                <li class="list-group-item"><span style="font-weight: bold">Quantity:</span> ${car.quantity}</li>

                            </ul>
                            <div class="card-body">
                                <p>
                                    <button class="btn btn-primary" style="margin-left: 40%;" type="button" data-toggle="collapse" data-target="#${car.name.trim().replace(" ","_")}" aria-expanded="false" aria-controls="collapseExample">
                                        <i class="fas fa-search"></i>
                                    </button>
                                </p>
                                <div class="collapse" id="${car.name.trim().replace(" ","_")}" style="position: absolute;z-index: 4; width: 400px;">
                                    <div class="card card-body">
                                        <form action="filter">
                                            <input type="hidden" name="txtSearch" value="${car.name.trim()}" />
                                            <span>Rental Date:</span>
                                            <div class="row" style="margin: 1px; font-size: 10px">
                                                <input class="form-control form-control-sm col-8" name="rental_date" type="date" value="" placeholder=".form-control-sm" required>
                                                <input class="form-control form-control-sm col-4" name="rental_time" type="time" value="" placeholder=".form-control-sm" required>
                                            </div>
                                            <span>Return Date:</span>
                                            <div class="row" style="margin: 1px; font-size: 10px">
                                                <input class="form-control form-control-sm col-8" name="return_date" type="date" value="" placeholder=".form-control-sm" required>
                                                <input class="form-control form-control-sm col-4" name="return_time" type="time" value="" placeholder=".form-control-sm" required>
                                            </div>
                                            <span>Amount:</span><input class="form-control form-control-sm" name="amount" max="${car.quantity}" min="1" type="number" value="" placeholder="Amount of car" required>
                                            <button type="submit" class="btn-success btn btn-sm" name="typeFilter" value="byName" style="margin-top:10px">Rent</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </c:forEach>
                </div>
                <div>
                    <c:if test="${requestScope.PAGE_COUNT ne 0}">
                        <nav aria-label="Page navigation example" >
                            <ul class="pagination" style="justify-content: center;">
                                <c:forEach begin="1" end="${requestScope.PAGE_COUNT}" step="1" var="counter">
                                    <li class="page-item <c:if test="${param.pageIndex eq counter}"> active </c:if>"><a class="page-link" href="loadcar?pageIndex=${counter}">${counter}</a></li>
                                    </c:forEach>
                            </ul>
                        </nav>
                    </c:if>
                </div>
            </c:if>
        </div>
        <div class="footer-container" style="background:#333333 ; min-height: 300px">

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