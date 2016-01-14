Final Project

**Introduction to Service Design and Engineering | University of Trento |** 

**Name:** Rodrigo Sestari

**Description:**

In this assignment is implemented a server calling this server. 
The server was deployed on Heroku *http://rodrigo-sestari-final-soap.herokuapp.com/ws/health?wsdl**.
Instead the client was implemented to call Heroku server. 

This project contains a SOAP WebService.





**Tasks Server:**

* **Request #1:** readPersonList() => List | should list all the people in the database (see below Person model to know what data to return here) in your database
```
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <ns2:readPersonListResponse xmlns:ns2="http://sw.soap.processcentricservices.systemlogic/">
         <people> 
            <person>
               <idPerson>2</idPerson>
               <firstname>Maicon</firstname>
               <lastname>Antonio</lastname>
               <healthProfile>
                  <measureType>
                     <measure>heigth</measure>
                     <value>102.0</value>
                  </measureType>
                  <measureType>
                     <measure>weight</measure>
                     <value>66.9</value>
                  </measureType>
                  <measureType>
                     <measure>heart</measure>
                     <value>78.9</value>
                  </measureType>
               </healthProfile>
            </person>
            <person>
               <idPerson>3</idPerson>
               <firstname>Anna</firstname>
               <lastname>Caprese</lastname>
               <healthProfile>
                  <measureType>
                     <measure>weight</measure>
                     <value>78.9</value>
                  </measureType>
                  <measureType>
                     <measure>heigth</measure>
                     <value>129.8</value>
                  </measureType>
                  <measureType>
                     <measure>heart</measure>
                     <value>71.3</value>
                  </measureType>
               </healthProfile>
            </person>
         </people>
      </ns2:readPersonListResponse>
   </S:Body>
</S:Envelope>
```

* **Request #2:** readPerson(Long id) => Person | should give all the Personal information plus current measures of one Person identified by {id} (e.g., current measures means current healthProfile)
```
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <ns2:readPersonResponse xmlns:ns2="http://sw.soap.processcentricservices.systemlogic/">
         <person>
            <idPerson>1</idPerson>
            <firstname>Sonia</firstname>
            <lastname>Broz</lastname>
            <healthProfile>
               <measureType>
                  <measure>weight</measure>
                  <value>32.0</value>
               </measureType>
               <measureType>
                  <measure>heigth</measure>
                  <value>37.8</value>
               </measureType>
               <measureType>
                  <measure>heart</measure>
                  <value>74.0</value>
               </measureType>
            </healthProfile>
         </person>
      </ns2:readPersonResponse>
   </S:Body>
</S:Envelope>
```
* **Request #3**: updatePerson(Person p) => Person | should update the Personal information of the Person identified by {id} (e.g., only the Person's information, not the measures of the health profile)
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sw="http://sw.soap.processcentricservices.systemlogic/">
   <soapenv:Header/>
   <soapenv:Body>
      <sw:updatePerson>
         <!--Optional:-->
         <person>
            <!--Optional:-->
            <idPerson>1</idPerson>
            <firstname>update name</firstname>
            <lastname>update last name</lastname>
         </person>
      </sw:updatePerson>
   </soapenv:Body>
</soapenv:Envelope>
```
* **Request #4:** createPerson(Person p) => Person | should create a new Person and return the newly created Person with its assigned id (if a health profile is included, create also those measurements for the new Person).
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sw="http://sw.soap.processcentricservices.systemlogic/">
   <soapenv:Header/>
   <soapenv:Body>
      <sw:createPerson>
         <!--Optional:-->
         <person>
            <firstname>new person</firstname>
            <lastname>new lasname</lastname>         
         </person>
      </sw:createPerson>
   </soapenv:Body>
</soapenv:Envelope>
```
* **Request #5:** deletePerson(Long id) should delete the Person identified by {id} from the system
* **Request #6:** readPersonHistory(Long id, String measureType) => List should return the list of values (the history) of {measureType} (e.g. weight) for Person identified by {id}
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sw="http://sw.soap.processcentricservices.systemlogic/">
   <soapenv:Header/>
   <soapenv:Body>
      <sw:readPersonHistory>
         <!--Optional:-->
         <personId>1</personId>
         <!--Optional:-->
         <type>weight</type>
      </sw:readPersonHistory>
   </soapenv:Body>
</soapenv:Envelope>
```
* **Request #7:** readMeasureTypes() => List should return the list of measures
```
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <ns2:readMeasureTypesResponse xmlns:ns2="http://sw.soap.processcentricservices.systemlogic/">
         <MeasureProfile>
            <measureType>weight</measureType>
            <measureType>heigth</measureType>
            <measureType>heart</measureType>
         </MeasureProfile>
      </ns2:readMeasureTypesResponse>
   </S:Body>
</S:Envelope>
```
* **Request #8:**  readPersonMeasure(Long id, String measureType, Long mid) => Measure should return the value of {measureType} (e.g. weight) identified by {mid} for Person identified by {id}
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sw="http://sw.soap.processcentricservices.systemlogic/">
   <soapenv:Header/>
   <soapenv:Body>
      <sw:readPersonMeasure>
         <!--Optional:-->
         <personId>1</personId>
         <!--Optional:-->
         <type>weight</type>
         <!--Optional:-->
         <mid>4</mid>
      </sw:readPersonMeasure>
   </soapenv:Body>
</soapenv:Envelope>
```
* **Request #9:** savePersonMeasure(Long id, Measure m) =>should save a new measure object {m} (e.g. weight) of Person identified by {id} and archive the old value in the history
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sw="http://sw.soap.processcentricservices.systemlogic/">
   <soapenv:Header/>
   <soapenv:Body>
      <sw:savePersonMeasure>
         <!--Optional:-->
         <personId>1</personId>
         <!--Optional:-->
         <measure>weight</measure>
         <!--Optional:-->
         <value>12345</value>
         <!--Optional:-->
         <data>2015-10-10</data>
      </sw:savePersonMeasure>
   </soapenv:Body>
</soapenv:Envelope>
```



**How to run:**

Running the project requires java and ant.

Ant source file build.xml is annotated. 
* Main targets are: 
* **start:** To start the local server.





**References:**

https://docs.google.com/document/d/1kcRTSzxkvRPT5Lp3A1eqqR51NNqHHHbmHFrjZKqs4Kc/edit#

