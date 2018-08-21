<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ include file="../header.jsp"%>
<%@ include file="../menu.jsp"%>
<link href="${contextPath}/resources/js/plugins/jquery.typeahead.min.css" rel="stylesheet">
<link href="${contextPath}/resources/js/plugins/toast/jquery.toast.css" rel="stylesheet">
<div>
    <label style="width:100%; margin-top: 300px; text-align: center">This will be the sheet manager for the DM</label>
</div>
<%@ include file="../footer.jsp" %>