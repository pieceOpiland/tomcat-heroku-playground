(function(){
    // Google Analytics here.
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
            (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
        m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

    ga('create', 'UA-88913516-1', 'auto');
    ga('send', 'pageview');

    // Bootstrap the app here.
    require(["jquery", "TodoList", "bootstrap"], function($, TodoList){
        $(function(){
            var $container = $("#listContainer");
            var $input = $("#newItem");
            var $submitButton = $("#submitItem");
            var $clearButton = $("#clearItems");
            TodoList.renderInto($container);
            $submitButton.on("click", function(){
                if($input.val()) {
                    TodoList.addItem($input.val());
                }
                $input.val("");
                $input.focus();
            });
            $clearButton.on("click", function(){
                TodoList.clearList();
                $input.val("");
                $input.focus();
            })
        });
    });
})();
