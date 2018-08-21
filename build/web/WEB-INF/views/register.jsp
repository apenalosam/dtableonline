<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="${contextPath}/resources/js/jquery-3.2.1.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="${contextPath}/resources/css/bootstrap-3.3.7/js/bootstrap.min.js"></script>
        <script src="${contextPath}/resources/js/plugins/toast/jquery.toast.js"></script>
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Register</title>
        <link href="${contextPath}/resources/js/plugins/toast/jquery.toast.css" rel="stylesheet">
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
        <div class="h1.title" style="font-family: 'MedievalSharp', cursive; font-size: 40pt; text-align: center;">
            Register New Account
        </div>
        <div class="container" style="padding-top: 10px;">
            <div class="row">
                <div class="main-login main-center">
                    <div class="">
                        <h3 class="panel-title">Register</h3>
                    </div>
                    <form id="register" method="POST" action="${contextPath}/register_user" class="form-signin">
                        <div class="center-block text-center">
                            <i class="fa-stack fa-5x">
                                <i class="fa fa-circle fa-stack-2x" style="color:#fff;"></i>
                                <i class="fa fa-dice fa-stack-1x fa-inverse" style="color:#333333;"></i>
                            </i>
                        </div>
                        <div class="form-group">
                            <label for="username" class="cols-sm-2 control-label">Name(s):* </label>
                            <div class="cols-sm-10">
                                <div class="input-group"><span class="input-group-addon" style="border: #1a1a1a; background: #333333"><i class="fa fa-user fa" aria-hidden="true" style="color:#eee"></i></span>
                                    <input style="border: #1a1a1a" name="names" id="names" type="text" class="form-control" placeholder="Enter your first and middle names..." autofocus="true" value="${names}"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="username" class="cols-sm-2 control-label">Last Name(s): </label>
                            <div class="cols-sm-10">
                                <div class="input-group"><span class="input-group-addon" style="border: #1a1a1a; background: #333333"><i class="fa fa-user fa" aria-hidden="true" style="color:#eee"></i></span>
                                    <input style="border: #1a1a1a" name="lastNames" id="lastNames" type="text" class="form-control" placeholder="Enter your last name(s)" autofocus="true" value="${lastNames}"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="username" class="cols-sm-2 control-label">Username:* </label>
                            <div class="cols-sm-10">
                                <div class="input-group"><span class="input-group-addon" style="border: #1a1a1a; background: #333333"><i class="fa fa-user fa" aria-hidden="true" style="color:#eee"></i></span>
                                    <input style="border: #1a1a1a" name="username" id="username" type="text" class="form-control" placeholder="Username" autofocus="true" value="${username}"/><span id="isE"></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="username" class="cols-sm-2 control-label">Password:* </label>
                            <div class="cols-sm-10">
                                <div class="input-group"><span class="input-group-addon" style="border: #1a1a1a; background: #333333"><i class="fa fa-lock fa-lg" aria-hidden="true" style="color:#eee"></i></span>
                                    <input style="border: #1a1a1a" name="password" id="password" type="password" class="form-control" placeholder="Password" value="${pswd}"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="username" class="cols-sm-2 control-label">Confirm Password:* </label>
                            <div class="cols-sm-10">
                                <div class="input-group"><span class="input-group-addon" style="border: #1a1a1a; background: #333333"><i class="fa fa-lock fa-lg" aria-hidden="true" style="color:#eee"></i></span>
                                    <input style="border: #1a1a1a" name="confirmPassword" id="confirmPassword" type="password" class="form-control" placeholder="Confirm your password" value="${pswdConfirm}"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <span>${message}</span>
                            <span>${error}</span>
                        </div>
                        <div class="form-group" style="padding-top: 20px">
                            <button id="regButton" style="background: #333333; border: #1a1a1a" class="btn btn-primary btn-block" type="submit" >Register</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </body>
</html>
<script>
    $(document).ready(function () {
        if ('${msg}' !== '') {
            alert('${msg}');
        }
        $('#regButton').click(function (event) {
            validaFormulario(event);
        });
        $('#username').change(function () {
            checkExist($(this).val());
        });
    });

    function checkExist(username) {
        if(username !== ''){
        $.ajax({
            url: '${contextPath}/exists/' + username,
            type: 'POST',
            cache: false,
            success: function (response) {
                if(response !== ''){
                    alert(response);
                }
            },
            error: function (jqXhr, textStatus, errorThrown) {
                alert('There was an error while checking the username');
            }
        });
        }
    }

    function validaFormulario(event) {
        if ($("#names").val() === '') {
            msgValida('Error', 'Please enter your name(s)', 'error');
            $("#names").focus();
            event.preventDefault();
            //return false;
        }
        if ($("#username").val() === '') {
            msgValida('Error', 'You must enter a username', 'error');
            $("#username").focus();
            event.preventDefault();
        }
        if ($("#password").val() === '') {
            msgValida('Error', 'You must enter a password', 'error');
            $("#password").focus();
            event.preventDefault();
        }
        if ($("#password").val().length < 6) {
            msgValida('Error', 'Your password must be at least 6 characters long', 'error');
            $("#password").focus();
            event.preventDefault();
        }
        if ($('#password').val() !== $('#confirmPassword').val()) {
            msgValida('Error', 'Password confirmation is different from password!', 'error');
            $("#confirm").focus();
            event.preventDefault();
        }
        return true;
    }


    function msgValida(title, msg, icon) {
        $.toast({
            heading: title,
            text: msg,
            showHideTransition: 'fade',
            position: 'bottom-right',
            hideAfter: 2000,
            icon: icon
        });
    }
</script>