<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
    <h2>Connexion</h2><br>

    <div style="color: red;">${erreur}</div>
    <div style="color: green;">${succes}</div><br>

	<form action="LoginServlet" method="post">
        <label for="email">Email :</label>
        <input type="email" name="email" id="email"><br>
        <label for="pass">Password :</label>
        <input type="password" name="pass" id="pass"><br>
        <input type="submit" value="Se connecter">
    </form>
    <br>
    <a href="register.jsp">Pas encore de compte? Inscrivez-vous</a>
</body>
</html>