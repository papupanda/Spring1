package com.nt.external;

public class ICCScoreCompImpl implements ICCScoreComp {

	@Override
	public String findScore(int mid) throws IllegalArgumentException {
		if(mid==1001)
			return  "300/2 --> IND -PAK  (IND)";
		else if(mid==1002)
			return "233/4 --->AUS vs  SA  (SA)";
		else
			throw new IllegalArgumentException("Invalid Match Id");
	}

}
