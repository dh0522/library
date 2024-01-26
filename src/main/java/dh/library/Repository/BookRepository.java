package dh.library.Repository;

import dh.library.constant.BookRentalStatus;
import dh.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByIdx(Long idx);
    List<Book> findByTitle(String title);
    List<Book> findByCategory(String category);

    //List<Book> findByBookRentalStatus(BookRentalStatus bookRentalStatus);

}