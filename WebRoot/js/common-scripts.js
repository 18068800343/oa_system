var Script = function () {

    // 侧边栏收缩
    var flag = true
    $('.icon-caidan').click(function () {
        if (flag) {
            $('#main-content').animate({
                'margin-left': '0px'
            },200);
            $('#sidebar').animate({
                'margin-left': '-270px'
            },200);
            flag = false;
        } else {
            $('#main-content').animate({
                'margin-left': '270px'
            },200);
            $('#sidebar > ul').show();
            $('#sidebar').animate({
                'margin-left': '0'
            },200);
            flag = true;
        }
    });


    // 获取iframe高度
    var wh=$(window).height();
    $('.w_r,.w_l').css('min-height',wh-265);


    // 当前时间
    function toDou(n){
        return n<10 ? '0'+n :n;
    }
    function change(n){
        switch (n) {
            case 0:
                return '日';
            case 1:
                return '一';
            case 2:
                return '二';
            case 3:
                return '三';
            case 4:
                return '四';
            case 5:
                return '五';
            default:
                return '六';
        }
    }
    var oDate = document.getElementById('date');
    var nowTime = new Date();
    var str = nowTime.getFullYear()+'/'+toDou(nowTime.getMonth()+1)+'/'+nowTime.getDate()+'<br/>星期'+change(nowTime.getDay());
    oDate.innerHTML = str;
}();