package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Owner;

/**
 * Servlet implementation class ownerNavigationServlet
 */
@WebServlet("/ownerNavigationServlet")
public class OwnerNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnerNavigationServlet() {
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
		doGet(request, response);
		
		OwnerHelper oh = new OwnerHelper();
		String action = request.getParameter("doThisToOwner");
		
		String path = "/viewAllOwnersServlet";
		
		if (action.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Owner ownerToDelete = oh.searchForOwnerById(tempId);
				oh.deleteOwner(ownerToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an owner");
			}
		} else if (action.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Owner ownerToEdit = oh.searchForOwnerById(tempId);
				request.setAttribute("ownerToEdit", ownerToEdit);
				path = "/edit-owner.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an owner");
			}
		} else if (action.equals("add")) {
			path = "/add-owner.jsp";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}
}
