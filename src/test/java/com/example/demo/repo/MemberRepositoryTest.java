package com.example.demo.repo;

import com.example.demo.entity.Member;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Disabled("저장 테스트 완료")
    @DisplayName("Member 저장")
    void memberSaveTest(){
        Member member = new Member();
        member.setName("jongmin");
        member.setEmail("test@test.com");

        Member member1 = memberRepository.save(member);
        assertEquals("jongmin", member1.getName());
    }

    @Test
    @Disabled("조회 테스트 종료")
    @DisplayName("Member 조회")
    void findMemberJongminTest(){
        Optional<Member> member = memberRepository.findById(1L);
        assertEquals("jongmin", member.get().getName());
    }

    @Test
    @DisplayName("메소드 이용")
    void findMemberByMethod(){
        String name = "jongmin";
        String email = "test@test.com";
        Optional<Member> member = memberRepository.findByNameAndAndEmail(name, email);

        assertEquals(name, member.get().getName());
        assertEquals(email, member.get().getEmail());
    }

    @Test
    @DisplayName("쿼리 이용")
    void findMemberByEmail(){
        String email = "test@test.com";
        Optional<Member> member = memberRepository.findMemberUseEmailAddress(email);

        assertEquals("jongmin", member.get().getName());
    }


}