/*const paymentstart  = () =>{
	
	 let amount =$("#payment_fild").val();

	 if (amount=="" || amount==null) {
		alert("amount is required !!!");
		return;
	}
	 
	 $.ajax({
		 
		 url:"/admin/creat_order",
		 data:{
	          amount:payment_fild,
	          
             },
		 contentType:'application/json',
		 type:'POST',
		 dataType:'json',
		 success:function(response){
			 //invoked when success
			 console.log(response)
		 }
	
	 })
};

*/

function paymentstart(){
	
		  var amount = $("#payment_fild").val(); 
		 
		  $.ajax({
			url:"/project/admin/makePayment",
		    type:'POST',
		    datatype:'json',
		    data:{
		    	amount:amount
		    },
		   
		    success:function(data) {
		      alert(data);
		    }
		  });
	
}