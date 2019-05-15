package com.haohao.asset.controller.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haohao.asset.utils.Result;
import com.haohao.asset.utils.SessionUtil;
import com.haohao.permission.context.AdminMemberSession;
import com.haohao.permission.model.cond.AdminCond;
import com.haohao.permission.model.vo.AdminVO;
import com.haohao.permission.service.AdminService;
import com.haohao.util.LogUtil;

/**
 * 用户登录
 *
 * @author wanglicheng
 * @date 2018年8月9日
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static final String BASE_PAGE = "login/";

    public String home = "/home/init";

    public Integer systemType = 46;

    @Autowired
    private AdminService adminService;

    @RequestMapping("/init")
    public String loginPage() {
        return BASE_PAGE + "init";
    }

    @RequestMapping("/login")
    public String login(AdminCond adminParams, HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        try {
            if (StringUtils.isBlank(adminParams.getUserName()) || StringUtils.isBlank(adminParams.getPassword())) {
                map.put("loginError", "用户名或密码错误");
                return "login/init";
            }
            AdminVO admin = adminService.getAdmin(adminParams);
            if (null == admin || !admin.getPassword().equals(DigestUtils.md5Hex(adminParams.getPassword()))) {
                map.put("loginError", "用户名或密码错误");
                return "login/init";
            }
            if (admin.getEnable().equals(0)) {
                map.put("loginError", "帐号失效");
                return "login/init";
            }
            AdminMemberSession principalPermission = adminService.principalPermission(admin, this.systemType);
            SessionUtil.setPrincipal(principalPermission);
            return "redirect:" + home;
        } catch (Exception e) {
            LogUtil.pringExceptionLog("登录异常", e);
        }
        return null;
    }

    /**
     * 退出系统
     *
     * @author:abner
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        try {
            SessionUtil.logout();
        } catch (Exception e) {
            LogUtil.pringExceptionLog("退出失败", e);
        }
        return "login/init";
    }


    /**
     * 修改密码
     *
     * @author:abner
     */
    @RequestMapping("/changePassword")
    public String changePassword() {
        return "home/changePassword";
    }

    /**
     * 修改密码
     *
     * @author:abner
     */
    @ResponseBody
    @RequestMapping("/updatePassword")
    public Result updatePassword(HttpServletRequest requst, String oldPassword, String newPassword) {
        try {
            AdminVO admin = adminService.getAdminById(SessionUtil.getUserId());
            if (null == admin || !admin.getPassword().equals(DigestUtils.md5Hex(oldPassword))) {
                return Result.error("旧密码输入错误");
            }
            adminService.updatePassword(SessionUtil.getUserId(), newPassword);
            return Result.success();
        } catch (Exception e) {
            LogUtil.pringExceptionLog("数据修改失败", e);
            return Result.error("数据修改失败");
        }
    }

}
