/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logisticstool.logisticstool;

import java.io.Serializable;
import java.util.Collection;
import java.util.*;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raphael
 */
@Entity
@Table(name = "customer")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerID", query = "SELECT c FROM Customer c WHERE c.customerID = :customerID"),
    @NamedQuery(name = "Customer.findByFirstName", query = "SELECT c FROM Customer c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Customer.findByLastName", query = "SELECT c FROM Customer c WHERE c.lastName = :lastName")
})
public class Customer implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CustomerID")
    private Integer customerID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "FirstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "LastName")
    private String lastName;

    /*
    @ManyToMany(mappedBy = "customerCollection")
    private Collection<Address> addressCollection;
    */
    @ManyToMany
    @JoinTable
    (
        schema = "LogisticsToolDB",
        name = "CustomerAddress",
        joinColumns =
            @JoinColumn
            (
                name = "Customer_CustomerID",
                referencedColumnName = "CustomerID"
            ),
        inverseJoinColumns =
            @JoinColumn
            (
                name = "Address_AddressID",
                referencedColumnName = "AddressID"
            )
    )
    private Set<Address> habitation;
    
    @ManyToMany(mappedBy = "customerCollection")
    private Collection<Creditadvice> creditadviceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerCustomerID")
    private Collection<Offer> offerCollection;

    public Customer()
    {
    }

    public Customer(Integer customerID)
    {
        this.customerID = customerID;
    }

    public Customer(Integer customerID, String firstName, String lastName)
    {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getCustomerID()
    {
        return customerID;
    }

    public void setCustomerID(Integer customerID)
    {
        this.customerID = customerID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Set<Address> getHabitation()
    {
        return habitation;
    }

    public void setHabitation(Set<Address> customerAddress)
    {
        this.habitation = customerAddress;
    }

    public void habitate(Address address)
    {
        if(this.habitation == null)
        {
            this.habitation = new HashSet();
        }
        this.habitation.add(address);
        
        if(address.getCustomers() == null)
        {
            address.setCustomers(new HashSet());
        }
        address.getCustomers().add(this);
    }
    /*
    public Address getFirstAddress()
    {
        List<Address> addressList = this.customerAddress;
        return addressList.get(0);
    }*/

    @XmlTransient
    public Collection<Creditadvice> getCreditadviceCollection()
    {
        return creditadviceCollection;
    }

    public void setCreditadviceCollection(Collection<Creditadvice> creditadviceCollection)
    {
        this.creditadviceCollection = creditadviceCollection;
    }

    @XmlTransient
    public Collection<Offer> getOfferCollection()
    {
        return offerCollection;
    }

    public void setOfferCollection(Collection<Offer> offerCollection)
    {
        this.offerCollection = offerCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (customerID != null ? customerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer))
        {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerID == null && other.customerID != null) || (this.customerID != null && !this.customerID.equals(other.customerID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.logisticstool.logisticstool.Customer[ customerID=" + customerID + " ]";
    }
    
}
