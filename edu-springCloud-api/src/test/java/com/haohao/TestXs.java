package com.haohao;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
import com.haohao.util.springTools.redis.RedisClientTemplate;
import com.haohao.util.springTools.springJdbc.MysqlSpringJdbcDao;
import com.haohao.util.springTools.springJdbc.helper.DaoHelper;
import com.haohao.util.springTools.springJdbc.helper.HttpClientHelper;
import com.haohao.util.springTools.springJdbc.helper.SpringApplicationContextHolder;
import com.haohao.util.tools.RequestToXS;
import com.haohao.util.tools.XSMethodActionTool;
import com.haohao.util.tools.XsConfig;
import com.haohao.util.tools.XsFtpClientUtil;

//存管1.0 改造
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class TestXs {

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
           doConnectSpringJdbc();
           doConnectMybatis();
           doConnectRedis();
           doGetConfig();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void doConnectSpringJdbc() {
        try {
           List<Map<String, Object>> queryForList = mysqlSpringJdbcDao.queryForList3("ac_company_order",null,"order by id desc limit 10 ");
           List<Map<String, Object>> queryForList2 = DaoHelper.getMysqlSpringJdbcDao().queryForList(" select * from ac_company_order limit 10  ");
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
    public void doConnectRedis() {
        try {
          RedisClientTemplate bean = SpringApplicationContextHolder.getBean(RedisClientTemplate.class);
          bean.set("xs_version", "2.0");
          log.info("{}",bean.get("xs_version"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void doGetConfig() {
        try {
        	
            String url2 = XsConfig.url;
            log.info(url2);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doConnectXs() {
        Map<String, Object> sendMap = new HashMap<String, Object>();
        sendMap.put("loanNumber", "T2435U20180504180123");
        Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.LOAN_LOAN_SEARCH);
        log.info("{} ", resultMap);
    }
    

    /**
     * http://localhost:8080/api/api/loan/doAuth?pass=32914&tt_userId=144
     * http://api.tt.sanwenqian.cn/api/loan/doAuth?pass=32914&tt_userId=144
     * 存管密码： a11999
     * 设置授权信息
     * 验证 金额   0.01
     */

    /**
     * 验证码查询通道
     * https://my-st1.orangebank.com.cn/corporbank/otp.jsp
     */


    /**
     * domain test
     * http://edu-china.imwork.net/supply_chain_pc/xs/account/cardSet?company_id=34&mobile=13758004082&cardNum=6228480790859137323
     */

    /**
     * 开户绑卡测试
     * http://localhost:8080/xs/account/cardSet?company_id=34&mobile=13758004082&cardNum=6228480790859137323
     */
    
    /**
     * 前台地址    http://qiye.tt.sanwenqian.cn/html/login.html
     * 15210584373  qq000000
     * 
     */
    @Test
    public void openAccount() {

    	 String para = "弘美兰,15808633809,610426198904090922,6222003723622385753,工商银行|ICBC";
         
    	 String[] split = StringUtils.split(para, ",");

         Map<String, Object> company = new HashMap<>();
         company.put("loan_company_name", split[0]);
         company.put("loan_company_id_card", split[2]);
         company.put("bank_card_no", split[3]);
         company.put("bank_mobile", split[1]);
         
         long id = 0;
		try {
			id = (long) mysqlSpringJdbcDao.addSelectiveAndGetId("ac_company_order", company);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

         String url = "http://localhost:8080/supply_chain_pc/xs/account/cardSet?company_id=" + id + "&mobile=" + split[1] + "&cardNum=" + split[3] + "&cardName=" + split[4];

         String aaa = String.format(url, id, split[1], split[3]);
         System.out.println(aaa);


    }

    /**
     * 担保人账户查询
     */
    @Test
    public void searchAssureInfo() {
        try {
        	String bankUserId = "6034000000096636";
            Map<String, Object> assureAccountInfo = assetsDockingService.getAssureAccountInfo(bankUserId);
            log.info("{}", assureAccountInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 是否开户
     */
    @Test
    public void hasOpenAccountTest() {
        Map<String, Object> sendMap = new HashMap<>();
        sendMap.put("company_id", 1);
        try {
            Boolean hasOpenAcount = assetsDockingService.hasOpenAcount(sendMap);
            log.info("{}", hasOpenAcount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 是否设置交易密码
     */
    @Test
    public void hasSetPwd() {
        Map<String, Object> sendMap = new HashMap<>();
        sendMap.put("company_id", 1);
        try {
            Boolean result = assetsDockingService.hasSetPwd(1);
            log.info("{}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    /**
     * 重置交易密码
     */
    @Test
    public void resetDealPwdTest() {
        Map<String, Object> sendMap = new HashMap<>();
        sendMap.put("company_id", 23);
        try {
            Map<String, Object> result = assetsDockingService.resetDealpwdH5(sendMap);
            log.info("{}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void changeCard() {
        Map<String, Object> sendMap = new HashMap<>();
        sendMap.put("company_id", 23);
        try {
            Map<String, Object> result = assetsDockingService.bankcardChangeH5(sendMap);
            log.info("{}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    public void doAuth() {
        int company_id = 23;
        int order_id = 43;
//        mysqlSpringJdbcDao.Update(new Object[][]{{"company_id", company_id}, {"risk_control_auth", 1}, {"status", OrderStatusEnums.COMMIT_EVALUATE.name()}}, "ac_company_order", new Object[][]{{"id", order_id}});
        try {
            String content = "{\"BK_SERIAL\":\"1806050051780892\",\"TranWebCode\":\"6034\",\"amtEnd\":\"300000\",\"amtStart\":\"0\",\"custAccId\":\"6034000000032319\",\"endDate\":\"20230605\",\"errorCode\":\"000000\",\"errorMessage\":\"交易成功\",\"orderid\":\"12420110507000000006\",\"startDate\":\"20180605\",\"thirdCustId\":\"1022011050600000019\",\"transState\":\"S\",\"type\":\"010010\"}";
            assetsDockingService.borrowSetAuthor(JSON.parseObject(content, Map.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveContract() {
        Map<String, Object> sendMap = new HashMap<>();
        sendMap.put("quotaSum", new BigDecimal("1000000.00"));
        sendMap.put("startDate", "2018-06-01");
        sendMap.put("invalidDate", "2019-06-30");
        try {
            Map<String, Object> saveContract = assetsDockingService.saveContract(sendMap);
            log.info("{}", saveContract);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isAbleToDeployOrder() {
        try {
            Boolean ableToDeployOrder = assetsDockingService.isAbleToDeployOrder(1);
            log.info("{}",ableToDeployOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 推送进件
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


    /**
     * 放款成功后
     * 查询放款结果
     * @Author:rienchou
     * @Date: 2018/6/22 16:30
     */
    @Test
    public void searchLoanLoanResult() {
        try {
            assetsDockingService.searchLoanResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loanLoanResultNotice() {
        String content = "{\"endTime\":\"2018-06-11 15:59:00\",\"loanAmount\":\"44.00\",\"loanNumber\":\"JK201806228504\",\"result\":\"04\"}";
        try {
            assetsDockingService.loanLoanResultNotice(JSON.parseObject(content, Map.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    
    @Test
    public void borrowAccountWithdrawH5() {
        String content = "{\"BK_SERIAL\":\"1806110051844864\",\"TranWebCode\":\"6034\",\"busOrderId\":\"601D20180613110903\",\"custAccId\":\"6034000000032319\",\"errorCode\":\"000000\",\"errorMessage\":\"交易接收成功,请稍后查询处理结果\",\"orderid\":\"12420110513000000011\",\"thirdCustId\":\"1022011050600000019\",\"transState\":\"S\"}";
        try {
            assetsDockingService.borrowAccountWithdrawH5(JSON.parseObject(content, Map.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchTiXianActionResult() {
    	int order_id = 1 ;
        try {
            int i = assetsDockingService.searchTiXianActionResult(order_id);
            log.info("i=[{}]",i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @Test
    public void searchTiXianResult() {
        try {
            assetsDockingService.searchTiXianResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    

    @Test
    public void getAccountInfo() {
        Map<String, Object> sendMap = new HashMap<>();
        sendMap.put("company_id", 23);
        try {
            assetsDockingService.getAccountInfo(sendMap);
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
        Map<String, Object> sendMap = new HashMap<>();
        sendMap.put("order_id", 601);
        try {
            assetsDockingService.manualRepaymentNotice(sendMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    @Test
    public void dzApply() {
        Map<String, Object> sendMap = new HashMap<>();
        sendMap.put("order_id", 601);
        try {
            assetsDockingService.dzApply(sendMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    @Test
    public void dzApplyResultNotice() {
    	
    	int order_id = 601 ;
    	
    	String order_no = (String) mysqlSpringJdbcDao.queryForObject(" select order_no from ac_company_order where order_id = ? ", String.class, order_id);
    	
        Map<String, Object> sendMap = new HashMap<>();
        sendMap.put("loanNumber", order_no);  // VARCHAR(64)
        sendMap.put("loanTerms", 1);   // NUMBER(4)
        sendMap.put("result", "0000");      // VARCHAR(4)
        try {
            assetsDockingService.dzApplyResultNotice(sendMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   
    @Test
    public void queryAttachmentInfo() {
        String loanNumber = "JK201806251601";
        Map<String, Object> sendMap = new HashMap<>();
        sendMap.put("loanNumber", loanNumber);
        try {
        	File zipFilePathDir = new File("D:/xs/haohao/data/qiye/sp/20180619/");
    		if(!zipFilePathDir.exists()){
    			if(!zipFilePathDir.mkdirs()){
    				log.info("需要存储的  zipFilePath 路径不存在， 自动创建目录失败！");
    			}
    			log.info("需要存储的  zipFilePath 路径不存在， 自动创建目录成功！");
    		}
            Map<String, Object> resultMap = assetsDockingService.queryAttachmentInfo(sendMap);
            log.info("{}", resultMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchElectronicSignature() {
        try {
//        	int order_id = 601 ;
//            assetsDockingService.searchElectronicSignatureByOrderId(order_id);
        	
        	XsFtpClientUtil ftpClientUtil = new XsFtpClientUtil(XsConfig.xs_ftp_host, Integer.parseInt(XsConfig.xs_ftp_port), XsConfig.xs_ftp_username, XsConfig.xs_ftp_password);
        	
        	String remoteAbsoluteFile = "/cfca/XS20180522155245/XS20180522155245.zip";
        	String localFilePath = "D:/cfca/sd";
        	String localFileName = "a.zip";
        	boolean b = ftpClientUtil.get(remoteAbsoluteFile, localFilePath, localFileName);
        	log.info("{}",b);
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
        
    
    
    
    
    
    
    public static void main(String[] args) {
        try {
            //String orderDeadLine = AssetDockingHelper.getOrderDeadLine("2018-06-01 15:36:02", 30);
            //System.out.println(orderDeadLine);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        String aa = "cardFace-a647dba8-4ca4-40a7-8721-0b80eb83c53f.png";
        System.out.println(StringUtils.split(aa, ".")[1]);



    }


    
    

}
