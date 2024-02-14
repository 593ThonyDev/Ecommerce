package aristosoft.api.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import aristosoft.api.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByEmail(String email);

    @Query("SELECT c FROM Customer c WHERE c.fullName LIKE ?1 OR c.email LIKE ?2 OR c.phone LIKE ?3")
    List<Customer> findByPartialFullNameOrPartialEmailOrPartialPhone(String partialFullName, String partialEmail,
            String partialPhone);
}
