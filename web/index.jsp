<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tomcat on Heroku</title>
    <script src="libs/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript">
        $(function(){
            var $target = $("#restTarget");
            var $input = $("#valueInput");
            var $button = $("#submitValue");

            $.ajax({
                url: "/rest/int",
                method: "GET"
            }).then(function(data){
                $target.html("Value: " + data.value);
            }).fail(function(){
                $target.html("I failed!");
            });

            $button.on("click", function() {
                var value = parseInt($input.val(), 10);
                if(!isNaN(value)) {
                    $.ajax({
                        url: "rest/int",
                        method: "POST",
                        contentType: "application/json",
                        data: JSON.stringify({value: value})
                    }).then(function () {
                        $target.html("Value: " + value);
                        $input.val("");
                        $input.focus();
                    });
                }
            });
        });
    </script>
</head>
<body>
<div>This should deploy.</div>
<div><%= getServletContext().getInitParameter("theValue") %></div>
<div id="restTarget"></div>
<div>
    <label>New Value: <input id="valueInput" type="text" /></label>
</div>
<div>
    <button id="submitValue">Submit</button>
</div>
</body>
</html>