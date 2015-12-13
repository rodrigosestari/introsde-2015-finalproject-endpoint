package systemlogic.businesslogicservices.dto;

import java.io.Serializable;
import java.util.Date;

public class MeasureHistoryDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6050748928415880448L;
	
	private int idMeasureHistory;

	private Date created;

	private String value;

	private MeasureDefinitionDto measureDefinition;

	private PersonDto person;

	public int getIdMeasureHistory() {
		return idMeasureHistory;
	}

	public void setIdMeasureHistory(int idMeasureHistory) {
		this.idMeasureHistory = idMeasureHistory;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
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

}
