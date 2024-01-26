package dh.library.entity;
import dh.library.constant.Role;
import dh.library.dto.MemberFormDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_idx")
    private Long idx;

    private String id;

    private String pwd;

    @Column(unique = true)
    private String email;

    private String name;

    @Column(name = "RENTAL_ABLE_USER", columnDefinition = "boolean default true")
    private Boolean rentalAbleUser;

    @Enumerated(EnumType.STRING)
    private Role role;



    public static Member createMember(MemberFormDto memberFormDto , PasswordEncoder passwordEncoder){

        Member member = new Member();


        member.setName(memberFormDto.getName());
        member.setId(memberFormDto.getId());
        member.setEmail(memberFormDto.getEmail());

        String password = passwordEncoder.encode(memberFormDto.getPwd());
        member.setPwd(password);

        member.setRole(Role.ADMIN);

        return member;
    }

}
