package org.babareko.graduationBoot.web.data;

import org.babareko.graduationBoot.model.Restaurant;
import org.babareko.graduationBoot.web.TestMatcher;

import java.util.List;

public class RestaurantTestData {
    public static TestMatcher<Restaurant> RESTAURANT_MATCHER = TestMatcher.usingEqualsComparator(Restaurant.class);

    public static final int Restaurant1_ID = 4;
    public static final Restaurant restaurant1 = new Restaurant(Restaurant1_ID, "Grand Café", "Cafe, Restaurant, Italian, Belarusian");
    public static final Restaurant restaurant2 = new Restaurant(Restaurant1_ID+1, "Kuhmistr", "Restaurant, Russian");
    public static final Restaurant restaurant3 = new Restaurant(Restaurant1_ID+2, "La Scala Trattoria Ignazio", "Restaurant, Italian");
    public static final Restaurant restaurant4 = new Restaurant(Restaurant1_ID+3, "BAR:DOT XX1", "Hotel Restaurant, Asian, Fusion");
    public static final Restaurant restaurant5 = new Restaurant(Restaurant1_ID+4, "Pena Dney", "Restaurant, European");
    public static final Restaurant restaurant6 = new Restaurant(Restaurant1_ID+5, "Animal Farm", "Restaurant, European, Mediterranean");
    public static final Restaurant restaurant7 = new Restaurant(Restaurant1_ID+6, "Seafood Bar by John Dory", "Restaurant, Seafood");
    public static final Restaurant restaurant8 = new Restaurant(Restaurant1_ID+7, "Svobody.4", "Restaurant, Wine Bar, Italian, European");
    public static final Restaurant restaurant9 = new Restaurant(Restaurant1_ID+8, "Om Namo", "Restaurant, Indian, Vegetarian");
    public static final Restaurant restaurant10 = new Restaurant(Restaurant1_ID+9, "Try Zhaunery", "Bar, Pub, Beer, Pub Grub");

    public static final List<Restaurant> restaurantList = List.of(restaurant1,restaurant2, restaurant3, restaurant4,
            restaurant5, restaurant6, restaurant7,restaurant8, restaurant9, restaurant10);

    public static final Restaurant restaurantNew = new Restaurant("New_Restaurant", "Description for a new restaurant");

    public static final List<Restaurant> restaurantListWithNew = List.of(restaurant1,restaurant2, restaurant3, restaurant4,
            restaurant5, restaurant6, restaurant7,restaurant8, restaurant9, restaurant10, restaurantNew);

    public static final List<Restaurant> restaurantListForDelete = List.of(restaurant1,restaurant2, restaurant3, restaurant4,
            restaurant5, restaurant6, restaurant7,restaurant8, restaurant10);


    public static Restaurant getUpdated() {
        return new Restaurant(12, "Name_Updated", "Description_updated");
    }


}
