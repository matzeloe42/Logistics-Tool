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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "startaddress")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Startaddress.findAll", query = "SELECT s FROM Startaddress s"),
    @NamedQuery(name = "Startaddress.findByStartAddressID", query = "SELECT s FROM Startaddress s WHERE s.startAddressID = :startAddressID"),
    @NamedQuery(name = "Startaddress.findByStreet", query = "SELECT s FROM Startaddress s WHERE s.street = :street"),
    @NamedQuery(name = "Startaddress.findByHousenumber", query = "SELECT s FROM Startaddress s WHERE s.housenumber = :housenumber")
})
public class Startaddress implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StartAddressID")
    private Integer startAddressID;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "startAddressStartAddressID")
    private Collection<Transport> transportCollection;

    public Startaddress()
    {
    }

    public Startaddress(Integer startAddressID)
    {
        this.startAddressID = startAddressID;
    }

    public Startaddress(Integer startAddressID, String street, String housenumber)
    {
        this.startAddressID = startAddressID;
        this.street = street;
        this.housenumber = housenumber;
    }

    public Integer getStartAddressID()
    {
        return startAddressID;
    }

    public void setStartAddressID(Integer startAddressID)
    {
        this.startAddressID = startAddressID;
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

    @XmlTransient
    public Collection<Transport> getTransportCollection()
    {
        return transportCollection;
    }

    public void setTransportCollection(Collection<Transport> transportCollection)
    {
        this.transportCollection = transportCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (startAddressID != null ? startAddressID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Startaddress))
        {
            return false;
        }
        Startaddress other = (Startaddress) object;
        if ((this.startAddressID == null && other.startAddressID != null) || (this.startAddressID != null && !this.startAddressID.equals(other.startAddressID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.logisticstool.logisticstool.Startaddress[ startAddressID=" + startAddressID + " ]";
    }
    
}
