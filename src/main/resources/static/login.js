$(function () {
$("form").on('submit', function (e) {
e.preventDefault();
});
        $(".text-uppercase").click(function() {



console.log("---------email---"+$("#inputEmail").val());
console.log("---------password---"+$("#inputPassword").val());

        var json = {
        'email':$("#inputEmail").val(),
        'password':$("#inputPassword").val()
        }
// json= $.parseJSON(response);


console.log("----------------hello tigger the form submittion-----"+json);
$.ajax({
url: '/login',
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(json),
        success: function (data) {
            console.log("--------sucess data------");
            console.log(data.payLoad);
            localStorage.setItem("auth",data);
             window.location.href="/chat-app";
        }
});

});
  });
