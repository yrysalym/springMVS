package junit.repository;

import junit.model.Company;

import java.util.List;
import java.util.Optional;

/**
 * springMVS
 * 16.02.2023
 * user
 * чт
 **/

public interface CompanyRepository {
    List<Company> findAll();
    Company save(Company newCompany);

    Company findBiId(Long companyId);

}
