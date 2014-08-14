package io.uned.proyectoFinal.model;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class SummaryElement {

    private int order;
    private String id;
    private String displayName;
    private String property;
    private List<SummaryElement> subElements;
    private int maxlines;

    @XmlAttribute
    private String type;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public List<SummaryElement> getSubElements() {
		return subElements;
	}

	public void setSubElements(List<SummaryElement> subElements) {
		this.subElements = subElements;
	}

	public int getMaxlines() {
		return maxlines;
	}

	public void setMaxlines(int maxlines) {
		this.maxlines = maxlines;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
    

}