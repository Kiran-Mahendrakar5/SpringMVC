package com.xworkz.taxii.service;

import java.util.List;

import com.xworkz.taxii.dto.TaxiiDto;

public interface TaxiiService {

	public boolean saveTaxi(TaxiiDto dto);

	public List<TaxiiDto> readAll();

	public boolean updatebyearning(int earning);

	public boolean updateisAvailableById(int id, boolean isAvailable);

	public TaxiiDto findtaxinoBylocation(String location, int taxino);

	public List<TaxiiDto> findByisAvailable(boolean b);

	public TaxiiDto bookTaxi();
}