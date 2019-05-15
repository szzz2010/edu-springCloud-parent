package com.haohao.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class FtpUtil {
	
	private static Logger logger = LoggerFactory.getLogger(FtpUtil.class);

	public static FTPClient getFTPClient(String host,int port,String username,String password) {
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect(host, port);// 连接FTP服务器
			ftpClient.login(username, password);
		} catch (IOException e) {
			logger.error("ftp服务器连接失败");
			e.printStackTrace();
		}
		if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
			logger.error("未连接到FTP服务器，用户名或密码错误");
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			logger.info("ftp连接成功");
		}
		return ftpClient;
	}
	public static ChannelSftp getSFTP(String host,int port,String username,String password) {
		ChannelSftp sftp = null;
		JSch jsch = new JSch();
		Session sshSession = null;
		try {
			sshSession = jsch.getSession(username, host, port);
			sshSession.setPassword(password);
			Properties sshConfig = new Properties();
			sshConfig.put("StrictHostKeyChecking", "no");
			sshSession.setConfig(sshConfig);
			sshSession.connect();
			Channel channel = sshSession.openChannel("sftp");
			channel.connect();
			sftp = (ChannelSftp) channel;
		} catch (JSchException e) {
			logger.error("sftp连接错误");
			e.printStackTrace();
		}
		return sftp;
	}
	public static void main(String[] args) {
		String path = "/usr/local/apps/apache-tomcat-9";
		String fileName = "RUNNING.txt";
		/*FTPClient client = FtpUtil.getFTPClient();
		try {
			client.setControlEncoding("UTF-8");
			client.setFileType(FTPClient.BINARY_FILE_TYPE);
			client.enterLocalPassiveMode();
			client.changeWorkingDirectory(path);
			OutputStream os = new FileOutputStream(new File("C:\\Users\\zhanghao\\Desktop\\tempFile"));
			client.retrieveFile(fileName, os);
			os.close();
			client.logout();
			client.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		ChannelSftp sftp = FtpUtil.getSFTP("", 222, "", "");
		try {
			sftp.cd(path);
			OutputStream os = new FileOutputStream(new File("C:\\Users\\zhanghao\\Desktop\\tempFile"));
			sftp.get(fileName, os);
			os.close();
			sftp.disconnect();
		} catch (SftpException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
