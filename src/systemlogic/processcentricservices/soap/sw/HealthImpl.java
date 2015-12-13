package systemlogic.processcentricservices.soap.sw;

import java.io.File;
import java.net.URI;

import javax.jws.WebService;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import systemlogic.businesslogicservices.dto.measure.MeasureHistoryDto;
import systemlogic.businesslogicservices.dto.measuredefinition.MeasureTypesView;
import systemlogic.businesslogicservices.dto.measurehistory.MeasureHistoryView;
import systemlogic.businesslogicservices.dto.people.PeopleView;
import systemlogic.businesslogicservices.dto.person.PersonDto;
import util.JaxbUtil;



//Service Implementation



@WebService(endpointInterface = "systemlogic.processcentricservices.soap.sw.Health", serviceName = "HealthService")
public class HealthImpl implements Health {

	ClientConfig clientConfig = new ClientConfig();
	Client client = ClientBuilder.newClient(clientConfig);
	

	private static URI getBaseURI() {
		return UriBuilder.fromUri("https://rodrigo-sestari-final-rest.herokuapp.com/finalprojectrest").build();
	}
	
	@Override
	public PersonDto readPerson(Long id) {
		WebTarget service = client.target(getBaseURI()).path("person/"+id);
		Response response = service.request(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).get();     		
		String xml = response.readEntity(String.class);
		
		//get xsd
		File xsdPeople = new File("resource/PersonDto.xsd");
		//um-marshal Xml into object people,
		PersonDto people = (PersonDto) JaxbUtil.xmlToJaxb("systemlogic.businesslogicservices.dto.person", xml, xsdPeople);
		return people;
	}

	@Override
	public PeopleView getPeople() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long addPerson(PersonDto person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long updatePerson(PersonDto person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletePerson(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MeasureHistoryView readPersonHistory(Long id, String measureType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MeasureTypesView readMeasureTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MeasureHistoryDto readPersonMeasure(Long id, String measureType, Long mid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long savePersonMeasure(Long id, MeasureHistoryDto m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long updatePersonMeasure(Long id, MeasureHistoryDto m) {
		// TODO Auto-generated method stub
		return null;
	}

}
