package com.xworkz.taxii.repo;

import java.util.List;

import com.xworkz.taxii.dto.TaxiiDto;

public interface TaxiiRepo {
	
	public boolean saveTaxi(TaxiiDto dto);

	public List<TaxiiDto> readAll();

	public boolean updatebyearning(int earning);

	public boolean updateisAvailableById(int id, boolean isAvailable);

	public TaxiiDto findtaxinoBylocation(String location, int taxino);

	public List<TaxiiDto> findByisAvailable(boolean b);
	
	public TaxiiDto bookTaxi();

}
