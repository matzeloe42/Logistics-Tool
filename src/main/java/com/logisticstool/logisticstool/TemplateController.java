package com.logisticstool.logisticstool;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Matthias
 */
@Named("templateController")
@SessionScoped
public class TemplateController implements Serializable
{
    public String login()
    {
        return "template/common/commonLogin.xhtml";
    }
    
    public String register()
    {
        return "template/common/commonRegister.xhtml";
    }
}
