package dh.library.entity;
import dh.library.constant.BookRentalStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@Table(name = "book_table")
public class Book {

    // 책 코드
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    // 책 이름
    @Column(nullable = false)
    private String title;

    // 저자
    @Column(nullable = false)
    private String author;

    // 책 내용
    @Column(nullable = false)
    private String bookDetail;

    // 카테고리
    @Column(nullable = false)
    private String category;

    @Enumerated(EnumType.STRING)
    private BookRentalStatus rentalAbleBook;

    public void setRentalAbleBook(BookRentalStatus ableBook){
        this.rentalAbleBook = ableBook;
    }

    public void update(String title, String category, String author ){
        this.author = author;
        this.category = category;
        this.title = title;
    }


}
