package com.logisticstool.logisticstool;

import com.logisticstool.logisticstool.util.JsfUtil;
import com.logisticstool.logisticstool.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("customerWithAddressController")
@SessionScoped
public class CustomerWithAddressController implements Serializable
{

    // Entity Beans

    @EJB
    private com.logisticstool.logisticstool.AddressFacade ejbAddressFacade;
    @EJB
    private com.logisticstool.logisticstool.CustomerFacade ejbCustomerFacade;
    //@EJB
    //private com.logisticstool.logisticstool.CustomerAddressFacade ejbCustomerAddressFacade;
    @EJB
    private com.logisticstool.logisticstool.PlaceFacade ejbPlaceFacade;

    // Bean List
    private List<Address> addressItems = null;
    private List<Customer> customerItems = null;
    private List<Place> placeItems = null;
    //private List<CustomerWithAddress> customerWithAddressItems = null;

    // Bean Objects
    private Address address = new Address();
    private Customer customer = new Customer();
    //private CustomerWithAddress customerWithAddress = new CustomerWithAddress();
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
        }
        return customerItems;
    }

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

    /*public List<CustomerWithAddress> getCustomerWithAddressItemsAvailableSelectMany()
    {
        return getCustomerWithAllValues();
    }

    public List<CustomerWithAddress> getCustomerWithAddressItemsAvailableSelectOne()
    {
        return getCustomerWithAllValues();
    }*/

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
                //createCustomerAddressRelation();

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

        for (int i = 0; i < customerItems.size(); i++)
        {
            if(customerItems.get(i).getFirstName().equals(customer.getFirstName()))
            {
                if(customerItems.get(i).getLastName().equals(customer.getLastName()))
                {
                    isKnown = true;
                    i = customerItems.size();
                }
            }
        }

        return isKnown;
    }

    private boolean placeCheck()
    {
        boolean isKnown = false;
        placeItems = getPlaceFacade().findAll();

        for (int i = 0; i < placeItems.size(); i++)
        {
            if( placeItems.get(i).getPlace().equals(place.getPlace()))
            {
                if(placeItems.get(i).getZip().equals(place.getZip()))
                {
                    isKnown = true;
                    i = customerItems.size();
                }
            }
        }

        return isKnown;
    }

    private void createAddress()
    {
        address.setPlaceZIP(place);
        //customerWithAddress.setCustomerAddress(address);
        getAddressFacade().edit(address);
    }

    private void createCustomer()
    {
        //customerWithAddress.setCustomer(customer);
        getCustomerFacade().edit(customer);
    }

    private void createPlace()
    {
        if(placeCheck() == false)
        {
            //customerWithAddress.setCustomerPlace(place);
            getPlaceFacade().edit(place);
        }
    }

/*    private void createCustomerAddressRelation()
    {
        List<Address> addressList = getAddressFacade().findAll();
        List<Customer> customerList = getCustomerFacade().findAll();        

        for (int i = 0; i < customerList.size(); i++)
        {
            if  (
                    //customerList.get(i).getFirstName().equals(customerWithAddress.getCustomer().getFirstName()) &&
                    //customerList.get(i).getLastName().equals(customerWithAddress.getCustomer().getLastName())
                    customerList.get(i).getFirstName().equals(customer.getFirstName()) &&
                    customerList.get(i).getLastName().equals(customer.getLastName())
                )
            {
                for(int j = 0; j < addressList.size(); j++)
                {
                    if  (
                            //addressList.get(j).getHousenumber().equals(customerWithAddress.getCustomerAddress().getHousenumber()) &&
                            //addressList.get(j).getPlaceZIP().getZip().equals(customerWithAddress.getCustomerPlace().getZip()) &&
                            //addressList.get(j).getStreet().equals(customerWithAddress.getCustomerAddress().getStreet())
                            addressList.get(j).getHousenumber().equals(address.getHousenumber()) &&
                            addressList.get(j).getPlaceZIP().getZip().equals(address.getPlaceZIP().getZip()) &&
                            addressList.get(j).getStreet().equals(address.getStreet())
                        )
                    {
                        CustomerAddress customerAddress = new CustomerAddress();
                        customerAddress.setAddressID(addressList.get(j).getAddressID());
                        customerAddress.setCustomerID(customerList.get(i).getCustomerID());
                        
                        ejbCustomerAddressFacade.edit(customerAddress);
                    }
                }
            }

        }
    }*/

    public void update()
    {
        //
    }

    public void destroy()
    {
        //
    }

/*    private List<CustomerWithAddress> getCustomerWithAllValues()
    {
        List<Customer> allCustomers = getCustomerItemsAvailableSelectMany();
        List<CustomerAddress> allCustomerAddresses = ejbCustomerAddressFacade.findAll();

        for (int i = 0; i < allCustomers.size(); i++)
        {

        }

        return null;
    }*/
}
