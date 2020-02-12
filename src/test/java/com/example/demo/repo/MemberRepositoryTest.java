package com.example.demo.repo;

import com.example.demo.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;


    @Test
    @DisplayName("Member 저장")
    void memberSaveTest(){
        Member member = new Member();
        member.setName("jongmin");
        member.setEmail("test@test.com");

        Member member1 = memberRepository.save(member);
        assertEquals("jongmin", member1.getName());
    }

}