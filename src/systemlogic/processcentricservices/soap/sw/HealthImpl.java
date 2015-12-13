package systemlogic.processcentricservices.soap.sw;

import java.io.File;
import java.io.StringReader;
import java.net.URI;

import javax.jws.WebService;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.glassfish.jersey.client.ClientConfig;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

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

	public static NodeList getNodes(String source, String query) throws Exception {
		NodeList nl = null;
		try {
			if (!source.isEmpty()) {
				InputSource input_source = new InputSource(new StringReader(source));

				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				org.w3c.dom.Document document = db.parse(input_source);

				XPathFactory xpathFactory = XPathFactory.newInstance();
				XPath xpath = xpathFactory.newXPath();

				nl = (NodeList) xpath.evaluate(query, document, XPathConstants.NODESET);
			}
		} catch (Exception e) {
			nl = null;
		}

		return nl;
	}

	@Override
	public PersonDto readPerson(Long id) {
		WebTarget service = client.target(getBaseURI()).path("person/" + id);
		Response response = service.request(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).get();
		String xml = response.readEntity(String.class);

		// get xsd
		File xsdFile = new File("resource/PersonDto.xsd");
		// um-marshal Xml into object people,
		PersonDto people = (PersonDto) JaxbUtil.xmlToJaxb("systemlogic.businesslogicservices.dto.person", xml, xsdFile);
		return people;
	}

	@Override
	public PeopleView getPeople() {
		WebTarget service = client.target(getBaseURI()).path("person/");
		Response response = service.request(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).get();
		String xml = response.readEntity(String.class);

		// get xsd
		File xsdFile = new File("resource/PeopleView.xsd");
		// um-marshal Xml into object people,
		PeopleView people = (PeopleView) JaxbUtil.xmlToJaxb("systemlogic.businesslogicservices.dto.people", xml,
				xsdFile);
		return people;
	}

	@Override
	public Long addPerson(PersonDto person) {
		WebTarget service = client.target(getBaseURI()).path("person");
		Long newIdPerson = (long) 0;
		try {
			// get xsd
			File xsdFile = new File("resource/PersonDto.xsd");
			String xml = JaxbUtil.jaxbToXml("systemlogic.businesslogicservices.dto.person", person, xsdFile);
			Response response = service.request(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML)
					.post(Entity.xml(xml));
			xml = response.readEntity(String.class);
			NodeList n1 = getNodes(xml, "//idPerson/text()");
			newIdPerson = Long.parseLong(n1.item(0).getNodeValue());
		} catch (Exception e) {
			// TODO: handle exception
		}

		return newIdPerson;
	}

	@Override
	public Long updatePerson(PersonDto person) {
		WebTarget service = client.target(getBaseURI()).path("person");
		Long newIdPerson = (long) 0;
		try {
			// get xsd
			File xsdFile = new File("resource/PersonDto.xsd");
			String xml = JaxbUtil.jaxbToXml("systemlogic.businesslogicservices.dto.person", person, xsdFile);
			Response response = service.request(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML)
					.put(Entity.xml(xml));
			xml = response.readEntity(String.class);
			NodeList n1 = getNodes(xml, "//idPerson/text()");
			newIdPerson = Long.parseLong(n1.item(0).getNodeValue());
		} catch (Exception e) {
			// TODO: handle exception
		}

		return newIdPerson;
	}

	@Override
	public int deletePerson(Long id) {
		WebTarget service = client.target(getBaseURI()).path("person/" + id);
		Response response = service.request(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).delete();
		int httpStatus = response.getStatus();
		return httpStatus;
	}

	@Override
	public MeasureHistoryView readPersonHistory(Long id, String measureType) {
		MeasureHistoryView measureHistory = null;
		try {
			WebTarget service = client.target(getBaseURI()).path("person/" + id + "/" + measureType);
			Response response = service.request(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).get();
			String xml = response.readEntity(String.class);

			// get xsd
			File xsdFile = new File("resource/MeasureHistoryView.xsd");
			// um-marshal Xml into object people,
			measureHistory = (MeasureHistoryView) JaxbUtil
					.xmlToJaxb("systemlogic.businesslogicservices.dto.measurehistory", xml, xsdFile);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return measureHistory;
	}

	@Override
	public MeasureTypesView readMeasureTypes() {
		WebTarget service = client.target(getBaseURI()).path("measureTypes/");
		Response response = service.request(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).get();
		String xml = response.readEntity(String.class);

		// get xsd
		File xsdFile = new File("resource/MeasureTypeView.xsd");
		// um-marshal Xml into object people,
		MeasureTypesView measureType = (MeasureTypesView) JaxbUtil
				.xmlToJaxb("systemlogic.businesslogicservices.dto.measuredefinition", xml, xsdFile);
		return measureType;
	}

	@Override
	public MeasureHistoryDto readPersonMeasure(Long id, String measureType, Long mid) {
		WebTarget service = client.target(getBaseURI()).path("person/" + id + "/" + measureType + "/" + mid);
		Response response = service.request(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).get();
		String xml = response.readEntity(String.class);

		// get xsd
		File xsdFile = new File("resource/MeasureHistoryDto.xsd");
		// um-marshal Xml into object people,
		MeasureHistoryDto measure = (MeasureHistoryDto) JaxbUtil
				.xmlToJaxb("systemlogic.businesslogicservices.dto.measure", xml, xsdFile);
		return measure;
	}

	@Override
	public Long savePersonMeasure(Long id, MeasureHistoryDto m) {

		/*
		 * WebTarget service =
		 * client.target(getBaseURI()).path("person/"+id+"/"+m);
		 * 
		 * 
		 * Response response =
		 * service.request(MediaType.APPLICATION_XML).accept(MediaType.
		 * APPLICATION_XML).post(Entity.xml(xml)); httpStatus
		 * =response.getStatus(); write("=> HTTP Status: " +httpStatus);
		 * write(xml);
		 * 
		 */

		return null;

	}

	@Override
	public Long updatePersonMeasure(Long id, MeasureHistoryDto m) {
		// TODO Auto-generated method stub
		/*
		 * NodeList n1 = getNodes(xml, "//measure"); if(n1.getLength()>1){
		 * 
		 * n1 = getNodes(xml, "//measure/mid/text()"); String measure_id =
		 * n1.item(0).getNodeValue(); return Long.parseLong(measure_id); }
		 */
		return null;
	}

}
