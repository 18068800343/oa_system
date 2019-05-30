/**
 * Created by 96131 on 2017/3/8 0008.
 */
var myTool = {
    confirm: function( message, callBack ){
        var $confirm = $('#confirmModal');
        if($confirm.length==0){
            $confirm = $('<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">' +
                '<div class="modal-dialog" role="document">' +
                '<div class="modal-content" style="width: 500px;">' +
                '<div class="modal-header">' +
                '<h4 class="modal-title" id="myModalLabel">确认提示</h4>' +
                '</div>' +
                '<div class="modal-body">' +
                '</div>' +
                '<div class="modal-footer">' +
                '<button type="button" class="btn btn-primary" id="btn-true">确认</button>' +
                '<button type="button" class="btn btn-default" id="btn-false">取消</button>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>');
        }
        $confirm.find('.modal-body').html(message);
        $confirm.find('#btn-true').one('click', function(){
            callBack(true);
            $confirm.modal('hide');
        });
        $confirm.find('#btn-false').one('click', function(){
            callBack(false);
            $confirm.modal('hide');
        });
        $confirm.modal('show');
    },
    mask:{
        show: function( message ){
            var $mask = $('#maskDom');
            if($mask.length==0){
                $mask = $('<div id="maskDom" class="mask-cover" style="position:fixed;top: 0;right:0;bottom:0;filter: alpha(opacity=60);background-color: #E2E2E2;z-index: 8888; left: 0;display:none;opacity:0.6; -moz-opacity:0.5;">' +
                    '<div class="mask-loading" style="width:auto;height:56px;position:fixed;top:50%;left:50%;transform: translate(-50%,-50%);line-height:56px;color:#fff;padding-left:60px;padding-right:20px;font-size:15px;background: #000 url(../../img/loader.gif) no-repeat 10px 50%;z-index:9999; -moz-border-radius:20px; -webkit-border-radius:20px;border-radius:20px;filter:progid:DXImageTransform.Microsoft.Alpha(opacity=70);">' +
                    '</div>' +
                    '</div>');
            }
            $mask.appendTo('body');
            $mask.find('.mask-loading').html(message);
            $mask.show();
        },
        hide: function(){
            $('#maskDom').hide();
        }
    },
    getDate: function(){
        var d = new Date();
        return d.getFullYear()+'年'+(d.getMonth()+1)+'月'+d.getDate()+'日'+' '+d.getHours()+'点'+d.getMinutes()+'分';
    },
    randomUUID: function(){
        function S4() {
            return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
        }
        return (S4()+S4()+S4()+S4()+S4()+S4()+S4()+S4());
    }
};

/**
 * Base64加密解密方法
 * 
 */
function Base64() {
    // private property
    _keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
    // public method for encoding
    this.encode = function (input) {
        var output = "";
        var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
        var i = 0;
        input = _utf8_encode(input);
        while (i < input.length) {
            chr1 = input.charCodeAt(i++);
            chr2 = input.charCodeAt(i++);
            chr3 = input.charCodeAt(i++);
            enc1 = chr1 >> 2;
            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
            enc4 = chr3 & 63;   
            if (isNaN(chr2)) {
                enc3 = enc4 = 64;
            } else if (isNaN(chr3)) {
                enc4 = 64;
            }
            output = output +
            _keyStr.charAt(enc1) + _keyStr.charAt(enc2) +
            _keyStr.charAt(enc3) + _keyStr.charAt(enc4);
        }
        return output;
    } 
    
    // public method for decoding
    this.decode = function (input) {
        var output = "";
        var chr1, chr2, chr3;
        var enc1, enc2, enc3, enc4;
        var i = 0;
        input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");
        while (i < input.length) {
            enc1 = _keyStr.indexOf(input.charAt(i++));
            enc2 = _keyStr.indexOf(input.charAt(i++));
            enc3 = _keyStr.indexOf(input.charAt(i++));
            enc4 = _keyStr.indexOf(input.charAt(i++));
            chr1 = (enc1 << 2) | (enc2 >> 4);
            chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
            chr3 = ((enc3 & 3) << 6) | enc4;
            output = output + String.fromCharCode(chr1);
            if (enc3 != 64) {
                output = output + String.fromCharCode(chr2);
            }
            if (enc4 != 64) {
                output = output + String.fromCharCode(chr3);
            }
        }
        output = _utf8_decode(output);
        return output;
    }
    //字节序列转ASCII码
    //[0x24, 0x26, 0x28, 0x2A] ==> "$&C*"
    this.byteToString=function(arr){
        if(typeof arr === 'string'){ 
            return arr;  
        }  
        var str = '',  
            _arr = arr;  
        for(var i = 0; i < _arr.length; i++) {  
            var one = _arr[i].toString(2),  
                v = one.match(/^1+?(?=0)/);  
            if(v && one.length == 8) {  
                var bytesLength = v[0].length;  
                var store = _arr[i].toString(2).slice(7 - bytesLength);  
                for(var st = 1; st < bytesLength; st++) {  
                    store += _arr[st + i].toString(2).slice(2);  
                }  
                str += String.fromCharCode(parseInt(store, 2));  
                i += bytesLength - 1;  
            } else {  
                str += String.fromCharCode(_arr[i]);  
            }  
        }  
        return str;  
    }
   
    // private method for UTF-8 encoding
    _utf8_encode = function (string) {
        string = string.replace(/\r\n/g,"\n");
        var utftext = "";
        for (var n = 0; n < string.length; n++) {
            var c = string.charCodeAt(n);
            if (c < 128) {
                utftext += String.fromCharCode(c);
            } else if((c > 127) && (c < 2048)) {
                utftext += String.fromCharCode((c >> 6) | 192);
                utftext += String.fromCharCode((c & 63) | 128);
            } else {
                utftext += String.fromCharCode((c >> 12) | 224);
                utftext += String.fromCharCode(((c >> 6) & 63) | 128);
                utftext += String.fromCharCode((c & 63) | 128);
            }
 
        }
        return utftext;
    }
 
    // private method for UTF-8 decoding
    _utf8_decode = function (utftext) {
        var string = "";
        var i = 0;
        var c = c1 = c2 = 0;
        while ( i < utftext.length ) {
            c = utftext.charCodeAt(i);
            if (c < 128) {
                string += String.fromCharCode(c);
                i++;
            } else if((c > 191) && (c < 224)) {
                c2 = utftext.charCodeAt(i+1);
                string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));
                i += 2;
            } else {
                c2 = utftext.charCodeAt(i+1);
                c3 = utftext.charCodeAt(i+2);
                string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));
                i += 3;
            }
        }
        return string;
    }
}