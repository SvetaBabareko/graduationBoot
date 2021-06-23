package org.babareko.graduationBoot.web.data;

import org.babareko.graduationBoot.model.Dish;
import org.babareko.graduationBoot.model.Restaurant;
import org.babareko.graduationBoot.web.TestMatcher;

import java.util.List;

public class DishTestData {
    public static TestMatcher<Dish> Dish_MATCHER = TestMatcher.usingEqualsComparator(Dish.class);

    public static final Restaurant restaurant4 = new Restaurant(4, "BAR:DOT XX1", "Hotel Restaurant, Asian, Fusion");

    public static final Dish dish1 = new Dish("Hamburger", 345.34, restaurant4);
    public static final Dish dish2 = new Dish("Soup", 341.34, restaurant4);
    public static final Dish dish3 = new Dish("Salad", 345.34, restaurant4);
    public static final Dish dish4 = new Dish("Bread", 145.34, restaurant4);

    public static final List<Dish> dishListForRestaurant4 = List.of(dish1, dish2, dish3, dish4);

    public static final Dish dishNew = new Dish("New_dish", 1234.99, restaurant4);

    public static final List<Dish> dishListForRestaurant4WithNew = List.of(dish1, dish2, dish3, dish4, dishNew);

    public static final List<Dish> dishListForRestaurant4ForDelete = List.of(dish1, dish3, dish4);

    public static Dish getUpdated() {
        return new Dish("Name_Updated", 1234567.11, restaurant4);
    }
}
