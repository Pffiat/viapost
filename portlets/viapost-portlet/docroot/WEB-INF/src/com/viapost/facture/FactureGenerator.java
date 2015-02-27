package com.viapost.facture;

import java.util.Date;

public class FactureGenerator {
	
	private String userId = "userId";
	private Date date = new Date();
	
	FactureGenerator(final Date date, final String userId) {

		this.userId = userId;
		this.date = date;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}
	
}
