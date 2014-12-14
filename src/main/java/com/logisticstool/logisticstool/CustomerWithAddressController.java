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

    @EJB
    private com.logisticstool.logisticstool.AddressFacade ejbAddressFacade;
    @EJB
    private com.logisticstool.logisticstool.CustomerFacade ejbCustomerFacade;
    @EJB
    private com.logisticstool.logisticstool.PlaceFacade ejbPlaceFacade;
    private List<Address> addressItems = null;
    private List<Customer> customerItems = null;
    private List<Place> placeItems = null;
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

    public void create()
    {
        try
        {
            createPlace();
            createCustomer();
            createAddress();
            
            FacesMessage m = new FacesMessage
                                (
                                    "Anlegung erfolgreich",
                                    "Kunde " + customer.getFirstName() + " " + customer.getLastName() + " erfolgreich angelegt."
                                );
            FacesContext.getCurrentInstance().addMessage("CustomerWithAddressCreateForm", m);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void createAddress()
    {
        if(addressItems == null)
        {
            addressItems = getAddressFacade().findAll();
        }
        
        // Abfrage zur Überprüfung der Benutzerdaten vorschalten!
        if(true)
        {
            address.setPlaceZIP(place);
            if(addressItems.size() == 0)
            {
                address.setAddressID(1);
                getAddressFacade().edit(address);
            }
            else
            {
                
            }
        }
    }

    private void createCustomer()
    {
        if(customerItems == null)
        {
            customerItems = getCustomerFacade().findAll();
        }
        
        // Abfrage zur Überprüfung der Benutzerdaten vorschalten!
        if(true)
        {
            getCustomerFacade().edit(customer);
        }
    }

    private void createPlace()
    {
        if(placeItems == null)
        {
            placeItems = getPlaceFacade().findAll();
        }
        
        // Abfrage zur Überprüfung der Benutzerdaten vorschalten!
        if(true)
        {
            getPlaceFacade().edit(place);
        }
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
