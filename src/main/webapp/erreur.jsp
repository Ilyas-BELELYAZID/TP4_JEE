<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Oups ! Une erreur est survenue</title>
</head>
<body>
	<div
		style="border: 2px solid red; padding: 20px; max-width: 600px; margin: 0 auto; text-align: center;">
		<h1 style="color: red;">Désolé, un problème est survenu.</h1>

		<!-- Récupération du code d'erreur HTTP (ex: 404, 500) -->
		<h2>
			Code d'erreur :
			<%=request.getAttribute("javax.servlet.error.status_code")%></h2>

		<p>
			<strong>Description :</strong>
			<!-- Récupération du message d'erreur HTTP -->
			<%=request.getAttribute("javax.servlet.error.message")%>
		</p>

		<!-- Affichage de l'exception Java s'il y en a une (ex: NullPointerException) -->
		<%
		if (exception != null) {
		%>
		<p>
			<strong>Détail technique :</strong>
			<%=exception.getMessage()%></p>
		<%
		}
		%>

		<br> <a href="${pageContext.request.contextPath}/login.jsp">Retourner
			à la page de se connecter</a>
	</div>
</body>
</html>