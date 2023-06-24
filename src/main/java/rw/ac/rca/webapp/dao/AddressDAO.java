/**
 * 
 */
package rw.ac.rca.webapp.dao;

import rw.ac.rca.webapp.orm.Address;

import java.util.List;

/**
 * @author Aphrodice Rwagaju
 *
 */
public interface AddressDAO {
	public Address saveAddress(Address address);
	public Address updateAddress(Address address);
	public Address saveOrUpdateAddress(Address address);
	public boolean deleteAddress(int address);
	public Address getAddressById(int addressId);
	public List<Address> getAllAddresses();
}
