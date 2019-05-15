package com.haohao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.haohao.dao.AcCompanyOrderDao;
import com.haohao.modelAndExample.AcCompanyOrder;
import com.haohao.service.xs.AssetsDockingService;
import com.haohao.util.springTools.springJdbc.MysqlSpringJdbcDao;
import com.haohao.util.springTools.springJdbc.helper.ConfigBootHelper;
import com.haohao.util.springTools.springJdbc.helper.DaoHelper;
import com.haohao.util.springTools.springJdbc.helper.HttpClientHelper;
import com.haohao.util.springTools.springJdbc.helper.TimeHelper;
import com.haohao.util.tools.RequestToXS;
import com.haohao.util.tools.XSMethodActionTool;
import com.haohao.util.tools.XsConfig;

//存管1.0 改造
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class TestXs_Job {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    MysqlSpringJdbcDao mysqlSpringJdbcDao;
    
    @Autowired 
    AssetsDockingService assetsDockingService;
    
    @Autowired
    AcCompanyOrderDao acCompanyOrderDao ;

    @Test
    public void doConnectDataBase() {
        try {
           List<Map<String, Object>> queryForList = mysqlSpringJdbcDao.queryForList3("jz_ac_company_order",null,"order by id desc");
           List<Map<String, Object>> queryForList2 = DaoHelper.getMysqlSpringJdbcDao().queryForList(" select * from ac_company_order  ");
           log.info("{}",queryForList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doConnectMybatis() {
        try {
         AcCompanyOrder findById = acCompanyOrderDao.findById(1);
         log.info("{}",findById);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getConfig() {
        try {
        	String url= "http://10.200.6.185:8080/haohao-risk_auth_api/api/xs/jiezhong/level";
        	Map<String,Object> sendMap = new HashMap<>();
        	sendMap.put("amount", new BigDecimal("250000.00").toString());
        	String exec = HttpClientHelper.exec(url, "1", "1", sendMap);
        	
            String propertyByName = ConfigBootHelper.getPropertyByName("project");
            String xs_agency_code = XsConfig.xs_agency_code;
            String url2 = XsConfig.url;
            log.info(url2);
            

            log.info(xs_agency_code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doConnectXs() {
        Map<String, Object> sendMap = new HashMap<String, Object>();
        sendMap.put("loanNumber", "T2435U20180504180123");
        String url = XsConfig.url;
        String exec = HttpClientHelper.exec(url, "1", "0", sendMap);
        
        
        Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.LOAN_LOAN_SEARCH);
        log.info("{} ", resultMap);
    }
    

    /**
     * 是否开户
     */
    @Test
    public void hasOpenAccountTest() {
        int company_id = 2;
        String mobile = "13049897458";
        try {
//            Boolean hasOpenAcount = assetsDockingService_v1.hasOpenAcount(params);
//            log.info("{}", hasOpenAcount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    /**
     * 查询账户信息
     */
    @Test
    public void getAccountInfoByCompanyId() {
        int company_id = 2;
        try {
//            Map<String, Object> account = assetsDockingService.getAccountInfoByCompanyId(company_id);
//            log.info("{}", account);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 发送短信验证码
     * 1.0  测试环境  短信验证码  默认   111111
     */
    @Test
    public void sendMobileCode() {
        int company_id = 602;
        String mobile = "13758004083";
        String cardNum = "6228480790889137339";
        String bankName = "中国农业银行";
        try {
//            boolean flag = assetsDockingService.sendPingAnMobileCode(company_id, mobile, cardNum, bankName);
//            log.info("{}", flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 开户
     * 1.0  测试环境  短信验证码  默认   111111
     */
    @Test
    public void openAccount() {
        int company_id = 601;
        String mobile = "13758004083";
        String bankCard = "6228480790889137339";
        String bankName = "中国农业银行";
		String bankCity = "西雅图";
		String bankProvince = "西雅图";
		String superBankCode = "103100000026";
		String smsCode = "111111";
        
		Map<String,Object> params = new HashMap<>();
		params.put("company_id", company_id);
		params.put("mobile", mobile);
		params.put("bankCard", bankCard);
		params.put("bankName", bankName);
		params.put("bankCity", bankCity);
		params.put("bankProvince",bankProvince );
		params.put("superBankCode", superBankCode);
		params.put("smsCode", smsCode);
        
        try {
//            boolean flag = assetsDockingService.openAccount(params);
//            log.info("{}", flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //--------------------------------------------------------------------------
    
    @Test
    public void saveContract() {
        Map<String, Object> sendMap = new HashMap<>();
        sendMap.put("quotaSum", new BigDecimal("10000000.00"));
        sendMap.put("startDate", "2018-06-01");
        sendMap.put("invalidDate", "2018-12-30");
        try {
            Map<String, Object> saveContract = assetsDockingService.saveContract(sendMap);
            log.info("{}", saveContract);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 推送进件
     *
     *  使用学习测试环境   183 数据库 可以成功
     *
     * @Author:rienchou
     * @Date: 2018/6/19 18:32
     */
    @Test
    public void autoDeployOrder() {

        try {
        	assetsDockingService.autoDeployOrder();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查结果
     * @Author:rienchou
     * @Date: 2018/7/12 17:17
     */
    @Test
    public void searchDeployResult() {
        try {
        	assetsDockingService.searchDeployResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    @Test
    public void deployResultNotice() {
        Map<String, Object> params = new HashMap<>();
        params.put("loanNumber", "JK201805315100");
        params.put("status", "0");  //进件结果 （0：失败 1：成功）
        params.put("message", "进件失败");

        try {
            assetsDockingService.deployResultNotice(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryLoanAuditResult() {
        try {
        	assetsDockingService.searchLoanAuditResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    @Test
    public void auditResultNotice() {
    	//{"message":"审批中","result":"00","loanNumber":"JK201807122631"}
        Map<String, Object> params = new HashMap<>();
        params.put("loanNumber", "JK201807122631");
        params.put("result", "00");  
        params.put("message", "审批中");
        params.put("loanAmount", "0.00");
        params.put("endTime", TimeHelper.getCurrentTime());

        try {
            assetsDockingService.loanAuditNotice(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 放款结果查询
     * @Author:rienchou
     * @Date: 2018/6/22 16:30
     */
    @Test
    public void searchLoanResult() {
        try {
        	assetsDockingService.searchLoanResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loanResultNoticeFromXS() {
        String content = "{\"endTime\":\"2018-06-11 15:59:00\",\"loanAmount\":\"44.00\",\"loanNumber\":\"JK201806228504\",\"result\":\"04\"}";
        try {
        	
        	assetsDockingService.loanLoanResultNotice(JSON.parseObject(content));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    /**
     * 提现结果查询
     * @Author:rienchou
     * @Date: 2018/6/22 16:30
     */
    @Test
    public void searchWithdrawResult() {
        try {
        	assetsDockingService.searchTiXianResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void drawResultNoticeFromXS() {
        String content = "{\"endTime\":\"2018-06-11 15:59:00\",\"loanAmount\":\"44.00\",\"loanNumber\":\"JK201806228504\",\"result\":\"04\"}";
        try {
//        	assetsDockingService.drawResultNoticeFromXS(JSON.parseObject(content, Map.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    @Test
    public void autoRepay() {
        try {
        	assetsDockingService.automaticRepaymentNotice();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    @Test
    public void manualRepay() {
    	int order_id = 1 ;
        try {
//        	assetsDockingService.manualRepaymentNotice(order_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testConnectFengkong(){
    	
    	String url= "http://10.200.6.185:8080/haohao-risk_auth_api/api/xs/jiezhong/level";
    	Map<String,Object> sendMap = new HashMap<>();
    	sendMap.put("amount", new BigDecimal("250000.00").toString());
    	String exec = HttpClientHelper.exec(url, "1", "1", sendMap);
    	
    	//返回格式  
    	/*
    	  {
    		  "code": "00000",
    		  "msg": "成功",
    		  "data": "D"
    		}
    	 **/
    	System.out.println(exec);
    	
    }
    
    
    public static void main(String[] args) {
       
    	Object [][] params = new Object[][]{{"a1","aaa"},{"b1","bbb"},{"c1","ccc"}};
    	
    	List<Object> asList = Arrays.asList(params);
    	
    	
    	
    	
    	
    	
  
    }

    
    
    

}
