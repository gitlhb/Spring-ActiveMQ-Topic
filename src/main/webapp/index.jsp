<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
<div>

<div>

    <form method="post" id="test">
        <input name="test" placeholder="test" type="text" id="test1"><br>
        <input id="btnparId" value="调用ACTIVEMQ" type="submit">
    </form>
    <hr>
</div>
</body>
</html>
<script type="text/javascript">

    $.fn.serializeObject = function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    }
    $(document).ready(function () {

        loginFormSubmit();
    });
    function loginFormSubmit() {
        var url = "/test";
        $("#test").submit(function () {
            var params = $("#test").serializeObject();
            var ax = $.ajax({
                url: url,
                type: "POST",
                data: params,
                dataType: 'json',
                timeout: 30000,
                async: true,
                beforeSend: function () {
                },
                error: function (data, textStatus, e) { //出错处理
                    alert("error");
                },
                success: function (data, textStatus, args) { //成功处理
                    alert(data.name);
                }
            });
            return false;
        });
    }
</script>
