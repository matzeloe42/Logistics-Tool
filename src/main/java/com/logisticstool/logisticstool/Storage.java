/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logisticstool.logisticstool;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raphael
 */
@Entity
@Table(name = "storage")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Storage.findAll", query = "SELECT s FROM Storage s"),
    @NamedQuery(name = "Storage.findByAmount", query = "SELECT s FROM Storage s WHERE s.amount = :amount"),
    @NamedQuery(name = "Storage.findByPrize", query = "SELECT s FROM Storage s WHERE s.prize = :prize"),
    @NamedQuery(name = "Storage.findByStorageID", query = "SELECT s FROM Storage s WHERE s.storageID = :storageID")
})
public class Storage implements Serializable
{
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount")
    private BigDecimal amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Prize")
    private BigDecimal prize;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StorageID")
    private Integer storageID;
    @OneToMany(mappedBy = "storageStorageID")
    private Collection<Offer> offerCollection;

    public Storage()
    {
    }

    public Storage(Integer storageID)
    {
        this.storageID = storageID;
    }

    public Storage(Integer storageID, BigDecimal amount, BigDecimal prize)
    {
        this.storageID = storageID;
        this.amount = amount;
        this.prize = prize;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public BigDecimal getPrize()
    {
        return prize;
    }

    public void setPrize(BigDecimal prize)
    {
        this.prize = prize;
    }

    public Integer getStorageID()
    {
        return storageID;
    }

    public void setStorageID(Integer storageID)
    {
        this.storageID = storageID;
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
        hash += (storageID != null ? storageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Storage))
        {
            return false;
        }
        Storage other = (Storage) object;
        if ((this.storageID == null && other.storageID != null) || (this.storageID != null && !this.storageID.equals(other.storageID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.logisticstool.logisticstool.Storage[ storageID=" + storageID + " ]";
    }
    
}
