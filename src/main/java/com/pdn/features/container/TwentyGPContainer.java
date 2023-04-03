package com.pdn.features.container;

public class TwentyGPContainer implements Container {
    private final String equipmentNumber;

    private boolean empty = true;

    public TwentyGPContainer(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    @Override
    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    @Override
    public String getEquipmentType() {
        return "Container";
    }

    @Override
    public String getEquipmentSizeName() {
        return "twenty-GP";
    }

    @Override
    public boolean isEmpty() {
        return empty;
    }
}
