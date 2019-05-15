package com.haohao.util.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;

public class HttpClientUtil {  
	private final static Logger log = LoggerFactory.getLogger(HttpClientUtil.class);
  
    public static String exec(String url, String is_post, String is_json, Map<String, Object> inParams) {
		CloseableHttpClient httpClient = null;
		HttpResponse resp = null;
		try {
			if (url.startsWith("https")) {
				httpClient = exec_ignoreSSLHttpClient();
			} else {
				httpClient = HttpClients.createDefault();
			}
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(60000).setConnectionRequestTimeout(30000).setSocketTimeout(30000).build();
			if ("1".equals(is_post)) {
				HttpPost httpost = new HttpPost(url);
				if (is_json.equals("0")) {
					List<NameValuePair> list = new ArrayList<NameValuePair>();
					if (!CollectionUtils.isEmpty(inParams)) {
						for(String key : inParams.keySet()){
							list.add(new BasicNameValuePair(key, inParams.get(key) == null ? "" : String.valueOf(inParams.get(key))));
						}
					}
					UrlEncodedFormEntity urlFormEntity = new UrlEncodedFormEntity(list,"UTF-8");
					httpost.setEntity(urlFormEntity);
					list = null;
				} else {
					httpost.setHeader("Content-Type", "application/json;charset=UTF-8");
					String json =JSON.toJSONString(inParams);
					StringEntity entity = new StringEntity(json, "UTF-8");
					httpost.setEntity(entity);
				}
				httpost.setConfig(requestConfig);
				resp = httpClient.execute(httpost);
			} else {
				URIBuilder builderGet = new URIBuilder(url);
				builderGet.setCharset(Charset.forName("UTF-8"));
				if (!CollectionUtils.isEmpty(inParams)) {
					for (String key : inParams.keySet()) {
						builderGet.addParameter(key, inParams.get(key) == null ? "" : (String)inParams.get(key));
					}
				}
				HttpGet httpGet = new HttpGet(builderGet.build());
				httpGet.setConfig(requestConfig);
				resp = httpClient.execute(httpGet);
			}
			int resultCode = resp.getStatusLine().getStatusCode();
			String result = EntityUtils.toString(resp.getEntity(), "UTF-8");
			if (resultCode == 200) {
				return result;
			} else {
				return "[#对方错误#]" + resultCode+",服务器返回:"+result;
			}
		} catch (Exception e) {
			log.error("http请求出现异常", e);
			return null;
		} finally {
			if (httpClient != null) {
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@SuppressWarnings("deprecation")
	private static CloseableHttpClient exec_ignoreSSLHttpClient() throws Exception {
		KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
		SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(trustStore, new TrustStrategy() {
			@Override
			public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
				return true;
			}
		}).build();
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new String[] { "TLSv1" }, null, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		return HttpClients.custom().setSSLSocketFactory(sslsf).build();
	}
    
}