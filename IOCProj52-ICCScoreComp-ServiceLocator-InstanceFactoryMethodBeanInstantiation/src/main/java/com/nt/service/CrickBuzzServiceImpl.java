package com.nt.service;

import com.nt.external.ICCScoreComp;

public class CrickBuzzServiceImpl implements CrickBuzzService {
	private ICCScoreComp extComp;
	
	public CrickBuzzServiceImpl(ICCScoreComp extComp) {
		this.extComp = extComp;
	}

	@Override
	public String getScore(int mid) throws IllegalArgumentException {
		String score=null;
		//use external comp ref
		score=extComp.findScore(mid);
		return score;
	}

	

}
