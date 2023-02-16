package junit.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import junit.model.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * springMVS
 * 16.02.2023
 * user
 * чт
 **/
@Repository
@RequiredArgsConstructor
@Transactional
public class CompanyRepoImpl implements CompanyRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Company> findAll() {
        return entityManager.createQuery("select c from Company c",Company.class).getResultList() ;
    }

    @Override
    public Company save(Company newCompany) {
        entityManager.persist(newCompany);
        return newCompany;
    }

    @Override
    public Company findBiId(Long companyId) {
        return entityManager.find(Company.class,companyId);
    }
}
