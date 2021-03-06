/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;


/**
 *
 * @author T2000
 */
public class ListItem implements Serializable {
    
    //class instance variables
    private String name; 
    private int number;

    public ListItem() {
    }
    
    public ListItem(String name, int number) {
        setName(name);
        setNumber(number);
    }
    
    //getter: name
    public String getName() {
        return name;
    }
    
    //setter: name
    public void setName(String name) {
        this.name = name;
    }
    
    //getter: number
    public int getNumber() {
        return number;
    }

    //setter: number
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + this.number;
        return hash;
    }

    @Override
    public String toString() {
        return "Name:"+name + ",  Number:"+number+"\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ListItem other = (ListItem) obj;
        if (this.number != other.number) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
}
