package io.uned.proyectoFinal.model;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="Credito")
@XmlAccessorType(XmlAccessType.FIELD)
public class Credito {
	
    @XmlAttribute
    private String type;
    
    private String idCredito;
    private String monto;
   // private Date fecFormalizacion;
    private String interes;
    private String plazo;
    
    @XmlElementWrapper(name="Abonos")
    @XmlElement(name="Abono")
    private List<Abono> abonos;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIdCredito() {
		return idCredito;
	}

	public void setIdCredito(String idCredito) {
		this.idCredito = idCredito;
	}

	public String getPlazo() {
		return plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	public List<Abono> getAbonos() {
		return abonos;
	}

	public void setAbonos(List<Abono> creditos) {
		this.abonos = abonos;
	} 
}
