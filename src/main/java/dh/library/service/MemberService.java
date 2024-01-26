package dh.library.service;

import dh.library.Repository.MemberRepository;
import dh.library.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        validDuplicateMember(member);
        return memberRepository.save(member);
    }
    
    private void validDuplicateMember(Member member){

        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember != null ){

            throw new IllegalStateException("이미 가입된 회원입니다.");
        }

    }
}
