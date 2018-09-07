<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ include file="../header.jsp"%>
<%@ include file="../menu.jsp"%>
<link href="${contextPath}/resources/js/plugins/jquery.typeahead.min.css" rel="stylesheet">
<link href="${contextPath}/resources/js/plugins/toast/jquery.toast.css" rel="stylesheet">
<script src="${contextPath}/resources/polymer/test-element/icon-toggle.js"></script>
<script>
    //document.getElementById("body").setAttribute("background", "${contextPath}/resources/img/char_sheet.png");
    var isNew;
    $(document).ready(function () {
        isNew = ${isNew};
        if ('${msg}' !== '') {
            alert('${msg}');
        }
       
    });</script>
<div class="hidden" id="loader"></div>
<div class='div-bckImg' style="background-image: url('${contextPath}/resources/img/char_sheet.png'); position: static; height: 1740px">
    <form:form action="${contextPath}/dtable/save_sheet" id="sheet" method="POST" enctype="multipart/form-data" accept-charset="UTF-8"> 
        <!--<input id="characterName" name="characterName" type="text" class="char-name stylish text-center" value="${c.characterName}">-->
        <div class="form-group">
            <div class="input-group">
                <input name="characterName" id="characterName" type="text" class="char-name form-control stylish" style="width:380px" value="${c.characterName}"/>

                <input name="characterId" id="characterId" type="hidden" class="form-control char-id stylish" style="width:380px" value="${c.characterId}"/>

                <input name="campaignId" id="campaignId" type="hidden" class="form-control char-id stylish" style="width:380px" value="${c.campaignId}"/>

                <input name="playerName" id="playerName" type="text" class=" player-name form-control stylish" style="width:200px" value="${user.names} ${user.lastNames}"/>

                <select name="classId" id="classId" type="text" class="class-select form-control stylish" style="width:150px;">
                    <option value="-1" disabled selected >Select your class</option>
                    <c:forEach var="clas" items="${classes}">
                        <option value="${clas.classId}">${clas.clasName}</option>
                    </c:forEach>
                </select>

                <input style="width:60px;" name="lvl" id="lvl" min="1" max="20" type="number" class="class-lvl form-control stylish" disabled="disabled" value="1"/>

                <select name="backgroundId" id="backgroundId" type="text" class="background-select form-control stylish" style="width:205px;">
                    <option value="-1" disabled selected >-Select your background-</option>
                    <c:forEach var="background" items="${backgrounds}">
                        <option value="${background.id}">${background.name}</option>
                    </c:forEach>
                </select>

                <select style="width:220px;" name="raceId" id="raceId" type="text" class="race-select form-control stylish">
                    <option value="-1" disabled selected>-Select your race-</option>
                    <c:forEach var="race" items="${races}">
                        <option value="${race.raceId}">${race.raceName}</option>
                    </c:forEach>
                </select>

                <select style="width:210px;" name="alignId" id="alignId" type="text" class="align-select form-control stylish">
                    <option value="-1" disabled selected>-Select your alignment-</option>
                    <c:forEach var="align" items="${alignments}">
                        <option value="${align.alignmentId}">${align.alignName}</option>
                    </c:forEach>
                </select>

                <input style="width:185px" name="expPoints" id="expPoints" type="number" style="text-align: center;" class="exp-points form-control stylish" value="${c.expPoints}"/>
            </div> 
            <div class="lvl-up">
                <button id="lvlUp" style="text-align: center;" class="btn-primary stylish">Level up</button>
            </div>
            <div style="width:100px; position:static">
                <label id="profBonus" class="stylish prof-bonus">+2</label>
                <br/>
                <label id="inspBonus" class="stylish insp-bonus">0</label>
            </div>
            <div class="third-pane">                
                <label id="armorClass" class="stylish armor-class">0</label>
                <label id="dexModifier2" class="stylish dex-modifier">0</label>
                <label id="armorValue" class="stylish armor-value">0</label>
                <label id="shieldValue" class="stylish shield-value">0</label>
                <label id="miscValue" class="stylish misc-value">0</label>
                <label id="initiative" class="stylish initiative">0</label>
                <div style="float: right; margin-top: -10px;">
                    <label tooltip="Regular speed" class="stylish" style="width: 30px; font-size: 20px; margin-left: 30px">R /</label>
                    <label tooltip="Speed while wearing heavy armor" class="stylish" style="width: 30px; font-size: 20px;">H /</label>
                    <label tooltip="Swimming speed" class="stylish" style="width: 30px; font-size: 20px;">S</label>
                    <br/>
                    <label id="speed" class="stylish speed"></label>                       
                </div>
            </div>            

            <div class="input-group fourth-pane" style="width: 87px;">
                <input name="str" id="str" type="number" class="form-control no-border text-center stylish inner-stat" value="${c.str}"/>
                <label id="strModifier" class="no-border text-center stylish stat-modifier">+0</label>            
                <input name="dex" id="dex" type="number" class="form-control no-border text-center stylish inner-stat" value="${c.dex}"/>                
                <label id="dexModifier" class="no-border text-center stylish stat-modifier">+0</label>                
                <input name="con" id="con" type="number" class="form-control no-border text-center stylish inner-stat" value="${c.con}"/>                
                <label id="conModifier" class="no-border text-center stylish stat-modifier">+0</label>                
                <input name="intl" id="intl" type="number" class="form-control no-border text-center stylish inner-stat" value="${c.intl}"/>
                <label id="intModifier" class="no-border text-center stylish stat-modifier">+0</label>
                <input name="wis" id="wis" type="number" class="form-control no-border text-center stylish inner-stat" value="${c.wis}"/>
                <label id="wisModifier" class="no-border text-center stylish stat-modifier">+0</label>
                <input name="cha" id="cha" type="number" class="form-control no-border text-center stylish inner-stat" value="${c.cha}"/>
                <label id="chaModifier" class="no-border text-center stylish stat-modifier">+0</label>
                <br/>
                <label id="pasWis" class="passive-wisdom stylish no-border text-center">0</label>
                <textarea class="stylish items no-border"></textarea>
            </div>
            <div class="input-group fifth-pane" style="min-width: 0px; width: 20px;">
                <canvas id="strDiamond" style="margin-left:3px; background-color: transparent;border:1px solid #000000;transform: rotate(45deg); width:12px; height: 12px;"></canvas>
                <br/>
                <input id="ath" value="ath" type="checkbox" class="form-control" onchange="chkBxStr(this)" style="width:18px; height: 18px; "/>
                <br/>
                <canvas id="dexDiamond" class="diamond" style="margin-top: 115px;"></canvas>
                <br/>
                <input id="acr" value="acr" type="checkbox" class="form-control" onchange="chkBxDex(this)" style="width:18px; height: 18px; "/>
                <br/>
                <input id="sle" value="sle" type="checkbox" class="form-control" onchange="chkBxDex(this)" style="width:18px; height: 18px; margin-top: 2px"/>
                <br/>
                <input id="ste" value="ste" type="checkbox" class="form-control" onchange="chkBxDex(this)" style="width:18px; height: 18px; margin-top: 2.5px"/>
                <br/>
                <canvas id="conDiamond" class="diamond" style="margin-top: 75px;"></canvas>
                <br/>
                <canvas id="intDiamond" class="diamond-typetwo" style="margin-top: 135px;"></canvas>
                <br/>
                <input id="arc" value="arc" type="checkbox" class="form-control" onchange="chkBxInt(this)" style="width:18px; height: 18px;  margin-top: 2.5px"/>
                <br/>
                <input id="his" value="his" type="checkbox" class="form-control" onchange="chkBxInt(this)" style="width:18px; height: 18px; margin-top: 2.5px"/>
                <br/>
                <input id="inv" value="inv" type="checkbox" class="form-control" onchange="chkBxInt(this)" style="width:18px; height: 18px; margin-top: 2.5px"/>
                <br/>
                <input id="nat" value="nat" type="checkbox" class="form-control" onchange="chkBxInt(this)" style="width:18px; height: 18px;  margin-top: 3px"/>
                <br/>
                <input id="rel" value="rel" type="checkbox" class="form-control" onchange="chkBxInt(this)" style="width:18px; height: 18px; margin-top: 3px"/>
                <br/>
                <canvas id="wisDiamond" class="diamond" style="margin-top: 34px;"></canvas>
                <br/>
                <input id="ani" value="ani" type="checkbox" class="form-control" onchange="chkBxWis(this)" style="width:18px; height: 18px;  margin-top: 2.5px"/>
                <br/>
                <input id="ins" value="ins" type="checkbox" class="form-control" onchange="chkBxWis(this)" style="width:18px; height: 18px; margin-top: 3px"/>
                <br/>
                <input id="med" value="med" type="checkbox" class="form-control" onchange="chkBxWis(this)" style="width:18px; height: 18px; margin-top: 3px"/>
                <br/>
                <input id="per" value="per" type="checkbox" class="form-control" onchange="chkBxWis(this)" style="width:18px; height: 18px;  margin-top: 3px"/>
                <br/>
                <input id="sur" value="sur" type="checkbox" class="form-control" onchange="chkBxWis(this)" style="width:18px; height: 18px; margin-top: 3px"/>
                <br/>
                <canvas id="chaDiamond" class="diamond" style="margin-top: 34px;"></canvas>
                <br/>
                <input id="dec" value="dec" type="checkbox" class="form-control" onchange="chkBxCha(this)" style="width:18px; height: 18px;  margin-top: 3px"/>
                <br/>
                <input id="ini" value="ini" type="checkbox" class="form-control" onchange="chkBxCha(this)" style="width:18px; height: 18px; margin-top: 3px"/>
                <br/>
                <input id="pef" value="pef" type="checkbox" class="form-control" onchange="chkBxCha(this)" style="width:18px; height: 18px; margin-top: 3px"/>
                <br/>
                <input id="pes" value="pes" type="checkbox" class="form-control" onchange="chkBxCha(this)" style="width:18px; height: 18px;  margin-top: 3px"/>
            </div>
            <div class="input-group sixth-pane" style="width: 198px">
                <label class="saveLbl stylish" id="strSave">+0</label><br/>
                <label class="saveLbl stylish mid-lbl" id="athSave">+0</label><br/>
                <label class="saveLbl stylish" id="dexSave" style="margin-top: 106px;">+0</label><br/>
                <label class="saveLbl stylish mid-lbl" id="acrSave">+0</label><br/>
                <label class="saveLbl stylish mid-lbl" id="sleSave">+0</label><br/>
                <label class="saveLbl stylish mid-lbl" id="steSave">+0</label><br/>
                <label class="saveLbl stylish" id="conSave" style="margin-top: 62px;">+0</label><br/>
                <label class="saveLbl stylish" id="intSave" style="margin-top: 126px;">+0</label><br/>
                <label class="saveLbl stylish mid-lbl" id="arcSave">+0</label><br/>
                <label class="saveLbl stylish mid-lbl" id="hisSave">+0</label><br/>
                <label class="saveLbl stylish mid-lbl" id="invSave">+0</label><br/>
                <label class="saveLbl stylish mid-lbl" id="natSave">+0</label><br/>
                <label class="saveLbl stylish mid-lbl" id="relSave">+0</label><br/>
                <label class="saveLbl stylish" id="wisSave" style="margin-top: 24px;">+0</label><br/>
                <label class="saveLbl stylish mid-lbl" id="aniSave">+0</label><br/>
                <label class="saveLbl stylish mid-lbl" id="insSave">+0</label><br/>
                <label class="saveLbl stylish mid-lbl" id="medSave">+0</label><br/>
                <label class="saveLbl stylish mid-lbl" id="perSave">+0</label><br/>
                <label class="saveLbl stylish mid-lbl" id="surSave">+0</label><br/>
                <label class="saveLbl stylish" id="chaSave" style="margin-top: 22px;">+0</label><br/>
                <label class="saveLbl stylish mid-lbl" id="decSave">+0</label><br/>
                <label class="saveLbl stylish mid-lbl" id="iniSave">+0</label><br/>
                <label class="saveLbl stylish mid-lbl" id="pefSave">+0</label><br/>
                <label class="saveLbl stylish mid-lbl" id="pesSave">+0</label><br/>
            </div>  
            <div class="input-group seventh-pane" style="width:430px">
                <label name="maxHp" id="maxHp" class="max-hp stylish">0</label>
                <br/>
                <input name="currentHp" id="currentHp" type="number" style="width:300px;" class="form-control text-center stylish current-hp" value="${c.currentHp}"/>
                <br/>
                <div style="width:180px; margin-left:40px">
                    <div style="width:50%">
                        <label id="totalHitDice" class="stylish text-center total-hit-dice">0</label>
                        <br/>
                        <label id="hitDice" class="stylish text-center hit-dice">0</label>
                    </div>
                </div>                
                <div style="width: 75px; margin-left: 60px;">
                    <input style="width:70px" name="cp" id="cp" type="number" class="currency form-control no-border text-center stylish" value="${c.cp}"/>
                    <br/>
                    <input style="width:70px" name="sp" id="sp" type="number" class="currency form-control no-border text-center stylish" value="${c.sp}"/>
                    <br/>
                    <input style="width:70px" name="gp" id="gp" type="number" class="currency form-control no-border text-center stylish" value="${c.gp}"/>
                    <br/>
                    <input style="width:70px" name="pp" id="pp" type="number" class="currency form-control no-border text-center stylish" value="${c.pp}"/>
                </div>
            </div>
        </div>
        <div class="form-group" style="float: bottom">
            <button id="regButton" class="bottom-right-button" type="submit" >${btnName}</button>
        </div>       
        <div class="input-group inventory">
            <input name="weapons" id="weapons" type="hidden" class="form-control stylish" value="${c.weapons}"/>

            <input name="armors" id="armors" type="hidden" class="form-control  stylish" value="${c.armors}"/>

            <input name="items" id="items" type="hidden" class="form-control  stylish" value="${c.items}"/>

            <input name="others" id="others" type="hidden" class="form-control  stylish" value="${c.others}"/>
        </div>
        <div name="raceCharacs" class="hidden">
            <label id="raceStr"></label>
            <label id="raceDex"></label>
            <label id="raceCon"></label>
            <label id="raceInt"></label>
            <label id="raceWis"></label>
            <label id="raceCha"></label>
            <label id="adulthood"></label>
            <label id="avgAge"></label>
            <label id="typicalAlignment"></label>
            <label id="size"></label>
        </div>
        <icon-toggle toggle-icon="star" pressed="{{isFav}}"></icon-toggle>
    </form:form>


