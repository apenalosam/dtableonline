</head>
<body class="bckImg" style="background-image: url('${contextPath}/resources/img/golden_die.png');" id="body">    
    <nav class="navbar navbar-default " style="background-color: #800000; border-color: #800000; width:100%; position: fixed; z-index: 100">
        <div class="" style="background-color:#ffffff">
        </div>
        <div class="container-fluid">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="${contextPath}/index" style="font-family: 'MedievalSharp', cursive; background-color: #800000; border-color: #800000"><i class="fa-stack fa-retro">
                                    <i class="fa fa-circle fa-stack-2x" style="color:grey;"></i>
                                    <i class="fa fa-home fa-stack-1x fa-inverse" style="color:#800000;"></i>
                                </i>&nbsp;Homepage</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" style="font-family: 'MedievalSharp', cursive;" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa-stack fa-retro">
                                    <i class="fa fa-circle fa-stack-2x" style="color:grey;"></i>
                                    <i class="fa fa-list fa-stack-1x fa-inverse" style="color:#800000"></i>
                                </i>&nbsp;Profiles
                                <span class="caret"></span>
                            </a>

                            <ul class="dropdown-menu" style="font-family: 'MedievalSharp', cursive; background-color: #800000; border-color: #800000">
                                <c:forEach items="${menu}" var="m">
                                    <li><a href="${contextPath}${m.link}" style="font-family: 'MedievalSharp', cursive;"><i class="fa-stack fa-retro">
                                                <i class="fa fa-circle fa-stack-2x" style="color:grey;"></i>
                                                <i class="fa ${m.icon} fa-stack-1x fa-inverse" style="color:#800000;"></i>
                                            </i>&nbsp;${m.menuName}</a></li>
                                    <li role="separator" class="divider"></li>
                                </c:forEach>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right" style="font-family: 'MedievalSharp', cursive; background-color: #800000; border-color: #800000">        
                        <li class="dropdown" >
                            <a href="#" style="font-family: 'MedievalSharp', cursive;" class="dropdown-toggle menuUsuario" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                <i class="fa-stack fa-retro">
                                    <i class="fa fa-circle fa-stack-2x" style="color:grey;"></i>
                                    <i class="fa fa-user fa-stack-1x fa-inverse" style="color:#800000;"></i>
                                </i>&nbsp;${user.username}
                                <span class="glyphicon glyphicon-chevron-down"></span>
                            </a>

                            <ul class="dropdown-menu" style="font-family: 'MedievalSharp', cursive; background-color: #800000; border-color: #800000;">
                                <li style="font-family: 'MedievalSharp', cursive; background-color: #800000; border-color: #800000">
                                    <div class="navbar-login" >                                        
                                        <div class="row">
                                            <div class="col-lg-12 center-block" >
                                                <p class="text-center">
                                                    <a href="#" onclick="" class="btn" style="color: #fff; width: 100%; height: 100%">
                                                        <i class="fa-stack fa-retro">
                                                            <i class="fa fa-circle fa-stack-2x" style="color:gray;"></i>
                                                            <i class="fa fa-cogs fa-stack-1x fa-inverse" style="color:#800000;"></i>
                                                        </i>&nbsp;Account settings</a>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="divider"></li>
                                <li style="font-family: 'MedievalSharp', cursive; background-color: #800000; border-color: #800000">
                                    <div class="navbar-login navbar-login-session">
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <p class="text-center">
                                                    <a href="#" onclick="document.forms['logoutForm'].submit()" class="btn btn-danger" style="background-color: #800000; border-color: #800000; width: 100%; height: 100%">
                                                        <i class="fa-stack fa-retro">
                                                            <i class="fa fa-circle fa-stack-2x" style="color:grey;"></i>
                                                            <i class="fa fa-sign-out-alt fa-stack-1x fa-inverse" style="color:#800000;"></i>
                                                        </i>&nbsp;Logout</a>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                                
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </c:if>
        </div><!-- /.container-fluid -->
    </nav>                              
                                