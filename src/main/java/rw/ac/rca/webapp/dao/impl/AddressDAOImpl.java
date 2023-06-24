package rw.ac.rca.webapp.dao.impl;

import org.hibernate.Query;
import rw.ac.rca.webapp.dao.AddressDAO;
import rw.ac.rca.webapp.orm.Address;
import rw.ac.rca.webapp.orm.User;

import java.util.List;

public class AddressDAOImpl extends DAO implements AddressDAO {
    private static AddressDAOImpl instance;

    private AddressDAOImpl(){}

    public static  AddressDAOImpl getInstance(){
        if(instance == null){
            return new AddressDAOImpl();
        }
        return instance;
    }


    @Override
    public Address saveAddress(Address address) {
        try{
            begin();
            getSession().save(address);
            commit();
            return address;
        }
        catch (Exception e){
            rollback();
            return null;
        }
    }

    @Override
    public Address updateAddress(Address address) {
        try{
            begin();
            getSession().update(address);
            commit();
            return  address;
        }
        catch (Exception e){
            rollback();
            return null;
        }
    }

    @Override
    public Address saveOrUpdateAddress(Address address) {
        try{
            begin();
            getSession().saveOrUpdate(address);
            commit();
            return address;
        }
        catch (Exception e){
            rollback();
            return null;
        }
    }


    @Override
    public boolean deleteAddress(int address) {
        try{
            begin();
            Query query = getSession().createQuery("from Address where id= :ref");
            query.setInteger("ref", address);
            Address address1 = (Address) query.uniqueResult();
            getSession().delete(address1);
            commit();
            return  true;
        }
        catch (Exception e){
            rollback();
            return false;
        }
    }

    @Override
    public Address getAddressById(int addressId) {
        try {
            begin();
            Query query = getSession().createQuery("from Address where id= :ref");
            query.setInteger("ref", addressId);
            Address address = (Address) query.uniqueResult();
            commit();
            return address;
        } catch (Exception e) {
            System.out.println("keke look "+ e);
            e.printStackTrace();
            rollback();
            return null;
        }
    }

    @Override
    public List<Address> getAllAddresses() {
        try{
            begin();
            Query query = getSession().createQuery("from Address");
            List<Address> addresses = query.list();
            commit();
            return addresses;
        }
        catch (Exception e){
            System.out.println("keke look "+ e);
            e.printStackTrace();
            rollback();
            return null;
        }
    }
}
