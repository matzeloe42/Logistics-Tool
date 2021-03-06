package com.logisticstool.logisticstool;

import com.logisticstool.logisticstool.util.JsfUtil;
import com.logisticstool.logisticstool.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("userdataController")
@SessionScoped
public class UserdataController implements Serializable
{

    @EJB
    private com.logisticstool.logisticstool.UserdataFacade ejbFacade;
    private List<Userdata> items = null;
    private Userdata selected;

    public UserdataController()
    {
    }

    public Userdata getSelected()
    {
        return selected;
    }

    public void setSelected(Userdata selected)
    {
        this.selected = selected;
    }

    protected void setEmbeddableKeys()
    {
    }

    protected void initializeEmbeddableKey()
    {
    }

    private UserdataFacade getFacade()
    {
        return ejbFacade;
    }

    public Userdata prepareCreate()
    {
        selected = new Userdata();
        initializeEmbeddableKey();
        return selected;
    }

    public void create()
    {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UserdataCreated"));
        if (!JsfUtil.isValidationFailed())
        {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update()
    {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UserdataUpdated"));
    }

    public void destroy()
    {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("UserdataDeleted"));
        if (!JsfUtil.isValidationFailed())
        {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Userdata> getItems()
    {
        if (items == null)
        {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage)
    {
        if (selected != null)
        {
            setEmbeddableKeys();
            try
            {
                if (persistAction != PersistAction.DELETE)
                {
                    getFacade().edit(selected);
                } else
                {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex)
            {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null)
                {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0)
                {
                    JsfUtil.addErrorMessage(msg);
                } else
                {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex)
            {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Userdata getUserdata(java.lang.Integer id)
    {
        return getFacade().find(id);
    }

    public List<Userdata> getItemsAvailableSelectMany()
    {
        return getFacade().findAll();
    }

    public List<Userdata> getItemsAvailableSelectOne()
    {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Userdata.class)
    public static class UserdataControllerConverter implements Converter
    {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value)
        {
            if (value == null || value.length() == 0)
            {
                return null;
            }
            UserdataController controller = (UserdataController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "userdataController");
            return controller.getUserdata(getKey(value));
        }

        java.lang.Integer getKey(String value)
        {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object)
        {
            if (object == null)
            {
                return null;
            }
            if (object instanceof Userdata)
            {
                Userdata o = (Userdata) object;
                return getStringKey(o.getUserDataID());
            } else
            {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]
                {
                    object, object.getClass().getName(), Userdata.class.getName()
                });
                return null;
            }
        }

    }

}
