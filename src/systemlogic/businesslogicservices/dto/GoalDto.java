package systemlogic.businesslogicservices.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "goal")
@XmlAccessorType(XmlAccessType.FIELD)
public class GoalDto implements  Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6546071085851753736L;

	private int idMeasureHistory;

	private Date start;

	private Date end;

	private String type;

	private String value;

	private MeasureDefinitionDto measureDefinition;

	private PersonDto person;

	public int getIdMeasureHistory() {
		return idMeasureHistory;
	}

	public void setIdMeasureHistory(int idMeasureHistory) {
		this.idMeasureHistory = idMeasureHistory;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public MeasureDefinitionDto getMeasureDefinition() {
		return measureDefinition;
	}

	public void setMeasureDefinition(MeasureDefinitionDto measureDefinition) {
		this.measureDefinition = measureDefinition;
	}

	public PersonDto getPerson() {
		return person;
	}

	public void setPerson(PersonDto person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "GoalDto [idMeasureHistory=" + idMeasureHistory + ", start=" + start + ", end=" + end + ", type=" + type
				+ ", value=" + value + ", measureDefinition=" + measureDefinition + ", person=" + person + "]";
	}

	
	
}
