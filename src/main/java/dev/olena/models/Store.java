package dev.olena.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    private String storeNumber;
    private String storeOwner;
    private String storeTaxIdentifier;
    private List<Computer> computers;

    public Store(String storeNumber, String storeOwner, String storeTaxIdentifier) {
        this.storeNumber = storeNumber;
        this.storeOwner = storeOwner;
        this.storeTaxIdentifier = storeTaxIdentifier;
        this.computers = new ArrayList<>();
    }

    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    public void removeComputerByBrand(String brand) {
        computers = computers.stream().filter(computer -> !computer.getBrand().equalsIgnoreCase(brand))
        .collect(Collectors.toList());
    }

    public Computer findComputerByBrand(String brand) {
        return computers.stream()
                .filter(computer -> computer.getBrand().equalsIgnoreCase(brand))
                .findFirst()
                .orElse(null);
    }

    public List<Computer> getAllComputers() {
        return new ArrayList<>(computers);
    }
}
