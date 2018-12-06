<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>纯音后台</title>
<meta name="description" content="这是纯音后台页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="assets/css/admin.css">
    <link rel="stylesheet" href="assets/css/app.css">
    <link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="assets/js/echarts.min.js"></script>
    <script type="text/javascript" src="static/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body data-type="index">


	<!-- 头部导航条 -->
    <header class="am-topbar am-topbar-inverse admin-header">
        <div class="am-topbar-brand">
            <a href="javascript:;" class="tpl-logo">
                <img src="assets/img/logo.png" alt="">
            </a>
        </div>
        <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

        </div>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

        <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

            <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
              
              
                <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen" class="tpl-header-list-link"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    	<!-- 		用户名显示		 -->
                        <span id="right_account" class="tpl-header-list-user-nick">123</span>
                        <span class="tpl-header-list-user-ico"> <img src="assets/img/user01.png"></span>
                    </a>
                    <ul class="am-dropdown-content">
                        <li id="out"><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
                    </ul>
                </li>
                
            </ul>
        </div>
    </header>



<div class="row" >

	
<div class="col-md-2">
	<!-- 左部导航条 -->
    <div class="tpl-page-container tpl-page-header-fixed">
        <div class="tpl-left-nav tpl-left-nav-hover">
        
        
            <div class="tpl-left-nav-title">
                ······
            </div>
            <div class="tpl-left-nav-list">
                <ul class="tpl-left-nav-menu">
                    <li class="tpl-left-nav-item">
                        <a href="indextest.jsp" class="nav-link active" target="mainframe">
                            <i class="am-icon-home"></i>
                            <span>首页</span>
                        </a>
                    </li>
                    

                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-table"></i>
                            <span>歌曲</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                                <a href="song_list.jsp?#" target="mainframe">
                                    <i class="am-icon-angle-right"></i>
                                    <span>所有歌曲</span>
                                    <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                                </a>

                                <a href="song_upload.jsp" target="mainframe">
                                    <i class="am-icon-angle-right"></i>
                                    <span>上传歌曲</span>
                                    <i class="tpl-left-nav-content tpl-badge-success">
						               18
						             </i>



                            </li>
                        </ul>
                    </li>
                    
                    <!-- 歌手管理 -->
					<li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-wpforms"></i>
                            <span>作曲人</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu" style="display: block;">
                            <li>
                                <a href="composer_list.jsp?#" target="mainframe">
                                    <i class="am-icon-angle-right"></i>
                                    <span>所有作曲人</span>
                                    <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                                </a>

                                
                            </li>
                        </ul>
                    </li>
                    
					<!-- 用户管理 -->
					<li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-wpforms"></i>
                            <span>用户</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu" style="display: block;">
                            <li>
                                <a href="user_list.jsp?#" target="mainframe">
                                    <i class="am-icon-angle-right"></i>
                                    <span>所有用户</span>
                                    <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                                </a>

                                
                            </li>
                        </ul>
                    </li>

						<!-- 评论管理 -->
                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-wpforms"></i>
                            <span>评论</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu" style="display: block;">
                            <li>
                                <a href="song_comments_list.jsp"  target="mainframe">
                                    <i class="am-icon-angle-right"></i>
                                    <span>歌曲评论</span>
                                    <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                                </a>

                                <a href="sheet_comments_list.jsp"  target="mainframe">
                                    <i class="am-icon-angle-right"></i>
                                    <span>歌单评论</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    
                   <!--  管理员账号管理 -->
                    <li id="adminManager" class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-wpforms"></i>
                            <span>管理员</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu" style="display: block;">
                            <li>
                                <a href="admin_list.jsp?#"  target="mainframe">
                                    <i class="am-icon-angle-right"></i>
                                    <span>管理员账号</span>
                                    <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                                </a>

                                
                            </li>
                        </ul>
                    </li>

                    
                </ul>
            </div>
        </div>
	</div>
</div>
	<div class="col-md-10">
		<!-- main右下角分页 -->
        <iframe align="right" name="mainframe" width="100%" height="100%" scrolling="no" src="indextest.jsp" frameborder="0" onload="javascript:resizeIframe(this);"></iframe>
	</div>

</div>
    
    
    
   
    <script src="static/js/cookie.js"></script>
    <script type="text/javascript">
    /* $(function(){
    	var account = getCookie("account");
    	var id = getCookie("id");
    	if(account==null || account==""){
    		alert("请先登录！");
    		window.location.href = "login.jsp";
    	}else{
    		//为右上角用户名赋值
    		document.getElementById("right_account").innerText = account;
    		
    		//隐藏管理员管理li
    		document.getElementById("adminManager").style.display="none";
    		if(id==1){
    			document.getElementById("adminManager").style.display="";
    		}
    		
    		
    	}
    }); */
    
    
    function resizeIframe(obj) {
	    obj.style.height = obj.contentWindow.document.body.scrollHeight + 'px';
	  }
    
    $("#out").click(function(){
    	delCookie("account");
    	delCookie("id");
    	window.location.href="login.jsp";
    });
    </script>
    <script src="assets/js/app.js"></script>
    <script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/iscroll.js"></script>
</body>
</html>