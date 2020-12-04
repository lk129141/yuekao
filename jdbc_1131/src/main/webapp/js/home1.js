$(function () {
    var msg =  [{"userid":"01","username":"奥特曼","address":"M-78星云","mobile":"110"},
        {"userid":"02","username":"jmqs","address":"kider","mobile":"233"},
        {"userid":"03","username":"atm","address":"123","mobile":"666"},
        {"userid":"04","username":"sd","address":"诚","mobile":"555"},
    ]
    var re = "";
    $.each(msg,function (i, ele) {
        // re += ele.userid +""+ele.username+""+ele.address+""+ele.mobile;
        $("#this").append("<option value="+ele+">"+ele.userid+"-"+ele.username+"-"+ele.address+ele.mobile+"</option>");
    })

    var re0 = "";
    $.each(msg,function (i, ele) {
        $("#this2").append("<tr>"+"<td>"+ele.userid+"</td>"+"<td>"+ele.username+"</td>"+"<td>"+ele.address+"</td>"+"<td>"+ele.mobile+"</td>"+"</tr>>");
    })
})