package com.pdn.features.container;

public class FortyGPContainer implements Container {
    private final String equipmentNumber;

    private boolean empty = true;

    public FortyGPContainer(String equipmentNumber) {
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
        return "forty-GP";
    }

    @Override
    public boolean isEmpty() {
        return empty;
    }
}