</div>
<script src="${contextPath}/resources/js/functions.js"></script>
<script>
    formData = new FormData($(this[0]));
    function setCharacter() {
        $('#playerName').text('${c.playerName}');
        $('#playerName').val('${c.playerName}');
        $('#characterName').val('${c.characterName}');
        $('#lvl').val('${c.lvl}');
        $('#classId').val('${c.classId}');
        $('#profBonus').html('+${profBonus}');
        $('#strModifier').html(setMod(${c.str}));
        $('#dexModifier').html(setMod(${c.dex}));
        $('#conModifier').html(setMod(${c.con}));
        $('#intModifier').html(setMod(${c.intl}));
        $('#wisModifier').html(setMod(${c.wis}));
        $('#chaModifier').html(setMod(${c.cha}));
        $('#raceId').val('${c.raceId}');
        getRace(${c.raceId});
        $('#alignId').val('${c.alignId}');
        getClas(${c.classId});
        setRace();
        setBackground();
    }
    function setSpeed() {
        var speeds = '';
        if ('${r.landSpeed}' !== "") {
            speeds += '${r.landSpeed}/';
        } else {
            speeds += '0/';
        }
        if ('${r.armorSpeed}' !== "") {
            speeds += '${r.armorSpeed}/';
        } else {
            speeds += '0/';
        }
        if ('${r.landSpeed}' !== "") {
            speeds += '${r.swimSpeed}';
        } else {
            speeds += '0';
        }
        $('#speed').html(speeds);
    }
    function setClas() {
        var saves = '${cl.saves}'.split("&;");
        var stat1 = saves[0].substr(0, 3);
        var stat2 = saves[1].substr(0, 3);
        $('#strSave').html('+0');
        $('#dexSave').html('+0');
        $('#conSave').html('+0');
        $('#intSave').html('+0');
        $('#wisSave').html('+0');
        $('#chaSave').html('+0');
        var mod1Changer = parseInt($('#' + stat1 + 'Modifier').html().substr(1));
        var mod2Changer = parseInt($('#' + stat2 + 'Modifier').html().substr(1));
        if ($('#' + stat1 + 'Modifier').html().substr(0, 1) === '-') {
            mod1Changer = (-1) * mod1Changer;
        }
        if ($('#' + stat2 + 'Modifier').html().substr(0, 1) === '-') {
            mod2Changer = (-1) * mod2Changer;
        }
        var mod1 = mod1Changer + parseInt($('#profBonus').html().substr(1));
        var mod2 = mod2Changer + parseInt($('#profBonus').html().substr(1));
        $('#' + saves[0]).html('+' + mod1);
        $('#' + saves[1]).html('+' + mod2);
        $('#' + stat1 + 'Diamond').css("background-color", "#000000");
        $('#' + stat2 + 'Diamond').css("background-color", "#000000");
        $('#maxHp').html('${cl.hitPoints + (cl.hitPointsOptional*(c.lvl-1))}');
        $('#hitDice').html($('#lvl').val());
        $('#totalHitDice').html($('#lvl').val() + 'd${cl.hitDie}');
    }
    function setRace() {
        $('#raceStr').html('${r.baseStr}');
        $('#raceDex').html('${r.baseDex}');
        $('#raceCon').html('${r.baseCon}');
        $('#raceInt').html('${r.baseInt}');
        $('#raceWis').html('${r.baseWis}');
        $('#raceCha').html('${r.baseCha}');
        $('#adulthood').html('${r.adulthood}');
        $('#avgAge').html('${r.avgAge}');
        $('#typicalAlignment').html('${r.typicalAlignment}');
        $('#size').html('${r.size}');
        $('#strModifier').html(setMod(${r.baseStr}));
        $('#dexModifier').html(setMod(${r.baseDex}));
        $('#conModifier').html(setMod(${r.baseCon}));
        $('#intModifier').html(setMod(${r.baseInt}));
        $('#wisModifier').html(setMod(${r.baseWis}));
        $('#chaModifier').html(setMod(${r.baseCha}));
        setSpeed();
    }
    function setBackground() {
        $('#backgroundId').val('${c.backgroundId}');
    }
    function getRace(selection) {
        $.ajax({
            url: '${contextPath}/dtable/getRace/' + selection,
            type: 'POST',
            cache: false,
            success: function (response) {
                var speeds = response.landSpeed + "/" + response.armorSpeed + "/" + response.swimSpeed;
                if (addedRaceStats) {
                    $('#str').val(parseInt($('#str').val()) - parseInt($('#raceStr').html()));
                    $('#dex').val(parseInt($('#dex').val()) - parseInt($('#raceDex').html()));
                    $('#con').val(parseInt($('#con').val()) - parseInt($('#raceCon').html()));
                    $('#intl').val(parseInt($('#intl').val()) - parseInt($('#raceInt').html()));
                    $('#wis').val(parseInt($('#wis').val()) - parseInt($('#raceWis').html()));
                    $('#cha').val(parseInt($('#cha').val()) - parseInt($('#raceCha').html()));
                }
                $('#str').val(parseInt($('#str').val()) + parseInt(response.baseStr));
                $('#dex').val(parseInt($('#dex').val()) + parseInt(response.baseDex));
                $('#con').val(parseInt($('#con').val()) + parseInt(response.baseCon));
                $('#intl').val(parseInt($('#intl').val()) + parseInt(response.baseInt));
                $('#wis').val(parseInt($('#wis').val()) + parseInt(response.baseWis));
                $('#cha').val(parseInt($('#cha').val()) + parseInt(response.baseCha));
                $('#raceStr').html(response.baseStr);
                $('#raceDex').html(response.baseDex);
                $('#raceCon').html(response.baseCon);
                $('#raceInt').html(response.baseInt);
                $('#raceWis').html(response.baseWis);
                $('#raceCha').html(response.baseCha);
                $('#adulthood').html(response.adulthood);
                $('#avgAge').html(response.avgAge);
                $('#typicalAlignment').html(response.typicalAlignment);
                $('#size').html(response.size);
                $('#speed').html(speeds);
                $('#strModifier').html(setMod($('#str').val()));
                $('#dexModifier').html(setMod($('#dex').val()));
                $('#conModifier').html(setMod($('#con').val()));
                $('#intModifier').html(setMod($('#intl').val()));
                $('#wisModifier').html(setMod($('#wis').val()));
                $('#chaModifier').html(setMod($('#cha').val()));
                addedRaceStats = true;
            },
            error: function (jqXhr, textStatus, errorThrown) {
                alert(jqXhr);
                alert(textStatus);
                alert(errorThrown);
            }
        });
    }
    function getClas(selection) {
        $.ajax({
            url: '${contextPath}/dtable/getClas/' + selection,
            type: 'POST',
            cache: false,
            success: function (response) {
                setHp(response.hitPoints, response.hitPointsOptional);
                var saves = response.saves.split("&;");
                var stat1 = saves[0].substr(0, 3);
                var stat2 = saves[1].substr(0, 3);
                if (addedClasStats) {
                    $('#strSave').html('+0');
                    $('#dexSave').html('+0');
                    $('#conSave').html('+0');
                    $('#intSave').html('+0');
                    $('#wisSave').html('+0');
                    $('#chaSave').html('+0');
                }
                var mod1Changer = parseInt($('#' + stat1 + 'Modifier').html().substr(1));
                var mod2Changer = parseInt($('#' + stat2 + 'Modifier').html().substr(1));
                var sign1 = '+';
                var sign2 = '+';
                if ($('#' + stat1 + 'Modifier').html().substr(0, 1) === '-') {
                    mod1Changer = (-1) * mod1Changer;
                }
                if ($('#' + stat2 + 'Modifier').html().substr(0, 1) === '-') {
                    mod2Changer = (-1) * mod2Changer;
                }
                var mod1 = mod1Changer + parseInt($('#profBonus').html().substr(1));
                var mod2 = mod2Changer + parseInt($('#profBonus').html().substr(1));
                if(mod1<0)
                    sign1 = '';
                if(mod2<0)
                    sign2 = '';
                $('#' + saves[0]).html(sign1 + mod1);
                $('#' + saves[1]).html(sign2 + mod2);
                $('#strDiamond').css("background-color", "transparent");
                $('#dexDiamond').css("background-color", "transparent");
                $('#conDiamond').css("background-color", "transparent");
                $('#intDiamond').css("background-color", "transparent");
                $('#wisDiamond').css("background-color", "transparent");
                $('#chaDiamond').css("background-color", "transparent");
                $('#' + stat1 + 'Diamond').css("background-color", "#000000");
                $('#' + stat2 + 'Diamond').css("background-color", "#000000");
                $('#hitDice').html($('#lvl').val());
                $('#totalHitDice').html($('#lvl').val() + 'd' + response.hitDie);
                addedClasStats = true;
            },
            error: function (jqXhr, textStatus, errorThrown) {
                alert(jqXhr);
                alert(textStatus);
                alert(errorThrown);
            }
        });
    }
    function getAlign(selection) {
        $.ajax({
            url: '${contextPath}/dtable/getAlign/' + selection,
            type: 'POST',
            cache: false,
            success: function (response) {
            },
            error: function (jqXhr, textStatus, errorThrown) {
                alert(jqXhr);
                alert(textStatus);
                alert(errorThrown);
            }
        });
    }
    /*function chkBxStr(item) {
        var lblName = item.id;
        lblName += 'Save';
        if ($(item).is(':checked')) {
            $('#' + lblName).html();
        }
    }
    function chkBxDex(item) {
        var lblName = item.id;
        lblName += 'Save';
        if ($(item).is(':checked')) {
            $('#' + lblName).html();
        }
    }
    function chkBxCon(item) {
        var lblName = item.id;
        lblName += 'Save';
        if ($(item).is(':checked')) {
            $('#' + lblName).html();
        }
    }
    function chkBxInt(item) {
        var lblName = item.id;
        lblName += 'Save';
        if ($(item).is(':checked')) {
            $('#' + lblName).html();
        }
    }
    function chkBxWis(item) {
        var lblName = item.id;
        lblName += 'Save';
        if ($(item).is(':checked')) {
            $('#' + lblName).html();
        }
    }
    function chkBxCha(item) {
        var lblName = item.id;
        lblName += 'Save';
        if ($(item).is(':checked')) {
            $('#' + lblName).html();
        }
    }
    function setHp(hitDie, hpAdd) {
        var maxHp = parseInt(hitDie) + parseInt($('#conModifier').text()) + parseInt((hpAdd * ($('#lvl').val() - 1)));
        $('#maxHp').html(maxHp);
    }*/
</script>
<%@ include file="../footer.jsp" %>
