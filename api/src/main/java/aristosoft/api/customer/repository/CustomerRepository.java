package aristosoft.api.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aristosoft.api.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByEmail(String email);
}
