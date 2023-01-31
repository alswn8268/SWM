package com.study.with.meow.swm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.study.with.meow.swm.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

    Optional<Member> findById(String id);
    Optional<Member> findByNickname(String nickname);

}
