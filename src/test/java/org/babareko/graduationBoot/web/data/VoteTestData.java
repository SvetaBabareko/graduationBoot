package org.babareko.graduationBoot.web.data;

import org.babareko.graduationBoot.model.Vote;
import org.babareko.graduationBoot.web.TestMatcher;

public class VoteTestData {
    public static TestMatcher<Vote> VOTE_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Vote.class);


}
