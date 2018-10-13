package com.prestonb.edu.dao;

import com.prestonb.edu.domain.Report;
import org.springframework.data.repository.CrudRepository;

/**
 * @author pbriggs
 */
public interface ReportRepository extends CrudRepository<Report, Long> {

    Report findByName(String name);

}
