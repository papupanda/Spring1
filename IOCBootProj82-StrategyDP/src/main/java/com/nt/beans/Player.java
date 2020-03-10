package com.nt.beans;

import javax.annotation.Resource;
import javax.inject.Named;

@Named("player")
public final class Player {
	@Resource
	private  Sport sport;
	
	public Player() {
		System.out.println("Player::0-param constructor");
	}
	
	public void playGame() {
		String equip=null;
		equip=sport.equipment();
		System.out.println("player is playing game using "+equip);
	}
	
	
	}