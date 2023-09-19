package com.xworkz.taxii.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Taxii_table")
@NamedQuery(name="readAll" ,query = "select dto from TaxiiDto dto")
@NamedQuery(name = "updatebyearning" ,query = "update TaxiiDto dto set dto.earning=:er")
@NamedQuery(name = "updateisAvailableById" ,query = "update TaxiiDto dto set dto.isAvailable=:isA where dto.id=:id")
@NamedQuery(name="findtaxinoBylocation",query = "select dto from TaxiiDto dto where dto.taxino=:tx and dto.location=:lc")
@NamedQuery(name="findByisAvailable" ,query = "select dto from TaxiiDto dto where dto.isAvailable=:isA")
@NamedQuery(name="findLowestEarnings" ,query = "select dto from TaxiiDto dto where dto.earning=:er")

public class TaxiiDto implements Serializable {
	
	
	
	@Id
	private int id;
	private int taxino;
	private int earning;
	private int trip;
	private boolean isAvailable;
	private String location;

}
