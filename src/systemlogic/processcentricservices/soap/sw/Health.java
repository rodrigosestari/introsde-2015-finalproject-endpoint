package systemlogic.processcentricservices.soap.sw;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import systemlogic.businesslogicservices.dto.MeasureHistoryDto;
import systemlogic.businesslogicservices.dto.PersonDto;
import systemlogic.businesslogicservices.view.MeasureListHistoryView;



@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface Health {
	
	/**
	 * Method #2: readPerson(Long id) => Person | should give all the 
	 * Personal information plus current measures of one Person identified by {id} (e.g., current measures means current healthProfile)
	 * @param id
	 * @return
	 */
    @WebMethod(operationName="readPerson")
    @WebResult(name="person") 
    public PersonDto readPerson(@WebParam(name="personId") Long id);

    /**
     * Method #1: readPersonList() => List | should list all the people in the database
     *  (see below Person model to know what data to return here) in your database
     * @return
     */
    @WebMethod(operationName="readPersonList")
    @WebResult(name="people") 
    public List<PersonDto> getPeople();

    
    /**
     * Method #4: createPerson(Person p) => Person | should create a new Person and return the 
     * newly created Person with its assigned id (if a health profile is included, create also those measurements for the new Person).
     * @param person
     * @return
     */
    @WebMethod(operationName="createPerson")
    @WebResult(name="personId") 
    public Long addPerson(@WebParam(name="person") PersonDto person);

    
    /**
     * Method #3: updatePerson(Person p) => Person | should update the Personal information of the Person 
     * identified by {id} (e.g., only the Person's information, not the measures of the health profile)
     * @param person
     * @return
     */
    @WebMethod(operationName="updatePerson")
    @WebResult(name="personId") 
    public Long updatePerson(@WebParam(name="person") PersonDto person);

    /**
     * Method #5: deletePerson(Long id) should delete the Person identified by {id} from the system
     * @param id
     * @return
     */
    @WebMethod(operationName="deletePerson")
    @WebResult(name="personId") 
    public int deletePerson(@WebParam(name="personId") Long id);

    
/**
 *  Method #6: readPersonHistory(Long id, String measureType) => 
 *  List should return the list of values (the history) of {measureType} (e.g. weight) for Person identified by {id} 
 * @param id
 * @return
 */
    @WebMethod(operationName="readPersonHistory")
    @WebResult(name="MeasureProfile") 
    public MeasureListHistoryView readPersonHistory(@WebParam(name="personId") Long id, @WebParam(name="type") String measureType);

    
    
    /**
     * Method #7: readMeasureTypes() => List should return the list of measures
     * @param id
     * @param type
     * @return
     */
    @WebMethod(operationName="readMeasureTypes")
    @WebResult(name="MeasureProfile") 
    public List<String> readMeasureTypes();

    
    /**
     * Method #8: readPersonMeasure(Long id, String measureType, Long mid) => 
     * Measure should return the value of {measureType} (e.g. weight) identified by {mid} for Person identified by {id}
     * @param id
     * @param measureType
     * @param mid
     * @return
     */
    @WebMethod(operationName="readPersonMeasure")
    @WebResult(name="MeasureProfile") 
    public MeasureHistoryDto readPersonMeasure(@WebParam(name="personId") Long id, @WebParam(name="type") String measureType,@WebParam(name="mid") Long mid);

    
    /**
     * Method #9: savePersonMeasure(Long id, Measure m) =>should save a new measure object {m}
     *  (e.g. weight) of Person identified by {id} and archive the old value in the history
     * @param id
     * @param type
     * @param mid
     * @return
     */
    @WebMethod(operationName="savePersonMeasure")
    @WebResult(name="measureId") 
    public Long savePersonMeasure(@WebParam(name="personId") Long id, @WebParam(name="measure") MeasureHistoryDto m);

    
    
    /**
     * Method #10: updatePersonMeasure(Long id, Measure m) => Measure | should update the measure identified with {m.mid}, 
     * related to the Person identified by {id}
     * @param id
     * @param m
     * @return
     */
    @WebMethod(operationName="updatePersonMeasure")
    @WebResult(name="measureId") 
    public Long updatePersonMeasure(@WebParam(name="personId") Long id, @WebParam(name="measure") MeasureHistoryDto m);

}
