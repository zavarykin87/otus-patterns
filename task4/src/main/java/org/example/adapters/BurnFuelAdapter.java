package org.example.adapters;

import org.example.actions.BurnFuel;
import org.example.exceptions.GetPropertyException;
import org.example.models.UnitObject;

public class BurnFuelAdapter implements BurnFuel {

    private final UnitObject unitObject;

    public BurnFuelAdapter(UnitObject unitObject) {
        this.unitObject = unitObject;
    }

    @Override
    public void burn() throws GetPropertyException {
        int fuel = (int) unitObject.getProperty("fuel")
                .orElseThrow(() -> new GetPropertyException("fuel"));

        int velocity = (int) unitObject.getProperty("velocityBurnFuel")
                .orElseThrow(() -> new GetPropertyException("velocityBurnFuel"));

        unitObject.setProperty("fuel", fuel - velocity);
    }
}
