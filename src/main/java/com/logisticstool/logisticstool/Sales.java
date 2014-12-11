/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logisticstool.logisticstool;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raphael
 */
@Entity
@Table(name = "sales")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Sales.findAll", query = "SELECT s FROM Sales s"),
    @NamedQuery(name = "Sales.findBySalesID", query = "SELECT s FROM Sales s WHERE s.salesID = :salesID")
})
public class Sales implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SalesID")
    private Integer salesID;
    @ManyToMany(mappedBy = "salesCollection")
    private Collection<Job> jobCollection;
    @ManyToMany(mappedBy = "salesCollection")
    private Collection<Creditadvice> creditadviceCollection;

    public Sales()
    {
    }

    public Sales(Integer salesID)
    {
        this.salesID = salesID;
    }

    public Integer getSalesID()
    {
        return salesID;
    }

    public void setSalesID(Integer salesID)
    {
        this.salesID = salesID;
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

    @XmlTransient
    public Collection<Creditadvice> getCreditadviceCollection()
    {
        return creditadviceCollection;
    }

    public void setCreditadviceCollection(Collection<Creditadvice> creditadviceCollection)
    {
        this.creditadviceCollection = creditadviceCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (salesID != null ? salesID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sales))
        {
            return false;
        }
        Sales other = (Sales) object;
        if ((this.salesID == null && other.salesID != null) || (this.salesID != null && !this.salesID.equals(other.salesID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.logisticstool.logisticstool.Sales[ salesID=" + salesID + " ]";
    }
    
}
