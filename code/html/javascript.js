$(function(){

	$(window).load(function() {

		update_dimensions();
		if (window.location.hash.substring(1) != "")
		{
			if ($("#slide"+(window.location.hash.substring(1)-1)).length)
			{
				go_to_slide(window.location.hash.substring(1)-1);
			}
		}
		else {
			go_to_slide(0);
		}
	});

	function findHHandWW(imgEle, newImg, sType) {

		var imgHeight, imgWidth;
		var hS, wS
		imgRatio =  newImg.width / newImg.height;
		switch(sType){
			case 1: {hS = 1; wS = 5; break; };
			case 3: {hS = 2; wS = 5; break; };
			case 4: {hS = 2; wS = 4; break; };
			case 5: {hS = 2; wS = 2; break; };
			case 6: {hS = 2; wS = 1; break; };
			case 7: {hS = 3; wS = 5; break; };
			case 8: {hS = 3; wS = 4; break; };
			case 9: {hS = 3; wS = 2; break; };
			case 10: {hS = 1; wS = 3; break; };
		};
		switch (hS){
			case 1:{imgHeight = (new_height*0.30); break; };
			case 2:{imgHeight = (new_height*0.54); break; };
			case 3:{imgHeight = (new_height*0.77); break; };
		};
		imgWidth = (imgHeight*imgRatio);
		switch (wS){
			case 1:{if (imgWidth > (new_width*0.204851)) {imgWidth = (new_width*0.204851); } break; };
			case 2:{if (imgWidth > (new_width*0.268194)) {imgWidth = (new_width*0.268194); } break; };
			case 3:{if (imgWidth > (new_width*0.393530)) {imgWidth = (new_width*0.393530); } break; };
			case 4:{if (imgWidth > (new_width*0.409703)) {imgWidth = (new_width*0.409703); } break; };
			case 5:{if (imgWidth > (new_width*0.820754)) {imgWidth = (new_width*0.820754); } break; };
		};
		$(imgEle).css({ "width":imgWidth }); return true;
	};


	function getImgSize(imgEle , sType) {
		imgSrc = $(imgEle).attr("src");
		var newImg = new Image();
		newImg.name = imgSrc;
		newImg.src = imgSrc;
		newImg.onload = findHHandWW(imgEle, newImg, sType);
	};

	var slide_pointer = 0;
	var slide_pointer_previous = -1;
	var new_height, new_width;

	function update_dimensions() {
		var h = $(window).height();
		var w = $(window).width();
		req = $("#wrapper").attr("data-ratio").split("/").map(function(i){return parseInt(i);});
		ratio = req[0] / req[1];
		actual = w / h;

		if(actual > ratio) {
				new_height = parseInt(h);
				new_width = parseInt(h * ratio);
				document.body.style.fontSize = ((window.innerHeight/100)*6.25)+"%";
		} 
		else if(ratio > actual) {
				new_width = parseInt(w);
				new_height = parseInt(w / ratio);
				document.body.style.fontSize = ((window.innerWidth/133)*6.25)+"%";
		}

		$(".slide_wrapper").css({
			"height":new_height,
			"width":new_width
		});

		$("#axis").css({
			"margin-left": (w/2)-(new_width/2) ,
		});

		$(".lotsslide > .image > img").each(function (index,domEle) {getImgSize(domEle, 1);});
		$(".titleimgageslide  > .image > img").each(function (index,domEle) {getImgSize(domEle, 3);});
		$(".titledimgageslide > .image > img").each(function (index,domEle) {getImgSize(domEle, 4);});
		$(".titletimgageslide > .image > img").each(function (index,domEle) {getImgSize(domEle, 5);});
		$(".titleqimgageslide > .image > img").each(function (index,domEle) {getImgSize(domEle, 6);});
		$(".imageslide  > .image > img").each(function (index,domEle) {getImgSize(domEle, 7);});
		$(".dimageslide > .image > img").each(function (index,domEle) {getImgSize(domEle, 8);});
		$(".timageslide > .image > img").each(function (index,domEle) {getImgSize(domEle, 9);});
		$(".qimageslide > .image > img").each(function (index,domEle) {getImgSize(domEle, 10);});
	};

	function go_to_slide_rotate_scale(nr) {
		slide_pointer = nr;
		selector = "#slide"+slide_pointer;
		selectorprevious = "#slide"+slide_pointer_previous;
		if (selector != selectorprevious)
		{
			$(selector).css('opacity','0');
			$(selector).css('top','0%');
			$(selector).css('-webkit-transform','scale(1)');
			$(selector).css('-moz-transform','scale(1)'); 
			$(selector).css('-o-transform','scale(1)'); 
			$(selector).css('-ms-transform','scale(1)'); 
			$(selectorprevious).stop().animate({
				"border-spacing" : "100","opacity":0},
				{step: function(now,fx) {
					var scale = (100-now)/100;
					$(this).css('-webkit-transform','rotate('+now*3.6+'deg) scale('+scale+')');
					$(this).css('-moz-transform','rotate('+now*3.6+'deg) scale('+scale+')'); 
					$(this).css('-o-transform','rotate('+now*3.6+'deg) scale('+scale+')'); 
					$(this).css('-ms-transform','rotate('+now*3.6+'deg) scale('+scale+')'); 
				},duration:700, complete: function() {
					$(selectorprevious).css('top','100%');
					$(selectorprevious).css('-webkit-transform','rotate(0deg) scale(1)');
					$(selectorprevious).css('-moz-transform','rotate(0deg) scale(1)');
					$(selectorprevious).css('-o-transform','rotate(0deg) scale(1)');
					$(selectorprevious).css('-ms-transform','rotate(0deg) scale(1)');
					$(selectorprevious).css('border-spacing','0');
				}}
				,'linear');
			$(selector).stop().fadeTo(700,1);
		}
	}

	function go_to_slide_scale(nr) {
		slide_pointer = nr;
		selector = "#slide"+slide_pointer;
		selectorprevious = "#slide"+slide_pointer_previous;
		if (selector != selectorprevious)
		{
			$(selector).css('opacity','0');
			$(selector).css('top','0%');
			$(selector).css('-webkit-transform','scale(1)');
			$(selector).css('-moz-transform','scale(1)'); 
			$(selector).css('-o-transform','scale(1)'); 
			$(selector).css('-ms-transform','scale(1)'); 
			$(selectorprevious).stop().animate({
				"border-spacing" : "100","opacity":0},
				{step: function(now,fx) {
					var scale = (100-now)/100;
					$(this).css('-webkit-transform','scale('+scale+')');
					$(this).css('-moz-transform','scale('+scale+')'); 
					$(this).css('-o-transform','scale('+scale+')'); 
					$(this).css('-ms-transform','scale('+scale+')'); 
				},duration:700, complete: function() {
					$(selectorprevious).css('top','100%');
					$(selectorprevious).css('-webkit-transform','scale(1)');
					$(selectorprevious).css('-moz-transform','scale(1)');
					$(selectorprevious).css('-o-transform','scale(1)');
					$(selectorprevious).css('-ms-transform','scale(1)');
					$(selectorprevious).css('border-spacing','0');
				}}
				,'linear');
			$(selector).stop().fadeTo(700,1);
		}
	}

	function go_to_slide_swipe(nr) {
		slide_pointer = nr;
		selector = "#slide"+slide_pointer;
		selectorprevious = "#slide"+slide_pointer_previous;
		if (slide_pointer != slide_pointer_previous)
		{
			var left = "-100%";
			if (slide_pointer < slide_pointer_previous)
			{
				left = "100%";
				$(selector).css('left','-100%');
			}
			else
			{
				$(selector).css('left','100%');
			}
			$(selector).css('top','0%');
			$(selector).css('opacity','1');
			$(selector).css('-webkit-transform','scale(1)');
			$(selector).css('-moz-transform','scale(1)'); 
			$(selector).css('-o-transform','scale(1)'); 
			$(selector).css('-ms-transform','scale(1)'); 
			$(selectorprevious).stop().fadeTo(200,0);
			$(selector).stop().fadeTo(700,1);

			$(selector).stop().animate({
				"left" : "0%"
			},500);
			$(selectorprevious).stop().animate({
				"left" : left
			},500,function() {
				$(selectorprevious).css('top','100%');
				$(selectorprevious).css('left','0%');
				$(selectorprevious).css('opacity','0');
			});

		}
	}

	function go_to_slide_fade(nr) {
		slide_pointer = nr;
		selector = "#slide"+slide_pointer;
		selectorprevious = "#slide"+slide_pointer_previous;
		if (selector != selectorprevious)
		{
			$(selector).css('opacity','0');
			$(selector).css('top','0%');
			$(selector).css('-webkit-transform','scale(1)');
			$(selector).css('-moz-transform','scale(1)'); 
			$(selector).css('-o-transform','scale(1)'); 
			$(selector).css('-ms-transform','scale(1)'); 
			$(selectorprevious).stop().fadeTo(300,0,function()
			{
				$(selector).stop().fadeTo(300,1, function() {
					$(selectorprevious).css('top','100%');
				});
			});
		}
	}

	$(document.body).keydown(function(e){
		slide_pointer_previous = slide_pointer;
		switch(e.keyCode){
			case 37: {go_to_slide(Math.max(slide_pointer - 1,0)); break; }
			case 38: {go_to_slide(Math.max(slide_pointer - 1,0)); break; }
			case 39: {go_to_slide(Math.min(slide_pointer + 1, $(".slide_wrapper[id]").length-2 )); break; }
			case 40: {go_to_slide(Math.min(slide_pointer + 1, $(".slide_wrapper[id]").length-2 )); break; }
		}
	});


	
	var swipeOptions = 
	{
		swipe:swipe,
		threshold:5
	};
	{$(function()
		{
			$('#wrapper').swipe(swipeOptions);
		}
		); };
	function swipe (event,direction)
	{
		slide_pointer_previous = slide_pointer;
		if (direction == "left")
		{
			go_to_slide(Math.min(slide_pointer + 1, $(".slide_wrapper[id]").length-2 ));
		}
		else if (direction == "right")
		{
			go_to_slide(Math.max(slide_pointer - 1,0));
		}
	};

	function go_to_slide(nr)
	{
			var type = document.getElementById('slide'+slide_pointer_previous).getAttribute("data-transition");
			switch(type) {
				case "rotatescale": {go_to_slide_rotate_scale(nr); break; }
				case "scale": {go_to_slide_scale(nr); break; } 
				case "swipe": {go_to_slide_swipe(nr); break; }
				case "fade": {go_to_slide_fade(nr); break; }
			}
	};

	$(window).resize(function(e){
		update_dimensions();
	});
});