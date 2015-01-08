package com.logisticstool.logisticstool;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Matthias
 */
@Stateless
public class CustomerWithAddressFacade extends AbstractFacade<CustomerWithAddress>
{
    @PersistenceContext(unitName = "com.logisticstool_LogisticsTool_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public CustomerWithAddressFacade()
    {
        super(CustomerWithAddress.class);
    }
    
}
