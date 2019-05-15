package com.haohao.util.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.StringTokenizer;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * FTP工具类
 */
public class XsFtpClientUtil {

    protected final Logger log = LoggerFactory.getLogger("FtpClientUtil.class");
    
    private ThreadLocal<FTPClient> ftpClientThreadLocal = new ThreadLocal<FTPClient>();
    private boolean binaryTransfer = true;  
    private boolean passiveMode = false;  
    private String encoding = "UTF-8";  
    private int clientTimeout = 1000 * 30;  
  
    private String host;
    private int port;
    private String username;
    private String password;
    
    public XsFtpClientUtil(String host, int port, String username, String password) {
		super();
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
	}
    
    /** 
     * 返回一个FTPClient实例 
     *  
     * @throws Exception 
     */  
    private FTPClient getFTPClient(){  
        if (ftpClientThreadLocal.get() != null && ftpClientThreadLocal.get().isConnected()) {  
            return ftpClientThreadLocal.get();  
        } else {  
            FTPClient ftpClient = new FTPClient(); //构造一个FtpClient实例  
            ftpClient.setControlEncoding(encoding); //设置字符集  
            try {
				connect(ftpClient); //连接到ftp服务器  
				log.info("***成功连接ftp服务器");
			} catch (Exception e1) {
				e1.printStackTrace();
				log.info("***失败连接ftp服务器");
			}
            //设置为passive模式  
            if (passiveMode) {  
                ftpClient.enterLocalPassiveMode();  
            }  
            try {
				setFileType(ftpClient); //设置文件传输类型  
			} catch (Exception e1) {
				e1.printStackTrace();
			}
            try {  
                ftpClient.setSoTimeout(clientTimeout);  
            } catch (SocketException e) {  
               log.info("***连接超时...");  
            }  
            ftpClientThreadLocal.set(ftpClient);  
            return ftpClient;  
        }  
    }  
  
