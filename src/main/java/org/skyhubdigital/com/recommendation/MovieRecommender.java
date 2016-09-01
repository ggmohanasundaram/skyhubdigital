package org.skyhubdigital.com.recommendation;

import org.json.simple.parser.ParseException;
import org.skyhubdigital.com.patterns.exceptions.WrongInputException;
import org.skyhubdigital.com.recommendation.data.Movie;
import org.skyhubdigital.com.recommendation.util.JSONFileReader;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by MohanDivya on 8/31/2016.
 *
 * MovieRecommender provides method to shortlist the Movies based on FlightDuration
 * Binary search Algorithm is used to shortlist the movies in efficient way
 */
public class MovieRecommender
{

    /**
     * getMovieSuggestions method used to select the movies based on flightTimeInMinutes.
     * To achieve binary search, this method sorts the Movies Array and calls the prioritizeLongerMovie recursively until
     * it finds the maximum movies with total duration is <= flightTime
     *
     * @param flightTimeInMinutes
     * @return
     * @throws IOException
     * @throws ParseException
     * @throws WrongInputException
     */
    public static String getMovieSuggestions(Long flightTimeInMinutes) throws IOException, ParseException, WrongInputException {

        Movie[] allMovies = JSONFileReader.readMovieFile();


        Arrays.sort(allMovies,Movie.nullSafeComparator);

        StringBuffer selectedMovies = new StringBuffer();

        int index = 0;
        int lastIndex = allMovies.length-1;

       if(flightTimeInMinutes!=null) {
           while (index < lastIndex && flightTimeInMinutes > 0) {

               int longerMovieIndex = prioritizeLongerMovie(allMovies, flightTimeInMinutes, index, lastIndex);
               if (allMovies[longerMovieIndex].getDuration() <= flightTimeInMinutes && allMovies[longerMovieIndex].getDuration() > 0) {
                   flightTimeInMinutes = flightTimeInMinutes - allMovies[longerMovieIndex].getDuration();
                   selectedMovies.append(allMovies[longerMovieIndex].getMovieName() + "(" + allMovies[longerMovieIndex].getDuration() + ")  ");
               }

               lastIndex = longerMovieIndex;

           }


           return selectedMovies.toString().trim();
       }
       else{
           throw new WrongInputException("FlightTiming is Null");
       }

    }

    /**
     * prioritizeLongerMovie is used to select the index of longer movie based on Flight Timings
     * It finds the index based on binary search algorithm
     * @param allMovies
     * @param flightTimeInMinutes
     * @param index
     * @param lastIndex
     * @return
     */

    private static int prioritizeLongerMovie(Movie[] allMovies, Long flightTimeInMinutes, int index, int lastIndex) {

           int middle = 0;
            int first = index;
            int last = lastIndex;

        while (first < last) {

                middle = first + (last - first) / 2;
                if(allMovies[middle].getDuration() == flightTimeInMinutes)
                {
                    return middle;
                }
                if (allMovies[middle].getDuration() > flightTimeInMinutes) {
                    last = middle - 1;
                } else if (allMovies[middle].getDuration() < flightTimeInMinutes) {
                    first = middle + 1;
                }

            }
        return middle;

    }

}

