package org.skyhubdigital.com.recommendation.util;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.skyhubdigital.com.recommendation.data.Movie;

import java.io.FileReader;
import java.io.IOException;


/**
 * Created by MohanDivya on 8/31/2016.
 * This utility class used to provide static methods to read the configuration File
 */
public class JSONFileReader {

    /**
     * readMovieFile method is used to read the Json file from class patha and
     * populates Movies Array
     */

        public static Movie[] readMovieFile() throws IOException, ParseException {

            Movie[] movies = null;
            ClassLoader classLoader = JSONFileReader.class.getClassLoader();
            FileReader fileReader = new FileReader(classLoader.getResource("recommendation/movies.json").getFile());
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(fileReader);
            movies = new Movie[jsonArray.size()];
            int i=0;
            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject)obj;
                Long runtime = (Long) jsonObject.get("runtime");
               movies[i++] = new Movie((String) jsonObject.get("title"), runtime);


            }

            return movies;



        }
}
