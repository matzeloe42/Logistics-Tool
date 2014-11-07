package com.logisticsTool;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author Raphael
 */
@ManagedBean (name = "helloWorld")
public class HelloWorld 
{
    public HelloWorld()
    {
        
    }

    public String getMessage()
    {
        return "Hello World running!";
    }
}
