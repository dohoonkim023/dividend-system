package com.example.dividend.persist.entity;

import com.example.dividend.model.Company;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "COMPANY")
@Data
@ToString
@NoArgsConstructor
public class CompanyEntity {

    @Id //프라이머리 키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //유니크 자동 생성
    private Long id;

    @Column(unique = true) //티커가 중복이되면 안
    private String ticker;

    private String name;


    public CompanyEntity(Company company) {
        this.ticker = company.getTicker();
        this.name = company.getName();
    }
}
