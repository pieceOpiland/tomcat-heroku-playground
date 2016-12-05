(function(){
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
