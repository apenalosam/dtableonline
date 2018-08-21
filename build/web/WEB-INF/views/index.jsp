<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ include file="header.jsp" %>
<!---------------------------------------------->
<link href="${contextPath}/resources/css/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/base.operativo.busqueda.css" rel="stylesheet">
<link href="${contextPath}/resources/css/dataTables.bootstrap.min.css" rel="stylesheet">
<script src="${contextPath}/resources/js/plugins/zoomify/zoomify.min.js"></script>
<link href="${contextPath}/resources/css/base.operativo.busqueda.css" rel="stylesheet">
<link href="${contextPath}/resources/js/plugins/zoomify/zoomify.min.css" rel="stylesheet">
<link href="${contextPath}/resources/js/plugins/toast/jquery.toast.css" rel="stylesheet">
<%@ include file="menu.jsp" %>
<script>
    var path = 'player_sheet'; 
    function newSheet(){
        path = 'new_sheet';
        setPath(path);
    }
    function loadSheet(characterId){
        $('.load'+characterId).removeClass('fa-edit');
        $('.load'+characterId).addClass('fa-spinner fa-spin');
        setPath('player_sheet/' + characterId);
    }
    function setPath(pathId){
        window.location.href='${contextPath}/dtable/'+pathId;
    }
    function openModal(){
        //$('.modal-body').load('${contextPath}/dtable/character_selector');
        $("#insert").load('${contextPath}/dtable/character_selector');
    }
</script>
<!--<form>-->
    <div class="container" style="padding-top: 10%">
        <button id="ncanch" class="menuButton" onclick='newSheet()'>
            New Character
        </button>
        <button id="ncaech" data-toggle="modal" data-target="#newCampaignModal" class="menuButton rightButton" onclick="openModal()">
            Load Character
        </button>
    </div>
<!--</form>-->
<!-- Modal -->
<div id="newCampaignModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content -->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h3 class="panel-title"><strong>Select your character</strong></h3>
            </div>
            <div class="modal-body" id="modalBody">
                <table id="listOfCharacters" class="table table-striped table-bordered" cellspacing="0" width="100%">
                    <thead class="stylish" style="background-color: #800000; border-color: #800000;">
                        <tr class="btn-primary">
                            <th style="width: 18%;" class="table-header">Name</th>
                            <th style="width: 18%;" class="table-header">Class</th>
                            <th style="width: 18%;" class="table-header">Level</th>
                            <th style="width: 18%;" class="table-header">Race</th>
                            <th style="width: 18%;" class="table-header">Campaign</th>
                            <th style="width: 10%;" class="table-header">Choose</th>
                        </tr>
                    </thead>
                    <tbody id="insert">
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
