package systemlogic.businesslogicservices.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import systemlogic.businesslogicservices.view.HealthProfileView;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "idPerson", "firstname", "lastname",  "healthprofile" })
public class PersonDto implements Serializable {


	private static final long serialVersionUID = 8987951899033020232L;
	private Integer idPerson;
	private String firstname;
	private String lastname;
	

	@XmlElement(name = "healthProfile")
	private HealthProfileView healthprofile;

	public Integer getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public HealthProfileView getHealthprofile() {
		return healthprofile;
	}

	public void setHealthprofile(HealthProfileView healthprofile) {
		this.healthprofile = healthprofile;
	}

	@Override
	public String toString() {
		return "PersonBean [lastname=" + lastname + ", firstname=" + firstname 
				+ ", healthprofile=" + healthprofile + "]";
	}

}