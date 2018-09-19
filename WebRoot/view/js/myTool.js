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
                    '<div class="mask-loading" style="width:auto;height:56px;position:fixed;top:50%;left:50%;transform: translate(-50%,-50%);line-height:56px;color:#fff;padding-left:60px;padding-right:20px;font-size:15px;background: #000 url(../img/loader.gif) no-repeat 10px 50%;z-index:9999; -moz-border-radius:20px; -webkit-border-radius:20px;border-radius:20px;filter:progid:DXImageTransform.Microsoft.Alpha(opacity=70);">' +
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