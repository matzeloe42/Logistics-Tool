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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "move")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Move.findAll", query = "SELECT m FROM Move m"),
    @NamedQuery(name = "Move.findByMoveID", query = "SELECT m FROM Move m WHERE m.moveID = :moveID")
})
public class Move implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MoveID")
    private Integer moveID;
    @JoinTable(name = "moveservice", joinColumns =
    {
        @JoinColumn(name = "Move_MoveID", referencedColumnName = "MoveID")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Service_ServiceID", referencedColumnName = "ServiceID")
    })
    @ManyToMany
    private Collection<Service> serviceCollection;
    @JoinColumn(name = "Transport_TransportID", referencedColumnName = "TransportID")
    @ManyToOne(optional = false)
    private Transport transportTransportID;
    @OneToMany(mappedBy = "moveMoveID")
    private Collection<Offer> offerCollection;

    public Move()
    {
    }

    public Move(Integer moveID)
    {
        this.moveID = moveID;
    }

    public Integer getMoveID()
    {
        return moveID;
    }

    public void setMoveID(Integer moveID)
    {
        this.moveID = moveID;
    }

    @XmlTransient
    public Collection<Service> getServiceCollection()
    {
        return serviceCollection;
    }

    public void setServiceCollection(Collection<Service> serviceCollection)
    {
        this.serviceCollection = serviceCollection;
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
        hash += (moveID != null ? moveID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Move))
        {
            return false;
        }
        Move other = (Move) object;
        if ((this.moveID == null && other.moveID != null) || (this.moveID != null && !this.moveID.equals(other.moveID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.logisticstool.logisticstool.Move[ moveID=" + moveID + " ]";
    }
    
}
