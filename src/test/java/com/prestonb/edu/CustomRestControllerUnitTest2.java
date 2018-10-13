package com.prestonb.edu;

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

public class CustomRestControllerUnitTest2 {

    @Mock
    private PersistentEntityResourceAssembler assembler;

    @Mock
    private PersistentEntityResourceAssemblerArgumentResolver assemblerResolver;

    @Mock
    private PersistentEntity<Report, ?> entity;

    @InjectMocks
    private ReportRestController controller;

    private MockMvc mvc;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private ReportRepository repository;

    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.standaloneSetup(controller)
                .setCustomArgumentResolvers(assemblerResolver)
                .build();
    }

    /**
     * org.springframework.web.util.NestedServletException: Request processing failed; nested exception is org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class org.mockito.internal.junit.DefaultStubbingLookupListener]; nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class org.mockito.internal.junit.DefaultStubbingLookupListener and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain: org.springframework.data.rest.webmvc.PersistentEntityResource["persistentEntity"]->org.springframework.data.mapping.PersistentEntity$MockitoMock$2115290768["mockitoInterceptor"]->org.mockito.internal.creation.bytebuddy.MockMethodInterceptor["mockHandler"]->org.mockito.internal.handler.InvocationNotifierHandler["mockSettings"]->org.mockito.internal.creation.settings.CreationSettings["stubbingLookupListeners"]->java.util.ArrayList[0])
     *
     * 	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:982)
     * 	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:866)
     * 	at javax.servlet.http.HttpServlet.service(HttpServlet.java:635)
     * 	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:851)
     * 	at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:71)
     * 	at javax.servlet.http.HttpServlet.service(HttpServlet.java:742)
     * 	at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:166)
     * 	at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:133)
     * 	at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:165)
     * 	at com.prestonb.edu.CustomRestControllerUnitTest2.thisTestFails(CustomRestControllerUnitTest2.java:78)
     * 	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
     * 	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
     * 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
     * 	at java.lang.reflect.Method.invoke(Method.java:498)
     * 	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
     * 	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
     * 	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
     * 	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
     * 	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)
     * 	at org.mockito.internal.junit.JUnitRule$1.evaluateSafely(JUnitRule.java:52)
     * 	at org.mockito.internal.junit.JUnitRule$1.evaluate(JUnitRule.java:43)
     * 	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
     * 	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
     * 	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
     * 	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
     * 	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
     * 	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
     * 	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
     * 	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
     * 	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
     * 	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
     * 	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
     * 	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
     * 	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
     * 	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
     * Caused by: org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class org.mockito.internal.junit.DefaultStubbingLookupListener]; nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class org.mockito.internal.junit.DefaultStubbingLookupListener and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain: org.springframework.data.rest.webmvc.PersistentEntityResource["persistentEntity"]->org.springframework.data.mapping.PersistentEntity$MockitoMock$2115290768["mockitoInterceptor"]->org.mockito.internal.creation.bytebuddy.MockMethodInterceptor["mockHandler"]->org.mockito.internal.handler.InvocationNotifierHandler["mockSettings"]->org.mockito.internal.creation.settings.CreationSettings["stubbingLookupListeners"]->java.util.ArrayList[0])
     * 	at org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter.writeInternal(AbstractJackson2HttpMessageConverter.java:291)
     * 	at org.springframework.http.converter.AbstractGenericHttpMessageConverter.write(AbstractGenericHttpMessageConverter.java:102)
     * 	at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor.writeWithMessageConverters(AbstractMessageConverterMethodProcessor.java:272)
     * 	at org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor.handleReturnValue(HttpEntityMethodProcessor.java:224)
     * 	at org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite.handleReturnValue(HandlerMethodReturnValueHandlerComposite.java:82)
     * 	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:119)
     * 	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:891)
     * 	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:797)
     * 	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
     * 	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:991)
     * 	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:925)
     * 	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:974)
     * 	... 34 more
     * Caused by: com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class org.mockito.internal.junit.DefaultStubbingLookupListener and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain: org.springframework.data.rest.webmvc.PersistentEntityResource["persistentEntity"]->org.springframework.data.mapping.PersistentEntity$MockitoMock$2115290768["mockitoInterceptor"]->org.mockito.internal.creation.bytebuddy.MockMethodInterceptor["mockHandler"]->org.mockito.internal.handler.InvocationNotifierHandler["mockSettings"]->org.mockito.internal.creation.settings.CreationSettings["stubbingLookupListeners"]->java.util.ArrayList[0])
     * 	at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:77)
     * 	at com.fasterxml.jackson.databind.SerializerProvider.reportBadDefinition(SerializerProvider.java:1191)
     * 	at com.fasterxml.jackson.databind.DatabindContext.reportBadDefinition(DatabindContext.java:312)
     * 	at com.fasterxml.jackson.databind.ser.impl.UnknownSerializer.failForEmpty(UnknownSerializer.java:71)
     * 	at com.fasterxml.jackson.databind.ser.impl.UnknownSerializer.serialize(UnknownSerializer.java:33)
     * 	at com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer.serializeContents(IndexedListSerializer.java:119)
     * 	at com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer.serialize(IndexedListSerializer.java:79)
     * 	at com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer.serialize(IndexedListSerializer.java:18)
     * 	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:727)
     * 	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:719)
     * 	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:155)
     * 	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:727)
     * 	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:719)
     * 	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:155)
     * 	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:727)
     * 	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:719)
     * 	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:155)
     * 	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:727)
     * 	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:719)
     * 	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:155)
     * 	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:727)
     * 	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:719)
     * 	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:155)
     * 	at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:480)
     * 	at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:319)
     * 	at com.fasterxml.jackson.databind.ObjectWriter$Prefetch.serialize(ObjectWriter.java:1396)
     * 	at com.fasterxml.jackson.databind.ObjectWriter.writeValue(ObjectWriter.java:913)
     * 	at org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter.writeInternal(AbstractJackson2HttpMessageConverter.java:285)
     * 	... 45 more
     */
    @Test
    public void thisTestFails() throws Exception {
        Report report = new Report(1L,"Report 1", new User(1L,"pbriggs"));

        given(repository.findById(1L)).willReturn(Optional.of(report));
        given(assemblerResolver.supportsParameter(any())).willReturn(true);
        given(assemblerResolver.resolveArgument(any(), any(), any(), any())).willReturn(assembler);
        given(assembler.toResource(report)).willReturn(PersistentEntityResource.build(report, entity).build());

        // Fails with:
        //
        // Caused by: com.fasterxml.jackson.databind.exc.InvalidDefinitionException:
        // No serializer found for class org.mockito.internal.junit.DefaultStubbingLookupListener and no
        // properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)
        // (through reference chain:
        // org.springframework.data.rest.webmvc.PersistentEntityResource["persistentEntity"]
        // ->org.springframework.data.mapping.PersistentEntity$MockitoMock$1659608278["mockitoInterceptor"]
        // ->org.mockito.internal.creation.bytebuddy.MockMethodInterceptor["mockHandler"]
        // ->org.mockito.internal.handler.InvocationNotifierHandler["mockSettings"]
        // ->org.mockito.internal.creation.settings.CreationSettings["stubbingLookupListeners"]
        // ->java.util.ArrayList[0])
        MvcResult mvcResult = mvc.perform(get("/custom/reports/1").accept(MediaTypes.HAL_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Report 1")))
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$._links.enteredBy").exists())
                .andReturn();
    }
}
