package com.example.dividend.model;

import lombok.Data;

import java.util.List;

public class Auth {

    @Data
    public static  class SignIn{
        private String username;
        private String password;
    }

    @Data
    public static class SignUp {
        private String username;
        private String password;
        private List<String> roles;

        //signup 클래스를 맴버엔터티로 만들수 있게
        public MemberEntity toEntity() {
            return MemberEntity.builder()
                    .username(this.username)
                    .password(this.password)
                    .roles(this.roles)
                    .build();
        }
    }

}
