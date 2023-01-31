package com.study.with.meow.swm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.with.meow.swm.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
