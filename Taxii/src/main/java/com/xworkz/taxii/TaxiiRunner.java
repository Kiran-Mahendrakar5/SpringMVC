package com.xworkz.taxii;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xworkz.taxii.config.TaxiiConfig;
import com.xworkz.taxii.dto.TaxiiDto;
import com.xworkz.taxii.service.TaxiiService;
import com.xworkz.taxii.service.TaxiiServiceImpl;

@WebServlet(urlPatterns = "/send")
public class TaxiiRunner extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Id = req.getParameter("Id");
		String taxino = req.getParameter("taxino");
		String earning = req.getParameter("earning");
		String trip = req.getParameter("trip");
		String isAvailable = req.getParameter("isAvailable");
		String location = req.getParameter("location");
		

		Integer Id1 = Integer.valueOf(Id);
		Integer taxino1 = Integer.valueOf(taxino);
		Integer earning3 = Integer.valueOf(earning);
		Integer trip4 = Integer.valueOf(trip);
		
		TaxiiDto dto1 = new TaxiiDto(Id1,taxino1,earning3,trip4,false,location);
		
		System.out.println(dto1);
		
		

		resp.setContentType("text/html");
		PrintWriter print = resp.getWriter();

		TaxiiService service = new TaxiiServiceImpl();

//		TaxiiDto dto = new TaxiiDto(1, 5566, 5000, 12, true, "goraguntepalya");
//		TaxiiDto dto1 = new TaxiiDto(2, 5577, 4900, 11, true, "yeshwanthpura");
//		TaxiiDto dto2 = new TaxiiDto(3, 7788, 4800, 10, true, "mahalakshmi");
//		TaxiiDto dto3 = new TaxiiDto(4, 8899, 4700, 9, true, "rajajinagar");
//		TaxiiDto dto4 = new TaxiiDto(5, 1010, 4600, 8, true, "mantrisquar");
//		TaxiiDto dto5 = new TaxiiDto(6, 1111, 4500, 7, true, "nagasandra");
//
//		service.saveTaxi(dto);
//		service.saveTaxi(dto1);
//		service.saveTaxi(dto2);
//		service.saveTaxi(dto3);
//		service.saveTaxi(dto4);
//		service.saveTaxi(dto5);

		System.out.println("helllooo");
		boolean save = service.saveTaxi(dto1);
		System.out.println(save);
		req.getRequestDispatcher("/CustomerInfo.jsp").forward(req, resp);
		
//		
//		if (!taxino.isEmpty() && !earning.isEmpty() && !trip.isEmpty() && isAvailable.isEmpty() && location.isEmpty()) {
//			System.out.println("is empty");
//			req.getRequestDispatcher("/CustomerInfo.jsp").forward(req, resp);
//		} else {
//			resp.setContentType("text/html");
//			PrintWriter writer = resp.getWriter();
//			writer.println("Empty data");
//			req.getRequestDispatcher("/CreateAccount.jsp").include(req, resp);
//		}

		// update updatebyearning
//		boolean updatebyearning = service.updatebyearning(4500);
//		System.out.println(updatebyearning);

		// updateisAvailableById
//		boolean updateisAvailableById = service.updateisAvailableById(3, false);
//		System.out.println(updateisAvailableById);

////		findtaxinoBylocation
//		TaxiDto findtaxinoBylocation = service.findtaxinoBylocation("rajajinagar", 8899);
//		System.out.println(findtaxinoBylocation);

//		readAll
//		List<TaxiiDto> list = service.readAll();
//		list.forEach((ref) -> {
//			System.out.println(ref);
//		});

		// available taxies
//		List<TaxiiDto> finded = service.findByisAvailable(true);
//
//		finded.forEach((ref) -> {
//			System.out.println(ref);
//		});

	}

}
