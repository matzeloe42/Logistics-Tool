package com.logisticstool.logisticstool;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named("customerWithAddressController")
@SessionScoped
public class CustomerWithAddressController implements Serializable
{

    // Entity Beans
    /*    
    @EJB
    private com.logisticstool.logisticstool.CustomerAddressFacade ejbCustomerAddressFacade;
    
    private CustomerAddressFacade getCustomerAddressFacade()
    {
        return ejbCustomerAddressFacade;
    }*/
    
    @EJB
    private com.logisticstool.logisticstool.AddressFacade ejbAddressFacade;
    @EJB
    private com.logisticstool.logisticstool.CustomerFacade ejbCustomerFacade;
    @EJB
    private com.logisticstool.logisticstool.PlaceFacade ejbPlaceFacade;

    // Bean List
    private List<Address> addressItems = null;
    private List<Customer> customerItems = null;
    private List<Place> placeItems = null;

    // Bean Objects
    private Address address = new Address();
    private Customer customer = new Customer();
    private Place place = new Place();

    public CustomerWithAddressController()
    {
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public Place getPlace()
    {
        return place;
    }

    public void setPlace(Place place)
    {
        this.place = place;
    }

    private AddressFacade getAddressFacade()
    {
        return ejbAddressFacade;
    }

    private CustomerFacade getCustomerFacade()
    {
        return ejbCustomerFacade;
    }

    private PlaceFacade getPlaceFacade()
    {
        return ejbPlaceFacade;
    }

    public List<Address> getAddressItems()
    {
        if (addressItems == null)
        {
            addressItems = getAddressFacade().findAll();
        }
        return addressItems;
    }

    public List<Customer> getCustomerItems()
    {
        if (customerItems == null)
        {
            customerItems = getCustomerFacade().findAll();
            //customerItems = filterCustomerItemsByCustomerAddress();
        }
        return customerItems;
    }

    /*
    private List<Customer> filterCustomerItemsByCustomerAddress()
    {
        List<Customer> customersFromDB = new ArrayList();
        List<CustomerAddress> customerAddressesFromDB = getCustomerAddressFacade().findAll();
        List<Address> addressesFromDB = getAddressFacade().findAll();
        
        for(int i = 0; i < customerItems.size(); i++)
        {
            Customer customerToAdd = customerItems.get(i);
            for(int j = 0; j < addressesFromDB.size(); j++)
            {
                for(int x = 0; x < customerAddressesFromDB.size(); x++)
                {
                    if
                    (
                        customerAddressesFromDB.get(x).getAddressID() == addressesFromDB.get(j).getAddressID() &&
                        customerAddressesFromDB.get(x).getCustomerID() == customerToAdd.getCustomerID()
                    )
                    {
                        HashSet<Address> customerAddressesToAdd;
                        if(customerToAdd.getCustomerAddress().isEmpty())
                        {
                            customerAddressesToAdd = new HashSet();
                        }
                        else
                        {
                            customerAddressesToAdd = (HashSet) customerToAdd.getCustomerAddress();
                        }
                        customerAddressesToAdd.add(addressesFromDB.get(j));
                        customerToAdd.setCustomerAddress(customerAddressesToAdd);
                        
                        customersFromDB.add(customerToAdd);
                    }
                }
            }
        }
        
        return customersFromDB;
    }*/

    public List<Place> getPlaceItems()
    {
        if (placeItems == null)
        {
            placeItems = getPlaceFacade().findAll();
        }
        return placeItems;
    }

    public Address getAddress(java.lang.Integer id)
    {
        return getAddressFacade().find(id);
    }

    public List<Address> getAddressItemsAvailableSelectMany()
    {
        return getAddressFacade().findAll();
    }

    public List<Address> getAddressItemsAvailableSelectOne()
    {
        return getAddressFacade().findAll();
    }

    public Customer getCustomer(java.lang.Integer id)
    {
        return getCustomerFacade().find(id);
    }

    public List<Customer> getCustomerItemsAvailableSelectMany()
    {
        return getCustomerFacade().findAll();
    }

    public List<Customer> getCustomerItemsAvailableSelectOne()
    {
        return getCustomerFacade().findAll();
    }

    public Place getPlace(java.lang.Integer id)
    {
        return getPlaceFacade().find(id);
    }

    public List<Place> getPlaceItemsAvailableSelectMany()
    {
        return getPlaceFacade().findAll();
    }

    public List<Place> getPlaceItemsAvailableSelectOne()
    {
        return getPlaceFacade().findAll();
    }

    public void create()
    {
        try
        {
            if (checkKnownCustomer())
            {
                FacesMessage m = new FacesMessage(
                        "Anlegen fehlgeschlagen.",
                        "Kunde " + customer.getFirstName() + " " + customer.getLastName() + " bereits bekannt."
                );
                FacesContext.getCurrentInstance().addMessage("CustomerWithAddressCreateForm", m);
            }
            else
            {
                createPlace();
                createAddress();
                createCustomer();

                FacesMessage m = new FacesMessage(
                        "Anlegung erfolgreich",
                        "Kunde " + customer.getFirstName() + " " + customer.getLastName() + " erfolgreich angelegt."
                );
                FacesContext.getCurrentInstance().addMessage("CustomerWithAddressCreateForm", m);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private boolean checkKnownCustomer()
    {
        if (addressCheck() && customerCheck() && placeCheck())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private void createAddress()
    {
        address.setPlaceZIP(place);
    }

    private void createCustomer()
    {
        if(customer.getHabitation() == null)
        {
            customer.habitate(address);
        }
        getCustomerFacade().edit(customer);
    }

    private void createPlace()
    {
        if(placeCheck())
        {
            getPlaceFacade().edit(place);
        }
    }

    private boolean addressCheck()
    {
        boolean isKnown = false;
        addressItems = getAddressFacade().findAll();

        for (int i = 0; i < addressItems.size(); i++)
        {
            if(addressItems.get(i).getStreet().equals(address.getStreet()))
            {
                if(addressItems.get(i).getHousenumber().equals(address.getHousenumber()))
                {
                    isKnown = true;
                    i = addressItems.size();
                }
            }
        }

        return isKnown;
    }

    private boolean customerCheck()
    {
        boolean isKnown = false;
        customerItems = getCustomerFacade().findAll();
        int customerItemsCount = customerItems.size();

        for (int i = 0; i < customerItemsCount; i++)
        {
            if
                (
                    customerItems.get(i).getFirstName().equals(customer.getFirstName()) &&
                    customerItems.get(i).getLastName().equals(customer.getLastName())
                )
            {
                isKnown = true;
                i = customerItemsCount;
            }
        }

        return isKnown;
    }

    private boolean placeCheck()
    {
        boolean isKnown = false;
        placeItems = getPlaceFacade().findAll();
        int placeItemsCount = placeItems.size();

        for (int i = 0; i < placeItemsCount; i++)
        {
            if
                (
                    placeItems.get(i).getPlace().equals(place.getPlace()) &&
                    placeItems.get(i).getZip().equals(place.getZip())
                )
            {
                    isKnown = true;
                    i = placeItemsCount;
            }
        }

        return isKnown;
    }

    public void update()
    {
        //
    }

    public void destroy()
    {
        //
    }

}