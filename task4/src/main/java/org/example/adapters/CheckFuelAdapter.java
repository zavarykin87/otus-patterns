package org.example.adapters;

import org.example.actions.CheckFuel;
import org.example.exceptions.CheckFuelException;
import org.example.exceptions.GetPropertyException;
import org.example.models.UnitObject;

public class CheckFuelAdapter implements CheckFuel {

    private final UnitObject unitObject;

    public CheckFuelAdapter(UnitObject unitObject) {
        this.unitObject = unitObject;
    }

    @Override
    public void checkFuel() throws GetPropertyException, CheckFuelException {
        int fuel = (int) unitObject.getProperty("fuel")
                .orElseThrow(() -> new GetPropertyException("fuel"));

        int velocityBurnFuel = (int) unitObject.getProperty("velocityBurnFuel")
                .orElseThrow(() -> new GetPropertyException("velocityBurnFuel"));

        if (fuel < velocityBurnFuel) {
            throw new CheckFuelException();
        };
    }
}
