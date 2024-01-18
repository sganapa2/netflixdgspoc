package com.dgs.poc.netflixdgspoc.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class ShowsDatafetcher {

    private final List<Show> shows = List.of(
            new Show("Dabang", 2009),
            new Show("Sholay", 1990),
            new Show("Arya", 2010),
            new Show("Suryavamsham", 1999),
            new Show("Bhagwant Kesari", 2023)
    );

    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter) {
        if (titleFilter == null) {
            return shows;
        }
        return shows.stream().filter(o -> o.getTitle().contains(titleFilter)).collect(Collectors.toList());
    }
}
