layui.use(['layer', 'element'], function(){
    var element = layui.element;
    element.on('nav(menu)', function (elem) {
        $('#iframe').attr('src', webPath + elem.data('url'));
    });
});
$(function(){
    var ul = $("ul").find("li").eq(0);
    var url = ul.data("url");
    if ('' === url || null === url) {
        url = ul.find("dd").eq(0).data("url");
    }
    if ('' !== url && null !== url) {
        $('#iframe').attr('src', webPath + url);
    }
});