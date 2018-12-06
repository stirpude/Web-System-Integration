<%-- 
    Document   : newownerform
    Created on : Oct 22, 2018, 7:44:54 PM
    Author     : shruti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success Page</title>
    </head>
    <body>
        <h1>Owner successfully validated!!!!!!</h1>
        <ul>
            <li>${requestScope.ow.name}</li>
            <li>${requestScope.ow.email}</li>
            <li>${requestScope.ow.dateJoined}</li>
        </ul>
    </body>
</html>
