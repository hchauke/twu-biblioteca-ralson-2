package com.twu.biblioteca.model;

public class Movie {
    private final String id;
    private final String name;
    private final String year;
    private final String director;
    private final double rating;

    public Movie(String id, String name, String year, String director, double rating) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public double getRating() {
        return rating;
    }

    public static String getColumnHeader() {
        return "\n" +
                "+--------+--------------+----------+---------------------+----------+" + "\n"
                + "|Movie ID|Name          | year     | Director            | Ratings  |" + "\n"
                + "+--------+--------------+----------+---------------------+----------+";
    }

    public String getColumnContent() {
        return "|" +getId() + "      |" + getName() + "       |" + getYear() + "      |" + getDirector() + "   |" + getRating();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (Double.compare(movie.rating, rating) != 0) return false;
        if (id != null ? !id.equals(movie.id) : movie.id != null) return false;
        if (name != null ? !name.equals(movie.name) : movie.name != null) return false;
        if (year != null ? !year.equals(movie.year) : movie.year != null) return false;
        return director != null ? director.equals(movie.director) : movie.director == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
