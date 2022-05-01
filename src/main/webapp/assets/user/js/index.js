const mobileBP = window.matchMedia("(max-width: 739px)");
const tabletBP = window.matchMedia("(min-width: 740px) and (max-width: 1024px)");
const mobileTabletBP = window.matchMedia("(max-width: 1024px)");

const app = {
    slickSlider: function () {
        $('.product-event__list').slick({
            autoplay: false,
            draggable: false,
            slidesToShow: 5,
            slidesToScroll: 1,
            prevArrow: `<button type='button' class='slick-prev pull-left'><i class="las la-arrow-left" aria-hidden='true'></i></button>`,
            nextArrow: `<button type='button' class='slick-next pull-right'><i class="las la-arrow-right" aria-hidden='true'></i></button>`,
            responsive: [
                {
                    breakpoint: 1024,
                    settings: {
                        slidesToShow: 3
                    }
                },
                {
                    breakpoint: 739,
                    settings: {
                        slidesToShow: 2
                    }
                },
            ]

        })
        $('.small-img-row').slick({
            autoplay: false,
            draggable: false,
            slidesToShow: 5,
            slidesToScroll: 1,
            prevArrow: `<button type='button' class='slick-prev pull-left'><i class="las la-arrow-left" aria-hidden='true'></i></button>`,
            nextArrow: `<button type='button' class='slick-next pull-right'><i class="las la-arrow-right" aria-hidden='true'></i></button>`,
            responsive: [
                {
                    breakpoint: 1024,
                    settings: {
                        slidesToShow: 5
                    }
                },
                {
                    breakpoint: 739,
                    settings: {
                        slidesToShow: 3
                    }
                },
            ]
        })
        $('.intro-image').slick({
            autoplay: true,
            draggable: false,
            slidesToShow: 1,
            slidesToScroll: 1,
            prevArrow: `<button type='button'hidden="hidden" class='slick-prev pull-left'></button>`,
            nextArrow: `<button type='button'hidden="hidden" class='slick-next pull-right'></button>`,
            autoplaySpeed: 2000
        })
    },
    // Responsive on tablet and mobile
    mobileTabletResponsive: function (ev) {
        $('.header__cart').click(function () {
            if ($('.header__cart-list').css('display') === "none")
                $('.header__cart-list').css({ 'display': "block" });
            else
                $('.header__cart-list').css({ 'display': "none" });
        })

        $('.category__mobile-click').click(function () {
            if ($('.category__bar--mobile').css('display') === "none")
                $('.category__bar--mobile').css({ 'display': "block" });
            else
                $('.category__bar--mobile').css({ 'display': "none" });
        })

        $('.contact').click(function () {
            if ($('.contact__list').css('height') === "0px")
                $('.contact__list').css({
                    "opacity": "1",
                    "height": "240px"
                });
            else
                $('.contact__list').css({
                    "opacity": "0",
                    "height": "0"
                });
        })


        $('.btn').on("touchstart", function () {
            $(this).css({ "background-color": "rgba(235, 20, 20, 0.5)" });
        })
        $('.btn').on("touchend", function () {
            $(this).css({ "background-color": "var(--red-color)" });
        })

        $('.pagination-btn').on("touchstart", function () {
            $(this).css({ "color": "var(--red-color)" });
        })
        $('.pagination-btn').on("touchend", function () {
            $(this).css({ "color": "var(--text-color)" });
        })

        $('.header__cart-item-remove').on("touchstart", function () {
            $(this).css({ "color": "var(--red-color)" });
        })
        $('.header__cart-item-remove').on("touchend", function () {
            $(this).css({ "color": "var(--text-color)" });
        })

        $('.pagination-number--active').on("touchstart", function () {
            $(this).css({ "color": "var(--white-color)" });
        })
        $('.pagination-number--active').on("touchend", function () {
            $(this).css({ "color": "var(--white-color)" });
        })

        $('.total-money > button').on("touchstart", function () {
            $(this).css({ "background-color": "rgba(235, 20, 20, 0.5)" });
        })
        $('.total-money > button').on("touchend", function () {
            $(this).css({ "background-color": "var(--red-color)" });
        })



        $('.remove-product').on("touchstart", function () {
            $(this).css({ "color": "var(--red-color)" });
        })
        $('.remove-product').on("touchend", function () {
            $(this).css({ "color": "#ccc" });
        })

        // $('.slick-arrow').unclick(function() {

        // })
        $('.quantity-btn--increase').click(function () {
            setTimeout(function () {
                let num = Number($('.quantity-number').val());
                console.log(num)
                $('.quantity-number').val(String(num + 1));
            }, 700);
        })

        $('.quantity-btn--decrease').click(function () {
            setTimeout(function () {
                let num = Number($('.quantity-number').val());
                console.log(num);
                num = num - 1 >= 0 ? num - 1 : 0;
                $('.quantity-number').val(String(num));
            }, 700);
        })

        function handleEventOnclick() {
            document.addEventListener("click", function (event) {
                const $target = $(event.target);
                if (!$target.closest(".header__cart").length)
                    $('.header__cart-list').css('display', "none");
            });
        }


        if (ev.matches) {
            handleEventOnclick();
        }

    },
    // Responsive on mobile
    mobileResponsive: function (ev) {

    },
    // Responsive on tablet
    tabletResponsive: function (ev) {

    },

    checkBreakPoint: function () {
        this.mobileResponsive(mobileBP);
        mobileBP.addListener(this.mobileResponsive);
        this.tabletResponsive(tabletBP);
        tabletBP.addListener(this.mobileResponsive);
        this.mobileTabletResponsive(mobileTabletBP);
        mobileTabletBP.addListener(this.mobileTabletResponsive);
    },

    start: function () {
        this.checkBreakPoint();
        this.slickSlider();
    }
};

$(window).on('load', function() { 
    app.start();
});
