package com.haohao.util.springTools.springJdbc.helper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.haohao.util.springTools.springJdbc.SpringJdbcDeployVersion;
/**
 * powered by denshinyou
 */
@Repository(SpringApplicationContextHolder.beanName)
public class SpringApplicationContextHolder implements ApplicationListener<ContextRefreshedEvent> {

	public static final String beanName = "springApplicationContextHolder"+SpringJdbcDeployVersion.deployVersion;
	
	private volatile static ApplicationContext context;

	public static Object getBean(String beanName) {
		if (context != null) {
			return context.getBean(beanName);
		} else
			return null;
	}

	public static <T> T getBean(Class<T> clazz) {
		if (context != null) {
			return context.getBean(clazz);
		} else	
			return null;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			if (ObjectUtils.isEmpty(context)) {
				synchronized (SpringApplicationContextHolder.class) {
					if (ObjectUtils.isEmpty(context)) {
						context = event.getApplicationContext();
					}
				}
			}
			long ID = Thread.currentThread().getId();
			String NAME = Thread.currentThread().getName();
			String displayName = context.getDisplayName();
			ApplicationContext parent = event.getApplicationContext().getParent();
			if ( parent != null||"main".equals(NAME)) {
				String PROJECT = null;
				String ENVIRONMENT = null;
				String DB = null;
				String PRINT = null;
				String ZOOKEEPER = null;
				String SERVER_PORT = null;
				String DUBBO_PORT = null;
				try {
					PRINT =  ConfigBootHelper.getPropertyByName("print");
					if(!"true".equals(PRINT)){
						return ;
					}
					PROJECT = SystemPropertiesNames.getConfigInfo(SystemPropertiesNames.project_names);
					ENVIRONMENT = SystemPropertiesNames.getConfigInfo(SystemPropertiesNames.environment_names);
					ZOOKEEPER = SystemPropertiesNames.getConfigInfo(SystemPropertiesNames.zookeeper_port_names);
					DUBBO_PORT = SystemPropertiesNames.getConfigInfo(SystemPropertiesNames.dubbo_port_names);
					SERVER_PORT = SystemPropertiesNames.getConfigInfo(SystemPropertiesNames.server_port_names);
					DB = StringUtils.split(SystemPropertiesNames.getConfigInfo(SystemPropertiesNames.db_names),"?")[0];
				} catch (Exception e) {}
				System.out.println(MessageHelper.format("##########################################################################################"));
				System.out.println(MessageHelper.format("		LOADED		:	{}",displayName));
				System.out.println(MessageHelper.format("		THREAD		:	{}",NAME));
				System.out.println(MessageHelper.format("		ID		:	{}",ID));
				System.out.println(MessageHelper.format("		PROJECT		:	{}",ObjectUtils.isEmpty(PROJECT)?"default":PROJECT));
				System.out.println(MessageHelper.format("		ENVIRONMENT	:	{}",ObjectUtils.isEmpty(ENVIRONMENT)?"default":ENVIRONMENT));
				System.out.println(MessageHelper.format("		SERVER_PORT	:	{}",ObjectUtils.isEmpty(SERVER_PORT)?"default":SERVER_PORT));
				System.out.println(MessageHelper.format("		DB-INFO		:	{}",ObjectUtils.isEmpty(DB)?"default":DB));
				System.out.println(MessageHelper.format("		ZOOKEEPER	:	{}",ObjectUtils.isEmpty(ZOOKEEPER)?"default":ZOOKEEPER));
				System.out.println(MessageHelper.format("		DUBBO-PORT	:	{}",ObjectUtils.isEmpty(DUBBO_PORT)?"default":DUBBO_PORT));
				System.out.println(MessageHelper.format("##########################################################################################"));
				if(!"main".equals(NAME)){}
				Thread.sleep(3000L);
			}
		} catch (Exception e) {
			
		}
	}
	
	
	/**
	 *  鍦╳eb椤圭洰涓紙spring mvc锛夛紝绯荤粺浼氬瓨鍦ㄤ袱涓鍣紝涓�涓槸root application context   
	 *  ,鍙︿竴涓氨鏄垜浠嚜宸辩殑 projectName-servlet context锛堜綔涓簉oot application  
	 *  context鐨勫瓙瀹瑰櫒锛夈��                                               
	 *  杩欑鎯呭喌涓嬶紝灏变細閫犳垚onApplicationEvent鏂规硶琚墽琛屼袱娆°�備负浜嗛伩鍏嶈繖涓棶棰橈紝鎴戜滑鍙互鍙湪root     
	 *  application context鍒濆鍖栧畬鎴愬悗璋冪敤閫昏緫浠ｇ爜锛屽叾浠栫殑瀹瑰櫒鐨勫垵濮嬪寲瀹屾垚锛屽垯涓嶅仛浠讳綍澶勭悊銆�        
	 */
	
	
}
