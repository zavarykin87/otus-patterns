package org.example.actions;

import org.example.exceptions.CheckFuelException;
import org.example.exceptions.GetPropertyException;

public interface CheckFuel {

    void checkFuel() throws GetPropertyException, CheckFuelException;
}
