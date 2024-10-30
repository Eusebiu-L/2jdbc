<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Introduce-ti</h2>
<form action="Calculator_Out.jsp" method="get">
    <label for="num1">Numărul 1:</label>
    <input type="number" id="num1" name="num1" required><br><br>

    <label for="num2">Numărul 2:</label>
    <input type="number" id="num2" name="num2" required><br><br>

    <label for="text">Text:</label>
    <input type="text" id="text" name="text" required><br><br>

    <input type="submit" value="Trimite">
</form>
	
</body>
</html>