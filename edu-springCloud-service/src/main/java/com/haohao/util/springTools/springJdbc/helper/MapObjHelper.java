package com.haohao.util.springTools.springJdbc.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.util.ObjectUtils;


/**
 * 
 * @author denshinyou
 *
 */

public class MapObjHelper {
	
	private static final String C = MapObjHelper.class.getName();
	
	/**
	 * 将Object 二维数据  转换为  map对象
	 */
	public static Map<String,Object> transObjectArrayToMap (Object[][]params){
		Map<String,Object> returnMap = new HashMap<>();
		if (!ObjectUtils.isEmpty(params)) {
			for (Object[]kv:params) {
				if(ObjectUtils.isEmpty(kv)){
					continue;
				}
				returnMap.put(String.valueOf(kv[0]), kv[1]);
			}
		}
		return returnMap;
	}
	
	/**
	 * 将 map 转为 Object对象 二维数据
	 */
	public static Object[][] transMapToObjectArray (Map<String,Object>params){
		List<Object[]> list = new ArrayList<>();
		if (!ObjectUtils.isEmpty(params)) {
			for(String k : params.keySet()){
				Object v = params.get(k);
				list.add(new Object[]{k,v});
			}
		}
		return list.toArray(new Object[][]{});
	}
	
	/**
	 * 将对象javaBean装换为Map<String, Object>
	 * @param javaBean 
	 * @return  Map<String, Object>
	 */
	public static <T> Map<String, Object> beanToMap(T bean) {  
	    Map<String, Object> map = new HashMap<>();  
	    if (bean != null) {  
	        BeanMap beanMap = BeanMap.create(bean);  
	        for (Object key : beanMap.keySet()) {  
	            map.put(String.valueOf(key), beanMap.get(key));  
	        }             
	    }  
	    return map;  
	}  
	
	/** 
	 * 将Map<String, Object>装换为javaBean对象 
	 * @param map 
	 * @param clazz 
	 * @return javaBean
	 */  
	public static <T> T mapToBean(Map<String, Object> map,Class<T> clazz) {  
		T t;
		try {
			t = clazz.newInstance();
			BeanMap beanMap = BeanMap.create(t);  
		    beanMap.putAll(map); 
		} catch (Exception e) {
			t = null;
			e.printStackTrace();
		} 
	    return t;  
	}  
	
	/** 
	 * 将List<T>转换为List<Map<String, Object>> 
	 * @param listBean 
	 * @return 
	 */  
	public static <T> List<Map<String, Object>> listBeanToListMap(List<T> listBean) {  
	    List<Map<String, Object>> listMap = new ArrayList<>();  
	    if (!ObjectUtils.isEmpty(listBean)) {  
	        for(T t: listBean){
	        	Map<String, Object> map = beanToMap(t);  
	        	listMap.add(map);  
	        }
	    }  
	    return listMap;  
	}  
	
	/** 
	 * 将List<Map<String,Object>>转换为List<T> 
	 * @param listMap 
	 * @param clazz 
	 * @return listBean
	 */  
	public static <T> List<T> listMapToListBean(List<Map<String, Object>> listMap,Class<T> clazz) {  
	    List<T> listBean = new ArrayList<>();  
	    if (!ObjectUtils.isEmpty(listMap)) {  
	        for (Map<String,Object> map: listMap) {  
	            listBean.add(mapToBean(map, clazz));  
	        }  
	    }  
	    return listBean;  
	}  
	
	/**
	 * 将Map<String, Object>强换成Map<String, String>
	 */
	public static Map<String, String> mapObjToString(Map<String, Object> map) {
		Map<String, String> returnMap = new HashMap<String, String>();
		if(!ObjectUtils.isEmpty(map)){
			for(String key : map.keySet()){
				returnMap.put(key, String.valueOf(map.get(key)));
			}
		}
		return returnMap;
	}
	
