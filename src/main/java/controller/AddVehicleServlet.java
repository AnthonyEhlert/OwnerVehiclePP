package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Owner;
import model.Vehicle;

/**
 * Servlet implementation class AddVehicleServlet
 */
@WebServlet("/addVehicleServlet")
public class AddVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVehicleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OwnerHelper oh = new OwnerHelper();
		request.setAttribute("allOwners", oh.showAllOwners());
		String path = "/add-vehicle.jsp";
		
		if(oh.showAllOwners().isEmpty()) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		OwnerHelper oh = new OwnerHelper();
		VehicleHelper vh = new VehicleHelper();
		
		Integer tempOwnerId = Integer.parseInt(request.getParameter("ownerId"));
		
		Owner ownerSelected = oh.searchForOwnerById(tempOwnerId);
		
		LocalDate dateOfPurchase = LocalDate.parse(request.getParameter("dateOfPurchase"));
		String type = request.getParameter("type");
		String color = request.getParameter("color");
		
		Vehicle vehicleToAdd = new Vehicle(ownerSelected, dateOfPurchase, type, color);
		
		vh.insertNewVehicle(vehicleToAdd);
	}

}
