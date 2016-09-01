package org.skyhubdigital.com.recommendation.data;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by MohanDivya on 8/31/2016.
 */
public class MovieTest {

    @Test
    public void compareToShouldReturnZero()
    {
        Movie movie1 = new Movie("movie", 10L);
        Movie movie2 = new Movie("movie", 10L);
        assertThat(movie1.compareTo(movie2),is(0));
    }

    @Test
    public void compareToShouldReturnPositive()
    {
        Movie movie1 = new Movie("movie", 20L);
        Movie movie2 = new Movie("movie", 10L);
        assertThat(movie1.compareTo(movie2),is(1));
    }

    @Test
    public void compareToShouldReturnNegative()
    {
        Movie movie1 = new Movie("movie", 5L);
        Movie movie2 = new Movie("movie", 10L);
        assertThat(movie1.compareTo(movie2),is(-1));
    }

    @Test
    public void nullSafeComparatorShouldReturnNegative()
    {
        Movie movie1 = null;
        Movie movie2 = new Movie("movie", 10L);
        assertThat(Movie.nullSafeComparator.compare(movie1,movie2),is(-1));
    }

    @Test
    public void nullSafeComparatorShouldReturnPositive()
    {
        Movie movie1 = new Movie("movie", 10L);;
        Movie movie2 = null;
        assertThat(Movie.nullSafeComparator.compare(movie1,movie2),is(1));
    }

    @Test
    public void nullSafeComparatorShouldReturnZero()
    {
        Movie movie1 = new Movie("movie", 10L);
        Movie movie2 = new Movie("movie", 10L);
        assertThat(Movie.nullSafeComparator.compare(movie1,movie2),is(0));
    }
}
