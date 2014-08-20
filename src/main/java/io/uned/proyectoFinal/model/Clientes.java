package io.uned.proyectoFinal.model;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="Clientes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Clientes{

    @XmlElement(name="Cliente")
    private List<Cliente> list;

	public Clientes() {
		super();
	}

	public List<Cliente> getList() {
		return list;
	}

	public void setList(List<Cliente> list) {
		this.list = list;
	}
}