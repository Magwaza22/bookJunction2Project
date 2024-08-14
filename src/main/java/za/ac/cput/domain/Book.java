package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;

@Entity
public class Book {
    @Id
    private Long bookID;
    @Lob
    @Column(length=100000)
    private byte[] bookPhoto;
    private String ISBN;
    private String title;
    private String edition;
    private Author author;
    private Double price;

    protected Book(){

    }

    public Book(Builder builder){
        this.bookID = builder.bookID;
        this.bookPhoto = builder.bookPhoto;
        this.ISBN = builder.ISBN;
        this.title = builder.title;
        this.edition = builder.edition;
        this.author = builder.author;
        this.price = builder.price;
    }

    public Long getBookID() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(getBookID(), book.getBookID()) && Arrays.equals(getBookPhoto(), book.getBookPhoto()) && Objects.equals(getISBN(), book.getISBN()) && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getEdition(), book.getEdition()) && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getPrice(), book.getPrice());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getBookID(), getISBN(), getTitle(), getEdition(), getAuthor(), getPrice());
        result = 31 * result + Arrays.hashCode(getBookPhoto());
        return result;
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
        private Long bookID;
        private byte[] bookPhoto;
        private String ISBN;
        private String title;
        private String edition;
        private Author author;
        private Double price;

        public Builder setBookID(Long bookID) {
            this.bookID = bookID;
            return this;
        }

        public Builder setBookPhoto(byte[] bookPhoto) {
            this.bookPhoto = bookPhoto;
            return this;
        }

        public Builder setISBN(String ISBN) {
            this.ISBN = ISBN;
            return  this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return  this;
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

        public Book.Builder copy(Book b) {
            this.bookID = b.bookID;
            this.bookPhoto = b.bookPhoto;
            this.ISBN = b.ISBN;
            this.title = b.title;
            this.edition = b.edition;
            this.author = b.author;
            this.price = b.price;
            return this;
        }
        public Book build(){
            return new Book(this);
        }

    }
}