    /** 
     * 设置文件传输类型 
     *  
     * @throws Exception 
     * @throws IOException 
     */  
    private void setFileType(FTPClient ftpClient) throws Exception {  
        try {  
            if (binaryTransfer) {  
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);  
            } else {  
                ftpClient.setFileType(FTPClient.ASCII_FILE_TYPE);  
            }  
        } catch (IOException e) {  
            throw new Exception("Could not to set file type.", e);  
        }  
    }  
  
    /** 
     * 连接到ftp服务器 
     * @param ftpClient
     * @param username
     * @param password
     * @return 连接成功返回true，否则返回false 
     * @throws Exception 
     */  
    private boolean connect(FTPClient ftpClient) throws Exception {  
        try {
            ftpClient.connect(host, port);  
            // 连接后检测返回码来校验连接是否成功  
            int reply = ftpClient.getReplyCode();  
            if (FTPReply.isPositiveCompletion(reply)) {  
                //登陆到ftp服务器  
                if (ftpClient.login(username, password)) {  
                    setFileType(ftpClient);  
                    return true;  
                }  
            } else {  
                ftpClient.disconnect();  
                throw new Exception("FTP server refused connection.");  
            }  
        } catch (IOException e) {  
            if (ftpClient.isConnected()) {  
                try {  
                    ftpClient.disconnect(); //断开连接  
                } catch (IOException e1) {  
                    throw new Exception("Could not disconnect from server.", e1);  
                }  
            }  
            throw new Exception("Could not connect to server.", e);  
        }  
        return false;  
    }  
  
    /** 
     * 断开ftp连接 
     * @throws Exception 
     */  
    private void disconnect() throws Exception {  
        try {  
            FTPClient ftpClient = getFTPClient();  
            ftpClient.logout();  
            if (ftpClient.isConnected()) {  
                ftpClient.disconnect();  
                ftpClient = null;  
            }  
        } catch (IOException e) {  
            throw new Exception("Could not disconnect from server.", e);  
        }  
    }  
      
    public boolean mkdir(String pathname) throws Exception {  
        return mkdir(pathname, null);  
    }  
      
    /** 
     * 在ftp服务器端创建目录（不支持一次创建多级目录） 
     * 该方法执行完后将自动关闭当前连接 
     * @param pathname 
     * @return 
     * @throws Exception 
     */  
    public boolean mkdir(String pathname, String workingDirectory) throws Exception {  
        return mkdir(pathname, workingDirectory, true);  
    }  
      
    /** 
     * 在ftp服务器端创建目录（不支持一次创建多级目录） 
     * @param pathname 
     * @param autoClose 是否自动关闭当前连接 
     * @throws Exception 
     */  
    public boolean mkdir(String pathname, String workingDirectory, boolean autoClose) throws Exception {  
        try {  
            getFTPClient().changeWorkingDirectory(workingDirectory);  
            return getFTPClient().makeDirectory(pathname);  
        } catch (IOException e) {  
            throw new Exception("Could not mkdir.", e);  
        } finally {  
            if (autoClose) {  
                disconnect(); //断开连接  
            }  
        }  
    }  
  
    /** 
     * 上传一个本地文件到远程指定文件 
     * @param remoteAbsoluteFile 远程文件名(包括完整路径) 
     * @param localAbsoluteFile 本地文件名(包括完整路径) 
     * @return 成功时，返回true，失败返回false 
     * @throws Exception 
     */  
    public boolean put(String remoteAbsoluteFile, String localAbsoluteFile) throws Exception {  
        return put(remoteAbsoluteFile, localAbsoluteFile, true);  
    }  
  
    /** 
     * 上传一个本地文件到远程指定文件 
     * @param remoteAbsoluteFile 远程文件名(包括完整路径) 
     * @param localAbsoluteFile 本地文件名(包括完整路径) 
     * @param autoClose 是否自动关闭当前连接 
     * @return 成功时，返回true，失败返回false 
     * @throws Exception 
     */  
    public boolean put(String remoteAbsoluteFile, String localAbsoluteFile, boolean autoClose) throws Exception {  
        InputStream input = null;  
        try {  
            // 处理传输  
            input = new FileInputStream(localAbsoluteFile);  
            Boolean flag = getFTPClient().storeFile(remoteAbsoluteFile, input);  
            log.debug("put " + localAbsoluteFile);  
            return flag;  
        } catch (FileNotFoundException e) {  
            throw new Exception("local file not found.", e);  
        } catch (IOException e) {  
            throw new Exception("Could not put file to server.", e);  
        } finally {  
            try {  
                if (input != null) {  
                    input.close();  
                }  
            } catch (Exception e) {  
                throw new Exception("Couldn't close FileInputStream.", e);  
            }  
            if (autoClose) {  
                disconnect(); //断开连接  
            }  
        }  
    }  
    
    /**
     *  储存附件开始---------------------------------------------------------
     * @param remoteFileDir ftp远程储存目录
     * @param remoteFileName ftp远程储存文件名，带格式 如 aaa.zip
     * @param localAbsoluteFile 本地上传文件路径和名称 如  data/aaa.zip
     * @param autoClose 是否关闭连接
     * @return
     */
    public boolean put2(String remoteFileDir,String remoteFileName, String localAbsoluteFile, boolean autoClose){  
    	log.info("*******************************");
    	log.info("***开始上传附件source=[{}]",localAbsoluteFile);
    	InputStream input = null;  
        try {  
        	log.info("***开始创建文件路径");
        	passiveMode = true;
            makeDirs(remoteFileDir);
            log.info("***读取本地文件");
            input = new FileInputStream(localAbsoluteFile);  
            log.info("***开始上传本地文件");
            Boolean flag = getFTPClient().storeFile(remoteFileDir+remoteFileName, input);
           if(flag){
        	   log.info("***上传服务器成功path=[{}]",remoteFileDir+remoteFileName);
           }else{
        	   log.info("***上传服务器失败");
           }
           log.info("*******************************");
            return flag;  
        } catch (FileNotFoundException e) {  
        	 log.info("***没有找到本地zip文件...");
             log.info("*******************************");
           e.printStackTrace();
           return false;
        }catch (IOException e) {
        	log.info("***上传zip文件到服务器失败...");
            log.info("*******************************");
			e.printStackTrace();
			return false;
		} catch (Exception e) {
        	log.info("***其他异常");
            log.info("*******************************");
			e.printStackTrace();
			return false;
		}  finally {  
            try {  
                if (input != null) {  
                    input.close();  
                }  
            } catch (Exception e) {  
               e.printStackTrace();
            }  
            if (autoClose) {  
                try {
                	//断开连接  
					disconnect();
				} catch (Exception e) {
					e.printStackTrace();
				} 
            }  
        }  
    }  
    
    public  boolean makeDirs(String path){
      boolean flag = true;
	  StringTokenizer s = new StringTokenizer(path, "/");
      s.countTokens(); 
      String pathName = ""; 
      while (s.hasMoreElements()) { 
      	   pathName = pathName + "/" + (String) s.nextElement(); 
      	   try { 
      		  getFTPClient().mkd(pathName); 
      	   } catch (Exception e) { 
      		   log.info("***ftp文件夹创建失败");
      		   flag = false;
      	   } 
      } 
      if(flag){
    	  log.info("***ftp文件夹确认成功：path=[{}]",path);
      }
    	return flag;
    }
    
    
    /**
     * 储存附件结束--------------------------------------------------------
     */
    
    /** 
     * 下载一个远程文件到本地的指定文件 
     *  
     * @param remoteAbsoluteFile 远程文件名(包括完整路径) 
     * @param localFilePath: D:/aaa/b
     * @param localFileName: ccc.txt
     * @return 成功时，返回true，失败返回false 
     * @throws Exception 
     */  
    public boolean get(String remoteAbsoluteFile, String localFilePath, String localFileName) throws Exception {  
        return get(remoteAbsoluteFile, localFilePath, localFileName, true);  
    }  
  
    /** 
     * 下载一个远程文件到本地的指定文件 
     * @param remoteAbsoluteFile 远程文件名(包括完整路径) 
     * @param localAbsoluteFile 本地文件名(包括完整路径) 
     * @param autoClose 是否自动关闭当前连接 
     * @return 成功时，返回true，失败返回false 
     * @throws Exception 
     */  
    private boolean get(String remoteAbsoluteFile, String localFilePath, String localFileName, boolean autoClose) throws Exception {  
        OutputStream output = null;  
        try {  
        	 File localFilePathDir = new File(localFilePath);
 			if(localFilePathDir.exists()){
 				log.info("本地路径存在localFilePath=[{}],无需创建。", localFilePath);
 			}else{
 				if(localFilePathDir.mkdirs()){
 					log.info("需要存储的  localFilePath 路径不存在， 自动创建目录成功！localFilePath={}",localFilePath);
 				}else{
 					log.info("需要存储的  localFilePath 路径不存在， 自动创建目录失败！localFilePath={}",localFilePath);
 					return false;
 				}
 			}
 			String localAbsoluteFile = localFilePath+File.separator+localFileName;
            output = new FileOutputStream(localAbsoluteFile);  
            boolean b = get(remoteAbsoluteFile, output, autoClose);  
            if(b){
            	log.info("ftp文件下载传输成功！remoteAbsoluteFile=[{}],localAbsoluteFile=[{}]",remoteAbsoluteFile,localAbsoluteFile);
            }else{
            	log.info("ftp文件下载传输失败！remoteAbsoluteFile=[{}],localAbsoluteFile=[{}]",remoteAbsoluteFile,localAbsoluteFile);
            }
            return b;
        } catch (FileNotFoundException e) {  
        	e.printStackTrace();
            throw new Exception("local file not found.", e);  
        } finally {  
            try {  
                if (output != null) {  
                    output.close();  
                }  
            } catch (IOException e) {  
                throw new Exception("Couldn't close FileOutputStream.", e);  
            }  
        }  
    }  
  
    /** 
     * 下载一个远程文件到指定的流 处理完后记得关闭流 
     * @param remoteAbsoluteFile 
     * @param output 
     * @return 
     * @throws Exception 
     */  
    public boolean get(String remoteAbsoluteFile, OutputStream output) throws Exception {  
        return get(remoteAbsoluteFile, output, true);  
    }  
  
    /** 
     * 下载一个远程文件到指定的流 处理完后记得关闭流 
     * @param remoteAbsoluteFile 
     * @param output 
     * @param delFile 
     * @return 
     * @throws Exception 
     */  
    public boolean get(String remoteAbsoluteFile, OutputStream output, boolean autoClose) throws Exception {  
        try {  
            FTPClient ftpClient = getFTPClient();  
            // 处理传输  
            return ftpClient.retrieveFile(remoteAbsoluteFile, output);  
        } catch (IOException e) {  
            e.printStackTrace();
            return false;
        } finally {  
            if (autoClose) {  
                disconnect(); //关闭链接  
            }  
        }  
    }  
  
    /** 
     * 从ftp服务器上删除一个文件 
     * 该方法将自动关闭当前连接 
     * @param delFile 
     * @return 
     * @throws Exception 
     */  
    public boolean delete(String delFile) throws Exception {  
        return delete(delFile, true);  
    }  
      
    /** 
     * 从ftp服务器上删除一个文件 
     * @param delFile 
     * @param autoClose 是否自动关闭当前连接 
     * @return 
     * @throws Exception 
     */  
    public boolean delete(String delFile, boolean autoClose) throws Exception {  
        try {  
            getFTPClient().deleteFile(delFile);  
            return true;  
        } catch (IOException e) {  
            throw new Exception("Couldn't delete file from server.", e);  
        } finally {  
            if (autoClose) {  
                disconnect(); //关闭链接  
            }  
        }  
    }  
      
    /** 
     * 批量删除 
     * 该方法将自动关闭当前连接 
     * @param delFiles 
     * @return 
     * @throws Exception 
     */  
    public boolean delete(String[] delFiles) throws Exception {  
        return delete(delFiles, true);  
    }  
  
    /** 
     * 批量删除 
     * @param delFiles 
     * @param autoClose 是否自动关闭当前连接 
     * @return 
     * @throws Exception 
     */  
    public boolean delete(String[] delFiles, boolean autoClose) throws Exception {  
        try {  
            FTPClient ftpClient = getFTPClient();  
            for (String s : delFiles) {  
                ftpClient.deleteFile(s);  
            }  
            return true;  
        } catch (IOException e) {  
            throw new Exception("Couldn't delete file from server.", e);  
        } finally {  
            if (autoClose) {  
                disconnect(); //关闭链接  
            }  
        }  
    }  
  
    /** 
     * 列出远程默认目录下所有的文件 
     * @return 远程默认目录下所有文件名的列表，目录不存在或者目录下没有文件时返回0长度的数组 
     * @throws Exception 
     */  
    public String[] listNames() throws Exception {  
        return listNames(null, true);  
    }  
      
    public String[] listNames(boolean autoClose) throws Exception {  
        return listNames(null, autoClose);  
    }  
  
    /** 
     * 列出远程目录下所有的文件 
     * @param remotePath 远程目录名 
     * @param autoClose 是否自动关闭当前连接 
     * @return 远程目录下所有文件名的列表，目录不存在或者目录下没有文件时返回0长度的数组 
     * @throws Exception 
     */  
    public String[] listNames(String remotePath, boolean autoClose) throws Exception {  
        try {  
            String[] listNames = getFTPClient().listNames(remotePath);  
            return listNames;  
        } catch (IOException e) {  
            throw new Exception("列出远程目录下所有的文件时出现异常", e);  
        } finally {  
            if (autoClose) {  
                disconnect(); //关闭链接  
            }  
        }  
    }  
    
    /** 判断Ftp目录是否存在 */
	public boolean isDirExist( String dir){
		return true;
    }
 
    
}

