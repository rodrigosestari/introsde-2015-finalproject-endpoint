package systemlogic.processcentricservices.soap.sw;

import java.net.URI;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import systemlogic.businesslogicservices.dto.MeasureHistoryDto;
import systemlogic.businesslogicservices.dto.PersonDto;
import systemlogic.businesslogicservices.view.MeasureListHistoryView;


//Service Implementation



@WebService(endpointInterface = "systemlogic.processcentricservices.soap.sw.Health", serviceName = "HealthService")
public class HealthImpl implements Health {
	
	ClientConfig clientConfig = new ClientConfig();
	Client client = ClientBuilder.newClient(clientConfig);
	WebTarget service = client.target(getBaseURI()).path("person");
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://10.218.221.138:5700/finalprojectrest/").build();
	}

	@Override
	public PersonDto readPerson(Long id) {
		

	
		Response response = service.request(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).get();
		int httpStatus =response.getStatus();     		
		String xml = response.readEntity(String.class);

	}

	@Override
	public List<PersonDto> getPeople() {
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
	public MeasureListHistoryView readPersonHistory(Long id, String measureType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> readMeasureTypes() {
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
