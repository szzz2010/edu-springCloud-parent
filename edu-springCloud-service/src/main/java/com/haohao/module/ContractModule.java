package com.haohao.module;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haohao.constant.ContractConstant;
import com.haohao.dao.ContractDao;
import com.haohao.dao.ContractDetailDao;
import com.haohao.modelAndExample.Contract;
import com.haohao.util.encrypt.Encrypt;
import com.haohao.util.paramAndDto.ContractDetail;
import com.haohao.util.paramAndDto.ContractDetailParam;
import com.haohao.util.paramAndDto.ContractParam;
import com.haohao.util.paramAndDto.PredicateUtil;
import com.haohao.util.service.DateUtil;

/**
 * @Desc 额度申请Module
 * @Author xiekunliang
 * @Date 2018/5/16 16:10
 */
@Component
public class ContractModule {

    @Autowired
    private ContractDao contractDao;

    @Autowired
    private ContractDetailDao contractDetailDao;

    /**
     * @Desc 查询额度包
     * @Author xiekunliang
     * @Date 2018/5/16 16:24
     */
    public List<Contract> selectByContractParam(ContractParam param) {
        return contractDao.selectByContractParam(param);
    }

    /**
     * @Desc 根据主键查询
     * @Author xiekunliang
     * @Date 2018/5/16 16:25
     */
    public Contract selectById(Integer id) {
        return contractDao.selectByPrimaryKey(id);
    }

    /**
     * @Desc 根据contractCode查询
     * @Author xiekunliang
     * @Date 2018/5/18 14:09
     */
    public Contract selectByContractCode(String contractCode) {
        return contractDao.selectByContractCode(contractCode);
    }


    /**
     * @Desc 添加
     * @Author xiekunliang
     * @Date 2018/5/16 16:33
     */
    public Contract insert(Contract contract) {
        contract.setCreateTime(DateUtil.now());
        contract.setUpdateTime(contract.getCreateTime());
        PredicateUtil.state(contractDao.insert(contract) > 0, "添加失败");
        return contract;
    }

    /**
     * @Desc 更新
     * @Author xiekunliang
     * @Date 2018/5/16 16:34
     */
    public Contract update(Contract contract) {
        contract.setUpdateTime(DateUtil.now());
        contractDao.updateByPrimaryKey(contract);
        return contract;
    }

    /**
     * @Desc 禁用/启用
     * @Author xiekunliang
     * @Date 2018/5/16 16:34
     */
    public Boolean enableOperation(Integer id, Boolean enable) {
        Contract contract = new Contract();
        contract.setId(id);
        contract.setEnable(enable ? ContractConstant.Enable.NORMAL
                : ContractConstant.Enable.FORBIDDEN);
        return update(contract) != null;
    }

    /**
     * @Desc 额度申请状态更新
     * @Author xiekunliang
     * @Date 2018/5/17 10:10
     */
    public int quotaApplySuccess(List<Integer> successIds) {
        long now = DateUtil.now();
        Contract contract = new Contract();
        contract.setStatus(ContractConstant.Status.USEING);
        contract.setStartDate(now);
        contract.setUpdateTime(now);
        return contractDao.quotaApplySuccess(successIds, contract);
    }

    /**
     * <p>Description：扣减额度</p>
     *
     * @param contractCode 额度包编号
     * @param subtract     扣减金额
     * @return
     * @date 2018年5月18日 下午8:45:56
     * @author zhangqiang
     */
    public int subtractBalance(String contractCode, BigDecimal subtract) {
        return contractDao.subtractBalance(contractCode, subtract);
    }

    /**
     * @Desc 查询额度包使用明细
     * @Author xiekunliang
     * @Date 2018/5/19 18:02
     */
    public List<ContractDetail> selectContractDetails(ContractDetailParam param) {
        if (StringUtils.isNotBlank(param.getLoanUserName())) {
            try {
                param.setLoanUserName(Encrypt.encryptAES(param.getLoanUserName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return contractDetailDao.selectContractDetails(param);
    }

    /**
     * @Desc 查询剩余总额度
     * @Author xiekunliang
     * @Date 2018/5/19 20:41
     */
    public BigDecimal countSumBalance() {
        return contractDao.countSumBalance();
    }

    /**
     * @Desc 查询已使用总额度
     * @Author xiekunliang
     * @Date 2018/5/19 21:40
     */
    public BigDecimal countSumContractAmt(String contractCode) {
        return contractDetailDao.countSumContractAmt(contractCode);
    }
}
