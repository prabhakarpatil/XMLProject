package customerJSON;



import java.util.Date;

import customerJavaClasses.Address;
import customerJavaClasses.CardInfo;

public class CustomerJSON {
	
	int customerID;
	String name;
	Date dateofBirth;
	float annualSalary;
	Address address;
	CardInfo card;
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	public float getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(float annualSalary) {
		this.annualSalary = annualSalary;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public CardInfo getCard() {
		return card;
	}
	public void setCard(CardInfo card) {
		this.card = card;
	}

	
	
	

}
