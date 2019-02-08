$(document).ready(function (){
    $("#a1").css({ "display": "block" });
    $("#a2").css({ "display": "none" });
    $("#a3").css({ "display": "none" });

    $("#country").click(function () {
        $("#a1").css({ "display": "block" });
        $("#a2").css({ "display": "none" });
        $("#a3").css({"display":"none"});
    });
    $("#state").click(function () {
        $("#a1").css({ "display": "none" });
        $("#a2").css({ "display": "block" });
        $("#a3").css({ "display": "none" });
        $("#a2Country").html('');
        getCountry();
    });
    $("#district").click(function () {
        $("#a1").css({ "display": "none" });
        $("#a2").css({ "display": "none" });
        $("#a3").css({ "display": "block" });
        $("#a3Country").html('');
        $("#a3State").html('');
        getCountry();
    });

    $("#addCName").click(function () {
        var country=$("#acname").val();
        
        var data = new FormData();
        data.append("name", country);

        $.ajax({
            method: "post",
            url: "php/addCountry.php",
            processData: false,
            contentType: false,
            data: data,
            success: function (result) {
                alert("Added Succesfully!");
                $("#acname").val("");
            }
        });
    });

    $("#addSName").click(function () {
        var country = $("#a2Country").val();
        var state = $("#a2sname").val();

        var data = new FormData();
        data.append("c", country);
        data.append("s", state);

        $.ajax({
            method: "post",
            url: "php/addState.php",
            processData: false,
            contentType: false,
            data: data,
            success: function (result) {
                $("#a2sname").val("");
            }
        });
    });

    $("#addDName").click(function () {
        var country = $("#a3Country").val();
        var state = $("#a3State").val();
        var dist = $("#adname").val();

    
        var data = new FormData();
        data.append("c", country);
        data.append("s", state);
        data.append("d", dist);

        $.ajax({
            method: "post",
            url: "php/addDist.php",
            processData: false,
            contentType: false,
            data: data,
            success: function (result) {
                $("#adname").val("");
            }
        });
    });

});


function getCountry(){
    
    $.ajax({
        method: "post",
        url: "php/getAllCountries.php",
        processData: false,
        contentType: false,
        success: function (result) {
            $("#a2Country").append(result);
            $("#a3Country").append(result);
            getState();
        }
    });
}


function getState() {
    var c = $("#a3Country").val();
    //alert(c);
    var data = new FormData();
    data.append("c", c);
    $.ajax({
        method: "post",
        url: "php/getState.php",
        processData: false,
        contentType: false,
        data:data,
        success: function (result) {
            $("#a3State").html('');
            $("#a3State").append(result);
        }
    });
}