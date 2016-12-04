(function(){
    require.config({
        baseUrl: "scripts",
        paths: {
            "jquery": "../libs/jquery/dist/jquery.min",
            "bootstrap": "../libs/bootstrap/dist/js/bootstrap.min"
        },
        shim: {
            "bootstrap": {
                deps: ["jquery"]
            }
        }
    });
})();
