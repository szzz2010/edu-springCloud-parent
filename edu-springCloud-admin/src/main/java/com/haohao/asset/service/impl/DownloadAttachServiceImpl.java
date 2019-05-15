package com.haohao.asset.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.haohao.asset.service.IDownloadAttachService;
import com.haohao.util.FtpUtil;
import com.haohao.util.springTools.springJdbc.helper.HttpClientHelper;

@Service
public class DownloadAttachServiceImpl implements IDownloadAttachService {
	private static final Logger log = LoggerFactory.getLogger(DownloadAttachServiceImpl.class);
	
    //大众
    @Value("${jiezhong.ftp.url}")
	private String jiezhongfilePath;
	@Value("${jiezhong.ftp.host}")
	private String jiezhonghost;
	@Value("${jiezhong.ftp.port}")
	private int jiezhongport;
	@Value("${jiezhong.ftp.username}")
	private String jiezhongusername;
	@Value("${jiezhong.ftp.password}")
	private String jiezhongpassword;
	@Value("${jiezhong.url}")
	private String jiezhongDomainUrl;
	
	//厚本
	@Value("${houben.ftp.path}")
	private String houbenfilePath;
	@Value("${houben.ftp.host}")
	private String houbenhost;
	@Value("${houben.ftp.port}")
	private int houbenport;
	@Value("${houben.ftp.username}")
	private String houbenusername;
	@Value("${houben.ftp.password}")
	private String houbenpassword;
	//学习
	@Value("${xs.ftp.path}")
	private String xspath;
	@Value("${xs.ftp.host}")
	private String xshost;
	@Value("${xs.ftp.port}")
	private int xsport;
	@Value("${xs.ftp.username}")
	private String xsusername;
	@Value("${xs.ftp.password}")
	private String xspassword;
	//友金所
	@Value("${youjinsuo.ftp.path}")
	private String youjinsuopath;
	@Value("${youjinsuo.ftp.host}")
	private String youjinsuohost;
	@Value("${youjinsuo.ftp.port}")
	private int youjinsuoport;
	@Value("${youjinsuo.ftp.username}")
	private String youjinsuousername;
	@Value("${youjinsuo.ftp.password}")
	private String youjinsuopassword;
	//用钱宝
	@Value("${yongqianbao.ftp.path}")
	private String yongqianbaopath;
	@Value("${yongqianbao.ftp.host}")
	private String yongqianbaohost;
	@Value("${yongqianbao.ftp.port}")
	private int yongqianbaoport;
	@Value("${yongqianbao.ftp.username}")
	private String yongqianbaousername;
	@Value("${yongqianbao.ftp.password}")
	private String yongqianbaopassword;
	
	//好好
	@Value("${tt.ftp.filePath}")
	private String haohaofilePath;
	@Value("${tt.ftp.host}")
	private String haohaohost;
	@Value("${tt.ftp.port}")
	private int haohaoport;
	@Value("${tt.ftp.username}")
	private String haohaousername;
	@Value("${tt.ftp.password}")
	private String haohaopassword;
	
