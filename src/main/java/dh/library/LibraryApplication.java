package dh.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller // 해당 클래스를 요청을 처리하는 컨트롤러로 사용하는 어노테이션
@ResponseBody // 자바 객체를 HTTP응답 본문의 객체로 전환하여 클라이언트에게 전송
@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}
