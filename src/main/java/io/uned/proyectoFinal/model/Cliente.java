package io.uned.proyectoFinal.model;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="Cliente")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cliente {


    @XmlAttribute
    private String type;
    
    private String idCliente;
    private String nombre;
    private String apellido1;
    private String apellido2;  
    
    @XmlElementWrapper(name="Creditos")
    @XmlElement(name="Credito")
    private List<Credito> creditos; 
    
    
    public List<Credito> getCreditos() {
		return creditos;
	}

	public void setCreditos(List<Credito> creditos) {
		this.creditos = creditos;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
    

}