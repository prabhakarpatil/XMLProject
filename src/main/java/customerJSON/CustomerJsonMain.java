package customerJSON;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import customerJSON.CustomerJSON;
import customerJSON.AddressJSON;
import customerJSON.PaymentJSON;

public class CustomerJsonMain {
	
	private static String FILE_PATH = "C:\\temp\\customerJSON.json";


	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		serialize();
		//deserialize();
		
		

	}

	private static void serialize() throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //convert Object to json string
        CustomerJSON cust = createCustomer();
        
        //configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
         
        //writing to console, can write to any output stream such as file
        objectMapper.writeValue(System.out, cust);
        objectMapper.writeValue(new PrintWriter("C:\\temp\\customerJSON.json"), cust);
	}

	public static void deserialize() throws IOException {
        
        byte[] jsonData = Files.readAllBytes(Paths.get(FILE_PATH));

        ObjectMapper objectMapper = new ObjectMapper();
         
        CustomerJSON cust = objectMapper.readValue(jsonData, CustomerJSON.class);
         
        System.out.println("Employee Object\n"+cust);
    }
	
	private static CustomerJSON createCustomer() {
		CustomerJSON cust = new CustomerJSON();
		cust.setCustomerID(100);
		cust.setName("Ameya");
		cust.setDateofBirth(new Date());
		cust.setAnnualSalary(10000.5f);
		
		PaymentJSON card = new PaymentJSON();
		card.setCardNumber(123456);
		card.setCardName("Ameya Patil");
		card.setDateFrom(new Date());
		card.setDateTo(new Date());
		card.setCardType("Credit");
 
		AddressJSON address = new AddressJSON();
		address.setStreetAddress("601 Summit Ave");
		address.setBillingAddress("219 Greek Row");
        return cust;
    }



}
