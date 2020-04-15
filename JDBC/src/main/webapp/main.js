$("#button1").click(function () {
    let data2 = {};
    data2 = {"department": $("#t1").val()};
    console.log(data2);

    $(document).ready(function () {
        $.ajax({
            type: "GET",
            data: data2,
            url: 'taskOne',
            error: function (e) {
                alert("ERROR");
            },
            success: function (json) {

                if (json.length > 0) {
                    var tableBody = $("#outputTable");
                    $("#outputTable").empty();

                    for (let i = 0; i < json.length; i++) {
                        var str = '';
                        var obj = json[i];
                        str += '<tr>';
                        str += '<td>' + obj.FIO + '</td>';
                        str += '<td>' + obj.salary + '</td>';
                        str += '<td>' + obj.position + '</td>';
                        str += '<td>' + obj.id + '</td>';
                        str += '</tr>';
                        tableBody.append(str);
                    }
                } else {
                    alert("Ничего не найдено!")
                }
            }
        });
    });
});

$("#button2").click(function () {
    let data2 = {};
    data2 = {"department": $("#t2").val()};
    console.log(data2);

    $(document).ready(function () {
        $.ajax({
            type: "GET",
            data: data2,
            url: 'taskTwo',
            error: function (e) {
                alert("ERROR");
            },
            success: function (json) {
                if (json.length > 0) {
                    var tableBody = $("#outputTable");
                    $("#outputTable").empty();

                    for (let i = 0; i < json.length; i++) {
                        var str = '';
                        var obj = json[i];
                        str += '<tr>';
                        str += '<td>' + obj.FIO + '</td>';
                        str += '<td>' + obj.salary + '</td>';
                        str += '<td>' + obj.position + '</td>';
                        str += '<td>' + obj.id + '</td>';
                        str += '</tr>';
                        tableBody.append(str);
                    }
                } else {
                    alert("Ничего не найдено!")
                }
            }
        });
    });
});

$("#button3").click(function () {
    let data2 = {};
    data2 = {"salary": $("#t3").val()};
    console.log(data2);

    $(document).ready(function () {
        $.ajax({
            type: "GET",
            data: data2,
            url: 'taskThree',
            error: function (e) {
                alert("ERROR");
            },
            success: function (json) {
                if (json.length > 0) {
                    var tableBody = $("#outputTable");
                    $("#outputTable").empty();

                    for (let i = 0; i < json.length; i++) {
                        var str = '';
                        var obj = json[i];
                        str += '<tr>';
                        str += '<td>' + obj.FIO + '</td>';
                        str += '<td>' + obj.salary + '</td>';
                        str += '<td>' + obj.position + '</td>';
                        str += '<td>' + obj.id + '</td>';
                        str += '</tr>';
                        tableBody.append(str);
                    }
                } else {
                    alert("Ничего не найдено!")
                }
            }
        });
    });
});

$("#button4").click(function () {
    let data2 = {};
    data2 = {"fio": $("#t4").val()};
    console.log(data2);

    $(document).ready(function () {
        $.ajax({
            type: "GET",
            data: data2,
            url: 'taskFour',
            error: function (e) {
                alert("ERROR");
            },
            success: function (json) {
                if (json.length > 0) {
                    var tableBody = $("#outputTable");
                    $("#outputTable").empty();
                    for (let i = 0; i < json.length; i++) {
                        var str = '';
                        var obj = json[i];
                        str += '<tr>';
                        str += '<td>' + obj.FIO + '</td>';
                        str += '<td>' + obj.salary + '</td>';
                        str += '<td>' + obj.position + '</td>';
                        str += '<td>' + obj.id + '</td>';
                        str += '</tr>';
                        tableBody.append(str);
                    }
                } else {
                    alert("Ничего не найдено!")
                }
            }
        });
    });
});