package collectionType;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
	private int id;
	private String name;
	private List<String> address;
	private Set<Long> contact;
	private Map<Integer, String> bankDetails;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
	public Set<Long> getContact() {
		return contact;
	}
	public void setContact(Set<Long> contact) {
		this.contact = contact;
	}
	public Map<Integer, String> getBankDetails() {
		return bankDetails;
	}
	public void setBankDetails(Map<Integer, String> bankDetails) {
		this.bankDetails = bankDetails;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", contact=" + contact + ", bankDetails="
				+ bankDetails + "]";
	}
	
}
 