/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logisticstool.logisticstool;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "place")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Place.findAll", query = "SELECT p FROM Place p"),
    @NamedQuery(name = "Place.findByZip", query = "SELECT p FROM Place p WHERE p.zip = :zip"),
    @NamedQuery(name = "Place.findByPlace", query = "SELECT p FROM Place p WHERE p.place = :place")
})
public class Place implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZIP")
    private Integer zip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "Place")
    private String place;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placeZIP")
    private Collection<Address> addressCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placeZIP")
    private Collection<Startaddress> startaddressCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placeZIP")
    private Collection<Destinationaddress> destinationaddressCollection;

    public Place()
    {
    }

    public Place(Integer zip)
    {
        this.zip = zip;
    }

    public Place(Integer zip, String place)
    {
        this.zip = zip;
        this.place = place;
    }

    public Integer getZip()
    {
        return zip;
    }

    public void setZip(Integer zip)
    {
        this.zip = zip;
    }

    public String getPlace()
    {
        return place;
    }

    public void setPlace(String place)
    {
        this.place = place;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection()
    {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection)
    {
        this.addressCollection = addressCollection;
    }

    @XmlTransient
    public Collection<Startaddress> getStartaddressCollection()
    {
        return startaddressCollection;
    }

    public void setStartaddressCollection(Collection<Startaddress> startaddressCollection)
    {
        this.startaddressCollection = startaddressCollection;
    }

    @XmlTransient
    public Collection<Destinationaddress> getDestinationaddressCollection()
    {
        return destinationaddressCollection;
    }

    public void setDestinationaddressCollection(Collection<Destinationaddress> destinationaddressCollection)
    {
        this.destinationaddressCollection = destinationaddressCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (zip != null ? zip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Place))
        {
            return false;
        }
        Place other = (Place) object;
        if ((this.zip == null && other.zip != null) || (this.zip != null && !this.zip.equals(other.zip)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.logisticstool.logisticstool.Place[ zip=" + zip + " ]";
    }
    
}
