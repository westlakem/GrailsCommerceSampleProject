// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
};

$(document).ready( function() { 
	updateTotals();
});

$(document).ready(function(){
	$('#2COPayment').click(function(){
		$.ajax({
		    url: '/ShoppingSolutionProject/shoppingCart/enterPaymentInfo',
		    type: 'GET',
		    success: function(response){
		    	$('#paymentInfo').html(response)
		    },
		    error: function(response){
		    	alert(response.status);
		    	return;
		    }
		    
		});
	});
});
$(document).ready(function(){
	$('.primaryImageSelector').change(function(){
		var radio = $(this)
		$.ajax({
			url: '/ShoppingSolutionProject/item/updatePrimaryImage',
			type: 'GET',
			async: false,
			data: {'productNumber' : radio.attr('name').replace('primaryImage',''), 
				'imageName' : radio.val()},
				success: function(response){
				},
				error: function(response){
					alert(response.status);
					return;
				}
				
		});
	});
});

$(document).ready(function(){
	$('#useBillingInfo').click(function(){
		$("#shippingFirstName").val($("#firstName").val())
		$("#shippingLastName").val($("#lastName").val())
		$("#shippingAddress1").val($("#address1").val())
		$("#shippingAddress2").val($("#address2").val())
		$("#shippingCity").val($("#city").val())
		$("#shippingState").val($("#state").val())
		$("#shippingZip").val($("#zip").val())
	});
});


$(document).ready(function(){
	$('.removeImage').click(function(){
		var $button = $(this);
		$.ajax({
			url: '/ShoppingSolutionProject/item/removeImage',
			type: 'GET',
			async: false,
			data: {'productNumber' : $button.attr('name'), 
				'imageName' : $button.attr('id')},
				success: function(response){
					$("li[id='"+$button.attr('id')+"Image']").hide()
				}
		});
	});
});

$(document).ready(function(){
	$('.add_to_cart').each(function(){
		var $button = $(this);
		$.ajax({
			url: '/ShoppingSolutionProject/shoppingCart/itemInCart',
			type: 'GET',
			async: false,
			data: {'productNumber' : $(this).attr('id')},
			success: function(response){
				if(response == 'true'){
					$button.removeClass('add_to_cart');
					$button.addClass('item_added_to_cart');
					$button.prop('value', 'Added to Cart!');
				}
			}
		});
	});
});

$(document).ready( function() {
	$('.pnqty').keyup(function(){
	    if ($(this).val()==''){
	    	
	    }
	    else if($(this).val() == '0'){
	    	alert('To set the value to 0 you must remove the item from the cart');
	    }
	    else{
	    	productNumber = $(this).attr('id').replace("quantity", "");
	    	qty = $(this).val();
	    	updateQty(qty,productNumber);
	    }
	});
});

$(document).ready( function() {
	$(".remove_from_cart").click(function(){
		var $button = $(this);
		var productNumber = $button.attr('id');
		$.ajax({
		    url: '/ShoppingSolutionProject/shoppingCart/removeFromCart',
		    type: 'GET',
		    data: {'productNumber' : productNumber},
		    success: function(response){
		    	$("#product"+productNumber).remove();
		    	if(response=="[]"){
		    		$("#cartButtons").remove();
		    		$("#cartButtons").remove();
		    	}
		    	updateTotals();
		    },
		    error: function(response){
		    	alert(response.status);
		    	return;
		    }
		})
	});
});
	

$(document).ready( function() {
	$(".add_to_cart").click(function(){
		var $button = $(this);
		var productNumber = $button.attr('id');
		if ($button.hasClass("add_to_cart")){
			$.ajax({
		        url: '/ShoppingSolutionProject/shoppingCart/addToCart',
		        type: 'GET',
		        data: {'productNumber' : productNumber},
		        success: function(){
		    		$button.prop('value', 'Added to Cart!');
		    		$button.removeClass("add_to_cart");
		    		$button.addClass("item_added_to_cart");
		        },
		        error: function(response){
		        	alert(response.status);
		        	return;
		        }
		    });
		}
	});
});
$(document).ready( function() {
	$("#searchBar").keyup(function(){
		var $search = $(this).val();
		if($search!=''){
			$.ajax({
				url: '/ShoppingSolutionProject/products/search',
				type: 'GET',
				data: {'searchParam' : $search},
				success: function(response){
					alert(response)
				},
				error: function(response){
					alert(response.status);
					return;
				}
			});
		}
	});
});

$(document).ready(function(){
	$("#addBillingAddress").click(function(){
		$("#newBillingAddress").toggle();
	})
});

$(document).ready(function(){
	$("#addShippingAddress").click(function(){
		$("#newShippingAddress").toggle();
	})
})

$(".empty_cart_link").click(function(){
	return confirm("Are you sure you want to empty your cart?");
});

function updateTotals(){
	updateSubtotal();
	updateShippingCost();
	updateTotal();
}

function updateQty(quantity, productNumber) {
	$.ajax({
	    url: '/ShoppingSolutionProject/shoppingCart/updateQuantity',
	    type: 'GET',
	    data: {'productNumber' : productNumber, 'quantity':quantity},
	    success: function(response){
	    	$("#price"+productNumber).html("$"+response);
	    	updateTotals();
	    }
	});
}

function updateSubtotal(){
	var subTotal = 0
	$('span[id^="price"]').each(function(){
		subTotal += parseFloat($(this).text().replace('$',''))
	});
	$('#subTotalAmmt').html('$'+subTotal.toFixed(2))
}

function updateShippingCost(){
	$.ajax({
	    url: '/ShoppingSolutionProject/shoppingCart/getShippingCost',
	    type: 'GET',
	    async: false,
	    success: function(response){
	    	$("#shippingCost").html("$"+response);
	    }
	});
}

function updateTotal(){
	var total = 0
	total += parseFloat($("#subTotalAmmt").text().replace('$',''))
	total += parseFloat($("#shippingCost").text().replace('$',''))
	$("#totalAmmt").html('$'+total.toFixed(2));
}

