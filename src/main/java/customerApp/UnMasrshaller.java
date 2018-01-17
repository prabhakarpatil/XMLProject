package customerApp;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import customerJavaClasses.Customer;

public class UnMasrshaller {
	public static void main(String[] args) throws DatatypeConfigurationException {
		try {

			File file = new File("C:\\temp\\customerData.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
			System.out.println(ReflectionToStringBuilder.toString(customer));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
