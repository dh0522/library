package dh.library.Repository;

import dh.library.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByIdx(Long Idx);
    Member findById(String Id);

    Member findByEmail(String email);

}
