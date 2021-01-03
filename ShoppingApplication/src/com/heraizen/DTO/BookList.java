package com.heraizen.DTO;

import java.util.concurrent.ThreadLocalRandom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter

@AllArgsConstructor
public class BookList {
	public int price;

	public String getId() {
		return ids;
	}

	public void setId(String id) {
		this.ids = id;
	}

	public String title;
	public String subtitle;
	public String author;
	public String publisher;
	public Integer pages;
	public String description;
	public String ids;
	public String image;
	public int duplicate = 1;

	public int getDuplicate() {
		return duplicate;
	}

	public void setDuplicate(int duplicate) {
		System.out.println(duplicate + " dul");

		this.duplicate = duplicate;
	}

	public BookList(String title2, String author, String pub, String id) {

		this.title = title2;
		this.author = author;
		this.publisher = pub;
		this.ids = id;

	}

	public BookList() {

	}

	public String getTitle() {
		return title;
	}

	public String getid() {
		return ids;
	}

	public void set_id(String _id) {
		this.ids = _id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getPages() {
		return pages;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
