package com.example.dividend.service;

import com.example.dividend.exception.impl.NoCompanyException;
import com.example.dividend.model.Company;
import com.example.dividend.model.Dividend;
import com.example.dividend.model.ScrapedResult;
import com.example.dividend.model.constants.CacheKey;
import com.example.dividend.persist.CompanyRepository;
import com.example.dividend.persist.DividendRepository;
import com.example.dividend.persist.entity.CompanyEntity;
import com.example.dividend.persist.entity.DividendEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class FinanceService {

    private final CompanyRepository companyRepository;
    private final DividendRepository dividendRepository;

    @Cacheable(key = "#companyName", value = CacheKey.KEY_FINANCE)
    public ScrapedResult getDividendByCompanyName(String companyName) {
        log.info("search company -> " + companyName);

        CompanyEntity company = companyRepository.findByName(companyName)
            .orElseThrow(() -> new RuntimeException(new NoCompanyException()));

        List<DividendEntity> dividendEntities = dividendRepository
            .findAllByCompanyId(company.getId());

        List<Dividend> dividends = dividendEntities.stream()
            .map(e -> new Dividend(e.getDate(), e.getDividend()))
            .collect(Collectors.toList());

        return new ScrapedResult(Company.builder()
            .ticker(company.getTicker())
            .name(company.getName())
            .build(),
            dividends
        );
    }
}
