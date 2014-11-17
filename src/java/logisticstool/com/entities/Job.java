/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logisticstool.com.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matze
 */
@Entity
@Table(name = "JOB")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j"),
    @NamedQuery(name = "Job.findByJobid", query = "SELECT j FROM Job j WHERE j.jobid = :jobid"),
    @NamedQuery(name = "Job.findByCreationdate", query = "SELECT j FROM Job j WHERE j.creationdate = :creationdate"),
    @NamedQuery(name = "Job.findBySalestax", query = "SELECT j FROM Job j WHERE j.salestax = :salestax"),
    @NamedQuery(name = "Job.findByTotalsum", query = "SELECT j FROM Job j WHERE j.totalsum = :totalsum")
})
public class Job implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "JOBID")
    private Integer jobid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.DATE)
    private Date creationdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALESTAX")
    private int salestax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTALSUM")
    private int totalsum;
    @JoinColumn(name = "OFFERID", referencedColumnName = "OFFERID")
    @ManyToOne(optional = false)
    private Offer offerid;

    public Job()
    {
    }

    public Job(Integer jobid)
    {
        this.jobid = jobid;
    }

    public Job(Integer jobid, Date creationdate, int salestax, int totalsum)
    {
        this.jobid = jobid;
        this.creationdate = creationdate;
        this.salestax = salestax;
        this.totalsum = totalsum;
    }

    public Integer getJobid()
    {
        return jobid;
    }

    public void setJobid(Integer jobid)
    {
        this.jobid = jobid;
    }

    public Date getCreationdate()
    {
        return creationdate;
    }

    public void setCreationdate(Date creationdate)
    {
        this.creationdate = creationdate;
    }

    public int getSalestax()
    {
        return salestax;
    }

    public void setSalestax(int salestax)
    {
        this.salestax = salestax;
    }

    public int getTotalsum()
    {
        return totalsum;
    }

    public void setTotalsum(int totalsum)
    {
        this.totalsum = totalsum;
    }

    public Offer getOfferid()
    {
        return offerid;
    }

    public void setOfferid(Offer offerid)
    {
        this.offerid = offerid;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (jobid != null ? jobid.hashCode() : 0);
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
        if ((this.jobid == null && other.jobid != null) || (this.jobid != null && !this.jobid.equals(other.jobid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "logisticstool.com.entities.Job[ jobid=" + jobid + " ]";
    }
    
}
