package systemlogic.businesslogicservices.view;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HealthProfileView implements Serializable {


	private static final long serialVersionUID = -7294911323864810080L;
	private List<MeasureTypeView> measure;

	public HealthProfileView() {
	}

	@XmlElement(name = "measureType")
	public List<MeasureTypeView> getMeasure() {
		return measure;
	}

	public void setMeasure(List<MeasureTypeView> measure) {
		this.measure = measure;
	}



	@Override
	public String toString() {
		return "HealthProfile [measure=" + measure + "]";
	}
	
	
}