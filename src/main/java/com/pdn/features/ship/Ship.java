package com.pdn.features.ship;

import com.pdn.features.container.Container;
import com.pdn.features.exception.ContainerException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Ship {
    private final Map<String, Integer> allowedPerContainerSizeMap;

    private final List<Container> containerList = new ArrayList<>();

    public Ship(Map<String, Integer> allowedPerContainerSizeMap) {
        this.allowedPerContainerSizeMap = allowedPerContainerSizeMap;
    }

    //    TODO: Refactor using stream (filter and count)
    public void loadContainer(Container container) throws ContainerException {
        int allowed = allowedPerContainerSizeMap.get(container.getEquipmentSizeName());

        int loaded = 0;
        for (Container c : containerList) {
            if (c.getClass() != container.getClass())
                continue;

            loaded++;
        }

        if (loaded == allowed) {
            throw new ContainerException(
                    String.format("Failed to load %s container %s! The ship already has %d out of %d allowed container(s) for this container size.",
                            container.getEquipmentSizeName(), container.getEquipmentNumber(), loaded, allowed));
        }

        containerList.add(container);
    }

    //    TODO: Refactor using stream (filter, findFirst, and removeIf) and optional (orElseThrow)
    public Container dischargeContainer(String equipmentNumber) throws ContainerException {
        Container dischargingContainer = null;

        for (Container container : containerList) {
            if (!container.getEquipmentNumber().equals(equipmentNumber))
                continue;

            dischargingContainer = container;
            break;
        }

        if (dischargingContainer == null)
            throw new ContainerException(String.format("Failed to discharge container %s! It does not exist.", equipmentNumber));

        containerList.remove(dischargingContainer);

        return dischargingContainer;
    }

    //    TODO: Refactor using stream (map, filter, collect) and method reference
    public List<String> displayLoadedContainers() {
        List<String> loadedContainersDetails = new ArrayList<>();

        for (String containerSizeName : allowedPerContainerSizeMap.keySet()) {
            StringJoiner equipmentNumbersJoiner = new StringJoiner(", ");

            for (Container container : containerList) {
                if (!container.getEquipmentSizeName().equals(containerSizeName))
                    continue;

                equipmentNumbersJoiner.add(container.getEquipmentNumber());
            }

            loadedContainersDetails.add(String.format("%s: %s", containerSizeName, equipmentNumbersJoiner));
        }

        return loadedContainersDetails;
    }

    public List<Container> getContainerList() {
        return containerList;
    }
}
