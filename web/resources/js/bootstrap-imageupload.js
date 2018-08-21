/**
 * bootstrap-imageupload v1.1.2
 * https://github.com/egonolieux/bootstrap-imageupload
 * Copyright 2016 Egon Olieux
 * Released under the MIT license
 */
if (typeof jQuery === 'undefined') {
    throw new Error('bootstrap-imageupload\'s JavaScript requires jQuery.');
}
(function ($) {
    'use strict';
    var options = {};
    var methods = {
        init: init
    };
    // -----------------------------------------------------------------------------
    // Plugin Definition
    // -----------------------------------------------------------------------------
    $.fn.imageupload = function (methodOrOptions) {
        var givenArguments = arguments;
        return this.filter('div').each(function () {
            if (methods[methodOrOptions]) {
                methods[methodOrOptions].apply($(this), Array.prototype.slice.call(givenArguments, 1));
            } else if (typeof methodOrOptions === 'object' || !methodOrOptions) {
                methods.init.apply($(this), givenArguments);
            } else {
                throw new Error('Method "' + methodOrOptions + '" is not defined for imageupload.');
            }
        });
    };
    $.fn.imageupload.defaultOptions = {
        allowedFormats: ['jpg', 'jpeg', 'png', 'gif'],
        maxWidth: 250,
        maxHeight: 250,
        maxFileSizeKb: 2048
    };
    // -----------------------------------------------------------------------------
    // Public Methods
    // -----------------------------------------------------------------------------
    function init(givenOptions) {
        options = $.extend({}, $.fn.imageupload.defaultOptions, givenOptions);
        var $imageupload = this;
        var $fileTab = $imageupload.find('.file-tab');
        var $browseFileButton = $fileTab.find('input[type="file"]');
        var $removeFileButton = $fileTab.find('.btn:eq(1)');
        $browseFileButton.off();
        $removeFileButton.off();
        $browseFileButton.on('change', function () {
            $(this).blur();
            submitImageFile($fileTab);
        });
        $removeFileButton.on('click', function () {
            $(this).blur();
            resetFileTab($fileTab);
        });
    }
    // -----------------------------------------------------------------------------
    // Private Methods
    // -----------------------------------------------------------------------------
    function getImageThumbnailHtml(src) {
        //var img = $('#imagen');
        //img.attr({src:src});
        //var d = new Date();
        $("#imagen").attr("src",src);
    }
    function getFileExtension(path) {
        return path.substr(path.lastIndexOf('.') + 1).toLowerCase();
    }
    function isValidImageFile(file, callback) {
        /***Checa el tamaño del archivo***/
        if (file.size / 1024 > options.maxFileSizeKb) {
            callback(false, 'El tamaño del archivo es inválido (max ' + options.maxFileSizeKb + 'kB).');
            return;
        }
        /***Checa el formato de la imagen por la extensión del archivo***/
        var fileExtension = getFileExtension(file.name);
        if ($.inArray(fileExtension, options.allowedFormats) > -1) {
            callback(true, 'La imagen es inválida.');
        } else {
            alert('El tipo de archivo no es permitido');
        }
    }
    function resetFileTab($fileTab) {
        getImageThumbnailHtml(url);
        $fileTab.find('.btn:eq(1)').prop('disabled', true);
        $('#nombreImg').val('');
        $fileTab.find('input').val('');
    }
    function submitImageFile($fileTab) {
        var $browseFileButton = $fileTab.find('.btn:eq(0)');
        var $removeFileButton = $fileTab.find('.btn:eq(1)');
        var $fileInput = $browseFileButton.find('input');
        if (!($fileInput[0].files && $fileInput[0].files[0])) {
            return;
        }
        $removeFileButton.prop('disabled', false);
        var file = $fileInput[0].files[0];
        isValidImageFile(file, function (isValid, message) {
            if (isValid) {
                var fileReader = new FileReader();
                fileReader.onload = function (e) {
                    $fileTab.prepend(getImageThumbnailHtml(e.target.result));
                };
                fileReader.onerror = function () {
                    alert('Error al cargar la imagen');
                    $fileInput.val('');
                };
                fileReader.readAsDataURL(file);
            } else {
                alert(message);
                $fileInput.val('');
            }
        });
    }
}(jQuery));
