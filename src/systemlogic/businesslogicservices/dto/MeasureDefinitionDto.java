package systemlogic.businesslogicservices.dto;

import java.io.Serializable;

public class MeasureDefinitionDto  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4919220552369615873L;
	private int idMeasureDef;
	private String measureName;
	public int getIdMeasureDef() {
		return idMeasureDef;
	}
	public void setIdMeasureDef(int idMeasureDef) {
		this.idMeasureDef = idMeasureDef;
	}
	public String getMeasureName() {
		return measureName;
	}
	public void setMeasureName(String measureName) {
		this.measureName = measureName;
	}
	@Override
	public String toString() {
		return "MeasureDefinitionDto [idMeasureDef=" + idMeasureDef + ", measureName=" + measureName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMeasureDef;
		result = prime * result + ((measureName == null) ? 0 : measureName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeasureDefinitionDto other = (MeasureDefinitionDto) obj;
		if (idMeasureDef != other.idMeasureDef)
			return false;
		if (measureName == null) {
			if (other.measureName != null)
				return false;
		} else if (!measureName.equals(other.measureName))
			return false;
		return true;
	}
	
	
}
