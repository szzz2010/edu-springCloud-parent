package com.haohao.util.tools;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class XsFileToZipUtil {

	private XsFileToZipUtil(){}
	
	private static final Logger log = LoggerFactory.getLogger("FileToZip.class");
	
	/**
	 * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
	 * @param sourceFilePath :待压缩的文件路径
	 * @param zipFilePath :压缩后存放路径
	 * @param zipFileName :压缩后文件的名称 包括后缀名  如  aaa.zip
	 * @param transNames :{{a.jpg,1.jpg},{b.jpg,2.jpg},{oldName,newName}}  a.jpg-->1.jpg
	 * @return
	 */
	public static boolean fileToZip(String sourceFilePath,String zipFilePath,String zipFileName,String[]...transNames ){
		log.info("********************************************");
		log.info("*********进入压缩附件功能...");
		boolean flag = false;
		File sourceFile = new File(sourceFilePath);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		if(sourceFile.exists() == false){
			log.info("*********待压缩的文件目录："+sourceFilePath+"不存在.");
			log.info("*********压缩失败，返回");
			return false;
		}else{
			try {
				File zipFile = new File(zipFilePath+zipFileName);
				File zipFilePathDir = new File(zipFilePath);
				if(!zipFilePathDir.exists()){
					if(!zipFilePathDir.mkdirs()){
						log.info("需要存储的  zipFilePath 路径不存在， 自动创建目录失败！zipFilePath={}",zipFilePath);
						return false;
					}
					log.info("需要存储的  zipFilePath 路径不存在， 自动创建目录成功！zipFilePath={}",zipFilePath);
				}
				if(zipFile.exists()){
					log.info("*********存在zip文件:"+zipFilePath+zipFileName);
					log.info("*********压缩成功，返回");
					flag = true;
				}else{
					File[] sourceFiles = sourceFile.listFiles();
					if(ObjectUtils.isEmpty(sourceFiles)){
						log.info("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，不能压缩.");
						log.info("*********压缩失败，返回");
					}else{
						log.info("*********开始压缩");
						fos = new FileOutputStream(zipFile);
						zos = new ZipOutputStream(new BufferedOutputStream(fos));
						byte[] bufs = new byte[1024*10];
						for(File file:sourceFiles){
							String fileName = null;
							if(file.isDirectory()){
								continue;
							}
							if(ObjectUtils.isEmpty(transNames)){
								log.info("未指定转换文件及名称，将按原始文件名称逐个压缩。");
								fileName = file.getName();
							}else{
								for(String[]nn: transNames){
									String oldName = nn[0];
									String newName = nn[1];
									if(file.getName().contains(oldName)){
										String end = "."+StringUtils.split(file.getName(),".")[1];
										fileName = newName+end;
										break;
									}
								}
								if(fileName == null){ 
									continue;
								}
							}
							ZipEntry zipEntry = new ZipEntry(fileName);
							zos.putNextEntry(zipEntry);
							log.info("*********读取待压缩的文件并写进压缩包里");
							fis = new FileInputStream(file);
							bis = new BufferedInputStream(fis, 1024*10);
							int read = 0;
							while((read=bis.read(bufs, 0, 1024*10)) != -1){
								zos.write(bufs,0,read);
							}
						}
						log.info("*********压缩成功，返回");
						flag = true;
						log.info("********************************************");
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally{
				//关闭流
				try {
					if(null != bis) bis.close();
					if(null != zos) zos.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		return flag;
	}
	
	
	public static void main(String[] args){
		String sourceFilePath = "D:\\data0\\Urlpictures\\2017-11-07\\23071519740104829X\\";
		String zipFilePath = "D:\\data2\\";
		String fileName = "zipFile.zip";
		
		File zipFilePathDir = new File("D:/xs/haohao/data/qiye/sp/20180619/");
		if(!zipFilePathDir.exists()){
			if(!zipFilePathDir.mkdirs()){
				log.info("需要存储的  zipFilePath 路径不存在， 自动创建目录失败！zipFilePath={}",zipFilePath);
			}
			log.info("需要存储的  zipFilePath 路径不存在， 自动创建目录成功！zipFilePath={}",zipFilePath);
		}
		boolean flag = XsFileToZipUtil.fileToZip(sourceFilePath, zipFilePath, fileName);
		if(flag){
			System.out.println("文件打包成功!");
		}else{
			System.out.println("文件打包失败!");
		}
	}
	
}
