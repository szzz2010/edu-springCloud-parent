package com.haohao;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author rienchou
 * @Description:
 * @date 2018/9/19 12:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TiantianJobApplicationTests.class)
public class BaseTest {

    protected Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @Autowired
    private WebApplicationContext webApplicationContext;
    protected MockMvc mockMvc;

    @Before
    public void before() {
        logger.info("\n=====测试开始=====\n");
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void after() {
        logger.info("\n=====测试结束=====\n");
    }

}
