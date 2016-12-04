(function(){
    // Bootstrap the app here.
    require(["jquery", "TodoList", "bootstrap"], function($, TodoList){
        $(function(){
            var $container = $("#listContainer");
            var $input = $("#newItem");
            var $submitButton = $("#submitItem");
            TodoList.renderInto($container);
            $submitButton.on("click", function(){
                TodoList.addItem($input.val());
                $input.val("");
                $input.focus();
            });
        });
    });
})();
