<%-- 
    Document   : newownerform
    Created on : Oct 20, 2018, 7:44:54 PM
    Author     : shruti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../../../favicon.ico">


        <title>Add new Owner</title>

        <!-- Bootstrap core CSS -->

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


        <!-- Custom styles for this template -->
        <link href="css/custom_lab7.css" rel="stylesheet">

    </head>

    <body>
        <form action="/stirpude-fp/OwnerServlet" method="POST">
            <main role="main" class="container">    
                <div class="text-center mb-4">


                    <h1 class="h3 mb-3 font-weight-normal">Add New Owner</h1>
                    <c:if test="${not empty requestScope.errors}">
                        <c:forEach items="${requestScope.errors}" var="error"> 
                            <p>Please correct this error: ${error.propertyPath} ${error.message}</p>
                        </c:forEach>
                    </c:if>

                </div>

                <div class="form-group">
                    <input value ="${requestScope.ow.name}" type="text" id="name" class="form-control" name="name" required>
                    <label for="name">Name</label>
                </div>

                <div class="form-label-group">
                    <input value ="${requestScope.ow.email}" type="email" id="email" class="form-control" name="email" required autofocus>
                    <label for="email">Email address</label>
                </div>



                <div class="form-label-group">
                    <input value ="${requestScope.dateJoined}" type="date" id="joineddate" class="form-control" name="joineddate" required>
                    <label for="joineddate">Joining Date</label>
                </div>


                <button class="btn btn-lg btn-primary btn-block" type="submit">Add New Owner</button>

        </form>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </main>
</body>
</html>