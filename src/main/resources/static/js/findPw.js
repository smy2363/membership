$(function(){
    $("#sendBtn").click(function(){
        sendNumber();



    });


});
function sendNumber(){
    var token = $("meta[name=_csrf]").attr("content");
    var header = $("meta[name=_csrf_header]").attr("content");
        $.ajax({
            url:"/findPw",
            type:"post",
            dataType:"json",
            data:{"mail" : $("#email").val()},
            beforeSend : function(xhr){
                        xhr.setRequestHeader(header, token);
            },
            success:function(data){
                alert("인증번호 발송");
                $("#Confirm").attr("value", data);
            },
            error:function(){
                alert("인증번호 발송실패");
                console.log($("#email").val());
            }

        });
}

function confirmNumber(){
    var number1 = $("#emailCode").val();
    var number2 = $("#Confirm").val();

    console.log(number1);
    console.log(number2);

    if(number1 == number2){
        alert("인증성공");
    }else{
        alert("인증실패");
    }
}
