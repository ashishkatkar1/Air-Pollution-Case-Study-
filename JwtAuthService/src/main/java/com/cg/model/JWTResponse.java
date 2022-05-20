package com.cg.model;

public class JWTResponse {
    
	//attributes
	private String jwtToken;
	
	//default constructor

	public JWTResponse() {
		super();
	}
	//parameterized constructor

	public JWTResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

   //getters and setter
	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	//toString method
	@Override
	public String toString() {
		return "JWTResponse [jwtToken=" + jwtToken + "]";
	}
	
}
