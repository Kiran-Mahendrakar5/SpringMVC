package com.xworkz.taxii;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xworkz.taxii.dto.TaxiiDto;
import com.xworkz.taxii.service.TaxiiService;
import com.xworkz.taxii.service.TaxiiServiceImpl;

@WebServlet(urlPatterns = "/find")
public class TaxiiServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter print = resp.getWriter();

		TaxiiService service = new TaxiiServiceImpl();
		List<TaxiiDto> finded = service.findByisAvailable(true);

		print.print("<h1>AvailableTaxi</h1>");
		print.print("<table border=1>");
		for (TaxiiDto ref : finded) {
			print.print("<tr>");
			print.print("<td>");
			print.print("<h4>Id</h4>");
			print.print(ref.getId());
			print.print("<td>");
			print.print("<h4>Taxino</h4>");
			print.print(ref.getTaxino());
			print.print("<td>");
			print.print("<h4>Earning</h4>");
			print.print(ref.getEarning());
			print.print("<td>");
			print.print("<h4>Trip</h4>");
			print.print(ref.getTrip());
			print.print("<td>");
			print.print("<h4>Location</h4>");
			print.print(ref.getLocation());
			print.print("<td>");
			print.print("<tr>");
			
			
//			print.print("<button type=\"submit\" class=\"btn btn-success\">AvailableTaxi</button>");
			
			
			
//			req.getRequestDispatcher("/book.jsp").forward(req, resp);

		

		}
		print.print("</table>");
		print.print("<form action=book  method=get><button type=\"submit\" class=\"btn btn-success\">AvailableTaxi</button></form>");

	}
}
