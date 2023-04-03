package com.pdn.features.container;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwentyGPContainerTest {

    @Test
    void when_getEquipmentNumber_should_return_the_given_equipment_number_during_initialization() {
        TwentyGPContainer twentyGPContainer = new TwentyGPContainer("CNTR01");

        String equipmentNumber = twentyGPContainer.getEquipmentNumber();

        assertThat(equipmentNumber).isEqualTo("CNTR01");
    }

    @Test
    void when_getEquipmentType_should_return_Container() {
        TwentyGPContainer twentyGPContainer = new TwentyGPContainer("CNTR01");

        String equipmentType = twentyGPContainer.getEquipmentType();

        assertThat(equipmentType).isEqualTo("Container");
    }

    @Test
    void when_getEquipmentSizeName_should_return_twenty_GP() {
        TwentyGPContainer twentyGPContainer = new TwentyGPContainer("CNTR01");

        String equipmentType = twentyGPContainer.getEquipmentSizeName();

        assertThat(equipmentType).isEqualTo("twenty-GP");
    }

    @Test
    void when_isEmpty_should_return_true() {
        TwentyGPContainer twentyGPContainer = new TwentyGPContainer("CNTR01");

        boolean empty = twentyGPContainer.isEmpty();

        assertThat(empty).isTrue();
    }

    @Test
    void when_isEmpty_should_return_true_if_setEmpty_is_called_with_true() {
        TwentyGPContainer twentyGPContainer = new TwentyGPContainer("CNTR01");
        twentyGPContainer.setEmpty(true);

        boolean empty = twentyGPContainer.isEmpty();

        assertThat(empty).isTrue();
    }

    @Test
    void when_isEmpty_should_return_false_if_setEmpty_is_called_with_false() {
        TwentyGPContainer twentyGPContainer = new TwentyGPContainer("CNTR01");
        twentyGPContainer.setEmpty(false);

        boolean empty = twentyGPContainer.isEmpty();

        assertThat(empty).isFalse();
    }
}