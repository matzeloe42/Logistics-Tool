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
@Table(name = "creditadvice")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Creditadvice.findAll", query = "SELECT c FROM Creditadvice c"),
    @NamedQuery(name = "Creditadvice.findByCreditadviceID", query = "SELECT c FROM Creditadvice c WHERE c.creditadviceID = :creditadviceID"),
    @NamedQuery(name = "Creditadvice.findByCreditadviceDate", query = "SELECT c FROM Creditadvice c WHERE c.creditadviceDate = :creditadviceDate"),
    @NamedQuery(name = "Creditadvice.findByAmount", query = "SELECT c FROM Creditadvice c WHERE c.amount = :amount")
})
public class Creditadvice implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CreditadviceID")
    private Integer creditadviceID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreditadviceDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creditadviceDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount")
    private BigDecimal amount;
    @JoinTable(name = "customercreditadvice", joinColumns =
    {
        @JoinColumn(name = "Creditadvice_CreditadviceID", referencedColumnName = "CreditadviceID")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Customer_CustomerID", referencedColumnName = "CustomerID")
    })
    @ManyToMany
    private Collection<Customer> customerCollection;
    @JoinTable(name = "salescreditadvice", joinColumns =
    {
        @JoinColumn(name = "Creditadvice_CreditadviceID", referencedColumnName = "CreditadviceID")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Sales_SalesID", referencedColumnName = "SalesID")
    })
    @ManyToMany
    private Collection<Sales> salesCollection;

    public Creditadvice()
    {
    }

    public Creditadvice(Integer creditadviceID)
    {
        this.creditadviceID = creditadviceID;
    }

    public Creditadvice(Integer creditadviceID, Date creditadviceDate, BigDecimal amount)
    {
        this.creditadviceID = creditadviceID;
        this.creditadviceDate = creditadviceDate;
        this.amount = amount;
    }

    public Integer getCreditadviceID()
    {
        return creditadviceID;
    }

    public void setCreditadviceID(Integer creditadviceID)
    {
        this.creditadviceID = creditadviceID;
    }

    public Date getCreditadviceDate()
    {
        return creditadviceDate;
    }

    public void setCreditadviceDate(Date creditadviceDate)
    {
        this.creditadviceDate = creditadviceDate;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection()
    {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection)
    {
        this.customerCollection = customerCollection;
    }

    @XmlTransient
    public Collection<Sales> getSalesCollection()
    {
        return salesCollection;
    }

    public void setSalesCollection(Collection<Sales> salesCollection)
    {
        this.salesCollection = salesCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (creditadviceID != null ? creditadviceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Creditadvice))
        {
            return false;
        }
        Creditadvice other = (Creditadvice) object;
        if ((this.creditadviceID == null && other.creditadviceID != null) || (this.creditadviceID != null && !this.creditadviceID.equals(other.creditadviceID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.logisticstool.logisticstool.Creditadvice[ creditadviceID=" + creditadviceID + " ]";
    }
    
}
