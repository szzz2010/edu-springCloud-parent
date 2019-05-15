package com.haohao.service.xs;

import java.util.List;
import java.util.Map;

/**
 * Created by fanzukun on 2018/9/20.
 */
public interface CompanyInfoService {

    Map<String, Object> getCompany(Integer id);

    int orderCount(Integer companyId);

    List<Map<String, Object>> orderList(Integer companyId);
}
