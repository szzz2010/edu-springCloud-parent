package com.haohao.asset.controller.home;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haohao.asset.utils.Result;
import com.haohao.permission.model.cond.ResourceCond;
import com.haohao.permission.model.po.ResourcePO;
import com.haohao.permission.service.ResourceService;
import com.haohao.util.LogUtil;
import com.haohao.util.service.DateUtil;

/**
 * @author:abner
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceModule;

    /**
     * @author:abner
     */
    @RequestMapping("/init")
    public String init() {
        return "permission/resourceList";
    }

    /**
     * 根据条件查询resourceList
     *
     * @param resourceParams 参数
     * @author:abner
     */
    @ResponseBody
    @RequestMapping("/getList")
    public Result getList(ResourceCond resourceParams) {
        try {
            return Result.success(resourceModule.getList(resourceParams));
        } catch (Exception e) {
            LogUtil.pringExceptionLog("数据查询失败", e);
            return Result.error("数据查询失败!");
        }
    }

    /**
     * @author:abner
     */
    @RequestMapping("/add")
    public String add() {
        return "permission/resourceAdd";
    }

    /**
     * @author:abner
     */
    @RequestMapping("/edit")
    public String edit(Integer id, Model model) {
        try {
            if (null != id) {
                model.addAttribute("resource", resourceModule.getResourceById(id));
            }
        } catch (Exception e) {
            LogUtil.pringExceptionLog("数据查询失败", e);
        }
        return "permission/resourceEdit";
    }

    /**
     * 新增resource
     *
     * @author:abner
     */
    @ResponseBody
    @RequestMapping("/save")
    public Result save(ResourcePO resource) {
        try {
//			if (null != resourceModule.getResourceByResourceName(resource.getResourceName())) {
//				return Result.error("资源名称已存在");
//			}
//			if (StringUtils.isNotBlank(resource.getResourceCode())&&null != resourceModule.getResourceByResourceCode(resource.getResourceCode())) {
//				return Result.error("资源编码已存在");
//			}
            resource.setCreateTime(DateUtil.unixTimestamp());
            resource.setEnable(1);
            resourceModule.save(resource);
            return Result.success();
        } catch (Exception e) {
            LogUtil.pringExceptionLog("数据保存失败", e);
            return Result.error("数据保存失败");
        }
    }


    /**
     * 修改resource
     *
     * @author:abner
     */
    @ResponseBody
    @RequestMapping("/update")
    public Result update(ResourcePO resource) {
        try {
            if (null == resource.getId()) {
                return Result.error("数据修改失败");
            }
            resourceModule.update(resource);
            return Result.success();
        } catch (Exception e) {
            LogUtil.pringExceptionLog("数据修改失败", e);
            return Result.error("数据修改失败");
        }
    }
}
