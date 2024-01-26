package dh.library.service;

import dh.library.dto.MemberFormDto;
import dh.library.entity.Member;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Member createMember(){

        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setId("id");
        memberFormDto.setName("hongdohyun");
        memberFormDto.setPwd("1234");
        memberFormDto.setEmail("gong4857@naver");

        return Member.createMember(memberFormDto, passwordEncoder);

    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemberTest(){

        Member member = createMember();
        Member savedMember = memberService.saveMember(member);

        assertEquals(member.getId(),savedMember.getId());
        assertEquals(member.getName(),savedMember.getName());
        assertEquals(member.getPwd(),savedMember.getPwd());
        assertEquals(member.getRole(),savedMember.getRole());

    }
}