/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logisticstool.logisticstool;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Raphael
 */
@Stateless
public class TransportFacade extends AbstractFacade<Transport>
{
    @PersistenceContext(unitName = "com.logisticstool_LogisticsTool_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public TransportFacade()
    {
        super(Transport.class);
    }
    
}
