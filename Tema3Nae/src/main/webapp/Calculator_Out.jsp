<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String num1Str = request.getParameter("num1");
	String num2Str = request.getParameter("num2");
	String inputString = request.getParameter("text");

	int num1 = num1Str != null ? Integer.parseInt(num1Str) : 0;
	int num2 = num2Str != null ? Integer.parseInt(num2Str) : 0;

	int suma = num1 + num2;

	String rezultatParitate = (num1 % 2 == 0) ? "par" : "impar";

	int nrVocale = 0;
	if (inputString != null) {
		for (char c : inputString.toLowerCase().toCharArray()) {
			if ("aeiou".indexOf(c) != -1) {
		nrVocale++;
			}
		}
	}
	%>

	<h2>Rezultate</h2>

	<p><strong>Suma celor două numere:</strong> <%=suma%></p>
	<p><strong>Verificare paritate:</strong> <%=rezultatParitate%></p>
	<p><strong>Număr de vocale:</strong> String-ul "<%=inputString%>" conține <%=nrVocale%> vocale.
	</p>
</body>
</html>