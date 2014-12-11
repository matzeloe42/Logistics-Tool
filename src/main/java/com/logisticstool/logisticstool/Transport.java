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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raphael
 */
@Entity
@Table(name = "transport")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Transport.findAll", query = "SELECT t FROM Transport t"),
    @NamedQuery(name = "Transport.findByTransportID", query = "SELECT t FROM Transport t WHERE t.transportID = :transportID")
})
public class Transport implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TransportID")
    private Integer transportID;
    @ManyToMany(mappedBy = "transportCollection")
    private Collection<Product> productCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transportTransportID")
    private Collection<Move> moveCollection;
    @JoinColumn(name = "DestinationAddress_DestinationAddressID", referencedColumnName = "DestinationAddressID")
    @ManyToOne(optional = false)
    private Destinationaddress destinationAddressDestinationAddressID;
    @JoinColumn(name = "StartAddress_StartAddressID", referencedColumnName = "StartAddressID")
    @ManyToOne(optional = false)
    private Startaddress startAddressStartAddressID;
    @OneToMany(mappedBy = "transportTransportID")
    private Collection<Offer> offerCollection;

    public Transport()
    {
    }

    public Transport(Integer transportID)
    {
        this.transportID = transportID;
    }

    public Integer getTransportID()
    {
        return transportID;
    }

    public void setTransportID(Integer transportID)
    {
        this.transportID = transportID;
    }

    @XmlTransient
    public Collection<Product> getProductCollection()
    {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection)
    {
        this.productCollection = productCollection;
    }

    @XmlTransient
    public Collection<Move> getMoveCollection()
    {
        return moveCollection;
    }

    public void setMoveCollection(Collection<Move> moveCollection)
    {
        this.moveCollection = moveCollection;
    }

    public Destinationaddress getDestinationAddressDestinationAddressID()
    {
        return destinationAddressDestinationAddressID;
    }

    public void setDestinationAddressDestinationAddressID(Destinationaddress destinationAddressDestinationAddressID)
    {
        this.destinationAddressDestinationAddressID = destinationAddressDestinationAddressID;
    }

    public Startaddress getStartAddressStartAddressID()
    {
        return startAddressStartAddressID;
    }

    public void setStartAddressStartAddressID(Startaddress startAddressStartAddressID)
    {
        this.startAddressStartAddressID = startAddressStartAddressID;
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
        hash += (transportID != null ? transportID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transport))
        {
            return false;
        }
        Transport other = (Transport) object;
        if ((this.transportID == null && other.transportID != null) || (this.transportID != null && !this.transportID.equals(other.transportID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.logisticstool.logisticstool.Transport[ transportID=" + transportID + " ]";
    }
    
}
