package coding1package;
/**
 *
 * @author ashtonhess
 */

import java.beans.PropertyChangeSupport;

public class coding1FXMLModel extends coding1FXMLAbstractPropChangeSupport {
    public String someString = "Jakob, this is being passed as the NEW VALUE below";
    public String anotherString = "dont really need this string, firePropertyChange"
            +" just requires a new and old value, so you have to put in 2 strings."
            +" can be useful sometimes though to have that, this is being passed as the OLD VALUE below";

    coding1FXMLModel(){
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void changeDaText(){
        firePropertyChange("textToChangePropertyChangeID", anotherString, someString);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
