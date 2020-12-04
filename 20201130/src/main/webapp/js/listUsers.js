$(function () {
    //下拉列表事件
    $("#slectPage").change(function () {
        document.location.href="all.do?pageIndex="+$(this).val();
    });
});