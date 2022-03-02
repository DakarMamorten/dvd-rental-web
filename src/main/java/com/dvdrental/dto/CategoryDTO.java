package com.dvdrental.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CategoryDTO {
	private long categoryID;
	private String name;
	private String lastUpdate;

	public CategoryDTO(String name) {
		this.name = name;
	}
}
