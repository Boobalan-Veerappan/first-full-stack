package com.heraizen.employee.dto;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "BookList")
public class BookList {

	@Id
	public String ids;
	public int price;
	public String title;
	public String subtitle;
	public String author;
	public String publisher;
	public Integer pages;
	public String description;
	public String image;
	public int duplicate = 1;
	
}
