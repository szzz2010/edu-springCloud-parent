package com.haohao.config;

import org.springframework.stereotype.Component;

import com.haohao.util.springTools.springJdbc.helper.ConfigBootHelper;

/**
 * @author Yongjun Xu
 * @description 加载属性文件的值
 * @date 11:37 2018/8/17
 */
@Component
public class PropertyLoader {
  public static String getPropertyByName(String name){
	  return ConfigBootHelper.getPropertyByName(name);
  }
}
