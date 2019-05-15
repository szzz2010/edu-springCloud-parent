package com.haohao.asset.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public interface IDownloadAttachService {
	void downloadOrderAttach(Map<String, Object> params, HttpServletResponse response);

	void downloadElectronicSignature(Map<String, Object> params, HttpServletResponse response);

	Map<String, Object> getElectronicSignatureList(String loan_number);

}
