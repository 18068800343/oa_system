(function(window){

    // 导航
    $('.w_nav>li>a').click(function(){
        $(this).addClass('active').parent().siblings().find('a').removeClass('active');
        $(this).parent().siblings().find('.on').removeClass('on');
        $(this).parent().find('.w_nav2').slideToggle();
        $(this).parent().siblings().find('.w_nav2').slideUp();
    });
    $('.w_nav li li').click(function(){
        $(this).find('a').addClass('on').parent().siblings().find('a').removeClass('on');
    });

    $('.w_nav>li>ul>li>a').click(function(){
        $(this).addClass('active').parent().siblings().find('a').removeClass('active');
        $(this).parent().siblings().find('.on').removeClass('on');
        $(this).parent().find('.w_nav3').slideToggle();
        $(this).parent().siblings().find('.w_nav3').slideUp();
    });
    $('.w_nav>li>ul>li>a').parent().siblings().find('.w_nav3').slideUp();
    $('.w_nav li li ul li').click(function(){
        $(this).find('a').addClass('on').parent().siblings().find('a').removeClass('on');
    });


    // 列表详细内容
    $('.table td a').click(function(){
        $('.list').hide();
        $('.renwu').show();
    });
    $('.fanhui').click(function(){
        $('.list').show();
        $('.renwu').hide();
    });
    
})(window);
