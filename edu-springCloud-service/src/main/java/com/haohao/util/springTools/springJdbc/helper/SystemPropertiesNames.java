package com.haohao.util.springTools.springJdbc.helper;

import org.springframework.util.ObjectUtils;

public class SystemPropertiesNames {

	public static String getConfigInfo(String [] names){
		String info = "";
		for(String name : names){
			String propertyByName = ConfigBootHelper.getPropertyByName(name);
			if(!ObjectUtils.isEmpty(propertyByName)){
				info = propertyByName;
				break;
			}
		}
		return info;
	}
	
	
	public static String [] db_names = new String [] {"env.mysql.url","spring.datasource.url"} ;
	public static String [] project_names = new String [] {"project","dubbo.application.name"} ;
	public static String [] environment_names = new String [] {"spring.profiles.active","environment"} ;
	public static String [] dubbo_port_names = new String [] {"dubbo.protocol.port","dubbo.port"} ;
	public static String [] zookeeper_port_names = new String [] {"dubbo.registry.address","zookeeper.address"} ;
	public static String [] server_port_names = new String [] {"server.port"} ;
	
	
	
	
	
	
	
	
	
	
}
