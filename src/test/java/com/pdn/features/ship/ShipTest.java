package com.pdn.features.ship;

import com.pdn.features.container.Container;
import com.pdn.features.container.FortyGPContainer;
import com.pdn.features.container.TwentyGPContainer;
import com.pdn.features.exception.ContainerException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ShipTest {

    @Test
    void when_loadContainer_should_add_container_to_container_list_given_a_twenty_GP_container_and_container_list_can_still_accommodate_this_container_size() throws ContainerException {
        Map<String, Integer> allowedPerContainerSizeMap = new HashMap<String, Integer>() {{
            put("twenty-GP", 1);
        }};

        Container container = new TwentyGPContainer("CNTR01");

        Ship ship = new Ship(allowedPerContainerSizeMap);
        ship.loadContainer(container);

        List<Container> containerList = ship.getContainerList();

        assertThat(containerList).contains(container);
    }

    @Test
    void when_loadContainer_should_throw_a_container_exception_given_a_twenty_GP_container_and_container_list_cannot_accommodate_this_container_size_anymore() throws ContainerException {
        Map<String, Integer> allowedPerContainerSizeMap = new HashMap<String, Integer>() {{
            put("twenty-GP", 1);
        }};

        Ship ship = new Ship(allowedPerContainerSizeMap);
        ship.loadContainer(new TwentyGPContainer("CNTR01"));

        assertThatThrownBy(() -> {
            ship.loadContainer(new TwentyGPContainer("CNTR02"));
        })
                .isInstanceOf(ContainerException.class)
                .hasMessage("Failed to load twenty-GP container CNTR02! The ship already has 1 out of 1 allowed container(s) for this container size.");
    }

    @Test
    void when_loadContainer_should_add_container_to_container_list_given_a_forty_GP_container_and_container_list_can_still_accommodate_this_container_size() throws ContainerException {
        Map<String, Integer> allowedPerContainerSizeMap = new HashMap<String, Integer>() {{
            put("forty-GP", 1);
        }};

        Container container = new FortyGPContainer("CNTR01");

        Ship ship = new Ship(allowedPerContainerSizeMap);
        ship.loadContainer(container);

        List<Container> containerList = ship.getContainerList();

        assertThat(containerList).contains(container);
    }

    @Test
    void when_loadContainer_should_throw_a_container_exception_given_a_forty_GP_container_and_container_list_cannot_accommodate_this_container_size_anymore() throws ContainerException {
        Map<String, Integer> allowedPerContainerSizeMap = new HashMap<String, Integer>() {{
            put("forty-GP", 1);
        }};

        Ship ship = new Ship(allowedPerContainerSizeMap);
        ship.loadContainer(new FortyGPContainer("CNTR01"));

        assertThatThrownBy(() -> {
            ship.loadContainer(new FortyGPContainer("CNTR02"));
        })
                .isInstanceOf(ContainerException.class)
                .hasMessage("Failed to load forty-GP container CNTR02! The ship already has 1 out of 1 allowed container(s) for this container size.");
    }

    @Test
    void when_dischargeContainer_should_return_matching_container_and_remove_it_from_container_list_given_an_existing_equipment_number() throws ContainerException {
        Map<String, Integer> allowedPerContainerSizeMap = new HashMap<String, Integer>() {{
            put("forty-GP", 1);
        }};

        Container container = new FortyGPContainer("CNTR01");

        Ship ship = new Ship(allowedPerContainerSizeMap);
        ship.loadContainer(container);

        Container dischargedContainer = ship.dischargeContainer("CNTR01");

        assertThat(ship.getContainerList()).doesNotContain(container);
        assertThat(dischargedContainer).isEqualTo(dischargedContainer);
    }

    @Test
    void when_dischargeContainer_should_throw_a_container_exception_given_an_non_existing_equipment_number() {
        Map<String, Integer> allowedPerContainerSizeMap = new HashMap<String, Integer>() {{
            put("forty-GP", 1);
        }};

        Ship ship = new Ship(allowedPerContainerSizeMap);

        assertThatThrownBy(() -> {
            ship.dischargeContainer("CNTR01");
        })
                .isInstanceOf(ContainerException.class)
                .hasMessage("Failed to discharge container CNTR01! It does not exist.");
    }

    @Test
    void when_displayLoadedContainers_should_return_the_equipment_number_of_containers_grouped_by_container_size_as_a_list_of_string() throws ContainerException {
        Map<String, Integer> allowedPerContainerSizeMap = new HashMap<String, Integer>() {{
            put("twenty-GP", 5);
            put("forty-GP", 5);
        }};

        Ship ship = new Ship(allowedPerContainerSizeMap);

        ship.loadContainer(new TwentyGPContainer("CNTR01"));
        ship.loadContainer(new FortyGPContainer("CNTR02"));
        ship.loadContainer(new TwentyGPContainer("CNTR03"));
        ship.loadContainer(new FortyGPContainer("CNTR04"));
        ship.loadContainer(new TwentyGPContainer("CNTR05"));
        ship.loadContainer(new FortyGPContainer("CNTR06"));
        ship.loadContainer(new TwentyGPContainer("CNTR07"));
        ship.loadContainer(new FortyGPContainer("CNTR08"));
        ship.loadContainer(new TwentyGPContainer("CNTR09"));
        ship.loadContainer(new FortyGPContainer("CNTR10"));

        List<String> loadedContainersDetails = ship.displayLoadedContainers();

        assertThat(loadedContainersDetails).containsExactly(
                "forty-GP: CNTR02, CNTR04, CNTR06, CNTR08, CNTR10",
                "twenty-GP: CNTR01, CNTR03, CNTR05, CNTR07, CNTR09"
        );
    }
}