package org.skyhubdigital.com.recommendation.util;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.skyhubdigital.com.recommendation.data.Movie;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by MohanDivya on 8/31/2016.
 */
public class JSONFileReaderTest {

    @Test
    public void shouldReadJsonFile() throws IOException, ParseException {
        Movie[] movies = JSONFileReader.readMovieFile();
        assertThat(movies.length,is(20));
    }


}
