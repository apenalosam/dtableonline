<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <title>Login with your account</title>
        <link href="${contextPath}/resources/css/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <link href="${contextPath}/resources/css/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="${contextPath}/resources/css/bootstrap.login.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=MedievalSharp" rel="stylesheet">
        <link rel="icon" href="${contextPath}/resources/img/icon.png">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
        
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="bckImg" style="background-image: url('${contextPath}/resources/img/golden_die.png');">
        <div class="h1.title" style="font-family: 'MedievalSharp', cursive; font-size: 40pt; text-align: center">
            Character Sheet Manager
        </div>
        <div class="container" style="padding-top: 10px;">
            <div class="row">
                <div class="main-login main-center">
                    <div class="">
                        <h3 class="panel-title">Login</h3>
                    </div>
                    <form method="POST" action="${contextPath}/login" class="form-signin">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <div class="center-block text-center">
                            <i class="fa-stack fa-5x">
                                <i class="fa fa-circle fa-stack-2x" style="color:#fff;"></i>
                                <i class="fa fa-dice fa-stack-1x fa-inverse" style="color:#333333;"></i>
                            </i>
                        </div>
                        <div class="form-group ${error != null ? 'has-error' : ''}">
                            <label for="username" class="cols-sm-2 control-label">Username: </label>
                            <div class="cols-sm-10">
                                <div class="input-group"><span class="input-group-addon" style="border: #1a1a1a; background: #333333"><i class="fa fa-user fa" aria-hidden="true" style="color:#eee"></i></span>
                                    <input style="border: #1a1a1a" name="username" type="text" class="form-control" placeholder="Username" autofocus="true"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group ${error != null ? 'has-error' : ''}">
                            <label for="username" class="cols-sm-2 control-label">Password: </label>
                            <div class="cols-sm-10">
                                <div class="input-group"><span class="input-group-addon" style="border: #1a1a1a; background: #333333"><i class="fa fa-lock fa-lg" aria-hidden="true" style="color:#eee"></i></span>
                                    <input style="border: #1a1a1a" name="password" type="password" class="form-control" placeholder="Password"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <span>${message}</span>
                            <span>${error}</span>
                        </div>
                        <div class="form-group" style="padding-top: 20px">
                            <button style="background: #333333; border: #1a1a1a" class="btn btn-primary btn-block" type="submit" >Login</button>
                        </div>
                        <div style="text-align: center; padding-top: 15px; padding-bottom: 20px">
                            Login using your account<br/>
                            Or <a href = "${contextPath}/register">register</a> if you don't have one
                        </div>
                    </form>
                </div>
   
            </div>
        </div>
        <!-- /container -->
    </body>
</html>
<script>
    $(document).ready(function () {
        if('${msg}' !== ''){
            alert('${msg}');
        }
    });
    $('#register').click(function(){
        location.href="${contextPath}/register.jsp";
    });
</script>
