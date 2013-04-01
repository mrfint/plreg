<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta charset="utf-8"/>
    <link rel="icon" href="<spring:url value="/resources/img/favicon.ico" />" type="image/vnd.microsoft.icon" />

    <link type="text/css" href="<spring:url value="/resources/css/lib/bootstrap.css"/>" rel="stylesheet" />
    <link type="text/css" href="<spring:url value="/resources/css/lib/bootstrap-responsive.css"/>" rel="stylesheet" />
    <link type="text/css" href="<spring:url value="/resources/css/pages/home.css"/>" rel="stylesheet" />

    <script type="text/javascript" src="<spring:url value="/resources/js/lib/jquery-1.9.1.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/resources/js/lib/underscore.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/resources/js/lib/backbone.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/resources/js/lib/jsrender.js"/>"></script>

    <script type="text/javascript" src="<spring:url value="/resources/js/pages/home.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/resources/js/collection/appointments.js"/>"></script>

</head>
<body>
<script id="rowTemplate" type="text/x-jsrender">
    <div class="item no-overflow">
        <div class="name">{{>name}}</div>
        <div class="liquid-container info no-overflow">
            <div class="span block">
                <div class="photo"></div>
            </div>
            <div class="span2 block">
                <div class="row">
                    <span class="param-name">Appointment Date</span>
                    <span class="param-value">{{>appointDate}}</span>
                </div>
                <div class="row">
                    <span class="param-name">Appointment Type</span>
                    <span class="param-value">{{>appointType}}</span>
                </div>
            </div>
            <div class="span2 block">
                <div class="row">
                    <span class="param-name">Resource</span>
                    <span class="param-value">{{>resource}}</span>
                </div>
                <div class="row">
                    <span class="param-name">Location</span>
                    <span class="param-value">{{>location}}</span>
                </div>
            </div>
            <div class="span block">
                <div class="row">
                    <span class="param-name">MRN</span>
                    <span class="param-value">{{>mrn}}</span>
                </div>
                <div class="row">
                    <span class="param-name">PCN</span>
                    <span class="param-value">{{>pcn}}</span>
                </div>
            </div>
            <div class="span2 block">
                <div class="row">
                    <span class="param-name">DOB</span>
                    <span class="param-value">{{>dob}}</span>
                </div>
                <div class="row">
                    <span class="param-name">Phone</span>
                    <span class="param-value">{{>phone}}</span>
                </div>
            </div>
        </div>
    </div>
</script>

<div class="container-fluid" id="appointments">
    <div class="header">
        <div class="right-navigation">
            <span class="user-name">${currentUser}</span>
            <i class="icon-home"></i>
            <a href="/loggedout">logout</a>
        </div>
    </div>
    <div class="filters">
        <select name="location" id="location">
        </select>
        <select name="department" id="department">
        </select>
    </div>

    <div class="list rounded">
        <div class="title">appointments</div>
        <div class="inner-list">
        </div>
    </div>
</div>
</body>
</html>