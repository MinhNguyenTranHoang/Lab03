<%-- 
    Document   : arithmeticcalculator
    Created on : May 30, 2022, 10:30:24 PM
    Author     : MINH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="post" action="arithmetic">
            <label>First: </label>
            <input type="" name="v1" value="${val1}">
            <br>
            <label>Second: </label>
            <input type="text" name="v2" value="${val2}">
            <br>
            <input type="submit" name="v3" value="+">
            <input type="submit" name="v3" value="-">
            <input type="submit" name="v3" value="*">
            <input type="submit" name="v3" value="%">
        </form>
        <p>Result: ${message}</p>
        <a href="age">Age Calculator</a>
    </body>
</html>
