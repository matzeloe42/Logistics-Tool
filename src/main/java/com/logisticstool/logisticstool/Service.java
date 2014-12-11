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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "service")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s"),
    @NamedQuery(name = "Service.findByServiceID", query = "SELECT s FROM Service s WHERE s.serviceID = :serviceID"),
    @NamedQuery(name = "Service.findByDenotation", query = "SELECT s FROM Service s WHERE s.denotation = :denotation"),
    @NamedQuery(name = "Service.findByPrize", query = "SELECT s FROM Service s WHERE s.prize = :prize")
})
public class Service implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ServiceID")
    private Integer serviceID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Denotation")
    private String denotation;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Prize")
    private BigDecimal prize;
    @ManyToMany(mappedBy = "serviceCollection")
    private Collection<Move> moveCollection;

    public Service()
    {
    }

    public Service(Integer serviceID)
    {
        this.serviceID = serviceID;
    }

    public Service(Integer serviceID, String denotation, BigDecimal prize)
    {
        this.serviceID = serviceID;
        this.denotation = denotation;
        this.prize = prize;
    }

    public Integer getServiceID()
    {
        return serviceID;
    }

    public void setServiceID(Integer serviceID)
    {
        this.serviceID = serviceID;
    }

    public String getDenotation()
    {
        return denotation;
    }

    public void setDenotation(String denotation)
    {
        this.denotation = denotation;
    }

    public BigDecimal getPrize()
    {
        return prize;
    }

    public void setPrize(BigDecimal prize)
    {
        this.prize = prize;
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

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (serviceID != null ? serviceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service))
        {
            return false;
        }
        Service other = (Service) object;
        if ((this.serviceID == null && other.serviceID != null) || (this.serviceID != null && !this.serviceID.equals(other.serviceID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.logisticstool.logisticstool.Service[ serviceID=" + serviceID + " ]";
    }
    
}
