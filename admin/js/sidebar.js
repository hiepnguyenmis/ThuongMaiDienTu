(function($) {
    $("list-unstyled>li>a").click(function(){
        $("list-unstyled>li>a").removeClass("active");
        $(this).addClass("active");
      });
})(jQuery);
