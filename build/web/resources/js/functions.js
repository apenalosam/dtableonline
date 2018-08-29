/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var addedRaceStats = false;
var addedClasStats = false;
$(document).ready(function () {
    resizable(document.getElementById('characterId'), 10);    
    if (!isNew) {
        setCharacter();
        addedRaceStats = true;
    }
    $('#strModifier').html(setMod($('#str').val()));
    $('#dexModifier').html(setMod($('#dex').val()));
    $('#conModifier').html(setMod($('#con').val()));
    $('#intModifier').html(setMod($('#intl').val()));
    $('#wisModifier').html(setMod($('#wis').val()));
    $('#chaModifier').html(setMod($('#cha').val()));
    $('#raceId').change(function () {
        getRace($(this).val());
    });
    $('#classId').change(function () {
        getClas($(this).val());
    });
    $('#alignId').change(function () {
        getAlign($(this).val());
    });
});

function setMod(stat) {
    if (stat > 19) {
        return '+5';
    } else if (stat > 17) {
        return '+4';
    } else if (stat > 15) {
        return '+3';
    } else if (stat > 13) {
        return '+2';
    } else if (stat > 11) {
        return '+1';
    } else if (stat > 9) {
        return '+0';
    } else if (stat > 7) {
        return '-1';
    } else if (stat > 5) {
        return '-2';
    } else if (stat > 3) {
        return '-3';
    } else {
        return '-4';
    }
}
function resizable(el, factor) {
    var int = Number(factor) || 7.7;
    function resize() {
        el.style.width = ((el.value.length + 1) * int) + 'px';
    }
    var e = 'keyup,keypress,focus,blur,change'.split(',');
    for (var i in e)
        el.addEventListener(e[i], resize, false);
    resize();
}

function chkBxStr(item) {
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
}