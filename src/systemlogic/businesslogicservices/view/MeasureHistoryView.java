package systemlogic.businesslogicservices.view;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "measure")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "mid", "value", "created" })
public class MeasureHistoryView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9163938455236472286L;

	private Integer mid;

	private double value;

	private String created;

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}


	
	@Override
	public String toString() {
		return "MeasureHistoryBean [mid=" + mid + ", value=" + value + ", created=" + created + "]";
	}

}