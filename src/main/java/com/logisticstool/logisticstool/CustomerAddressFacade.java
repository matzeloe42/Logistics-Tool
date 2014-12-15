package com.logisticstool.logisticstool;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Matze
 */
@Stateless
public class CustomerAddressFacade extends AbstractFacade<CustomerAddress>
{
    @PersistenceContext(unitName = "com.logisticstool_LogisticsTool_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public CustomerAddressFacade()
    {
        super(CustomerAddress.class);
    }
    
}
