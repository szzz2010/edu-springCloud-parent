<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
.call-lable {
	position: fixed;
	z-index: 9999;
	top: 100px;
	right: 0px;
	width: 28px;
	height: 45px;
	border-radius: 5px 0px 0px 5px;
	background-color: #5CB85C;
	color: white;
	display: flex;
	justify-content: center;
	align-items: Center;
	background-image:
		url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAEgUlEQVRYR62XaaydUxiFnyWomKl5SGNoqVIqVVNImiIaBI3UWENE9QcNTZWgtBJipiKhihhrSpSYaRszIcaGqjbijzFCquZpybrZ9zr3u9937r2t98/JOWcPa693vWu/WzSE7ZHA+cAewCBgdeBa4GJJfzTN6+/vqk6wvTZwG3Bi+W85sBgYBqwHvAgcIunP/m5WN74OwHPZoGw0XdKrmWh7K+AVYHvgOklT/3cAtk8A7gfeAA6Q9HfrJrZ3Bj4CfgW2kPTTqoLoxoDt54GDgf0kBUSPsH03cDIwUdKchjE7lkO8Dlwt6bUmoF0AbCe/PwBLJQ1tI85DgWeABySFsTqQ6wK3ACeVP+8AJkv6pTq4FUBOHgZmSprRBsAAIAstlrRruxTY3gt4pFTRk8CRkv5pndMKILSG3gmS7utl4e+BAZLWaWDgWGC5pGdtDwReAEYAV0i6qAnAeckXMEbSwl4A5BQrJG1QU8ZrFZHmr1TQ4cBfwAfAdsC+kt7qnNfKwNnATcARkkJXbdiOKX0OLJI0vIGBy4BzgWjhzYg6VQW8BDwsKQx1RCuA8cBDwOmS7mxYeE3gciAecKmkbNQVtg/LCctBopX4RgCPLelYCmwNbC5pRRXAgQXhDEkza6idAFwPbALEigdJ+roCIOAuBL4rOc/Jc6iOirF9A3BOSl3S/CqA0JUyXCAppdZ6smz6Rfkhp5ol6YkGlqbEKYEbgSuBgHxf0gjb2TwguliuGlEMYzdgw9Zysb0p8C3wuKSjehFo5n8IPA0cn2oAlkkabLtTZ1MlBeR/GsgX26H+kjontL0E2AEYIumzNiLdFsjYWREc8G7SIOk420lhxHmKpHvqAAwpk2dLmlRJwzHFVOZJGteOhc7/bK8B5NRzoxfbqYi9geGSFvUAUFh4GdgTGCjp9wqIUBuKD5K0oC8gKvMj0N1ry7AFddQeeiZJml1ZYAwQ9X5ZUvFzf0FUx9f1A6EtOcznYEm/VUA8CMRI7pUU++4I27HaOOMSSV/1FVgPAGWxzr5gmqRrKgA2Kj3BlmEJyJUcwZ1VxqWHiJPOkfRUb0BqARQQyfc2wFBJ31RA7ANEK6sBHxdd3FX6xnRTm5XxEd1pkj5pAtIOQNSahmKhpFzV3cJ20nB78fuU2khJtp01Y+sp6Z2AH+MHkuILPaIRQGEhXj8duEDSVTUgch3vArxTvedtp4uO2UwGUk2jJIXVbtEbgFAc6w3loyWF9n6F7VTSRCBpGNbYkDStajv3wNvA+sD+7fJZt4bt9AefAnHI8ZLSIXVFWwY6R9lOLiOoKDw32Xv9ocH2mcCtwM2S4oz9A1D0MKpc1/k6TlIa0z6F7Vxg84DHJB29UgAKiFzTj6YfBKZISv33GrZTAWPrmpg+paB1B9t5osVg0unk84x2zmc7TUmu+bhrLqFu78p+AyhMxHLTcJwK5I04t1y987OB7Y3jC6UPnFba+Dx28sbsFisFoEWcaTQjquQ1dV8X6YDzikpX3CNWCUALkJTo6NKQ5v2Ytn1ZhNf0xOuc+y/uNc0w7mEdRAAAAABJRU5ErkJggg==");
	background-repeat: no-repeat;
	background-position:center;
	background-size: 18px;
}

#dyCti {
	position: fixed;
	z-index: 9998;
	overflow: hidden;
	text-align: center;
	top: 100px;
	right: 28px;
	border: 0px;
	box-shadow: 5px 5px 5px #888888;
	display: none;
}
</style>
<div class="aside-nav">
	<div class="call-lable"></div>
	<div id="callme"></div>
	<iframe allow="microphone" id="dyCti" src="https://cti.duyansoft.com?noOpBtn=false&noNumberInput=false" width="260px" height="480px" scrolling="no"></iframe>
</div>

<script type="text/javascript"
	src='https://cti.duyansoft.com/syui/dysdk/dysdk.js'></script>
<script type="text/javascript">
	var duyan = {};

	$(".call-lable").click(function(event){
		event.stopPropagation();
		$("#dyCti").slideToggle("fast");
	});
	
	$('#callme').bind('myclick', function(event, number) {
		duyan.callme(number);
	})

	DYSDK.ready(function() {
		duyan.callme = function(number) {
			//alert(number);
			$("#dyCti").slideDown("fast");
			DYSDK.call(number, function() {
			}, '信审');
		}
	})

	window.onload = function() {
		DYSDK.init();
		// 接通电话的回调函数，返回电话号码等信息
		DYSDK.callConfirm(function(data) {
			console.log("接通电话", data)
		});

		// 拨打电话失败的回调函数，返回电话号码等信息
		DYSDK.callFail(function(data) {
			var id = localStorage.getItem('id');
			console.log("拨打失败", data)
		});

		// 电话结束的回调函数，返回电话号码等信息
		DYSDK.callEnd(function(data) {
			console.log("电话结束", data)
		});

		// 正在拨打中的回调函数，返回电话号码等信息
		DYSDK.callConnecting(function(data) {
			console.log("正在拨号中", data);
		});

		// 编辑电话记录结束后的回调函数，返回电话号码等信息
		DYSDK.wrapupEnd(function(data) {
			console.log("编辑电话记录结束", data);
		})

		// CTI退出登录的回调函数
		DYSDK.ctiLogout(function(data) {
			console.log("退出登录", data);
		});

		//登录成功后返回accountId.
		DYSDK.ctiLogined(function(data) {
			console.log("登录成功", data);
		});

		DYSDK.callBridge(function(data) {
			console.log("退出登录", data);
		});
	}
</script>
<script>
	$(document).click(function(){
		$("#dyCti").hide();
	});
	
	$("#dyCti").click(function(event){
		event.stopPropagation();
	});
</script>