	@Override
	public void downloadOrderAttach(Map<String, Object> params, HttpServletResponse response) {
		String loan_agency_code = (String) params.get("loan_agency_code");
		String fileName = (String) params.get("fileName");
		if(loan_agency_code.equals("jiezhong")){
			downloadAttach(jiezhonghost,jiezhongport,jiezhongusername,jiezhongpassword,jiezhongfilePath,fileName,response);
		}else if(loan_agency_code.equals("houben")){//东方明珠电视塔厚冠信息咨询培训学校 houben
			downloadAttach(houbenhost,houbenport,houbenusername,houbenpassword,houbenfilePath,fileName,response);
		}else if(loan_agency_code.equals("jieyue")){//西雅图捷越联合信息咨询培训学校 jieyue
			downloadAttach(xshost,xsport,xsusername,xspassword,xspath,fileName,response);
		}else if(loan_agency_code.equals("TIANSHENDAI")){//西雅图天神贷科技培训学校 TIANSHENDAI
			downloadAttach(xshost,xsport,xsusername,xspassword,xspath,fileName,response);
		}else if(loan_agency_code.equals("yongqianbao")){//湖南德宇融资性担保培训学校 yongqianbao
			downloadAttach(yongqianbaohost,yongqianbaoport,yongqianbaousername,yongqianbaopassword,yongqianbaopath,fileName,response);
		}else if(loan_agency_code.equals("youjinsuo")){//深圳用友力合普惠信息服务培训学校 youjinsuo
			downloadAttach(youjinsuohost,youjinsuoport,youjinsuousername,youjinsuopassword,youjinsuopath,fileName,response);
		}else if(loan_agency_code.equals("HELLODAI")){//西雅图喜鹊创维科技培训学校 HELLODAI
			
		}else if(loan_agency_code.equals("MINTQ")){//明特量化信息技术培训学校 MINTQ
			
		}else if(loan_agency_code.equals("haohao")){//西雅图捷茂科技培训学校 haohao
			downloadAttach(haohaohost,haohaoport,haohaousername,haohaopassword,haohaofilePath,fileName,response);
		}else if(loan_agency_code.equals("Zendaimoney")){//东方明珠电视塔假小金融信息服务培训学校 Zendaimoney 
			
		}
		
	}
	
