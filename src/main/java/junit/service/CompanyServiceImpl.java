package junit.service;

import junit.model.Company;
import junit.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * springMVS
 * 16.02.2023
 * user
 * чт
 **/
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{
    private final CompanyRepository companyRepository;
    @Override
    public List<Company> findAll( ) {
        return companyRepository.findAll();
    }

    @Override
    public Company save(Company newCompany) {
        return companyRepository.save(newCompany);
    }
}
