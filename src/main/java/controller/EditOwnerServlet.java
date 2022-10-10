package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Owner;

/**
 * Servlet implementation class EditOwnerServlet
 */
@WebServlet("/editOwnerServlet")
public class EditOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOwnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OwnerHelper oh = new OwnerHelper();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Owner ownerToUpdate = oh.searchForOwnerById(tempId);
		ownerToUpdate.setFirstName(firstName);
		ownerToUpdate.setLastName(lastName);
		
		oh.updateOwner(ownerToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllOwnersServlet").forward(request, response);
		
	}

}
