package com.example.listycity;
import java.util.Objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * Constructor for the City class.
     * @param city The name of the city.
     * @param province The name of the province.
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the name of the city.
     * @return The city name.
     */
    String getCityName() {
        return this.city;
    }

    /**
     * Gets the name of the province.
     * @return The province name.
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * Compares this city to another city for order. [12]
     * The comparison is based on the city name. [2]
     * @param o The city to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     *          is less than, equal to, or greater than the specified object. [12]
     */
    @Override
    public int compareTo(City o) {
        // Casting is unnecessary here as the type is already specified by Comparable<City>
        return this.city.compareTo(o.getCityName());
    }

    /**
     * Indicates whether some other object is "equal to" this one. [1]
     * Two cities are considered equal if they have the same city and province names. [9]
     * @param o The reference object with which to compare.
     * @return {@code true} if this object is the same as the o argument;
     *          {@code false} otherwise. [1, 3]
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city1 = (City) o;

        // Use the standard java.util.Objects class
        return Objects.equals(city, city1.city) &&
                Objects.equals(province, city1.province);
    }

    /**
     * Returns a hash code value for the object. [8, 9]
     * This method is supported for the benefit of hash tables such as those provided by HashMap.
     * @return A hash code value for this object. [11]
     */
    @Override
    public int hashCode() {
        // Use the standard java.util.Objects class
        return Objects.hash(city, province);
    }
}


