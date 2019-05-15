<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    request.setAttribute("webPath", request.getContextPath());
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<script type="text/javascript" src="${webPath}/static/js/jquery.min.js" ></script>
	<script type="text/javascript">
	(function($){
		 var browser = {
					versions : function() {
						var u = navigator.userAgent, app = navigator.appVersion;
						return { // 移动终端浏览器版本信息
							ios : !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/),
							android : u.indexOf('Android') > -1
									|| u.indexOf('Linux') > -1
						};
					}(),
					language : (navigator.browserLanguage || navigator.language).toLowerCase()
				}
		function  finishCurrentPage(){
			if(browser.versions.ios) {
				console.info("ios");
				window.location.href = 'cc:method://${resultMap}';
			} else if(browser.versions.android) {
				console.info("android");
				window.haohao.next('${resultMap}');
			}
		}
		finishCurrentPage();
	})(jQuery);
	</script>
	<body>
	</body>
</html>
