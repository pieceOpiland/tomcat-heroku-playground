define(function(require){
    var $ = require("jquery");
    var $list = $("<ul>");
    var renderItem = function(item){
        var $checkbox = $("<input type=\"checkbox\" />");
        $checkbox.data("id", item.id);
        $checkbox.prop("checked", item.done);
        $checkbox.prop("disabled", item.done);

        $checkbox.on("change", updateItem);

        var $text = $("<span>").text(item.task);
        $list.append($("<li>").append($checkbox).append($text));
    };
    var renderItems = function(items){
        for(var i = 0; i < items.length; i++){
            renderItem(items[i]);
        }
    };

    var updateItem = function(e){
        var $this = $(this);
        $.ajax({
            url: "/rest/todo/" + $this.data("id"),
            method: "PUT",
            contentType:"application/json"
        }).then(function(data){
            $this.prop("disabled", data.done);
        });
    };

    var populateList = function(){
        return $.ajax({
            url: "/rest/todo",
            method: "GET"
        }).then(function(data){
            $list.html("");
            renderItems(data);
        });
    };

    var addItem = function(text) {
        return $.ajax({
            url: "/rest/todo",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                task: text,
                done: false
            })
        }).then(function(data){
            renderItem(data);
        });
    };

    var renderInto = function($el){
        $el.append($list);
        return populateList();
    };

    return {
        renderInto: renderInto,
        addItem: addItem
    }
});
