package com.study.with.meow.swm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class Member {

    @Id
    private String id;
    
    @Column
    private String password;

    @Column
    private String nickname;

    @Column
    private String introduce;

    @Column
    private String todo;

}