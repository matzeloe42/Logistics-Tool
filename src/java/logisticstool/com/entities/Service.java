/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logisticstool.com.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matze
 */
@Entity
@Table(name = "SERVICE")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s"),
    @NamedQuery(name = "Service.findByServiceid", query = "SELECT s FROM Service s WHERE s.serviceid = :serviceid"),
    @NamedQuery(name = "Service.findByDenotation", query = "SELECT s FROM Service s WHERE s.denotation = :denotation"),
    @NamedQuery(name = "Service.findByPrize", query = "SELECT s FROM Service s WHERE s.prize = :prize")
})
public class Service implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SERVICEID")
    private Integer serviceid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DENOTATION")
    private String denotation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIZE")
    private int prize;

    public Service()
    {
    }

    public Service(Integer serviceid)
    {
        this.serviceid = serviceid;
    }

    public Service(Integer serviceid, String denotation, int prize)
    {
        this.serviceid = serviceid;
        this.denotation = denotation;
        this.prize = prize;
    }

    public Integer getServiceid()
    {
        return serviceid;
    }

    public void setServiceid(Integer serviceid)
    {
        this.serviceid = serviceid;
    }

    public String getDenotation()
    {
        return denotation;
    }

    public void setDenotation(String denotation)
    {
        this.denotation = denotation;
    }

    public int getPrize()
    {
        return prize;
    }

    public void setPrize(int prize)
    {
        this.prize = prize;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (serviceid != null ? serviceid.hashCode() : 0);
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
        if ((this.serviceid == null && other.serviceid != null) || (this.serviceid != null && !this.serviceid.equals(other.serviceid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "logisticstool.com.entities.Service[ serviceid=" + serviceid + " ]";
    }
    
}
