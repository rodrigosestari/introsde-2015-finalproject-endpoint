package systemlogic.processcentricservices.soap.endpoint;
import java.net.InetAddress;

import javax.xml.ws.Endpoint;

import systemlogic.processcentricservices.soap.sw.HealthImpl;


public class HealthPublisher {
	
	public static void main(String[] args) throws Exception {
        String PROTOCOL = "http://";
        String HOSTNAME = InetAddress.getLocalHost().getHostAddress();
        if (HOSTNAME.equals("127.0.0.1"))
        {
            HOSTNAME = "localhost";
        }
        String PORT = "6902";
        String BASE_URL = "/ws/health";

        if (String.valueOf(System.getenv("PORT")) != "null"){
            PORT=String.valueOf(System.getenv("PORT"));
        }
        
        String endpointUrl = PROTOCOL+HOSTNAME+":"+PORT+BASE_URL;
        System.out.println("Starting Health Service...");
        System.out.println("--> Published. Check out "+endpointUrl+"?wsdl");
        Endpoint.publish(endpointUrl, new HealthImpl());
    }
}
