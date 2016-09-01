package org.skyhubdigital.com.recommendation;

import org.hamcrest.CoreMatchers;
import org.json.simple.parser.ParseException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.skyhubdigital.com.patterns.exceptions.WrongInputException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.IOException;

/**
 * Created by MohanDivya on 8/31/2016.
 */
public class MovieRecommenderTest {


    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Test
    public void shouldThrowExceptionForNull() throws IOException, ParseException, WrongInputException {

        exception.expect(WrongInputException.class);
        exception.expectMessage(CoreMatchers.is("FlightTiming is Null"));
        String movieSuggestions = MovieRecommender.getMovieSuggestions(null);


    }

    @Test
    public void shouldReturnMovieListForInputOne() throws IOException, ParseException, WrongInputException {
        String movieSuggestions = MovieRecommender.getMovieSuggestions(100L);
        assertThat(movieSuggestions,is("Mike & Dave Need Wedding Dates(98)"));

    }

    @Test
    public void shouldReturnMovieListForInputTwo() throws IOException, ParseException, WrongInputException {
        String movieSuggestions = MovieRecommender.getMovieSuggestions(325L);
        assertThat(movieSuggestions,is("Jason Bourne(123)  Dishoom(120)  Batman: The Killing Joke(72)"));

    }

    @Test
    public void shouldReturnMovieListForInputThree() throws IOException, ParseException, WrongInputException {
        String movieSuggestions = MovieRecommender.getMovieSuggestions(92L);
        assertThat(movieSuggestions,is("The Secret Life of Pets(91)"));

    }

    @Test
    public void shouldReturnMovieListForInputFour() throws IOException, ParseException, WrongInputException {
        String movieSuggestions = MovieRecommender.getMovieSuggestions(0L);
        assertThat(movieSuggestions,is(""));

    }

    @Test
    public void shouldReturnMovieListForInputFive() throws IOException, ParseException, WrongInputException {
        String movieSuggestions = MovieRecommender.getMovieSuggestions(71L);
        assertThat(movieSuggestions,is(""));

    }
    @Test
    public void shouldReturnMovieListForInputSix() throws IOException, ParseException, WrongInputException {
        String movieSuggestions = MovieRecommender.getMovieSuggestions(72L);
        assertThat(movieSuggestions,is("Batman: The Killing Joke(72)"));

    }

    @Test
    public void shouldReturnMovieListForInputSeven() throws IOException, ParseException, WrongInputException {
        String movieSuggestions = MovieRecommender.getMovieSuggestions(73L);
        assertThat(movieSuggestions,is("Batman: The Killing Joke(72)"));

    }


}
