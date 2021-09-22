package in.praveen.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.praveen.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Serializable> {

	

}
