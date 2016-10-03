package com.twu.biblioteca.model;

public class Book {
    private final String id;
    private final String title;
    private final String author;
    private final String publishedYear;

    public Book(String id, String title, String author, String publishedYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedYear() {
        return publishedYear;
    }


    public static String getColumnHeader() {
        return "\n" +
                "+-------+----------------------+---------------------+------------------+" + "\n"
                + "|Book id|Book Name             |Director             | Year Published   |" + "\n"
                + "+-------+----------------------+---------------------+------------------+";
    }

    public String getColumnContent() {

        return "| "+ getId() + "    |" + getTitle() + "    |" + getAuthor() + "            |" + getPublishedYear() + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        return publishedYear != null ? publishedYear.equals(book.publishedYear) : book.publishedYear == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (publishedYear != null ? publishedYear.hashCode() : 0);
        return result;
    }
}
