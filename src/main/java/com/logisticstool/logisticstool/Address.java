/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logisticstool.logisticstool;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raphael
 */
@Entity
@Table(name = "address")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByAddressID", query = "SELECT a FROM Address a WHERE a.addressID = :addressID"),
    @NamedQuery(name = "Address.findByStreet", query = "SELECT a FROM Address a WHERE a.street = :street"),
    @NamedQuery(name = "Address.findByHousenumber", query = "SELECT a FROM Address a WHERE a.housenumber = :housenumber")
})
public class Address implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AddressID")
    private Integer addressID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Street")
    private String street;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Housenumber")
    private String housenumber;
    @JoinColumn(name = "Place_ZIP", referencedColumnName = "ZIP")
    @ManyToOne(optional = false)
    private Place placeZIP;
    @ManyToMany(mappedBy="habitation")
    private Set<Customer> customers;

    public Address()
    {
    }

    public Address(Integer addressID)
    {
        this.addressID = addressID;
    }

    public Address(Integer addressID, String street, String housenumber)
    {
        this.addressID = addressID;
        this.street = street;
        this.housenumber = housenumber;
    }

    public Integer getAddressID()
    {
        return addressID;
    }

    public void setAddressID(Integer addressID)
    {
        this.addressID = addressID;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getHousenumber()
    {
        return housenumber;
    }

    public void setHousenumber(String housenumber)
    {
        this.housenumber = housenumber;
    }

    public Place getPlaceZIP()
    {
        return placeZIP;
    }

    public void setPlaceZIP(Place placeZIP)
    {
        this.placeZIP = placeZIP;
    }
    
    public Set<Customer> getCustomers()
    {
        return customers;
    }
    
    public void setCustomers(Set<Customer> customers)
    {
        this.customers = customers;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (addressID != null ? addressID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address))
        {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressID == null && other.addressID != null) || (this.addressID != null && !this.addressID.equals(other.addressID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.logisticstool.logisticstool.Address[ addressID=" + addressID + " ]";
    }

}