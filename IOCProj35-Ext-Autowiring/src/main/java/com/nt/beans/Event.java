package com.nt.beans;

import java.util.Arrays;

public class Event {
	private String[] games;

	public Event() {
		System.out.println("Event:0-param costructor");
	}
	
	public void setGames(String[] games) {
		System.out.println("Event: setGames(-)");
		this.games = games;
	}

	@Override
	public String toString() {
		return "Event [games=" + Arrays.toString(games) + "]";
	}
	
	

}
