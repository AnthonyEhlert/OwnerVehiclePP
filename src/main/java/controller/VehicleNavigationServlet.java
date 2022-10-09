package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vehicle;

/**
 * Servlet implementation class VehicleNavigationServlet
 */
@WebServlet("/vehicleNavigationServlet")
public class VehicleNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleNavigationServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		VehicleHelper vh = new VehicleHelper();
		String act = request.getParameter("doThisToVehicle");
		
		String path = "/viewAllVehiclesServlet";
		
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Vehicle vehicleToDelete = vh.searchForVehicleById(tempId);
				vh.deleteVehicle(vehicleToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a vehicle");
			}
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Vehicle vehicleToEdit = vh.searchForVehicleById(tempId);
				request.setAttribute("vehicleToEdit", vehicleToEdit);
				path = "/edit-vehicle.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a vehicle");
			}
		} else if (act.equals("add")) {
			path = "/addVehicleServlet";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}

}
