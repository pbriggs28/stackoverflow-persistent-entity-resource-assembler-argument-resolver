package com.prestonb.edu;

import com.prestonb.edu.dao.ReportRepository;
import com.prestonb.edu.domain.Report;
import com.prestonb.edu.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author pbriggs
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomRestControllerIntegrationTest {

    private static final String REPORT_NAME = "Report 1";

    @MockBean
    private ReportRepository repository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void thisTestPasses() throws Exception {
        given(repository.findById(any())).willReturn(Optional.of(new Report(1L, REPORT_NAME, new User(1L, "pbriggs"))));

        mvc.perform(get("/custom/reports/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(REPORT_NAME)))
                .andReturn().getResponse();
    }
}
