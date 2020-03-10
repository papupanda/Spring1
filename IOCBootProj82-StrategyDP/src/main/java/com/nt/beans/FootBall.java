package com.nt.beans;

public final class FootBall implements Sport {
	
	public FootBall() {
		System.out.println("FootBall::0-param constructor");
	}

	@Override
	public String equipment() {
		return "FootBall:: ball,Nets,Vissile,Keeping Gloves,knee pads and etc...";
	}

}
