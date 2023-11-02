package com.example.dividend.scraper;

import com.example.dividend.model.Company;
import com.example.dividend.model.ScrapedResult;

public interface Scraper {

    Company scrapCompanyByTicker(String sticker);

    ScrapedResult scrap(Company company);
}