	private void downloadAttach(String host,int port,String username,String password,String filePath,String fileName, HttpServletResponse response){
		FTPClient client = FtpUtil.getFTPClient(host, port, username, password);
		if(client.isConnected()) {
			try {
				client.setControlEncoding("UTF-8");
				client.setFileType(FTPClient.BINARY_FILE_TYPE);
				client.enterLocalPassiveMode();
				client.setRemoteVerificationEnabled(false);
				client.changeWorkingDirectory(filePath.replaceFirst("ftp://[\\w]*/", "/"));
				OutputStream os = response.getOutputStream();
				response.addHeader("Content-Disposition", "attachment;filename=" + new String (fileName.getBytes("utf-8"),"iso8859-1"));
				client.retrieveFile(fileName, os);
			} catch (Exception e) {
				log.error("ftp连接失败----"+filePath.replaceFirst("ftp://[\\w]*/", "/")+fileName);
				e.printStackTrace();
				sendFailResponse(response);
			} finally {
				try {
					client.logout();
					client.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else {
			sendFailResponse(response);
		}
		try {
			response.flushBuffer();
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void sendFailResponse(HttpServletResponse response) {
		String error = "服务器异常";
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(error);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String,Object> getElectronicSignatureList(String loan_number){
		Map<String,Object> returnMap = new HashMap<>();
		Map<String,Object> sendMap = new HashMap<>();
		sendMap.put("orderNo", loan_number);
		String url = jiezhongDomainUrl+"/xs/account/searchElectronicSignatureInfoByOrderNo";
		String exec = HttpClientHelper.exec(url, "0", "0", sendMap);
//		exec = "{\"result\":\"0000\",\"file\":[{\"fileName\":\"8190a66b1d66ee319a1def77a96d4826.zip\",\"contractType\":52,\"fileRealName\":\"8190a66b1d66ee319a1def77a96d4826.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"0588c7d6f9cb3f9dfc28a61a6f8e8352.zip\",\"contractType\":52,\"fileRealName\":\"0588c7d6f9cb3f9dfc28a61a6f8e8352.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"96cfe29006d648302d5cc4f1ef368ffb.zip\",\"contractType\":52,\"fileRealName\":\"96cfe29006d648302d5cc4f1ef368ffb.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"4a440ba221dfc579b9db18eb5256eee8.zip\",\"contractType\":52,\"fileRealName\":\"4a440ba221dfc579b9db18eb5256eee8.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"fe6ccce95629aaa2ed190fbee43a1a25.zip\",\"contractType\":52,\"fileRealName\":\"fe6ccce95629aaa2ed190fbee43a1a25.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"ca89d06b82032432eb0f293527de1bed.zip\",\"contractType\":52,\"fileRealName\":\"ca89d06b82032432eb0f293527de1bed.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"190555712fe7fe54c8489f82c3668a02.zip\",\"contractType\":52,\"fileRealName\":\"190555712fe7fe54c8489f82c3668a02.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"836649cdafd1b1c67b925daff8c935e0.zip\",\"contractType\":52,\"fileRealName\":\"836649cdafd1b1c67b925daff8c935e0.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"ffab2b44e958b15a19c41e683583c84e.zip\",\"contractType\":52,\"fileRealName\":\"ffab2b44e958b15a19c41e683583c84e.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"7bfc36c0dcaac38f2ed746bebfa7a757.zip\",\"contractType\":52,\"fileRealName\":\"7bfc36c0dcaac38f2ed746bebfa7a757.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"b917fb38e42c2ede8fdf3a537595fc9f.zip\",\"contractType\":52,\"fileRealName\":\"b917fb38e42c2ede8fdf3a537595fc9f.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"bdcf52d8a3fcf44efc95e98d046f80f4.zip\",\"contractType\":52,\"fileRealName\":\"bdcf52d8a3fcf44efc95e98d046f80f4.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"22ace03446c7a4bebaccb210246e6e64.zip\",\"contractType\":10,\"fileRealName\":\"22ace03446c7a4bebaccb210246e6e64.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"b87e18db072fff1169fb01b86c1617f5.zip\",\"contractType\":10,\"fileRealName\":\"b87e18db072fff1169fb01b86c1617f5.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"6c4f17742b93d13cbbd855ca1014dfd1.zip\",\"contractType\":10,\"fileRealName\":\"6c4f17742b93d13cbbd855ca1014dfd1.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"3982e4e48c4386d41c78b3649c150cd4.zip\",\"contractType\":10,\"fileRealName\":\"3982e4e48c4386d41c78b3649c150cd4.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"11e9c2d243b523a113610173d73130e3.zip\",\"contractType\":10,\"fileRealName\":\"11e9c2d243b523a113610173d73130e3.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"0d7d55eabdf6daab06a34dcbc10c7eef.zip\",\"contractType\":10,\"fileRealName\":\"0d7d55eabdf6daab06a34dcbc10c7eef.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"af5ff22e44e7201107803fa8f464b873.zip\",\"contractType\":10,\"fileRealName\":\"af5ff22e44e7201107803fa8f464b873.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"a3756b1fcbc103579c3765512cf57350.zip\",\"contractType\":10,\"fileRealName\":\"a3756b1fcbc103579c3765512cf57350.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"d795fc89bf86bbb2e0df701bca50c74a.zip\",\"contractType\":10,\"fileRealName\":\"d795fc89bf86bbb2e0df701bca50c74a.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"f9179216d55f6469f4949896773c1841.zip\",\"contractType\":10,\"fileRealName\":\"f9179216d55f6469f4949896773c1841.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"0ae0379eb0b4cd630a7f3f269625e098.zip\",\"contractType\":10,\"fileRealName\":\"0ae0379eb0b4cd630a7f3f269625e098.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"703b07beddceaa870d1bb3390e342d87.zip\",\"contractType\":10,\"fileRealName\":\"703b07beddceaa870d1bb3390e342d87.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"206788a64a535c34675f68a2ccb0fb11.zip\",\"contractType\":11,\"fileRealName\":\"206788a64a535c34675f68a2ccb0fb11.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《个人账户代扣款项委托书》\"},{\"fileName\":\"bdf204ed4e9ec0d833ae63d20917da2a.zip\",\"contractType\":4,\"fileRealName\":\"bdf204ed4e9ec0d833ae63d20917da2a.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《个人征信查询及使用授权书》\"},{\"fileName\":\"350c08d308f8be37b408c2ea4d4e52eb.zip\",\"contractType\":6,\"fileRealName\":\"350c08d308f8be37b408c2ea4d4e52eb.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《CFCA电子签章使用授权书》\"},{\"fileName\":\"6effceadbbdc906663f5b70ca0a00b46.zip\",\"contractType\":23,\"fileRealName\":\"6effceadbbdc906663f5b70ca0a00b46.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《通知、文书送达方式确认书》\"},{\"fileName\":\"fcde63814ac90246ec2a841580bdc02e.zip\",\"contractType\":7,\"fileRealName\":\"fcde63814ac90246ec2a841580bdc02e.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款人信用承诺书》\"},{\"fileName\":\"8bbad1e367fdd7b968d387ee4f2cc6fe.zip\",\"contractType\":5,\"fileRealName\":\"8bbad1e367fdd7b968d387ee4f2cc6fe.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款人禁止性行为承诺书》\"},{\"fileName\":\"6f848f8cd4991fae6f0a084d837b277f.zip\",\"contractType\":3,\"fileRealName\":\"6f848f8cd4991fae6f0a084d837b277f.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《网络借贷风险确认书》\"},{\"fileName\":\"585a237735e7166f625f05d36ae56105.zip\",\"contractType\":9,\"fileRealName\":\"585a237735e7166f625f05d36ae56105.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款咨询与管理服务协议》\"},{\"fileName\":\"8190a66b1d66ee319a1def77a96d4826.zip\",\"contractType\":52,\"fileRealName\":\"8190a66b1d66ee319a1def77a96d4826.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"0588c7d6f9cb3f9dfc28a61a6f8e8352.zip\",\"contractType\":52,\"fileRealName\":\"0588c7d6f9cb3f9dfc28a61a6f8e8352.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"96cfe29006d648302d5cc4f1ef368ffb.zip\",\"contractType\":52,\"fileRealName\":\"96cfe29006d648302d5cc4f1ef368ffb.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"4a440ba221dfc579b9db18eb5256eee8.zip\",\"contractType\":52,\"fileRealName\":\"4a440ba221dfc579b9db18eb5256eee8.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"fe6ccce95629aaa2ed190fbee43a1a25.zip\",\"contractType\":52,\"fileRealName\":\"fe6ccce95629aaa2ed190fbee43a1a25.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"ca89d06b82032432eb0f293527de1bed.zip\",\"contractType\":52,\"fileRealName\":\"ca89d06b82032432eb0f293527de1bed.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"190555712fe7fe54c8489f82c3668a02.zip\",\"contractType\":52,\"fileRealName\":\"190555712fe7fe54c8489f82c3668a02.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"836649cdafd1b1c67b925daff8c935e0.zip\",\"contractType\":52,\"fileRealName\":\"836649cdafd1b1c67b925daff8c935e0.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"ffab2b44e958b15a19c41e683583c84e.zip\",\"contractType\":52,\"fileRealName\":\"ffab2b44e958b15a19c41e683583c84e.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"7bfc36c0dcaac38f2ed746bebfa7a757.zip\",\"contractType\":52,\"fileRealName\":\"7bfc36c0dcaac38f2ed746bebfa7a757.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"b917fb38e42c2ede8fdf3a537595fc9f.zip\",\"contractType\":52,\"fileRealName\":\"b917fb38e42c2ede8fdf3a537595fc9f.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"bdcf52d8a3fcf44efc95e98d046f80f4.zip\",\"contractType\":52,\"fileRealName\":\"bdcf52d8a3fcf44efc95e98d046f80f4.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《授权委托书》\"},{\"fileName\":\"22ace03446c7a4bebaccb210246e6e64.zip\",\"contractType\":10,\"fileRealName\":\"22ace03446c7a4bebaccb210246e6e64.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"b87e18db072fff1169fb01b86c1617f5.zip\",\"contractType\":10,\"fileRealName\":\"b87e18db072fff1169fb01b86c1617f5.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"6c4f17742b93d13cbbd855ca1014dfd1.zip\",\"contractType\":10,\"fileRealName\":\"6c4f17742b93d13cbbd855ca1014dfd1.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"3982e4e48c4386d41c78b3649c150cd4.zip\",\"contractType\":10,\"fileRealName\":\"3982e4e48c4386d41c78b3649c150cd4.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"11e9c2d243b523a113610173d73130e3.zip\",\"contractType\":10,\"fileRealName\":\"11e9c2d243b523a113610173d73130e3.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"0d7d55eabdf6daab06a34dcbc10c7eef.zip\",\"contractType\":10,\"fileRealName\":\"0d7d55eabdf6daab06a34dcbc10c7eef.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"af5ff22e44e7201107803fa8f464b873.zip\",\"contractType\":10,\"fileRealName\":\"af5ff22e44e7201107803fa8f464b873.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"a3756b1fcbc103579c3765512cf57350.zip\",\"contractType\":10,\"fileRealName\":\"a3756b1fcbc103579c3765512cf57350.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"d795fc89bf86bbb2e0df701bca50c74a.zip\",\"contractType\":10,\"fileRealName\":\"d795fc89bf86bbb2e0df701bca50c74a.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"f9179216d55f6469f4949896773c1841.zip\",\"contractType\":10,\"fileRealName\":\"f9179216d55f6469f4949896773c1841.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"0ae0379eb0b4cd630a7f3f269625e098.zip\",\"contractType\":10,\"fileRealName\":\"0ae0379eb0b4cd630a7f3f269625e098.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"},{\"fileName\":\"703b07beddceaa870d1bb3390e342d87.zip\",\"contractType\":10,\"fileRealName\":\"703b07beddceaa870d1bb3390e342d87.jpg\",\"filePath\":\"/cfca/20190224/\",\"contractName\":\"《借款协议》\"}],\"id\":\"T97099U20190224114134\",\"message\":\"操作成功\"}";
		Map<String,Object> resultMap = (Map<String, Object>) JSON.parseObject(exec,Map.class);
		log.info("loan_number={},电子签章查询信息resultMap={}",loan_number,resultMap);
		String result = (String) resultMap.get("result");
		List<Map<String,Object>> fileList = new ArrayList<>();
		List<Map<String,Object>> fileList2 = new ArrayList<>();
		if("0000".equals(result)){
			fileList2 = (List<Map<String, Object>>) resultMap.get("file");
			Set<String> aa = new HashSet<>();
			for(Map<String,Object> file :fileList2){
				String fileName = (String) file.get("fileName") ;
				if(!aa.contains(fileName)){
					fileList.add(file);
					aa.add(fileName);
				}
			}
		}
		returnMap.put("data", fileList);
		returnMap.put("code", 0);
		returnMap.put("count", fileList.size());
		return returnMap ;
	}
	
	@Override
	public void downloadElectronicSignature(Map<String,Object>params, HttpServletResponse response) {
		String loan_agency_code = (String) params.get("loan_agency_code");
		String fileName = (String) params.get("fileName");
		String filePath = (String) params.get("filePath");
		if(loan_agency_code.equals("jiezhong")){
			//大众
			downloadAttach(jiezhonghost,jiezhongport,jiezhongusername,jiezhongpassword,filePath,fileName,response);
		}else if(loan_agency_code.equals("houben")){
			//东方明珠电视塔厚冠信息咨询培训学校 houben
			downloadAttach(houbenhost,houbenport,houbenusername,houbenpassword,filePath,fileName,response);
		}else if(loan_agency_code.equals("jieyue")){
			//西雅图捷越联合信息咨询培训学校 jieyue
			downloadAttach(xshost,xsport,xsusername,xspassword,filePath,fileName,response);
		}else if(loan_agency_code.equals("TIANSHENDAI")){
			//西雅图天神贷科技培训学校 TIANSHENDAI
			downloadAttach(xshost,xsport,xsusername,xspassword,filePath,fileName,response);
		}else if(loan_agency_code.equals("yongqianbao")){
			//湖南德宇融资性担保培训学校 yongqianbao
			downloadAttach(yongqianbaohost,yongqianbaoport,yongqianbaousername,yongqianbaopassword,filePath,fileName,response);
		}else if(loan_agency_code.equals("youjinsuo")){
			//深圳用友力合普惠信息服务培训学校 youjinsuo
			downloadAttach(youjinsuohost,youjinsuoport,youjinsuousername,youjinsuopassword,filePath,fileName,response);
		}else if(loan_agency_code.equals("HELLODAI")){
			//西雅图喜鹊创维科技培训学校 HELLODAI
		}else if(loan_agency_code.equals("MINTQ")){
			//明特量化信息技术培训学校 MINTQ
		}else if(loan_agency_code.equals("haohao")){
			//西雅图捷茂科技培训学校 haohao
			downloadAttach(haohaohost,haohaoport,haohaousername,haohaopassword,filePath,fileName,response);
		}else if(loan_agency_code.equals("Zendaimoney")){
			//东方明珠电视塔假小金融信息服务培训学校 Zendaimoney 
		}
	}
}
