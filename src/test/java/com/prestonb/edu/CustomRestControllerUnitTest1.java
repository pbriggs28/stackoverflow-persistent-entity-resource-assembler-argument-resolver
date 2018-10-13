package com.prestonb.edu;

import com.prestonb.edu.dao.ReportRepository;
import com.prestonb.edu.domain.Report;
import com.prestonb.edu.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
@EnableSpringDataWebSupport
public class CustomRestControllerUnitTest1 {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReportRepository repository;

    /**
     * org.springframework.web.util.NestedServletException: Request processing failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler]: Constructor threw exception; nested exception is java.lang.IllegalArgumentException: entities is marked @NonNull but is null
     *
     * 	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:982)
     * 	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:866)
     * 	at javax.servlet.http.HttpServlet.service(HttpServlet.java:635)
     * 	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:851)
     * 	at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:71)
     * 	at javax.servlet.http.HttpServlet.service(HttpServlet.java:742)
     * 	at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:166)
     * 	at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:133)
     * 	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:99)
     * 	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
     * 	at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:133)
     * 	at org.springframework.web.filter.HttpPutFormContentFilter.doFilterInternal(HttpPutFormContentFilter.java:109)
     * 	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
     * 	at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:133)
     * 	at org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:93)
     * 	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
     * 	at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:133)
     * 	at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:165)
     * 	at com.prestonb.edu.CustomRestControllerUnitTest2.contextLoads(CustomRestControllerUnitTest2.java:38)
     * 	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
     * 	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
     * 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
     * 	at java.lang.reflect.Method.invoke(Method.java:498)
     * 	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
     * 	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
     * 	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
     * 	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
     * 	at org.springframework.test.context.junit4.statements.RunBeforeTestExecutionCallbacks.evaluate(RunBeforeTestExecutionCallbacks.java:73)
     * 	at org.springframework.test.context.junit4.statements.RunAfterTestExecutionCallbacks.evaluate(RunAfterTestExecutionCallbacks.java:83)
     * 	at org.springframework.test.context.junit4.statements.RunBeforeTestMethodCallbacks.evaluate(RunBeforeTestMethodCallbacks.java:75)
     * 	at org.springframework.test.context.junit4.statements.RunAfterTestMethodCallbacks.evaluate(RunAfterTestMethodCallbacks.java:86)
     * 	at org.springframework.test.context.junit4.statements.SpringRepeat.evaluate(SpringRepeat.java:84)
     * 	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
     * 	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:251)
     * 	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:97)
     * 	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
     * 	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
     * 	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
     * 	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
     * 	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
     * 	at org.springframework.test.context.junit4.statements.RunBeforeTestClassCallbacks.evaluate(RunBeforeTestClassCallbacks.java:61)
     * 	at org.springframework.test.context.junit4.statements.RunAfterTestClassCallbacks.evaluate(RunAfterTestClassCallbacks.java:70)
     * 	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
     * 	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.run(SpringJUnit4ClassRunner.java:190)
     * 	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
     * 	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
     * 	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
     * 	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
     * 	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
     * Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler]: Constructor threw exception; nested exception is java.lang.IllegalArgumentException: entities is marked @NonNull but is null
     * 	at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:182)
     * 	at org.springframework.web.method.annotation.ModelAttributeMethodProcessor.constructAttribute(ModelAttributeMethodProcessor.java:298)
     * 	at org.springframework.web.method.annotation.ModelAttributeMethodProcessor.createAttribute(ModelAttributeMethodProcessor.java:216)
     * 	at org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor.createAttribute(ServletModelAttributeMethodProcessor.java:84)
     * 	at org.springframework.web.method.annotation.ModelAttributeMethodProcessor.resolveArgument(ModelAttributeMethodProcessor.java:131)
     * 	at org.springframework.web.method.support.HandlerMethodArgumentResolverComposite.resolveArgument(HandlerMethodArgumentResolverComposite.java:124)
     * 	at org.springframework.web.method.support.InvocableHandlerMethod.getMethodArgumentValues(InvocableHandlerMethod.java:161)
     * 	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:131)
     * 	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:102)
     * 	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:891)
     * 	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:797)
     * 	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
     * 	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:991)
     * 	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:925)
     * 	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:974)
     * 	... 48 more
     * Caused by: java.lang.IllegalArgumentException: entities is marked @NonNull but is null
     * 	at org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler.<init>(PersistentEntityResourceAssembler.java:38)
     * 	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
     * 	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
     * 	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
     * 	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
     * 	at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:170)
     * 	... 62 more
     */
    @Test
    public void thisTestFails() throws Exception {
        Report report = new Report(1L,"Report 1", new User(1L,"pbriggs"));

        given(repository.findById(1L)).willReturn(Optional.of(report));

        // Fails with:
        //
        // Caused by: org.springframework.beans.BeanInstantiationException:
        // Failed to instantiate [org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler]:
        // Constructor threw exception; nested exception is java.lang.IllegalArgumentException:
        // entities is marked @NonNull but is null
        MvcResult mvcResult = mvc.perform(get("/custom/reports/1").accept(MediaTypes.HAL_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Report 1")))
                .andReturn();
    }

}
