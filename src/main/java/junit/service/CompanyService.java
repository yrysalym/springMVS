package junit.service;

import junit.model.Company;

import java.util.List;

/**
 * springMVS
 * 16.02.2023
 * user
 * чт
 **/
public interface CompanyService {
    List<Company> findAll( );
    Company save (Company newCompany);
}
