package com.blog.toyproject.projectblog.test;

import com.blog.repository.UserRepository;
import com.blog.table.RoleType;
import com.blog.table.User;
import jakarta.servlet.jsp.tagext.TryCatchFinally;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaSize;
import java.util.List;
import java.util.function.Supplier;


@RestController
public class DummeyControllerTest {

    @Autowired //의존성 주입
    private UserRepository userRepository;

    @PostMapping("/insert")
    public String test(String user_id, String password, String email) {
        System.out.println("userid : "+user_id);
        System.out.println("password : "+password);
        System.out.println("email : "+email);

        return "회원가입완료";
    }

    @PostMapping("/insert2")
    public String test2 (User user) {
        System.out.println("useremail : "+user.getEmail());
//        user.setRole(user); // eunm이명 해당박식이 아니라 아래 방법을 이용해야함
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입완료2";
    }



    @GetMapping("/detail/{user_idx}")
    public User detail(@PathVariable int user_idx) {
        User user =  userRepository.findById(user_idx).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("유저 "+user_idx+" 는 없는 유저입니다.");
            }

            /* 람다식
            *  User user =  userRepository.findById(user_idx).orElseThrow(()-> {
            *  return new IllegalArgumentException("유저 "+user_idx+" 는 없는 유저입니다.")
            * });
            * */

        });



    return user;
    // 요청 : 웹브라우저
    // user 객체 = 자바 오브젝트
    // Jsoq으로 변환이 필요함 -> Sptring boot messageConverter가 응답시 자동작동됨 -> 자바객체은 user를 jackson 라이브러리를 호출해서 json으로 변환해서 브라우저에게 응답
    }


    //리스트로 받아서 user 정보 출력
    @GetMapping("/select/list")
    public List<User> list() {

        return userRepository.findAll();
    }

    //한페이지당 2건의 데이터 출력
    @GetMapping("/select/list/page")
    public List<User> pageList(@PageableDefault(size = 2/*, sort = "user_idx" ,direction = Sort.Direction.DESC*/) Pageable pageable) {
        Page<User> page =  userRepository.findAll(pageable); // Page<User>를 리턴하면 페이징 정보까지 볼 수 있음
        List<User> user = page.getContent();
        return user;
    }

    @PutMapping("/detail/{id}")
    @Transactional // 함수 시작할 때 작동이 되어서 함수 종료시에 자동 commit됨
    public User update(@PathVariable int id, @RequestBody User requestUser) {
        System.out.println("password : "+requestUser.getPassword());
        System.out.println("email : "+requestUser.getEmail());
        System.out.println("user_idx : "+id);


        User user =userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException( "수정할 수 없습니다");
                });

        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());



        //userRepository.save(user); //save함수는 id를 전달하지 않으면 insert 할 떄 사용함 그래서 넣은 값을 제외하고는 null 값이 되어버림
                                    // save함수는 id를 전달하면 해당 Id에 대한 데이터가 있으면 update
                                    // save함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert



        return user;
    }

    @DeleteMapping("/detail/{id}")
    public String delete(@PathVariable int id) {

            try {
                userRepository.deleteById(id);
            }catch (EmptyResultDataAccessException exception){
                return "없는 아이디입니다.";
        }
        return "아이디 삭제완료";
    }


}
