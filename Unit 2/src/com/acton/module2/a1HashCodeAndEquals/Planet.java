package com.acton.module2.a1HashCodeAndEquals;

public class Planet {
    private String designation;
    private double massKg;
    private double orbitEarthYears;
    private PlanetType type;

    public Planet(String designation, PlanetType type){
        this.designation = designation;
        this.type = type;
    }

    public Planet(String designation, double massKg, double orbitEarthYears, PlanetType type) {
        this.designation = designation;
        this.massKg = massKg;
        this.orbitEarthYears = orbitEarthYears;
        this.type = type;
    }

    public int hashCode(){
        return designation.hashCode();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o instanceof Planet){
            return designation.equals(((Planet)o).designation);
        }
        else return false;
    }

    public String toString(){
        return "Designation=" + designation + "; Type=" + type;
    }
}