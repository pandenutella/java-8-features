package com.pdn.features.container;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FortyGPContainerTest {

    @Test
    void when_getEquipmentNumber_should_return_the_given_equipment_number_during_initialization() {
        FortyGPContainer fortyGPContainer = new FortyGPContainer("CNTR01");

        String equipmentNumber = fortyGPContainer.getEquipmentNumber();

        assertThat(equipmentNumber).isEqualTo("CNTR01");
    }

    @Test
    void when_getEquipmentType_should_return_Container() {
        FortyGPContainer fortyGPContainer = new FortyGPContainer("CNTR01");

        String equipmentType = fortyGPContainer.getEquipmentType();

        assertThat(equipmentType).isEqualTo("Container");
    }

    @Test
    void when_getEquipmentSizeName_should_return_forty_GP() {
        FortyGPContainer fortyGPContainer = new FortyGPContainer("CNTR01");

        String equipmentType = fortyGPContainer.getEquipmentSizeName();

        assertThat(equipmentType).isEqualTo("forty-GP");
    }

    @Test
    void when_isEmpty_should_return_true() {
        FortyGPContainer fortyGPContainer = new FortyGPContainer("CNTR01");

        boolean empty = fortyGPContainer.isEmpty();

        assertThat(empty).isTrue();
    }

    @Test
    void when_isEmpty_should_return_true_if_setEmpty_is_called_with_true() {
        FortyGPContainer fortyGPContainer = new FortyGPContainer("CNTR01");
        fortyGPContainer.setEmpty(true);

        boolean empty = fortyGPContainer.isEmpty();

        assertThat(empty).isTrue();
    }

    @Test
    void when_isEmpty_should_return_false_if_setEmpty_is_called_with_false() {
        FortyGPContainer fortyGPContainer = new FortyGPContainer("CNTR01");
        fortyGPContainer.setEmpty(false);

        boolean empty = fortyGPContainer.isEmpty();

        assertThat(empty).isFalse();
    }
}