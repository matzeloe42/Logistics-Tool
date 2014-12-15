package com.logisticstool.logisticstool;

import com.logisticstool.logisticstool.*;

public class CustomerWithAddress
{
    private Address customerAddress;
    private Customer customer;
    private Place customerPlace;
    
    public CustomerWithAddress(){}

    public Address getCustomerAddress()
    {
        return customerAddress;
    }

    public void setCustomerAddress(Address customerAddress)
    {
        this.customerAddress = customerAddress;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public Place getCustomerPlace()
    {
        return customerPlace;
    }

    public void setCustomerPlace(Place customerPlace)
    {
        this.customerPlace = customerPlace;
    }
}