package za.ac.cput.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookID;

    @Lob
    private byte[] bookPhoto;

    private String ISBN;
    private String title;
    private String edition;

    @Embedded
    private Author author;

    private Double price;

    public Book() {}

    public Book(Builder builder) {
        this.bookID = builder.bookID;
        this.bookPhoto = builder.bookPhoto;
        this.ISBN = builder.ISBN;
        this.title = builder.title;
        this.edition = builder.edition;
        this.author = builder.author;
        this.price = builder.price;
    }

    public int getBookID() {
        return bookID;
    }

    public byte[] getBookPhoto() {
        return bookPhoto;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getEdition() {
        return edition;
    }

    public Author getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Book book)) return false;
        return bookID == book.bookID &&
                Objects.equals(ISBN, book.ISBN) &&
                Objects.equals(title, book.title) &&
                Objects.equals(edition, book.edition) &&
                Objects.equals(author, book.author) &&
                Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookID, ISBN, title, edition, author, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookPhoto=" + Arrays.toString(bookPhoto) +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", edition='" + edition + '\'' +
                ", author=" + author +
                ", price=" + price +
                '}';
    }

    public static class Builder {
        private int bookID;
        private byte[] bookPhoto;
        private String ISBN;
        private String title;
        private String edition;
        private Author author;
        private Double price;

        public Builder setBookID(int bookID) {
            this.bookID = bookID;
            return this;
        }

        public Builder setBookPhoto(byte[] bookPhoto) {
            this.bookPhoto = bookPhoto;
            return this;
        }

        public Builder setISBN(String ISBN) {
            this.ISBN = ISBN;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setEdition(String edition) {
            this.edition = edition;
            return this;
        }

        public Builder setAuthor(Author author) {
            this.author = author;
            return this;
        }

        public Builder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public Builder copy(Book b) {
            this.bookID = b.bookID;
            this.bookPhoto = b.bookPhoto;
            this.ISBN = b.ISBN;
            this.title = b.title;
            this.edition = b.edition;
            this.author = b.author;
            this.price = b.price;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
