package fr.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.beans.EnclosureBean;
import fr.beans.PlayerBean;
import fr.dao.DaoHomeBuildMenu;

@WebServlet("/createEnclosure")
public class BuildEnclosureMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoHomeBuildMenu dao;
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dao = new DaoHomeBuildMenu();
		HttpSession session = request.getSession(); 
		// hydratation du bean local PlayerBean en fonction d'un Id spécifique et recupération de l'attribut money
		int idPlayer = Integer.parseInt(request.getParameter("player"));
		PlayerBean player = dao.getPlayerById(idPlayer);
		
		// hydratation du bean local EnclosureBean en fonction d'un Id spécifique et recupération des attributs locate
		//int idEnclosure = Integer.parseInt(request.getParameter("id"));
		//EnclosureBean enclosure = dao.getEnclosureById(idEnclosure);
		
		request.setAttribute("player", player);

		//lien vers la vue buildEnclosure
		this.getServletContext().getRequestDispatcher("/WEB-INF/buildEnclosure.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}