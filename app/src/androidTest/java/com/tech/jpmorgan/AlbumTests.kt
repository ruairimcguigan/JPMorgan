package com.tech.jpmorgan

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.tech.jpmorgan.matchers.atPosition
import com.tech.jpmorgan.ui.album.AlbumActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AlbumTests {

    @get:Rule
    var activityRule: ActivityTestRule<AlbumActivity>
            = ActivityTestRule(AlbumActivity::class.java)

    @Test
    fun albumsDisplayedInSortedOrderByTitle() {
        onView(withId(R.id.album_list))
            .check(matches(atPosition(0, hasDescendant(withText("distinctio laborum qui")))))
            .check(matches(atPosition(1, hasDescendant(withText("enim repellat iste")))))
            .check(matches(atPosition(2, hasDescendant(withText("est vel dignissimos")))))
            .check(matches(atPosition(3, hasDescendant(withText("et deleniti unde")))))
            .check(matches(atPosition(4, hasDescendant(withText("id nihil reprehenderit")))))
    }
}