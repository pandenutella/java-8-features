package com.pdn.features.container;

public class TwentyGPContainer implements Container {
    private final String equipmentNumber;

    private double grossWeight = 0;
    private boolean empty = true;

    public TwentyGPContainer(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public TwentyGPContainer(String equipmentNumber, double grossWeight) {
        this.equipmentNumber = equipmentNumber;
        this.grossWeight = grossWeight;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    @Override
    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    //    TODO: Refactor using default method
    @Override
    public String getEquipmentType() {
        return "Container";
    }

    @Override
    public String getEquipmentSizeName() {
        return "twenty-GP";
    }

    @Override
    public double getGrossWeight() {
        return grossWeight;
    }

    @Override
    public boolean isEmpty() {
        return empty;
    }
}
