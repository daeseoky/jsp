/**
 *  슬라이더 애니메이션
 */
$(function(){
    let sliders = $('.slider > ul > li');
    let i = 0;

    setInterval(function(){

        //0, 1, 2, 0
        sliders.eq(i).animate({'left':'-100%'}, 10000);
        i++

        if(i==3){
            i = 0;
        }

        //1, 2, 0, 1
        sliders.eq(i).css('left','100%').animate({'left':'0'}, 10000);

    }, 11000);
});