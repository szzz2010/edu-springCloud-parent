package com.haohao.util.tools;

import com.haohao.util.springTools.springJdbc.helper.ConfigBootHelper;

public class XsConfig {
	
	public static final String url              = ConfigBootHelper.getPropertyByName("xs.zc.url");
	public static final String appId            = ConfigBootHelper.getPropertyByName("xs.appId");
	public static final String version          = ConfigBootHelper.getPropertyByName("xs.version");
	public static final String xs_md5_key       = ConfigBootHelper.getPropertyByName("xs.md5.key");
	public static final String xs_aes_key       = ConfigBootHelper.getPropertyByName("xs.aes.key");
	public static final String xs_method_prefix = "ac";
	
	public static final String xs_source_name   = ConfigBootHelper.getPropertyByName("xs.source.name");
	public static final String xs_h5_url        = ConfigBootHelper.getPropertyByName("xs.h5.url");
	
	public static final String xs_agency_code   = ConfigBootHelper.getPropertyByName("xs.agency.code");
	public static final String jz_agency_code   = "91120118MA06Q569XG";
	
	public static final String img_path         = ConfigBootHelper.getPropertyByName("img.path"); 
	public static final String web_domain       = ConfigBootHelper.getPropertyByName("web.domain");
	
	public static final String xs_ftp_host		= ConfigBootHelper.getPropertyByName("xs.ftp.host");
	public static final String xs_ftp_port		= ConfigBootHelper.getPropertyByName("xs.ftp.port");
	public static final String xs_ftp_username  = ConfigBootHelper.getPropertyByName("xs.ftp.username");
	public static final String xs_ftp_password	= ConfigBootHelper.getPropertyByName("xs.ftp.password");
	public static final String xs_ftp_filePath	= ConfigBootHelper.getPropertyByName("xs.ftp.filePath");
	
	
	
}
