package dh.library.dto;

import dh.library.constant.BookRentalStatus;
import dh.library.entity.Book;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookDto {

    public static class Add {
        private Long idx;
        private String title;
        private String author;
        private String bookDetail;
        private String category;
        private BookRentalStatus rentalAbleBook = BookRentalStatus.POSSIBLE;

        public Book toEntity(){
            return Book.builder()
                    .title(title)
                    .author(author)
                    .category(category)
                    .rentalAbleBook(rentalAbleBook)
                    .build();
        }

    }


    public static class Delete{
        private Long idx;
    }

    public static class findBy {
        private String findBook;
    }
}
