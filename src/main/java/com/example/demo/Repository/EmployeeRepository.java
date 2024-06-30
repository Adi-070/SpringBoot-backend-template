package com.example.demo.Repository;

import com.example.demo.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // Indicates that this interface is a Spring repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
