package com.haohao.service.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.haohao.util.tools.UploadUtil;

@Service
@Transactional(readOnly = true)
public class FileService {


    @Autowired
    private UploadUtil uploadUtil;

    public String uploadFile(MultipartFile file, String uploadFileDomain) throws Exception {
        if (uploadFileDomain.contains("localhost")) {
            return uploadUtil.doUploadLocal(file);
        }
        return uploadUtil.doUpload(file);
    }
}
