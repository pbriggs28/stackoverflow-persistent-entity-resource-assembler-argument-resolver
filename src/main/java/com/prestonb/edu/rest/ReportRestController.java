package com.prestonb.edu.rest;

import com.prestonb.edu.dao.ReportRepository;
import com.prestonb.edu.domain.Report;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pbriggs
 */
@RepositoryRestController
//@BasePathAwareController
@RestController
@RequestMapping(produces = MediaTypes.HAL_JSON_VALUE )
public class ReportRestController {

    private final ReportRepository reportRepository;

    public ReportRestController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @GetMapping(path = "/custom/reports/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<?> customReportsEndpoint(@PathVariable("id") Long id, PersistentEntityResourceAssembler entityAssembler) {
        return ResponseEntity.ok(entityAssembler.toResource(serviceFindById(id)));
    }

    private Report serviceFindById(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No report found with ID: " + id));
    }
}
