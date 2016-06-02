window.onload=function(){
	//校验用户名
    $("input[type='text'][name='username']").blur(function(){
    	var username=$(this).val();
		if ($.trim(username) == "") {//判断用户名是否为空
			$("#username_msg").html("<font color='red'>用户名不能为空</font>");
		}
		else {//当用户名不为空的时候  在校验用户名是否存在
			$.get("../servlet/ValiNameServlet", {
				username: username
			}, function(data){
				var json = eval("(" + data + ")");
				if (json.stat == 1) {//当用户名存在时
					$("#username_msg").html("<font color='red'>" + json.msg + "</font>");
				}
				else 
					if (json.stat == 0) {//当用户名不存在时
						$("#username_msg").html("<font color='blue'>" + json.msg + "</font>");
					}
			});
		}
    });
	
	//校验密码
	$("input[type='password'][name='userpassword']").blur(function(){
		var userpassword=$(this).val();
		//当密码复合格式时
		if(/^[a-z0-9A-Z]{6,12}$/.test(userpassword)){
				$("#password_msg").html("<font color='blue'>密码格式信息正确</font>");
		}else{//当密码不符合格式时
			$("#password_msg").html("<font color='red'>密码格式信息不正确</font>");
		}
	});
	
	//校验两次密码是否一致
	$("input[type='password'][name='userpassword2']").blur(function(){
		var userpassword=$("input[type='password'][name='userpassword']").val();
		var userpassword2=$(this).val();
		if($.trim(userpassword2)==userpassword){
			$("#password_msg2").html("<font color='blue'>两次密码一样</font>");
		}else{
			$("#password_msg2").html("<font color='red'>两次密码不一样</font>");
		}
	});
	
	//校验手机格式
	$("input[type='text'][name='userphone']").blur(function(){
		
		var userphone=$(this).val();
		if($.trim(userphone)==""){
			$("#userphone_msg").html("<font color='red'>手机号不能为空</font>");
		}else{
			if(/^[1][3,5,8][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$/.test(userphone)){
				$("#userphone_msg").html("<font color='blue'>手机号格式正确</font>");
			}else{
				$("#userphone_msg").html("<font color='red'>手机号格式不正确</font>");
			}
		}
		
	});
	
	//校验邮箱
	$("input[type='text'][name='useremail']").blur(function(){
		var useremail=$(this).val();
		if($.trim(useremail)==""){
			$("#email_msg").html("<font color='red'>邮箱不能为空</font>");
		}else{
			if(/^\w+@\w+(\.\w+)+$/.test(useremail)){
				$("#email_msg").html("<font color='blue'>邮箱格式正确</font>");
			}else{
				$("#email_msg").html("<font color='red'>邮箱格式不正确</font");
			}
		}
	});
	
	
	//地址校验
	$("input[type='text'][name='userfrom']").blur(function(){
		var userfrom=$(this).val();
		if($.trim(userfrom)==""){
			$("#from_msg").html("<font color='red'>地址不能为空</font>");
		}
	});
}
