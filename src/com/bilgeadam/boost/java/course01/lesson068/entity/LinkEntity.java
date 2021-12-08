package com.bilgeadam.boost.java.course01.lesson068.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "links")
public class LinkEntity {
	@Id 
	private long   id;
	@Column(name = "imdb")
	private String imdb;
	@Column(name = "tmdb")
	private String tmdb;
}
