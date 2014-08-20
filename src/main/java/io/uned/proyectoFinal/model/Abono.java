package io.uned.proyectoFinal.model;

import io.uned.proyectoFinal.util.Util;

import java.text.ParseException;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;

@XmlRootElement(name="Abono")
@XmlAccessorType(XmlAccessType.FIELD)
public class Abono {
	
    @XmlAttribute
    private String type;
    
    private double monto;
    private String fecAbono;
    private Date date;
    
	@Autowired
	private Util util;
    
    

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getFecAbono() {
		
		return fecAbono;
	}
	public void setFecAbono(String fecAbono) {
		
		this.fecAbono = fecAbono;
		setDate(util.getDate(fecAbono));
	}
    public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Util getUtil() {
		return util;
	}
	public void setUtil(Util util) {
		this.util = util;
	}

}
