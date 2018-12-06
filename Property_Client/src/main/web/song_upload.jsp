<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传歌曲</title>
<meta name="description" content="上传歌曲">
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
    
</head>
<body data-type="generalComponents">



        <div>
            <div class="tpl-content-page-title">
                	上传歌曲
            </div>
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">歌曲</a></li>
                <li class="am-active">上传歌曲</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 上传歌曲
                    </div>
                    <div class="tpl-portlet-input tpl-fz-ml">
                        <div class="portlet-input input-small input-inline">
                            <div class="input-icon right">
                                <i class="am-icon-search"></i>
                                <input type="text" class="form-control form-control-solid" placeholder="搜索..."> </div>
                        </div>
                    </div>


                </div>
                <div class="tpl-block ">
                    <div class="am-g tpl-amazeui-form">
                        <div class="am-u-sm-12 am-u-md-9">
                        
                            <form id="song_upload_table" class="am-form am-form-horizontal">
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">歌名</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" name="songName" placeholder="输入歌名">
                                        <small>响亮的名字</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">作曲人</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" name="composerName" placeholder="输入作曲人">
                                        <small>优秀的作者</small>
                                    </div>
                                </div>
                                
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">类别</label>
                                    <div class="am-u-sm-9">
                                        <select id="class_box" name="className">
                                        	<option value="1">安静</option>
											<option value="2">浪漫</option>
											<option value="3">伤感</option>
											<option value="4">治愈</option>
											<option value="5">放松</option>
											<option value="6">孤独</option>
											<option value="7">感动</option>
											<option value="8">兴奋</option>
											<option value="9">快乐</option>
											<option value="10">思念</option>
											<option value="11">清新</option>
                                        </select>
                                    </div>
                                </div>
								
								<div class="am-form-group">
                                    <label for="user_issue_date" class="am-u-sm-3 am-form-label">发布时间</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" name="songIssueDate" placeholder="输入发行日期">
                                        <small>出生的日子</small>
                                    </div>
                                </div>
								
                                <div class="am-form-group">
                                    <label for="user-phone" class="am-u-sm-3 am-form-label">歌曲链接</label>
                                    <div class="am-u-sm-9">
                                        <input onchange="set_song_time();" id="song_url" type="text" name="songUrl" placeholder="输入歌曲链接">
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-QQ" class="am-u-sm-3 am-form-label">封面连接</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" name="songImageUrl" placeholder="输入封面连接">
                                    </div>
                                </div>

   

                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button type="button" id="add_music" class="am-btn am-btn-primary">上传歌曲</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>



	<audio id="music" controls="controls" >
	
	</audio><span id="music_prompt"></span>

            </div>




        </div>

   
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/app.js"></script> 
    <script src="static/js/song_upload.js"></script>
</body>
</html>