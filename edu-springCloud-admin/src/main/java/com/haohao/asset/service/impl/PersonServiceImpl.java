package com.haohao.asset.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haohao.asset.entity.Person;
import com.haohao.asset.mapper.PersonMapper;
import com.haohao.asset.service.IPersonService;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xueyx
 * @since 2019-03-25
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

}
