package com.haohao.service.order;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haohao.modelAndExample.LoanOrderInfo;
import com.haohao.modelAndExample.LoanUserInfo;
import com.haohao.modelAndExample.LoanUserJobInfo;
import com.haohao.modelAndExample.RiskExtraInfo;
import com.haohao.util.encrypt.Encrypt;
import com.haohao.util.service.DateUtil;

/**
 * @Desc 订单风控辅助类
 * @Author xiekunliang
 * @Date 2018/5/29 13:47
 */
@Component
public class OrderRiskParameterService {

    public JSONObject getSendData(LoanOrderInfo loanOrderInfo, LoanUserJobInfo jobInfo, LoanUserInfo userInfo){
        JSONObject json = new JSONObject();
        JSONArray jsonarray = new JSONArray();
        JSONObject jsonItem = new JSONObject();
        jsonItem.put("id", loanOrderInfo.getOrderId());
        jsonItem.put("age", userInfo.getAge());
        int edu = Integer.parseInt(userInfo.getEducation());
        if(edu >= 4){
            edu = 4;
        }
        jsonItem.put("edu", edu);
        jsonItem.put("loanPurpose", loanOrderInfo.getLoanPurpose());
        jsonItem.put("workYear", getWorkYear(jobInfo.getStartDate()));
        jsonItem.put("income", jobInfo.getMonthlyIncome());
        jsonItem.put("post", Integer.parseInt(jobInfo.getDutyJob()));
        int familyknow = "1".equals(userInfo.getFamilyIsKnown()) ? 1 :2;;
        jsonItem.put("familyknow", familyknow);
        jsonItem.put("maritalStatus", Integer.parseInt(userInfo.getMarriage()));
        jsonarray.add(jsonItem);
        json.put("data", jsonarray.toString());
        return json;
    }

    //获取不放款的风控数据
    public JSONObject getNotPaySendData(LoanOrderInfo loanOrderInfo,LoanUserJobInfo jobInfo,LoanUserInfo userInfo) throws Exception{
        String loanNumber = loanOrderInfo.getLoanNumber();
        String name = Encrypt.decryptAES(userInfo.getName());
        Integer gender = userInfo.getGender();
        if(gender == 0){//女
            gender = 2;
        }
        Integer age = userInfo.getAge();
        String education = userInfo.getEducation();

        Integer edu = null;
        if(isNumeric(education)){
            edu = Integer.parseInt(education);
            if(edu >= 4){
                edu = 4;
            }
        }

        String loanPurPoseStr = loanOrderInfo.getLoanPurpose();
        Integer loanPurpose = null;
        if(isNumeric(loanPurPoseStr)){
            loanPurpose = Integer.parseInt(loanPurPoseStr);
        }

        String startDate = jobInfo.getStartDate();
        Integer workYear = null;
        if(isTime(startDate)){
            workYear = getWorkYear(startDate);
        }
        BigDecimal income = jobInfo.getMonthlyIncome();

        String dutyJob = jobInfo.getDutyJob();
        Integer post = null;
        if(isNumeric(dutyJob)){
            post = Integer.parseInt(dutyJob);
        }

        int familyknow = "1".equals(userInfo.getFamilyIsKnown()) ? 1 :2;

        String marriage = userInfo.getMarriage();
        Integer maritalStatus = null;
        if(isNumeric(marriage)){
            maritalStatus = Integer.parseInt(marriage);
        }

        String cellphone = Encrypt.decryptAES(userInfo.getCellPhone());
        String idNo = Encrypt.decryptAES(userInfo.getIdCardNo());
        String productCode = loanOrderInfo.getProductCode();

        String signDate = userInfo.getSignDate();
        Integer loanTime = null;
        if(isDate(signDate)){
            loanTime = DateUtil.getUnixTimeStamp(signDate, DateUtil.YYYY_MM_DD);
        }

        BigDecimal loanAmount = loanOrderInfo.getContractAmt();
        Integer loanDuration = loanOrderInfo.getLoanTerms();

        String repayType = loanOrderInfo.getRepayType();
        String filePath = loanOrderInfo.getFilePath();
        int status = 0;

        JSONObject json = new JSONObject();
        JSONArray jsonarray = new JSONArray();
        JSONObject js = new JSONObject();

        js.put("loanNumber", loanNumber);
        js.put("gender", gender);
        js.put("age", age);
        js.put("name", name);
        js.put("idNo", idNo);
        js.put("cellPhone", cellphone);
        js.put("loanAmount", loanAmount);
        js.put("edu", edu);
        js.put("loanPurpose", loanPurpose);
        js.put("workYear", workYear);
        js.put("income", income);
        js.put("post", post);
        js.put("familyknow", familyknow);
        js.put("maritalStatus", maritalStatus);
        js.put("productCode", productCode);
        js.put("loanTime", loanTime);
        js.put("loanDuration", loanDuration);
        js.put("repayType", repayType);
        js.put("status", status);
        js.put("filePath", filePath);
        jsonarray.add(js);
        json.put("data", jsonarray.toString());
        return json;
    }