	/**
	 * 数据清洗Map<String, Object>中的值，将Object转成String 存入新 Map<String, Object>
	 * 深度递归 到 list Map 的情况
	 * 实用情况 返回前端json数据
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> mapObjToMapStringObj(Map<String, Object> map) {
		Map<String, Object> returnMap = new HashMap<>();
		if(!ObjectUtils.isEmpty(map)){
			for(String key : map.keySet()){
				Object value = map.get(key);
				if(value instanceof java.lang.String){
					returnMap.put(key, (String) value);
				}else if(value instanceof java.util.List){
					returnMap.put(key, ListMapObjToListMapString((List<Map<String, Object>>) value));
				}else if(value instanceof java.util.Map){
					returnMap.put(key, mapObjToMapStringObj((Map<String, Object>) value));
				}else{
					returnMap.put(key, String.valueOf(value));
				}
			}
		}
		return returnMap;
	}

	/**
	 * 数据清洗将List Map<String, Object>
	 */
	public static List<Map<String,Object>> ListMapObjToListMapString(List<Map<String,Object>>listMapObj) {
		List<Map<String,Object>> listMapString = new ArrayList<>();
		if(!ObjectUtils.isEmpty(listMapObj)){
			for(Map<String,Object> mapObj:listMapObj){
				listMapString.add(mapObjToMapStringObj(mapObj));
			}
		}
		return listMapString;
	}
	
	/**
	 * 放入此map中的数据会根据key进行升序序排序并按照顺序输出 已实现线程同步机制
	 */
	public static Map<String, Object> getMapSortedUpByKey() {
		Map<String, Object> map = Collections.synchronizedMap(new TreeMap<String, Object>(new Comparator<String>() {
			public int compare(String obj1, String obj2) {
				return obj1.compareTo(obj2);
			}
		}));
		return map;
	}
	
	/**
	 * 放入此map中的数据会根据key进行降序排序并按照顺序输出 已实现线程同步机制
	 */
	public static Map<String, Object> getMapSortedDownByKey() {
		Map<String, Object> map = Collections.synchronizedMap(new TreeMap<String, Object>(new Comparator<String>() {
			public int compare(String obj1, String obj2) {
				return obj2.compareTo(obj1);
			}
		}));
		return map;
	}

	/**
	 * trim 所有指定的key的值
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> trimValueByKey(Map<K, V> map, K... ks) {
		try {
			for (K k : ks) {
				if (map.containsKey(k)) {
					try {
						V v = map.get(k);
						if(v instanceof java.lang.String){
							if(StringUtils.isNotBlank((String) v)){
								map.put(k, (V) StringUtils.trim((String) v));
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * trim 所有指定的key的值
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> trimAllStringValue(Map<K, V> map) {
		try {
			for (K k : map.keySet()) {
				V v = map.get(k);
				if(v instanceof java.lang.String){
					if(StringUtils.isNotBlank((String) v)){
						map.put(k, (V) StringUtils.trim((String) v));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 *  将原始map中的   指定key  移动到新的map中，返回新map
	 *  强一致性：如果原始map  中没有这个key,   新map中也不会有 这个key
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> transMapByKeys(Map<K, V> map, K... ks) {
		Map<K,V>returnMap = new HashMap<>();
		try {
			for (K k : ks) {
				if (map.containsKey(k)) {
					returnMap.put(k, map.get(k));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return returnMap;
		}
		return returnMap;
	}
	
	/**
	 * 根据参数映射关系，生成一个新映射的map
	 * @param name_name2Map
	 * @param name_valueMap
	 * @return name2_valueMap
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> transMap(Map<K, V> name_name2Map, Map<K, V> name_valueMap,boolean...serializeNulls) {
		Map<K, V> name2_valueMap = new HashMap<K, V>();
		try {
			for (K name : name_name2Map.keySet()) {
				V name2 = name_name2Map.get(name);
				V value = name_valueMap.get(name);
				try{
					if (name_valueMap.containsKey(name)) {
						name2_valueMap.put((K) name2, value);
					}else{
						if(!ObjectUtils.isEmpty(serializeNulls)&&true == serializeNulls[0]){
							name2_valueMap.put((K) name2, null);
						}
					}
				}catch(Exception e){
					name2_valueMap.put((K) String.valueOf(name2), value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name2_valueMap;
	}
	
	/**
	 * 数据清洗list
	 * @param K_VList
	 * @param VS
	 * @return
	 */
	public static <K, V>List<Map<K, V>> transAndFlushListMap(List<Map<K,V>>K_VList,List<V[]>VS){
		if(ObjectUtils.isEmpty(K_VList)){
			return K_VList;
		}
		List<Map<K,V>>K2_VList = new ArrayList<Map<K,V>>();
		for(Map<K,V> K_VMap:K_VList){
			K2_VList.add(transAndFlushMap(K_VMap, VS));
		}
		return K2_VList;
	}
	
