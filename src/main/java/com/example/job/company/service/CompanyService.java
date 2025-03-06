package com.example.job.company.service;

import com.example.job.company.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> findAllCompanies();

    Company findCompanyById(Long id);

    boolean updateCompanyById(Long id, Company company);

    void addCompany(Company company);

    boolean deleteCompany(Long id);
}
