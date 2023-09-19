package com.xworkz.taxii.repo;

import java.util.Comparator;

import com.xworkz.taxii.dto.TaxiiDto;

public class MyCompareter implements Comparator<TaxiiDto> {

	@Override
	public int compare(TaxiiDto o1, TaxiiDto o2) {
		if(o1.getEarning()<o2.getEarning()) {
			return -1;
		}
		return 0;
	}
	

}
