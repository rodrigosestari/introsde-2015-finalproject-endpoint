package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
/**
 * 
 * @author sestari
 *
 */
public class JaxbUtil {

	/**
	 * This function unmarshal a file XML
	 * into a object 
	 * 
	 * @param packageXml
	 * name of package that contains the files generated
	 * @param fileXml
	 * a file XML
	 * @param fileXsd
	 * the file XSD relative at XML
	 * @return
	 * a object type packageXml
	 */
	public static Object xmlToJaxb(String packageXml, String xml, File fileXsd) {
		Object obj = null;
		try {

			InputStream is = new  ByteArrayInputStream(xml.getBytes());

			JAXBContext jaxbContext = JAXBContext.newInstance(packageXml);

			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(fileXsd);

			unmarshaller.setSchema(schema);

			obj = unmarshaller.unmarshal(is);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * This function marshal a object into a XML
	 * 
	 * @param packageXml
	 * name of package that contains the files generated
	 * @param object
	 * the object to marshal
	 * @param fileXsd
	 * the file XSD relative at XML
	 * @return
	 * a String containing a XML
	 */
	public static String jaxbToXml(String packageXml, Object object, File fileXsd) {
		String ret = null;
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(packageXml);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
			if (fileXsd != null) {
				// imposto la validazione
				SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
				Schema schema = schemaFactory.newSchema(fileXsd);
				marshaller.setSchema(schema);
			}

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			marshaller.marshal(object, baos);

			ret = baos.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * Convert a object java.util.Date into 
	 * javax.xml.datatype.XMLGregorianCalendar
	 * 
	 * @param date
	 * an object Date
	 * @return
	 * an object XMLGregorianCalendar 
	 */
	public static XMLGregorianCalendar dateToXmlGregorianCalendar(Date date) {
		if (date == null)
			return null;
		GregorianCalendar c = new GregorianCalendar();
		c.clear();
		c.setTime(date);
		return JaxbUtil.gregorianCalendarToXmlGregorianCalendar(c);
	}

	
	private static XMLGregorianCalendar gregorianCalendarToXmlGregorianCalendar(GregorianCalendar calendar) {
		if (calendar == null)
			return null;
		XMLGregorianCalendar c = null;
		try {
			c = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
			c.setTimezone(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	/**
	 * This function convert a javax.xml.datatype.XMLGregorianCalendar
	 * into a java.util.Date
	 * 
	 * @param xmlCalendar
	 * an object XMLGregorianCalendar
	 * @return
	 * an object Date
	 */
	public static Date xmlGregorianCalendarToDate(XMLGregorianCalendar xmlCalendar) {
		if (xmlCalendar == null)
			return null;
		try {
			Calendar c = xmlCalendar.toGregorianCalendar();
			return c.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}