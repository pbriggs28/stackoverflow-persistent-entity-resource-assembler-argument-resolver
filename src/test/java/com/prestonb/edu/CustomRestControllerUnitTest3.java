package com.prestonb.edu;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.prestonb.edu.dao.ReportRepository;
import com.prestonb.edu.domain.Report;
import com.prestonb.edu.domain.User;
import com.prestonb.edu.rest.ReportRestController;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.config.PersistentEntityResourceAssemblerArgumentResolver;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CustomRestControllerUnitTest3 {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private PersistentEntityResourceAssembler assembler;

    @Mock
    private PersistentEntityResourceAssemblerArgumentResolver assemblerResolver;

    @Mock
    private PersistentEntity<Report, ?> entity;

    @InjectMocks
    private ReportRestController controller;

    private MockMvc mvc;

    @Mock
    private ReportRepository repository;

    @Before
    public void setup() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        this.mvc = MockMvcBuilders.standaloneSetup(controller)
                .setMessageConverters(converter)
                .setCustomArgumentResolvers(assemblerResolver)
                .build();
    }

    @Test
    public void thisTestFails() throws Exception {
        Report report = new Report(1L,"Report 1", new User(1L,"pbriggs"));

        given(repository.findById(1L)).willReturn(Optional.of(report));
        given(assemblerResolver.supportsParameter(any())).willReturn(true);
        given(assemblerResolver.resolveArgument(any(), any(), any(), any())).willReturn(assembler);
        given(assembler.toResource(report)).willReturn(PersistentEntityResource.build(report, entity).build());

        MvcResult mvcResult = mvc.perform(get("/custom/reports/1").accept(MediaTypes.HAL_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Report 1")))
                .andExpect(jsonPath("$.name").exists())
                // Fails:
                //
                // Caused by: com.jayway.jsonpath.PathNotFoundException: Missing property in path $['_links']
                .andExpect(jsonPath("$._links.enteredBy").exists())
                .andReturn();

        /*
         * Expected (HAL document):
         *
         * {
         *   "name" : "Report 1",
         *   "_links" : {
         *     "self" : {
         *       "href" : "http://localhost/reports/1"
         *     },
         *     "report" : {
         *       "href" : "http://localhost/reports/1"
         *     },
         *     "enteredBy" : {
         *       "href" : "http://localhost/reports/1/enteredBy"
         *     }
         *   }
         * }
         *
         * Actual (Normal json):
         *
         * {
         *   "id": 1,
         *   "name": "Report 1",
         *   "enteredBy": {
         *     "id": 1,
         *     "username": "pbriggs"
         *   }
         *   // plus a bunch of mockito properties
         * }
         */
    }
}
