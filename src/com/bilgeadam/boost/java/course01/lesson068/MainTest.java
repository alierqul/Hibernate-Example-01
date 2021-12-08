package com.bilgeadam.boost.java.course01.lesson068;

import java.util.ArrayList;

import com.bilgeadam.boost.java.course01.lesson068.control.MovieEntityController;
import com.bilgeadam.boost.java.course01.lesson068.entity.MovieEntity;

public class MainTest {
	public static void main(String[] args) {
		MovieEntityController movieController = new MovieEntityController();

		ArrayList<MovieEntity> movieEntities = movieController.list();
		for (MovieEntity movieEntity : movieEntities) {
			System.out.println(movieEntity);
		}
	}
}
