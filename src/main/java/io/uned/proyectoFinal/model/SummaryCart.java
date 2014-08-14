package io.uned.proyectoFinal.model;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="SummaryCart", namespace="SummaryCart")
@XmlAccessorType(XmlAccessType.FIELD)
public class SummaryCart{

    @XmlElement(name="SummaryElement")
    private List<SummaryElement> summaryElementList;

	public List<SummaryElement> getSummaryElementList() {
		return summaryElementList;
	}

	public void setSummaryElementList(List<SummaryElement> summaryElementList) {
		this.summaryElementList = summaryElementList;
	}
       

}