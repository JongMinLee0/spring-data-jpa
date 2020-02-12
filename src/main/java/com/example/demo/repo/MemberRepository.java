package com.example.demo.repo;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByNameAndAndEmail(String name, String email);

    @Query(value = "SELECT m.* FROM MEMBER m WHERE m.email = ?1", nativeQuery = true)
    Optional<Member> findMemberUseEmailAddress(String email);

}