	/**
	 * 数据清洗map
	 * @param K_VMap
	 * @param VS
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> transAndFlushMap(Map<K, V> K_VMap, List<V[]> VS) {
		if (ObjectUtils.isEmpty(K_VMap)) {
			return K_VMap;
		}
		Map<K, V> K2_VMap = new HashMap<>();
		for (V[] vs : VS) {
			if (K_VMap.containsKey((K) vs[0])) {
				V v = K_VMap.get((K) vs[0]);
				if (v == null) {
					v = vs[2];
				} else {
					if (!ObjectUtils.isEmpty(vs[3])) {
						try {
							String[] invokeArgs = ((String) vs[3]).split("#");
							v = (V) InvokeMethod.invoke(invokeArgs[0] + "#" + invokeArgs[1],
									new Class[] { Object.class, Object.class ,Object.class}, invokeArgs[2], v,vs[2]);
						} catch (Exception e) {
							v = vs[2];
							e.printStackTrace();
						}
					}
				}
				K2_VMap.put((K) vs[1], v);
			} else {
				K2_VMap.put((K) vs[1], vs[2]);
			}
		}
		return K2_VMap;
	}

	public static String getCMF(){
		return MapObjHelper.C+"#fomatData#";
	}
	
	public static void main(String[] args) {
		System.out.println(getCMF());
	}
	
	/**
	 * 数据化清洗过程中的格式化问题
	 * @param k
	 * @param v
	 * @param v2
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <K,V> V fomatData(K k,V v,V v2){
		if(ObjectUtils.isEmpty(k)){
			return v;
		}
		if("noToDefault".equals(k)){
			return v2;
		}
		if("bigDecimal".equals(k)){
			if(ObjectUtils.isEmpty(v)){
				v = v2;
			}else{
				v = (V) new BigDecimal(String.valueOf(v));
			}
			return v;
		}
		if("int".equals(k)){
			if(ObjectUtils.isEmpty(v)){
				v = v2;
			}else{
				v = (V) Integer.valueOf(String.valueOf(v));
			}
			return v;
		}
		if(TimeHelper.YYYY_MM_DD_HH_MM_SS.equals(k)){
			if(ObjectUtils.isEmpty(v)){
				v = v2;
			}else{
				v = (V) TimeHelper.transTimeByFormat((String)v, TimeHelper.YYYY_MM_DD_HH_MM_SS);
			}
			return v;
		}
		/*if(TimeHelper.YYYY_MM_DD.equals(k)){
			if(ObjectUtils.isEmpty(v)){
				v = v2;
			}else{
				v = (V) TimeHelper.transTimeByFormat((String)v, TimeHelper.YYYY_MM_DD);
			}
			return v;
		}*/
		
