$( document ).ready(function() {
    $(".result").css("display", "none");
});

$(".calBtn").click(function () {
    var emi = {};
    emi["loan"] = parseInt($(".inputLoan").val());
    emi["tenure"] = parseInt($(".inputTenure").val());
    emi["rate"] = parseInt($(".inputRate").val());
    console.log(emi);
    $.ajax({
        url : "http://localhost:8080/calculate",
        dataType : "json",
        contentType: "application/json; charset=utf-8",
        data : JSON.stringify(emi),
        type : "post",
        success : function(result) {
            $(".calResult").text(result);
            $(".result").css("display", "block");
        },
    });
});