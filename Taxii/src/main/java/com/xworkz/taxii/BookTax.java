package com.xworkz.taxii;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xworkz.taxii.dto.TaxiiDto;
import com.xworkz.taxii.service.TaxiiService;
import com.xworkz.taxii.service.TaxiiServiceImpl;


@WebServlet(urlPatterns = "/book" )
public class BookTax extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		TaxiiService service = new TaxiiServiceImpl();
		
	TaxiiDto book =	service.bookTaxi();
	
	System.out.println(book.getEarning());
		
		
				
				
	
	}
	
	
	
	

}
