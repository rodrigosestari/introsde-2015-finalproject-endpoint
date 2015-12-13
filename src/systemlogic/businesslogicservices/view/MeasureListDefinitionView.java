package systemlogic.businesslogicservices.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "measureTypes")
public class MeasureListDefinitionView implements Serializable{


	private static final long serialVersionUID = -6959456534581259572L;
	private List<String> measureType = new ArrayList<String>();

	@XmlElement(name = "measureType")
	public List<String> getMeasureType() {
		return measureType;
	}

	public void setMeasureType(List<String> measureType) {
		this.measureType = measureType;
	}

	public MeasureListDefinitionView() {

	}

	@Override
	public String toString() {
		return "MeasureDefinitionBean [measureType=" + measureType + "]";
	}

}
