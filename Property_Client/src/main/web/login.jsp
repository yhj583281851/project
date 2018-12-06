<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AdminLogin</title>
<link rel="stylesheet" href="static/forgetPass/css/lrtk.css">
<link rel="stylesheet" href="static/idcode/jquery.idcode.css" />
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="static/idcode/jquery.idcode.js"></script>
<script src="static/js/cookie.js"></script>
<link rel="stylesheet" href="static/forgetPass/css/lrtk.css">
</head>
	<body>
	
	<!-- 代码 开始 -->
	<div id="login">
		<div class="wrapper">
			<div class="login">
				<form id="form1" method="post" class="container offset1 loginform">
					<div id="owl-login">
						<div class="hand"></div>
						<div class="hand hand-r"></div>
						<div class="arms">
							<div class="arm"></div>
							<div class="arm arm-r"></div>
						</div>
					</div>
					<div class="pad">
						<input type="hidden" name="_csrf" value="gzh">
						<div class="control-group">
							<div class="controls">
								<label for="account" class="control-label fa fa-user"></label>
								<input id="account" type="text" name="account"
									placeholder="Account" tabindex="1" autofocus="autofocus"
									class="form-control input-medium">
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<label for="password" class="control-label fa fa-asterisk"></label>
								<input id="password" type="password" name="password"
									placeholder="Password" tabindex="2"
									class="form-control input-medium">
							</div>
						</div>
						
						
						
						<div class="control-group">
							<div class="controls">
							
	                      	<input type="text" id="Txtidcode" onchange="check()" class="txtVerification" />
		                 <span id="idcode"></span>
		                 </div>
		                 </div>
					</div>
					<div class="form-actions">
						<center>
							<button id="loginbtn" type="submit" tabindex="4" disabled="false"
								class="btn btn-info">Login</button>
						</center>
					</div>
				</form>
			</div>
		</div>
		</div>

		<script>
		
		        $.idcode.setCode();
		        function check(){
				var IsBy = $.idcode.validateCode(); 
				if(IsBy==true){
					 document.getElementById("loginbtn").removeAttribute("disabled");			
				}else{
					alert("验证码错误");
				}
				console.log(IsBy);
			}
	
			$(function() {
		        $('#login #password').focus(function() {
		            $('#owl-login').addClass('password');
		        }).blur(function() {
		            $('#owl-login').removeClass('password');
		        });
		    });
			
			$("#loginbtn").click(function(){
				
				var account = $("#account").val();
				var password = $("#password").val();
				
				var string = "account="+account+"&password="+password;
				
				if(account==""||password==""){
					alert("账号或密码不能为空！");
				}
				
			$.ajax({
				url:"http://localhost:8080/ChunYinBackGround/adminLogin",
				data:string,
				type:"post",
				dataType:"jsonp",
				success:function(datas){
					if(datas.code==100){
						//登录成功，创建cookie
						setCookie("account",account,365);
						setCookie("id",datas.data.adminId,365);
						
						window.location.href = "main.jsp";
					}else{
						alert("账号或密码错误！");
					}
					
					
				},
				error:function(){
					alert("error");
				}
			});
			return false; 
		});
			
		
			
		
			</script>

	</body>
</html>