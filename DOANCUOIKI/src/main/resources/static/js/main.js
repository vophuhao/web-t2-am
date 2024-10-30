/**
    * selectImages
    * menuleft
    * tabs
    * progresslevel
    * collapse_menu
    * fullcheckbox
    * showpass
    * gallery
    * coppy
    * select_colors_theme
    * icon_function
    * box_search
    * preloader
*/

; (function ($) {

  "use strict";

  var selectImages = function () {
    if ($(".image-select").length > 0) {
      const selectIMG = $(".image-select");
      selectIMG.find("option").each((idx, elem) => {
        const selectOption = $(elem);
        const imgURL = selectOption.attr("data-thumbnail");
        if (imgURL) {
          selectOption.attr(
            "data-content",
            "<img src='%i'/> %s"
              .replace(/%i/, imgURL)
              .replace(/%s/, selectOption.text())
          );
        }
      });
      selectIMG.selectpicker();
    }
  };

  var menuleft = function () {
    if ($('div').hasClass('section-menu-left')) {
      var bt =$(".section-menu-left").find(".has-children");
      bt.on("click", function () {
        var args = { duration: 200 };
        if ($(this).hasClass("active")) {
          $(this).children(".sub-menu").slideUp(args);
          $(this).removeClass("active");
        } else {
          $(".sub-menu").slideUp(args);
          $(this).children(".sub-menu").slideDown(args);
          $(".menu-item.has-children").removeClass("active");
          $(this).addClass("active");
        }
      });
      $('.sub-menu-item').on('click', function(event){
        event.stopPropagation();
      });
    }
  };

  var tabs = function(){
    $('.widget-tabs').each(function(){
        $(this).find('.widget-content-tab').children().hide();
        $(this).find('.widget-content-tab').children(".active").show();
        $(this).find('.widget-menu-tab').find('li').on('click',function(){
            var liActive = $(this).index();
            var contentActive=$(this).siblings().removeClass('active').parents('.widget-tabs').find('.widget-content-tab').children().eq(liActive);
            contentActive.addClass('active').fadeIn("slow");
            contentActive.siblings().removeClass('active');
            $(this).addClass('active').parents('.widget-tabs').find('.widget-content-tab').children().eq(liActive).siblings().hide();
        });
    });
  };

  $('ul.dropdown-menu.has-content').on('click', function(event){
    event.stopPropagation();
  });
  $('.button-close-dropdown').on('click', function(){
    $(this).closest('.dropdown').find('.dropdown-toggle').removeClass('show');
    $(this).closest('.dropdown').find('.dropdown-menu').removeClass('show');
  });

  var progresslevel = function () {
    if ($('div').hasClass('progress-level-bar')) {
    var bars = document.querySelectorAll('.progress-level-bar > span');
    setInterval(function(){
    bars.forEach(function(bar){
      var t1 = parseFloat(bar.dataset.progress);
      var t2 = parseFloat(bar.dataset.max);
      var getWidth = ( t1 / t2) * 100;
      bar.style.width = getWidth + '%';
    });
    }, 500);
  }}

  var collapse_menu = function () {
    $(".button-show-hide").on("click", function () {
      $('.layout-wrap').toggleClass('full-width');
    })
  }

  var fullcheckbox = function () {
    $('.total-checkbox').on('click', function () {
      if ( $(this).is(':checked') ) {
        $(this).closest('.wrap-checkbox').find('.checkbox-item').prop('checked', true);
      } else {
        $(this).closest('.wrap-checkbox').find('.checkbox-item').prop('checked', false);
      }
    });
  };

  var showpass = function() {
    $(".show-pass").on("click", function () {
      $(this).toggleClass("active");
      var input = $(this).parents(".password").find(".password-input");

      if (input.attr("type") === "password") {
        input.attr("type", "text");
      } else if (input.attr("type") === "text") {
        input.attr("type", "password");
      }
    });
  }

  var gallery = function() {
    $(".button-list-style").on("click", function () {
      $(".wrap-gallery-item").addClass("list");
    });
    $(".button-grid-style").on("click", function () {
      $(".wrap-gallery-item").removeClass("list");
    });
  }

  var coppy = function() {
    $(".button-coppy").on("click", function () {
      myFunction()
    });
    function myFunction() {
      var copyText = document.getElementsByClassName("coppy-content");
      navigator.clipboard.writeText(copyText.text);
    }
  }

  var select_colors_theme = function () {
    if ($('div').hasClass("select-colors-theme")) {
      $(".select-colors-theme .item").on("click", function (e) {
        $(this).parents(".select-colors-theme").find(".active").removeClass("active");
        $(this).toggleClass("active");
      })
    }
  }

  var icon_function = function () {
    if ($('div').hasClass("list-icon-function")) {
      $(".list-icon-function .trash").on("click", function (e) {
        $(this).parents(".product-item").remove();
        $(this).parents(".attribute-item").remove();
        $(this).parents(".countries-item").remove();
        $(this).parents(".user-item").remove();
        $(this).parents(".roles-item").remove();
      })
    }
  }

  var box_search=function(){
        
    $(document).on('click',function(e){
      var clickID=e.target.id;if((clickID!=='s')){
          $('.box-content-search').removeClass('active');
      }});
    $(document).on('click',function(e){
        var clickID=e.target.class;if((clickID!=='a111')){
            $('.show-search').removeClass('active');
    }});
        
    $('.show-search').on('click',function(event){
      event.stopPropagation();}
    );
    $('.search-form').on('click',function(event){
      event.stopPropagation();}
    );
    var input =  $('.header-dashboard').find('.form-search').find('input');
    input.on('input', function() {
      if ($(this).val().trim() !== '') {
        $('.box-content-search').addClass('active');
      } else {
        $('.box-content-search').removeClass('active');
      }
    });
   
  }

  var retinaLogos = function() {
    var retina = window.devicePixelRatio > 1 ? true : false;
      if(retina) {
        if ($(".dark-theme").length > 0) {
          $('#logo_header').attr({src:'images/logo/logo-dark@2x.png',width:'154px',height:'52px'});
        } else {
          $('#logo_header').attr({src:'images/logo/logo@2x.png',width:'154px',height:'52px'});
        }
      }
  };  

  var preloader = function () {
    setTimeout(function () {
    $("#preload").fadeOut("slow", function () {
        $(this).remove();
    });
    }, 1000);
  };

  var variant_picker = function () {
    if ($(".variant-picker-item").length) {
      $(".variant-picker-item label").on("click", function (e) {
        $(this)
          .closest(".variant-picker-item")
          .find(".variant-picker-label-value")
          .text($(this).data("value"));
      });
    }
};

var btnQuantity = function () {
    $(".minus-btn").on("click", function (e) {
      e.preventDefault();
      var $this = $(this);
      var $input = $this.closest("div").find("input");
      var value = parseInt($input.val());

      if (value > 0) {
        value = value - 1;
      }

      $input.val(value);
    });

    $(".plus-btn").on("click", function (e) {
      e.preventDefault();
      var $this = $(this);
      var $input = $this.closest("div").find("input");
      var value = parseInt($input.val());

      if (value > -1) {
        value = value + 1;
      }

      $input.val(value);
    });
};


  // Dom Ready
  $(function () {
    selectImages();
    menuleft();
    tabs();
    progresslevel();
    collapse_menu();
    fullcheckbox();
    showpass();
    gallery();
    coppy();
    select_colors_theme();
    icon_function();
    box_search();
    retinaLogos();
    variant_picker();
    btnQuantity();
    preloader();
    
  });

})(jQuery);

