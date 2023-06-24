 /**
 * 
 */
package rw.ac.rca.webapp.orm;

 import javax.persistence.*;
 import java.io.Serializable;
 import java.util.List;

/**
 * @author Aphrodice Rwagaju
 *
 */
@Entity
public class Student extends Person implements Serializable {


	private static final long serialVersionUID = -8680703317249517930L;

	private Boolean international;


	public Boolean getInternational() {
		return international;
	}

	public void setInternational(Boolean international) {
		this.international = international;
	}

	public Boolean getRepeating() {
		return repeating;
	}

	public void setRepeating(Boolean repeating) {
		this.repeating = repeating;
	}

	public Boolean getPartTime() {
		return partTime;
	}

	public void setPartTime(Boolean partTime) {
		this.partTime = partTime;
	}

	public List<Enrol> getEnrols() {
		return enrols;
	}

	public void setEnrols(List<Enrol> enrols) {
		this.enrols = enrols;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	private Boolean repeating;
	private Boolean partTime;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "student")
	private List<Enrol> enrols;

	@ManyToOne
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

	public List<Parents> getParents() {
		return parents;
	}

	public void setParents(List<Parents> parents) {
		this.parents = parents;
	}

	@OneToMany(mappedBy = "student")
    private List<Parents> parents;
}