		return v;
	}
	
	
	/**
	 * 封尘示例    请勿删除
	 * 
	 * Map<String,Object> personOrder2 = 
	 * MapObjHelper.transAndFlushMap(personOrder, getPersonOrderTransNames());
	 **/
	private String cm = getCMF();
	private List<Object[]> getPersonOrderTransNames(){
		List<Object[]> orderTransNames = new ArrayList<Object[]>();                                
		orderTransNames.add(new Object[]{"loan_number","loan_number","",""}); 
		orderTransNames.add(new Object[]{"loan_agency_code","loan_agency_code","",""}); 
		orderTransNames.add(new Object[]{"loan_agency_name","loan_agency_name","",""}); 
		orderTransNames.add(new Object[]{"loan_user_name","loan_user_name","",""}); 
		orderTransNames.add(new Object[]{"loan_user_id_card","loan_user_id_card","",""}); 
		orderTransNames.add(new Object[]{"loan_user_mobile","loan_user_mobile","",""}); 
		orderTransNames.add(new Object[]{"loan_consult_amt","loan_consult_amt",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"loan_apply_time","loan_apply_time",null,cm+TimeHelper.YYYY_MM_DD_HH_MM_SS}); 
		orderTransNames.add(new Object[]{"loan_contract_amt","loan_contract_amt",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"loan_amt","loan_amt",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"loan_product_type","loan_product_type",1,cm+"int"}); 
		orderTransNames.add(new Object[]{"loan_purpose","loan_purpose",1,cm+"int"}); 
		orderTransNames.add(new Object[]{"loan_interest_rate","loan_interest_rate","",""}); 
		orderTransNames.add(new Object[]{"loan_year_interest_rate","loan_year_interest_rate","",""}); 
		orderTransNames.add(new Object[]{"loan_give_quota","loan_give_quota",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"loan_terms","loan_terms",6,cm+"int"}); 
		orderTransNames.add(new Object[]{"loan_success_time","loan_success_time",null,cm+TimeHelper.YYYY_MM_DD_HH_MM_SS}); 
		orderTransNames.add(new Object[]{"loan_risk_amt","loan_risk_amt",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"loan_risk_level","loan_risk_level","A",""}); 
		orderTransNames.add(new Object[]{"loan_risk_advice","loan_risk_advice","A",""}); 
		orderTransNames.add(new Object[]{"repay_month_amount","repay_month_amount",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"repay_month_principal","repay_month_principal",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"repay_expiry_time","repay_expiry_time",null,cm+TimeHelper.YYYY_MM_DD_HH_MM_SS}); 
		orderTransNames.add(new Object[]{"repay_period","repay_period",0,cm+"int"}); 
		orderTransNames.add(new Object[]{"repay_is_settle","repay_is_settle",0,cm+"int"});
		orderTransNames.add(new Object[]{"repay_first_date","repay_first_date",null,cm+TimeHelper.YYYY_MM_DD}); 
		orderTransNames.add(new Object[]{"repay_month_date","repay_month_date",0,cm+"int"}); 
		orderTransNames.add(new Object[]{"bank_num","bank_num","",""}); 
		orderTransNames.add(new Object[]{"bank_name","bank_name","",""}); 
		orderTransNames.add(new Object[]{"bank_card_no","bank_card_no","",""}); 
		orderTransNames.add(new Object[]{"bank_mobile","bank_mobile","",""}); 
		orderTransNames.add(new Object[]{"bank_province","bank_province","",""}); 
		orderTransNames.add(new Object[]{"bank_city","bank_city","",""}); 
		orderTransNames.add(new Object[]{"bank_branch_name","bank_branch_name","",""}); 
		orderTransNames.add(new Object[]{"person_age","person_age",0,cm+"int"}); 
		orderTransNames.add(new Object[]{"person_birth_date","person_birth_date",null,cm+TimeHelper.YYYY_MM_DD}); 
		orderTransNames.add(new Object[]{"person_gender","person_gender",0,cm+"int"}); 
		orderTransNames.add(new Object[]{"person_education","person_education",0,cm+"int"}); 
		orderTransNames.add(new Object[]{"person_marriage","person_marriage",0,cm+"int"}); 
		orderTransNames.add(new Object[]{"person_local_addr","person_local_addr","",""}); 
		orderTransNames.add(new Object[]{"job_company_name","job_company_name","",""}); 
		orderTransNames.add(new Object[]{"job_company_property","job_company_property",0,cm+"int"}); 
		orderTransNames.add(new Object[]{"job_compnay_detail_addr","job_compnay_detail_addr","",""}); 
		orderTransNames.add(new Object[]{"job_profession","job_profession","",""}); 
		orderTransNames.add(new Object[]{"job_monthly_income","job_monthly_income",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"person_relation_first","person_relation_first",0,cm+"int"}); 
		orderTransNames.add(new Object[]{"person_relation_first_name","person_relation_first_name","",""}); 
		orderTransNames.add(new Object[]{"person_relation_first_mobile","person_relation_first_mobile","",""}); 
		orderTransNames.add(new Object[]{"person_relation_second","person_relation_second",0,cm+"int"}); 
		orderTransNames.add(new Object[]{"person_relation_second_name","person_relation_second_name","",""}); 
		orderTransNames.add(new Object[]{"person_relation_second_mobile","person_relation_second_mobile","",""}); 
		orderTransNames.add(new Object[]{"","create_time",null,cm+TimeHelper.YYYY_MM_DD_HH_MM_SS}); 
		orderTransNames.add(new Object[]{"","update_time",null,cm+TimeHelper.YYYY_MM_DD_HH_MM_SS}); 
		return orderTransNames;
	}
	
	
}
