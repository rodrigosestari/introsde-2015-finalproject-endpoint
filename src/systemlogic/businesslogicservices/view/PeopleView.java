package systemlogic.businesslogicservices.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import systemlogic.businesslogicservices.dto.PersonDto;

@XmlRootElement(name = "people")
public class PeopleView implements Serializable {

	private static final long serialVersionUID = -6571361062455280397L;
	
	private List<PersonDto> person = new ArrayList<PersonDto>();

	@XmlElement(name = "person")
	public List<PersonDto> getPerson() {
		return person;
	}

	public void setPerson(List<PersonDto> person) {
		this.person = person;
	}

	public PeopleView() {

	}

	@Override
	public String toString() {
		return "PeopleBean [person=" + person + "]";
	}


}
