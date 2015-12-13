package systemlogic.businesslogicservices.view;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "measureHistory")
public class MeasureListHistoryView implements Serializable {


	private static final long serialVersionUID = 3521996173451216932L;
	private List<MeasureHistoryView> measure;

	public MeasureListHistoryView() {
	}

	@XmlElement(name = "measure")
	public List<MeasureHistoryView> getMeasure() {
		return measure;
	}

	public void setMeasure(List<MeasureHistoryView> measure) {
		this.measure = measure;
	}


	
	@Override
	public String toString() {
		return "MeasureHistoryBean [measure=" + measure + "]";
	}

}