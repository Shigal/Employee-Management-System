package com.shigal.ems.repository;/*
 *
 * @author Lawshiga
 *
 */

import com.shigal.ems.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
