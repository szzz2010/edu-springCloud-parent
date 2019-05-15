package com.haohao.asset.controller.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haohao.asset.utils.Result;
import com.haohao.permission.model.cond.RoleCond;
import com.haohao.permission.model.po.RolePO;
import com.haohao.permission.model.vo.ResourceVO;
import com.haohao.permission.model.vo.RoleVO;
import com.haohao.permission.service.RoleService;
import com.haohao.util.LogUtil;
import com.haohao.util.service.DateUtil;

/**
 * @author:abner
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleModule;

    /**
     * @author:abner
     */
    @RequestMapping("/init")
    public String init() {
        return "permission/roleList";
    }

    /**
     * 根据条件查询roleList
     *
     * @param roleParams 参数
     * @author:abner
     */
    @ResponseBody
    @RequestMapping("/getList")
    public Result getList(RoleCond roleParams) {
        try {
            List<RoleVO> list = roleModule.getList(roleParams);
            return Result.success(list);
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
        return "permission/roleAdd";
    }

    /**
     * @author:abner
     */
    @RequestMapping("/edit")
    public String edit(Integer id, Model model) {
        try {
            if (null != id) {
                model.addAttribute("role", roleModule.getRoleById(id));
            }
        } catch (Exception e) {
            LogUtil.pringExceptionLog("数据查询失败", e);
        }
        return "permission/roleEdit";
    }

    /**
     * 新增role
     *
     * @author:abner
     */
    @ResponseBody
    @RequestMapping("/save")
    public Result save(RolePO role) {
        try {
            if (null != roleModule.getRoleByRoleName(role.getRoleName())) {
                return Result.error("角色已存在");
            }
            role.setCreateTime(DateUtil.unixTimestamp());
            role.setEnable(1);
            roleModule.save(role);
            return Result.success();
        } catch (Exception e) {
            LogUtil.pringExceptionLog("数据保存失败", e);
            return Result.error("数据保存失败");
        }
    }

    /**
     * @author:abner
     */
    @RequestMapping("/allocationResource")
    public String allocationResource() {
        return "permission/allocationResource";
    }

    /**
     * 修改role
     *
     * @author:abner
     */
    @ResponseBody
    @RequestMapping("/update")
    public Result update(RolePO role) {
        try {
            if (null == role.getId()) {
                return Result.error("数据修改失败");
            }
            if (role.getId().equals(1)) {
                return Result.error("此数据不能修改!");
            }
            roleModule.update(role);
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
    @RequestMapping("/resourceList")
    public List<ResourceVO> resourceList(Integer roleId) {
        try {
            return roleModule.resourceList(roleId);
        } catch (Exception e) {
            LogUtil.pringExceptionLog("数据查询失败", e);
            return null;
        }
    }

    /**
     * 保存role资源
     *
     * @author:abner
     */
    @ResponseBody
    @RequestMapping("/saveResource")
    public Result saveResource(RoleCond roleParams) {
        try {
            if (null == roleParams.getId()) {
                return Result.error("数据保存失败");
            }
            roleModule.saveResource(roleParams);
            return Result.success();
        } catch (Exception e) {
            LogUtil.pringExceptionLog("数据保存失败", e);
            return Result.error("数据保存失败");
        }
    }

}
