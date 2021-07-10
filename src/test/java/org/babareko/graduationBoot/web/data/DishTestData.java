package org.babareko.graduationBoot.web.data;

import org.babareko.graduationBoot.model.Dish;
import org.babareko.graduationBoot.model.Restaurant;
import org.babareko.graduationBoot.web.TestMatcher;

import static org.babareko.graduationBoot.web.data.RestaurantTestData.*;

import java.util.List;

public class DishTestData {
    public static TestMatcher<Dish> DISH_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Dish.class, "restaurant");

   // public static final Restaurant restaurant4 = new Restaurant(4, "BAR:DOT XX1", "Hotel Restaurant, Asian, Fusion");

    /*public static final Dish dish1 =  new Dish("Pizza", 345.34, restaurant9);
    public static final Dish dish2 =  new Dish("Pasta", 145.34, restaurant9);
    public static final Dish dish3 =  new Dish("Hamburger", 345.34, restaurant1);
    public static final Dish dish4 =  new Dish("Soup", 341.34, restaurant1);
    public static final Dish dish5 =  new Dish("Salad", 345.34, restaurant1);
    public static final Dish dish6 =  new Dish("Bread", 145.34, restaurant1);
    public static final Dish dish7 =  new Dish("Rice", 345.34, restaurant2);
    public static final Dish dish8 =  new Dish("Eggs", 345.34, restaurant2);
    public static final Dish dish9 =  new Dish("Salad", 345.34, restaurant3);
    public static final Dish dish10 =  new Dish("Bread", 145.34, restaurant3);
    public static final Dish dish11 =  new Dish("Rice", 345.34, restaurant3);
    public static final Dish dish12 =  new Dish("Eggs", 345.34, restaurant4);
    public static final Dish dish13 =  new Dish("Pizza", 345.34, restaurant4);
    public static final Dish dish14 =  new Dish("Pasta", 145.34, restaurant4);
    public static final Dish dish15 =  new Dish("Hamburger", 345.34, restaurant5);
    public static final Dish dish16 =  new Dish("Soup", 345.34, restaurant5);
    public static final Dish dish17 =  new Dish("Salad", 345.34, restaurant6);
    public static final Dish dish18 =  new Dish("Bread", 145.34, restaurant6);
    public static final Dish dish19 =  new Dish("Rice", 345.34, restaurant6);
    public static final Dish dish20 =  new Dish("Eggs", 345.34, restaurant6);
    public static final Dish dish21 =  new Dish("Pizza", 345.34, restaurant7);
    public static final Dish dish22 =  new Dish("Pasta", 145.34, restaurant7);
    public static final Dish dish23 =  new Dish("Hamburger", 345.34, restaurant7);
    public static final Dish dish24 =  new Dish("Soup", 345.34, restaurant10);
    public static final Dish dish25 =  new Dish("Salad", 345.34, restaurant10);*/

    public static final int dish1_Id = 14;

    public static final Dish dish1 =  new Dish(dish1_Id, "Pizza", 345.34);
    public static final Dish dish2 =  new Dish(dish1_Id+1, "Pasta", 145.34);
    public static final Dish dish3 =  new Dish(dish1_Id+2,"Hamburger", 345.34);
    public static final Dish dish4 =  new Dish(dish1_Id+3,"Soup", 341.34);
    public static final Dish dish5 =  new Dish(dish1_Id+4,"Salad", 345.34);
    public static final Dish dish6 =  new Dish(dish1_Id+5,"Bread", 145.34);
    public static final Dish dish7 =  new Dish(dish1_Id+6,"Rice", 345.34);
    public static final Dish dish8 =  new Dish(dish1_Id+7,"Eggs", 345.34);
    public static final Dish dish9 =  new Dish(dish1_Id+8,"Salad", 345.34);
    public static final Dish dish10 =  new Dish(dish1_Id+9,"Bread", 145.34);
    public static final Dish dish11 =  new Dish(dish1_Id+10,"Rice", 345.34);
    public static final Dish dish12 =  new Dish(dish1_Id+11,"Eggs", 345.34);
    public static final Dish dish13 =  new Dish(dish1_Id+12,"Pizza", 345.34);
    public static final Dish dish14 =  new Dish(dish1_Id+13,"Pasta", 145.34);
    public static final Dish dish15 =  new Dish(dish1_Id+14,"Hamburger", 345.34);
    public static final Dish dish16 =  new Dish(dish1_Id+15,"Soup", 345.34);
    public static final Dish dish17 =  new Dish(dish1_Id+16,"Salad", 345.34);
    public static final Dish dish18 =  new Dish(dish1_Id+17,"Bread", 145.34);
    public static final Dish dish19 =  new Dish(dish1_Id+18,"Rice", 345.34);
    public static final Dish dish20 =  new Dish(dish1_Id+19,"Eggs", 345.34);
    public static final Dish dish21 =  new Dish(dish1_Id+20,"Pizza", 345.34);
    public static final Dish dish22 =  new Dish(dish1_Id+21,"Pasta", 145.34);
    public static final Dish dish23 =  new Dish(dish1_Id+22,"Hamburger", 345.34);
    public static final Dish dish24 =  new Dish(dish1_Id+23,"Soup", 345.34);
    public static final Dish dish25 =  new Dish(dish1_Id+24,"Salad", 345.34);

    public static final List<Dish> dishList= List.of(dish1, dish2, dish3, dish4, dish5, dish6, dish7, dish8,
            dish9, dish10, dish11, dish12, dish13, dish14, dish15, dish16, dish17, dish18, dish19, dish20, dish21,
            dish22, dish23, dish24, dish25);

    public static final List<Dish> dishListForRestaurant4 = List.of(dish3, dish4, dish5, dish6);

    public static final Dish dishNew = new Dish("New_dish", 1234.99, restaurant4);

    public static final List<Dish> dishListWithNew = List.of(dish1, dish2, dish3, dish4, dish5, dish6, dish7, dish8,
            dish9, dish10, dish11, dish12, dish13, dish14, dish15, dish16, dish17, dish18, dish19, dish20, dish21,
            dish22, dish23, dish24, dish25, dishNew);

    public static final List<Dish> dishListWithDelete = List.of(dish1, dish2, dish4, dish5, dish6, dish7, dish8,
            dish9, dish10, dish11, dish12, dish13, dish14, dish15, dish16, dish17, dish18, dish19, dish20, dish21,
            dish22, dish23, dish24, dish25);

    public static Dish getUpdated() {
        return new Dish(15, "Name_Updated", 1234.11);
    }
}
