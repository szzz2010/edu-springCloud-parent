package com.haohao.asset.controller.home;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haohao.asset.utils.Result;
import com.haohao.permission.model.cond.AdminCond;
import com.haohao.permission.model.po.AdminPO;
import com.haohao.permission.service.AdminService;
import com.haohao.permission.service.RoleService;
import com.haohao.util.LogUtil;
import com.haohao.util.service.DateUtil;

/**
 * @author:abner
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminModule;

    @Autowired
    private RoleService roleModule;

    /**
     * @author:abner
     */
    @RequestMapping("/init")
    public String init() {
        return "permission/adminList";
    }

    /**
     * @author:abner
     */
    @ResponseBody
    @RequestMapping("/getList")
    public Result getList(AdminCond adminParams) {
        try {
            return Result.success(adminModule.getList(adminParams));
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
        return "permission/adminAdd";
    }

    /**
     * @author:abner
     */
    @RequestMapping("/edit")
    public String edit(Integer id, Model model) {
        try {
            if (null != id) {
                model.addAttribute("admin", adminModule.getAdminById(id));
            }
        } catch (Exception e) {
            LogUtil.pringExceptionLog("数据查询失败", e);
        }
        return "permission/adminEdit";
    }

    /**
     * @author:abner
     */
    @RequestMapping("/allocationRole")
    public String allocationRole(Integer id, Model model) {
        try {
            if (null != id) {
                model.addAttribute("roleIdList", adminModule.getRoleIdListByAdminId(id));
                model.addAttribute("roleList", roleModule.getList());
            }
        } catch (Exception e) {
            LogUtil.pringExceptionLog("数据查询失败", e);
        }
        return "permission/allocationRole";
    }

    /**
     * @author:abner
     */
    @ResponseBody
    @RequestMapping("/save")
    public Result save(AdminPO admin) {
        try {
            if (null != adminModule.getAdminByUserName(admin.getUserName())) {
                return Result.error("帐号已存在");
            }
            admin.setCreateTime(DateUtil.unixTimestamp());
            admin.setEnable(1);
            admin.setPassword(DigestUtils.md5Hex(admin.getPassword()));
            adminModule.save(admin);
            return Result.success();
        } catch (Exception e) {
            LogUtil.pringExceptionLog("数据保存失败", e);
            return Result.error("数据保存失败");
        }
    }

    /**
     * @author:abner
     */
    @ResponseBody
    @RequestMapping("/update")
    public Result update(AdminPO admin) {
        try {
            if (null == admin.getId()) {
                return Result.error("数据修改失败!");
            }
            if (admin.getId().equals(1)) {
                return Result.error("此数据不能修改!");
            }
            adminModule.update(admin);
            return Result.success();
        } catch (Exception e) {
            LogUtil.pringExceptionLog("数据修改失败", e);
            return Result.error("数据修改失败!");
        }
    }

    /**
     * @author:abner
     */
    @ResponseBody
    @RequestMapping("/resetPassword")
    public Result resetPassword(AdminPO admin) {
        try {
            if (null == admin.getId()) {
                return Result.error("数据修改失败");
            }
            admin.setPassword(DigestUtils.md5Hex(admin.getPassword()));
            adminModule.update(admin);
            return Result.success();
        } catch (Exception e) {
            LogUtil.pringExceptionLog("数据修改失败", e);
            return Result.error("数据修改失败");
        }
    }

    /**
     * @author:abner
     */
    @ResponseBody
    @RequestMapping("/saveRole")
    public Result saveRole(AdminCond adminParams) {
        try {
            if (null == adminParams.getId()) {
                return Result.error("数据保存失败");
            }
            adminModule.saveRole(adminParams);
            return Result.success();
        } catch (Exception e) {
            LogUtil.pringExceptionLog("数据保存失败", e);
            return Result.error("数据保存失败");
        }
    }

}
