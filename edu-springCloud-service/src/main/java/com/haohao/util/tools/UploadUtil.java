package com.haohao.util.tools;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.haohao.exception.BizException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

@Component
public class UploadUtil {


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${upload_file_dir}")
    private String uploadFileDir;

    @Value("${upload_file_domain}")
    private String uploadFileDomain;

    public String doUpload(MultipartFile uploadFile) {
        try {
            // 获取上传文件的值
            InputStream value = uploadFile.getInputStream();
            // 文件名
            String fileName = uploadFile.getOriginalFilename();
            // 如果文件名为空，跳过
            if (StringUtils.isBlank(fileName)) {
                throw new BizException(201, "文件上传错误,文件名为空");
            }
            String ext = fileName == null ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);
            StringBuffer realPath = new StringBuffer();
            realPath.append(uploadFileDir).append(DateFormatUtils.format(new Date(), "/yyyyMMdd")).append("/");
            // 判断目录是否存在，不存在，则创建
            File dir = new File(realPath.toString());
            if (!dir.exists()) {
                logger.info("文件上传路径不存在在,创建路径{}", uploadFileDir + realPath.toString());
                dir.mkdirs();
            }
            realPath.append(UUID.randomUUID().toString()).append(".").append(ext);
            // 文件路径
            String savePath = realPath.toString();
            File file = new File(savePath);
            FileOutputStream fos = new FileOutputStream(file);
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = value.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            fos.flush();
            fos.close();
            value.close();

            logger.info("==文件保存完成" + savePath);
            String returnPath = realPath.toString();
            if (!uploadFileDomain.contains("localhost")) {
                returnPath = returnPath.substring(returnPath.indexOf("/jz"), returnPath.length());
            }

            return returnPath;
        } catch (Exception ex) {
            logger.error("文件上传错误:" + ex.toString());
            return null;
        }
    }


    public String doUploadLocal(MultipartFile uploadFile) {
        try {
            String configPath = "";//上传路径
            // 获取上传文件的值
            InputStream value = uploadFile.getInputStream();
            // 文件名
            String fileName = uploadFile.getOriginalFilename();
            // 如果文件名为空，跳过
            if (StringUtils.isBlank(fileName)) {
                throw new BizException(201, "文件上传错误,文件名为空");
            }
            String ext = fileName == null ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);
            StringBuffer realPath = new StringBuffer();
            configPath = Thread.currentThread().getContextClassLoader().getResource("").toString();
            if (configPath.startsWith("file:/") && uploadFileDomain.contains("localhost")) {
                configPath = configPath.substring("file:/".length(), configPath.length());
                if (configPath.contains("target")) {
                    configPath = configPath.substring(0, configPath.indexOf("target")) + "src/main/webapp";
                }
            }

            realPath.append(uploadFileDir).append(DateFormatUtils.format(new Date(), "/yyyyMMdd")).append("/");
            // 判断目录是否存在，不存在，则创建
            File dir = new File(configPath + realPath.toString());
            if (!dir.exists()) {
                logger.info("文件上传路径不存在在,创建路径{}", configPath + realPath.toString());
                dir.mkdirs();
            }

            realPath.append(UUID.randomUUID().toString()).append(".").append(ext);

            // 文件路径
            String savePath = configPath + realPath.toString();
            File file = new File(savePath);
            FileOutputStream fos = new FileOutputStream(file);
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = value.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            fos.flush();
            fos.close();
            value.close();

            logger.info("==文件保存完成" + savePath);
            String returnPath = realPath.toString();
            if (!uploadFileDomain.contains("localhost")) {
                returnPath = returnPath.substring(returnPath.indexOf("/sp"), returnPath.length());
            }

            return returnPath;
        } catch (Exception ex) {
            logger.error("文件上传错误:" + ex.toString());
            return null;
        }
    }
}
