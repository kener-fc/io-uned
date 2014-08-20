package io.uned.proyectoFinal.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	private SimpleDateFormat dateFormat;
	
	public Util(){
		
	}

	public SimpleDateFormat getDateFormat() {
		if(dateFormat == null){
			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		}
		return dateFormat;
	}

	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}
	
	public Date getDate(String formatDate){
		try {
			return getDateFormat().parse(formatDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
