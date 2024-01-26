package dh.library.dto;

import dh.library.constant.Role;
import dh.library.entity.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Getter
@Setter
public class MemberFormDto {

    //회원가입 화면으로부터 넘어올 정보

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String id;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min=8, max=16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요.")
    private String pwd;

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;


    private Boolean rentalAbleUser = true;

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .pwd(pwd)
                .name(name)
                .role(Role.USER)
                .rentalAbleUser(rentalAbleUser)
                .build();
    }

}
