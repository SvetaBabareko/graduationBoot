package org.babareko.graduationBoot.web.data;

import org.babareko.graduationBoot.model.Dish;
import org.babareko.graduationBoot.model.Restaurant;
import org.babareko.graduationBoot.model.Vote;
import org.babareko.graduationBoot.web.TestMatcher;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.babareko.graduationBoot.web.data.RestaurantTestData.*;
import static org.babareko.graduationBoot.web.data.UserTestData.*;

public class VoteTestData {
    public static TestMatcher<Vote> VOTE_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Vote.class);

    public static final int vote1_Id = 39;

    public static final Vote vote1 = new Vote(vote1_Id, user, restaurant5, LocalDate.of(2021, 05, 24));
    public static final Vote vote2 = new Vote(vote1_Id + 1, user, restaurant2, LocalDate.of(2021, 05, 24));
    public static final Vote vote3 = new Vote(vote1_Id + 2, user, restaurant5, LocalDate.of(2021, 05, 24));
    public static final Vote vote4 = new Vote(vote1_Id + 3, user, restaurant9, LocalDate.of(2021, 05, 24));
    public static final Vote vote5 = new Vote(vote1_Id + 4, user2, restaurant5, LocalDate.of(2021, 05, 24));
    public static final Vote vote6 = new Vote(vote1_Id + 5, user2, restaurant2, LocalDate.of(2021, 05, 24));
    public static final Vote vote7 = new Vote(vote1_Id + 6, user2, restaurant1, LocalDate.of(2021, 05, 24));
    public static final Vote vote8 = new Vote(vote1_Id + 7, user2, restaurant10, LocalDate.of(2021, 05, 24));

    public static final List<Vote> voteList = List.of(vote1, vote2, vote3, vote4, vote5, vote6, vote7, vote8);

}