    //获取打款风控数据
    public JSONObject getPaySendData(LoanOrderInfo loanOrderInfo,LoanUserJobInfo jobInfo,LoanUserInfo userInfo) throws Exception{
        String loanNumber = loanOrderInfo.getLoanNumber();
        String name = Encrypt.decryptAES(userInfo.getName());
        int gender = 0 == userInfo.getGender() ? 2 : 1;
        int age = userInfo.getAge();
        int edu = Integer.parseInt(userInfo.getEducation());
        if(edu >= 4){
            edu = 4;
        }
        int loanPurpose = Integer.parseInt(loanOrderInfo.getLoanPurpose());
        int workYear = getWorkYear(jobInfo.getStartDate());
        BigDecimal income = jobInfo.getMonthlyIncome();
        int post = Integer.parseInt(jobInfo.getDutyJob());
        int familyknow = "1".equals(userInfo.getFamilyIsKnown()) ? 1 :2;
        int maritalStatus = Integer.parseInt(userInfo.getMarriage());
        String cellPhone = Encrypt.decryptAES(userInfo.getCellPhone());
        String idNo = Encrypt.decryptAES(userInfo.getIdCardNo());
        String productCode = loanOrderInfo.getProductCode();
        int loanTime = DateUtil.getUnixTimeStamp(userInfo.getSignDate(), DateUtil.YYYY_MM_DD);
        BigDecimal loanAmount = loanOrderInfo.getContractAmt();
        int loanDuration = loanOrderInfo.getLoanTerms();
        String repayType = loanOrderInfo.getRepayType();
        String filePath = loanOrderInfo.getFilePath();
        int status = 1;
        JSONObject json = new JSONObject();
        JSONArray jsonarray = new JSONArray();
        JSONObject js = new JSONObject();

        js.put("loanNumber", loanNumber);
        js.put("gender", gender);
        js.put("age", age);
        js.put("name", name);
        js.put("idNo", idNo);
        js.put("cellPhone", cellPhone);
        js.put("loanAmount", loanAmount);
        js.put("edu", edu);
        js.put("loanPurpose", loanPurpose);
        js.put("workYear", workYear);
        js.put("income", income);
        js.put("post", post);
        js.put("familyknow", familyknow);
        js.put("maritalStatus", maritalStatus);
        js.put("productCode", productCode);
        js.put("loanTime", loanTime);
        js.put("loanDuration", loanDuration);
        js.put("repayType", repayType);
        js.put("status", status);
        js.put("filePath", filePath);
        jsonarray.add(js);
        json.put("data", jsonarray.toString());
        return json;
    }

    private boolean isNumeric(String s) {
        if (s != null && !"".equals(s.trim()))
            return s.matches("^[0-9]*$");
        else
            return false;
    }
    private boolean isTime(String s){
        if (s != null && !"".equals(s.trim()))
            return s.matches("((19)|(20))\\d\\d-((0[1-9])|(1[012]))-((0[1-9])|([12][0-9])|(3[01]))\\s((0[0-9])|(1[0-9])|(2[0-3])):[0-5][0-9]:[0-5][0-9]");
        else
            return false;
    }

    private boolean isDate(String s){
        if (s != null && !"".equals(s.trim()))
            return s.matches("((19)|(20))\\d\\d-((0[1-9])|(1[012]))-((0[1-9])|([12][0-9])|(3[01]))");
        else
            return false;
    }


    private int getWorkYear(String startDate){
        //1-5年以上 2-(3-5年) 3-(1-3年（含3)）4-(1年以内)
        int unixTime = DateUtil.getUnixTimeStamp(startDate, DateUtil.YYYY_MM_DD_HH_MM_SS);
        int cha = DateUtil.unixTimestamp() - unixTime;
        int days = cha / 86400;
        int year = days / 365;
        int mark = 0;
        if(year < 1){
            mark = 4;
        }else if(year >=1 && year <3){
            mark = 3;
        }else if(year >=3 && year <5){
            mark = 2;
        }else{
            mark = 1;
        }
        return mark;
    }
    

