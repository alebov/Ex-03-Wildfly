<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Calculator</title>
</head>
<body>
<h1>Calcolatrice</h1>
<p>
    <jsp:include page="/EJBCalculator"/>
<p/>
<form action="index.jsp" method="get">
    <label>Operation</label>
    <select id = "operation" name="operation">
        <option value = "+">+</option>
        <option value = "-">-</option>
        <option value = "*">*</option>
        <option value = "/">/</option>
    </select>
    <br/>
    <label>Operand</label>
    <input type="text" name="operand"/><br/>
    <br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>