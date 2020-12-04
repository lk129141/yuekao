$(function () {
    $("#buts").click(function () {
        var email = $("#email").val();
        var name = $("#name").val();
        var password = $("#password").val();
        if (email == "") {
            $("#no1").html("邮箱不能为空").css("color","red");
            return;
        }
        if (name == "") {
            $("#no2").html("账号不能为空").css("color","red");
            return;
        }
        if (password == "") {
            $("#no3").html("密码不能为空").css("color","red");
            return;
        }else {
            $("#no1").html("");
            $("#no2").html("");
            $("#no3").html("");
            //json数据的地址,data:用于请求数据时发送数据参数；
            $.get("indexEmail",{"email":email,"name":name,"password":password},function (data) {
                alert(data);
            });}
    });
});