(function ($) {
 "use strict";

/*----------------------------
 jQuery MeanMenu
------------------------------ */
    $('.mobile-menu nav').meanmenu({
        meanScreenWidth: "991",
        meanMenuContainer: ".mobile-menu"
    });

/*----------------------------
 wow js
------------------------------ */
 new WOW().init();

/*----------------------------
 product-slider
------------------------------ */
    $(".product-slider").owlCarousel({
      autoPlay: false,
      slideSpeed:2000,
      pagination:false,
      navigation:false,
      items : 3,
      itemsDesktop : [1199,3],
      itemsDesktopSmall : [980,3],
      itemsTablet: [768,2],
      itemsMobile : [479,1],
  });

/*----------------------------
 feature-product-slider
------------------------------ */
    $(".feature-product-slider").owlCarousel({
      autoPlay: false,
      slideSpeed:2000,
      pagination:false,
      navigation:true,
      margin: 30,
      items : 4,
      itemsDesktop : [1199,4],
      itemsDesktopSmall : [980,3],
      itemsTablet: [768,2],
      itemsMobile : [479,1],
  });

/*----------------------------
 new-product-slider
------------------------------ */
    $(".new-product-slider").owlCarousel({
      autoPlay: false,
      slideSpeed:2000,
      pagination:false,
      navigation:true,
      items : 4,
      itemsDesktop : [1199,4],
      itemsDesktopSmall : [980,3],
      itemsTablet: [768,2],
      itemsMobile : [479,1],
  });

/*----------------------------
 testimonial-slider
------------------------------ */
    $(".testimonial-slider").owlCarousel({
      autoPlay: false,
      slideSpeed:2000,
      pagination:true,
      navigation:false,
      items : 1,
      itemsDesktop : [1199,1],
      itemsDesktopSmall : [980,1],
      itemsTablet: [768,1],
      itemsMobile : [479,1],
  });

/*----------------------------
 sell-slider
------------------------------ */
    $(".sell-area .sell-slider").owlCarousel({
      autoPlay: false,
      slideSpeed:2000,
      pagination:false,
      navigation:false,
      items : 5,
      itemsDesktop : [1199,4],
      itemsDesktopSmall : [1100,3],
      itemsTablet: [768,2],
      itemsMobile : [479,1],
  });

/*----------------------------
 features-home2-slider
------------------------------ */
    $(".features-home2-slider").owlCarousel({
      autoPlay: false,
      slideSpeed:2000,
      pagination:false,
      navigation:true,
      items : 4,
      itemsDesktop : [1199,3],
      itemsDesktopSmall : [980,2],
      itemsTablet: [768,2],
      itemsMobile : [360,1],
  });

/*----------------------------
 sell-off-slider
------------------------------ */
    $(".sell-off-slider").owlCarousel({
      autoPlay: false,
      slideSpeed:2000,
      pagination:false,
      navigation:false,
      items : 4,
      itemsDesktop : [1199,3],
      itemsDesktopSmall : [980,3],
      itemsTablet: [768,2],
      itemsMobile : [479,1],
  });

/*----------------------------
 product-page-slider
------------------------------ */
    $(".product-page-slider").owlCarousel({
        autoPlay: false,
        slideSpeed:2000,
        pagination:false,
        navigation:true,
        items : 3,
        itemsDesktop : [1199,3],
        itemsDesktopSmall : [980,3],
        itemsTablet: [768,3],
        itemsMobile : [360,2],
    });

/*----------------------------
upsell-slider
------------------------------ */
    $(".upsell-slider").owlCarousel({
        autoPlay: false,
        slideSpeed:2000,
        pagination:false,
        navigation:true,
        items : 4,
        itemsDesktop : [1199,3],
        itemsDesktopSmall : [980,3],
        itemsTablet: [768,2],
        itemsMobile : [479,1],
    });

/*----------------------------
 related-slider
------------------------------ */
    $(".related-slider").owlCarousel({
        autoPlay: false,
        slideSpeed:2000,
        pagination:false,
        navigation:true,
        items : 4,
        itemsDesktop : [1199,3],
        itemsDesktopSmall : [980,3],
        itemsTablet: [768,2],
        itemsMobile : [479,1],
    });

/*----------------------------
 price-slider active
------------------------------ */
    $( "#slider-range" ).slider({
    range: true,
    min: 100,
    max: 750,
    values: [ 100, 700 ],
    slide: function( event, ui ) {
    $( "#amount" ).val( "" + ui.values[ 0 ] + " -- " + ui.values[ 1 ] );
    }
    });
    $( "#amount" ).val( "" + $( "#slider-range" ).slider( "values", 0 ) +
    " -- " + $( "#slider-range" ).slider( "values", 1 ) );

/*----------------------------
 elevateZoom active
------------------------------ */
    /* $(".optima_zoom").elevateZoom({gallery:'optima_gallery', cursor: 'pointer', galleryActiveClass: "active", imageCrossfade: true, loadingIcon: ""});

    $(".optima_zoom").bind("click", function(e) {
        var ez =   $('.optima_zoom').data('elevateZoom');
        ez.closeAll();
        $.fancybox(ez.getGalleryList());
        return false;
    }); */

/*----------------------------
 cart-plus-minus-button active
------------------------------ */
    $(".cart-plus-minus").append('<div class="dec qtybutton"><</div><div class="inc qtybutton">></div>');
    $(".qtybutton").on("click", function() {
        var $button = $(this);
        var oldValue = $button.parent().find("input").val();
        if ($button.text() == ">") {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            // Don't allow decrementing below zero
            if (oldValue > 0) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 0;
            }
        }
        $button.parent().find("input").val(newVal);
    });

/*--------------------------
 scrollUp
---------------------------- */
    //Check to see if the window is top if not then display button
    $(window).scroll(function(){
        if ($(this).scrollTop() > 300) {
            $('#scrollUp').fadeIn();
        } else {
            $('#scrollUp').fadeOut();
        }
    });

    //Click event to scroll to top
    $('#scrollUp').click(function(){
        $('html, body').animate({scrollTop : 0},800);
        return false;
    });

/*--------------------------
 tooltip
---------------------------- */
    const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
    const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))

})(jQuery);
