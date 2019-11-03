package edu.neu.csye6220.entity;

public class Movies {
    private String title;
    private String actor;
    private String actress;
    private String genre;
    private Integer year;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActress() {
        return actress;
    }

    public void setActress(String actress) {
        this.actress = actress;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movies movies = (Movies) o;

        if (title != null ? !title.equals(movies.title) : movies.title != null) return false;
        if (actor != null ? !actor.equals(movies.actor) : movies.actor != null) return false;
        if (actress != null ? !actress.equals(movies.actress) : movies.actress != null) return false;
        if (genre != null ? !genre.equals(movies.genre) : movies.genre != null) return false;
        if (year != null ? !year.equals(movies.year) : movies.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (actor != null ? actor.hashCode() : 0);
        result = 31 * result + (actress != null ? actress.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }
}
