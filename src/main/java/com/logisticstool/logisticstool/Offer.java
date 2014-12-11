/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logisticstool.logisticstool;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raphael
 */
@Entity
@Table(name = "offer")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Offer.findAll", query = "SELECT o FROM Offer o"),
    @NamedQuery(name = "Offer.findByOfferID", query = "SELECT o FROM Offer o WHERE o.offerID = :offerID"),
    @NamedQuery(name = "Offer.findByCreationDate", query = "SELECT o FROM Offer o WHERE o.creationDate = :creationDate"),
    @NamedQuery(name = "Offer.findBySalestax", query = "SELECT o FROM Offer o WHERE o.salestax = :salestax")
})
public class Offer implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OfferID")
    private Integer offerID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Salestax")
    private BigDecimal salestax;
    @JoinColumn(name = "Customer_CustomerID", referencedColumnName = "CustomerID")
    @ManyToOne(optional = false)
    private Customer customerCustomerID;
    @JoinColumn(name = "Move_MoveID", referencedColumnName = "MoveID")
    @ManyToOne
    private Move moveMoveID;
    @JoinColumn(name = "Storage_StorageID", referencedColumnName = "StorageID")
    @ManyToOne
    private Storage storageStorageID;
    @JoinColumn(name = "Transport_TransportID", referencedColumnName = "TransportID")
    @ManyToOne
    private Transport transportTransportID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offerOfferID")
    private Collection<Job> jobCollection;

    public Offer()
    {
    }

    public Offer(Integer offerID)
    {
        this.offerID = offerID;
    }

    public Offer(Integer offerID, Date creationDate, BigDecimal salestax)
    {
        this.offerID = offerID;
        this.creationDate = creationDate;
        this.salestax = salestax;
    }

    public Integer getOfferID()
    {
        return offerID;
    }

    public void setOfferID(Integer offerID)
    {
        this.offerID = offerID;
    }

    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    public BigDecimal getSalestax()
    {
        return salestax;
    }

    public void setSalestax(BigDecimal salestax)
    {
        this.salestax = salestax;
    }

    public Customer getCustomerCustomerID()
    {
        return customerCustomerID;
    }

    public void setCustomerCustomerID(Customer customerCustomerID)
    {
        this.customerCustomerID = customerCustomerID;
    }

    public Move getMoveMoveID()
    {
        return moveMoveID;
    }

    public void setMoveMoveID(Move moveMoveID)
    {
        this.moveMoveID = moveMoveID;
    }

    public Storage getStorageStorageID()
    {
        return storageStorageID;
    }

    public void setStorageStorageID(Storage storageStorageID)
    {
        this.storageStorageID = storageStorageID;
    }

    public Transport getTransportTransportID()
    {
        return transportTransportID;
    }

    public void setTransportTransportID(Transport transportTransportID)
    {
        this.transportTransportID = transportTransportID;
    }

    @XmlTransient
    public Collection<Job> getJobCollection()
    {
        return jobCollection;
    }

    public void setJobCollection(Collection<Job> jobCollection)
    {
        this.jobCollection = jobCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (offerID != null ? offerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offer))
        {
            return false;
        }
        Offer other = (Offer) object;
        if ((this.offerID == null && other.offerID != null) || (this.offerID != null && !this.offerID.equals(other.offerID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.logisticstool.logisticstool.Offer[ offerID=" + offerID + " ]";
    }
    
}