	public JSONObject getYqbPayData(LoanOrderInfo loanOrderInfo,LoanUserJobInfo jobInfo,LoanUserInfo userInfo,RiskExtraInfo riskExtraInfo)throws Exception{
		String loanNumber = loanOrderInfo.getLoanNumber();
        String name = Encrypt.decryptAES(userInfo.getName());
        int gender = 0 == userInfo.getGender() ? 2 : 1;
        int age = userInfo.getAge();
        int edu = Integer.parseInt(userInfo.getEducation());
        if(edu >= 4){
            edu = 4;
        }
        int loanPurpose = Integer.parseInt(loanOrderInfo.getLoanPurpose());
        int post = Integer.parseInt(jobInfo.getDutyJob());
        String cellPhone = Encrypt.decryptAES(userInfo.getCellPhone());
        String idNo = Encrypt.decryptAES(userInfo.getIdCardNo());
        String productCode = loanOrderInfo.getProductCode();
        int loanTime = DateUtil.getUnixTimeStamp(userInfo.getSignDate(), DateUtil.YYYY_MM_DD);
        BigDecimal loanAmount = loanOrderInfo.getContractAmt();
        int loanDuration = loanOrderInfo.getLoanTerms();
        String repayType = loanOrderInfo.getRepayType();
        String filePath = loanOrderInfo.getFilePath();
        int status = 1;
        
        String city = userInfo.getSubmitCity();
        Integer onlineTime = riskExtraInfo.getNetDuration();
        Integer orderAddressNum = riskExtraInfo.getOrderAddressNum();
        Integer orderNum = riskExtraInfo.getOrderNum();
        String authType = riskExtraInfo.getAuthType();
        
        JSONObject json = new JSONObject();
        JSONArray jsonarray = new JSONArray();
        JSONObject js = new JSONObject();

        js.put("loanNumber", loanNumber);//
        js.put("gender", gender);//
        js.put("age", age);//
        js.put("name", name);//
        js.put("idNo", idNo);//
        js.put("cellPhone", cellPhone);//
        js.put("loanAmount", loanAmount);//
        js.put("loanPurpose", loanPurpose);//
        js.put("post", post);//
        js.put("productCode", productCode);//
        js.put("loanTime", loanTime);//
        js.put("loanDuration", loanDuration);//
        js.put("repayType", repayType);//
        js.put("status", status);//
        js.put("filePath", filePath);//
        
        js.put("city", city);//
        js.put("onlineTime", onlineTime);//
        js.put("addressNum", orderAddressNum);//
        js.put("orderCount", orderNum);//
        js.put("authentication", authType);//
        
        jsonarray.add(js);
        json.put("data", jsonarray.toString());
        return json;
	}
	
	public JSONObject getYqbNotPayData(LoanOrderInfo loanOrderInfo,LoanUserJobInfo jobInfo,LoanUserInfo userInfo,RiskExtraInfo riskExtraInfo)throws Exception{
		String loanNumber = loanOrderInfo.getLoanNumber();
        String name = Encrypt.decryptAES(userInfo.getName());
        Integer gender = userInfo.getGender();
        if(gender == 0){//女
            gender = 2;
        }
        Integer age = userInfo.getAge();
        String education = userInfo.getEducation();

        Integer edu = null;
        if(isNumeric(education)){
            edu = Integer.parseInt(education);
            if(edu >= 4){
                edu = 4;
            }
        }

        String loanPurPoseStr = loanOrderInfo.getLoanPurpose();
        Integer loanPurpose = null;
        if(isNumeric(loanPurPoseStr)){
            loanPurpose = Integer.parseInt(loanPurPoseStr);
        }


        String dutyJob = jobInfo.getDutyJob();
        Integer post = null;
        if(isNumeric(dutyJob)){
            post = Integer.parseInt(dutyJob);
        }

        String cellphone = Encrypt.decryptAES(userInfo.getCellPhone());
        String idNo = Encrypt.decryptAES(userInfo.getIdCardNo());
        String productCode = loanOrderInfo.getProductCode();

        String signDate = userInfo.getSignDate();
        Integer loanTime = null;
        if(isDate(signDate)){
            loanTime = DateUtil.getUnixTimeStamp(signDate, DateUtil.YYYY_MM_DD);
        }

        BigDecimal loanAmount = loanOrderInfo.getContractAmt();
        Integer loanDuration = loanOrderInfo.getLoanTerms();

        String repayType = loanOrderInfo.getRepayType();
        String filePath = loanOrderInfo.getFilePath();
        int status = 0;

        String city = userInfo.getSubmitCity();
        Integer onlineTime = riskExtraInfo.getNetDuration();
        Integer orderAddressNum = riskExtraInfo.getOrderAddressNum();
        Integer orderNum = riskExtraInfo.getOrderNum();
        String authType = riskExtraInfo.getAuthType();
        
        JSONObject json = new JSONObject();
        JSONArray jsonarray = new JSONArray();
        JSONObject js = new JSONObject();

        js.put("loanNumber", loanNumber);
        js.put("gender", gender);
        js.put("age", age);
        js.put("name", name);
        js.put("idNo", idNo);
        js.put("cellPhone", cellphone);
        js.put("loanAmount", loanAmount);
        js.put("loanPurpose", loanPurpose);
        js.put("post", post);
        js.put("productCode", productCode);
        js.put("loanTime", loanTime);
        js.put("loanDuration", loanDuration);
        js.put("repayType", repayType);
        js.put("status", status);
        js.put("filePath", filePath);
        
        js.put("city", city);//
        js.put("onlineTime", onlineTime);//
        js.put("addressNum", orderAddressNum);//
        js.put("orderCount", orderNum);//
        js.put("authentication", authType);//
        
        jsonarray.add(js);
        json.put("data", jsonarray.toString());
        return json;
	}

}
