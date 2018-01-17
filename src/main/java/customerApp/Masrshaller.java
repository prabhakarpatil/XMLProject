package customerApp;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import customerJavaClasses.Address;
import customerJavaClasses.CardInfo;
import customerJavaClasses.Customer;

public class Masrshaller {
	public static void main(String[] args) throws DatatypeConfigurationException {
		try {

			File file = new File("C:\\temp\\customerData.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Customer customer = createCustomer();
			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	private static Customer createCustomer() throws DatatypeConfigurationException {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		
		//Customer
		Customer customer = new Customer();
		customer.setCustomerID(100);
		customer.setName("Ameya");
		customer.setDateOfBirth(date2);
		customer.setAnnualSalary(10000.2f);
		//customer.setAddress(address);
		
		
		
		//payment
		CardInfo card = new CardInfo();
		card.setCardNumber(123456);
		card.setCardName("Ameya Patil");
		card.setDateFrom(date2);
		card.setDateTo(date2);
		card.setCardType("Credit");
		customer.setPaymentMethod(card);
		
		//address
		Address address = new Address();
		address.setStreetAddress("601 Summit Ave");
		address.setBillingAddress("219 Greek Row");
		customer.setAddress(address);
		return customer;
		
		
	}
}
