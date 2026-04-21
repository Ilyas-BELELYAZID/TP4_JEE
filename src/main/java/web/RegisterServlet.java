package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User;
import services.RegisterMetier;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final RegisterMetier register = RegisterMetier.getInstance();

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		if (firstname == null || lastname == null || email == null || pass == null || firstname.isEmpty()
				|| lastname.isEmpty() || email.isEmpty() || pass.isEmpty()) {
			request.setAttribute("erreur", "Tous les champs sont obligatoires.");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

		User nouvelUtilisateur = new User(firstname, lastname, email, pass, "client");

		if (register.RegisterUser(nouvelUtilisateur) == false) {
			request.setAttribute("erreur", "Cet email est déjà utilisé.");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

		request.setAttribute("succes", "Inscription réussie ! Vous pouvez vous connecter.");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
