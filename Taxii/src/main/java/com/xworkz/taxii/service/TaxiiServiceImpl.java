package com.xworkz.taxii.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.taxii.dto.TaxiiDto;
import com.xworkz.taxii.repo.MyCompareter;
import com.xworkz.taxii.repo.TaxiiRepo;
import com.xworkz.taxii.repo.TaxiiRepoImpl;

@Component
public class TaxiiServiceImpl implements TaxiiService {

	private TaxiiRepo repo = new TaxiiRepoImpl();

	@Override
	public boolean saveTaxi(TaxiiDto dto) {
		if (dto != null) {
//			if (dto.getId() != 0) {
//				if (dto.getTaxino() != 0) {
//					if (dto.getEarning() != 0) {
//						if (dto.getTrip() != 0) {
//							if (dto.isAvailable() != false) {
//								if (dto.getLocation() != null) {
			repo.saveTaxi(dto);
			System.out.println("saved");
			return true;
//								}
//								System.out.println("location is null");
//								return false;
//							}
//							System.out.println("isAbailable is false");
//							return false;
//						}
//						System.out.println("trip is 0");
//						return false;
//					}
//					System.out.println("earning is 0");
//					return false;
//				}
//				System.out.println("taxino is 0");
//				return false;
////			}
//			System.out.println("Id is 0");
//			return false;
		}
		System.out.println("dto is null");
		return false;

	}

	@Override
	public List<TaxiiDto> readAll() {

		return repo.readAll();
	}

	@Override
	public boolean updatebyearning(int earning) {
		if (earning != 0) {
			repo.updatebyearning(earning);
			System.out.println("updated earning");
			return true;
		}
		return false;
	}

	@Override
	public boolean updateisAvailableById(int id, boolean isAvailable) {
		if (id != 0) {
			if (isAvailable != true) {
				repo.updateisAvailableById(id, isAvailable);
				System.out.println("service method");
				return true;
			}
			System.out.println("isAvailable is false");
			return false;
		}
		System.out.println("id is 0");
		return false;
	}

	@Override
	public TaxiiDto findtaxinoBylocation(String location, int taxino) {
		if (location != null) {
			if (taxino != 0) {
				System.out.println("finded");
				return repo.findtaxinoBylocation(location, taxino);

			}
		}
		return null;
	}

	@Override
	public List<TaxiiDto> findByisAvailable(boolean b) {
		List<TaxiiDto> avaible = repo.findByisAvailable(b);
		if (avaible != null) {
			System.out.println("not null");
			return avaible;
		}
		System.out.println("is null");
		return null;
	}

	@Override

	public TaxiiDto bookTaxi() {
		
			return repo.bookTaxi();
	}

}
