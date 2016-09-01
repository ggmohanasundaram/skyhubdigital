package org.skyhubdigital.com.recommendation.data;

import java.util.Comparator;

/**
 * Created by MohanDivya on 8/31/2016.
 *  This Movie class is a template to populate Movie objects with required fields
 *  It Implements Comparable interface for shorting purpose
 *
 */
public class Movie implements Comparable<Movie>{

    /**
     * nullSafeComparator used to avoid null pointer exception while sorting
     */
   public static Comparator<Movie> nullSafeComparator = new Comparator<Movie>() {
       @Override
       public int compare(Movie movie1, Movie movie2) {
           if(movie1 == null){
               return -1;
           }
           else if(movie2 == null){
               return 1;
           }
           else {
               return movie1.compareTo(movie2);
           }
       }
   };
    private String movieName;
    private Long duration;

    public Movie(String movieName, Long duration){

        this.movieName = movieName;
        this.duration = duration;
    }

    public String getMovieName() {
        return movieName;
    }

    public Long getDuration() {
        return duration;
    }

    /**
     * compareTo method is override to short based on Movie Duration
     * @param movie
     * @return
     */
    @Override
    public int compareTo(Movie movie) {
        if(this.getDuration() == movie.getDuration())
            return 0;
        else  return this.getDuration() > movie.getDuration() ? 1 : -1;
    }


}
