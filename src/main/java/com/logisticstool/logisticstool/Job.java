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
import javax.persistence.ManyToOne;
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
@Table(name = "job")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j"),
    @NamedQuery(name = "Job.findByJobID", query = "SELECT j FROM Job j WHERE j.jobID = :jobID"),
    @NamedQuery(name = "Job.findByCreationDate", query = "SELECT j FROM Job j WHERE j.creationDate = :creationDate"),
    @NamedQuery(name = "Job.findBySalestax", query = "SELECT j FROM Job j WHERE j.salestax = :salestax"),
    @NamedQuery(name = "Job.findByTotalSum", query = "SELECT j FROM Job j WHERE j.totalSum = :totalSum")
})
public class Job implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "JobID")
    private Integer jobID;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "TotalSum")
    private BigDecimal totalSum;
    @JoinTable(name = "jobsales", joinColumns =
    {
        @JoinColumn(name = "Job_JobID", referencedColumnName = "JobID")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Sales_SalesID", referencedColumnName = "SalesID")
    })
    @ManyToMany
    private Collection<Sales> salesCollection;
    @JoinColumn(name = "Offer_OfferID", referencedColumnName = "OfferID")
    @ManyToOne(optional = false)
    private Offer offerOfferID;

    public Job()
    {
    }

    public Job(Integer jobID)
    {
        this.jobID = jobID;
    }

    public Job(Integer jobID, Date creationDate, BigDecimal salestax, BigDecimal totalSum)
    {
        this.jobID = jobID;
        this.creationDate = creationDate;
        this.salestax = salestax;
        this.totalSum = totalSum;
    }

    public Integer getJobID()
    {
        return jobID;
    }

    public void setJobID(Integer jobID)
    {
        this.jobID = jobID;
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

    public BigDecimal getTotalSum()
    {
        return totalSum;
    }

    public void setTotalSum(BigDecimal totalSum)
    {
        this.totalSum = totalSum;
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

    public Offer getOfferOfferID()
    {
        return offerOfferID;
    }

    public void setOfferOfferID(Offer offerOfferID)
    {
        this.offerOfferID = offerOfferID;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (jobID != null ? jobID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Job))
        {
            return false;
        }
        Job other = (Job) object;
        if ((this.jobID == null && other.jobID != null) || (this.jobID != null && !this.jobID.equals(other.jobID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.logisticstool.logisticstool.Job[ jobID=" + jobID + " ]";
    }
    
}
