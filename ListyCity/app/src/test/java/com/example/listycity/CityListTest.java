package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
// This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
// is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
// This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
// Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }


    @Test
    void testHasCity() {
        CityList cityList = mockCityList();

        // 1. Test for a city that exists in the list
        City existingCity = new City("Edmonton", "Alberta");
        assertTrue(cityList.hasCity(existingCity));

        // 2. Test for a city that does not exist in the list
        City nonExistingCity = new City("Toronto", "Ontario");
        assertFalse(cityList.hasCity(nonExistingCity));
    }

    @Test
    public void testDelete() {
        CityList cityList = new CityList();
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertTrue(cityList.hasCity(city)); // Check if the city is added
        cityList.delete(city);
        assertFalse(cityList.hasCity(city)); // Check if the city is deleted
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList(); // This creates a list with "Edmonton"
        City city = new City("Regina", "Saskatchewan"); // A city that is not in the list

        // Assert that trying to delete a non-existent city throws the correct exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.countCities());
    }
}