<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div>Main</div>
    <hr />
    <div>Spring Security Area</div>
    <sec:authentication property="principal" var="userDetailsBean" />
    <div>userDetailsBean : ${userDetailsBean} </div>
    <sec:authorize access="isAnonymous()"> <%-- 분기1 로그인 X --%>
        <div>
            <a href="/loginForm">Login</a>
        </div>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()"> <%-- 분기2 로그인 O --%>
        <div>
            username : ${userDetailsBean.username}, Name : ${userDetailsBean.memberName}<a href="/logoutForm">Logout</a>
        </div>
    </sec:authorize>
    
    <hr />
</body>
</html>