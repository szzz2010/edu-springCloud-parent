<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<div class="layui-header">
    <div class="layui-logo" style="color: #fff;">资产系统</div>
    <nav>
        <ul class="layui-nav layui-layout-left" lay-filter="menu">
            <c:forEach items="${sessionScope.adminMemberSession.menuList}" var="menu">
                <li class="layui-nav-item" data-url="${menu.resourceUrl}"><a data-url="${menu.resourceUrl}" href="javascript:;">${menu.resourceName}</a>
                    <c:if test="${menu.children != null && menu.children.size()>0}">
                        <dl class="layui-nav-child">
                            <c:forEach items="${menu.children}" var="children">
                                <dd data-url="${children.resourceUrl}"><a data-url="${children.resourceUrl}" href="javascript:;">${children.resourceName}</a></dd>
                            </c:forEach>
                        </dl>
                    </c:if>
                </li>
            </c:forEach>
        </ul>
    </nav>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a>
                ${sessionScope.adminMemberSession.admin.realName}
            </a>
            <dl class="layui-nav-child">
                <dd><a onclick="openView('修改密码','/login/changePassword',['380px', '250px'])">修改密码</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="${webPath}/login/logout">退出</a></li>
    </ul>
</div>