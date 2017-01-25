<%--
  Created by IntelliJ IDEA.
  User: giogge
  Date: 23/01/17
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="LoginBean" scope="request" class="javabean.LoginBean"/>

<jsp:setProperty name="LoginBean" property="*"/>

<html>
<head>
    <title>DaDa - HOMEPAGE </title>
    <jsp:include page="jspPageTemplates/head.jsp" flush="true" />

</head>


<body>


<jsp:include page="jspPageTemplates/headerArea.jsp" flush="true" />

<%
    if (LoginBean.getUsername().equals(""))
    {
%>

    <jsp:include page="jspPageTemplates/brandingArea.jsp" flush="true" />
<%
    }
    else
    {
%>
    <jsp:include page="jspPageTemplates/AccountArea.jsp" flush="true" />
<%
    }
%>

<jsp:include page="jspPageTemplates/mainMenu.jsp" flush="true" />

    <div class="user-menu">
        <ul>
            <li><a href="registrationForm.jsp"><i class="fa fa-user"></i>Registrati come privato</a></li>
            <li><a href="registrationForm.jsp"><i class="fa fa-user"></i>Registrati come azienda</a></li>
        </ul>
    </div>

    <div id="slideshow">
        <div>
            <img src="img/product-1.jpg">
        </div>
        <div>
            <img src="img/product-2.jpg">
        </div>
        <div>
            <img src="img/product-3.jpg">
        </div>
    </div>

<jsp:include page="jspPageTemplates/footerArea.jsp" flush="true" />

</body>
</html>