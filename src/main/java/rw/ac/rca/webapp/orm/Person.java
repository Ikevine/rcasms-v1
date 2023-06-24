/**
 * 
 */
package rw.ac.rca.webapp.orm;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Aphrodice Rwagaju
 *
 */
@MappedSuperclass
public abstract class Person implements Serializable{
	
	private static final long serialVersionUID = 2173199134252447177L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	int id;

	private String fullName;
	private Date dateOfBirth;
	private String phoneNumber;
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Person() {
	}

	public Person(String fullName, Date dateOfBirth, String phoneNumber) {
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
	}

}
