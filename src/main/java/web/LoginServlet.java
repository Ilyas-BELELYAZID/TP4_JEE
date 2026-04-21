package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import services.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		final LoginMetier login = LoginMetier.getInstance();
		boolean estUtilisateur = login.verifierIdentifiants(email, pass);

		if (estUtilisateur) {
			// Creation de la session
			HttpSession session = request.getSession();
			session.setAttribute("userSession", login.getRole(email, pass));

			// Redirection vers l'espace securise
			response.sendRedirect(request.getContextPath() + "/securise/home.jsp");
		} else {
			request.setAttribute("erreur", "Email ou mot de passe incorrect.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
