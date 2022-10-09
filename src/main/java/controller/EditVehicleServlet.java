package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vehicle;

/**
 * Servlet implementation class EditVehicleServlet
 */
@WebServlet("/editVehicleServlet")
public class EditVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVehicleServlet() {
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
		
		LocalDate dateOfPurchase = LocalDate.parse(request.getParameter("dateOfPurchase"));
		String type = request.getParameter("type");
		String color = request.getParameter("color");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Vehicle vehicleToUpdate = vh.searchForVehicleById(tempId);
		vehicleToUpdate.setDateOfPurchase(dateOfPurchase);
		vehicleToUpdate.setType(type);
		vehicleToUpdate.setColor(color);
		
		vh.updateVehicle(vehicleToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllVehiclesServlet").forward(request, response);
		
		
	}

}
