<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>
    <h2>Créer un compte</h2>

    <div style="color: red;">${erreur}</div>

    <form action="RegisterServlet" method="post">
        <label for="lastname">Nom :</label>
        <input type="text" name="lastname" id="lastname"><br>
        <label for="firstname">Prénom :</label>
        <input type="text" name="firstname" id="firstname"><br>
        <label for="email">Email :</label>
        <input type="email" name="email" id="email"><br>
        <label for="pass">Password :</label>
        <input type="password" name="pass" id="pass"><br>
        <input type="submit" value="S'inscrire">
    </form>
    <br>
    <a href="login.jsp">Déjà inscrit? Connectez-vous</a>
</body>
</html>