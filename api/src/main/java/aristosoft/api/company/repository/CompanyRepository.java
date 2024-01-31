package aristosoft.api.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aristosoft.api.company.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{
    
}
