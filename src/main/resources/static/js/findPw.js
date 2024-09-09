$(function(){
    $("#find-pw-bt").click(function(){
        alert("임시 비밀번호 발급");
        findId();
    });




});

function findId(){
    var token = $("meta[name=_csrf]").attr("content");
    var header = $("meta[name=_csrf_header]").attr("content");
    $.ajax({
                url:"/findPw",
                type:"post",
                dataType:"json",
                data:{"email" : $("#email").val()},
                beforeSend : function(xhr){
                            xhr.setRequestHeader(header, token);
                },
                success:function(data){
                    alert("해당 이메일로 임시 비밀번호 전송");

                },
                error:function(){
                    alert("이메일 발송실패");
                }

    });

}