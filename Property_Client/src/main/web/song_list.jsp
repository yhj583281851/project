<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>歌曲列表</title>
<meta name="description" content="这是一个 index 页面">
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
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    
    <script type="text/javascript" src="static/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="static/js/DateUtils.js"></script>
</head>

<body data-type="generalComponents">

<!-- -----------------------   模态框--------------------------------- -->

<!-- UpdateModal -->
	<div class="modal fade" id="update_modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改歌曲信息</h4>
				</div>
				<div class="modal-body">
				<audio id="music" controls="controls"></audio>
					<form>
						<div class="form-group">
							<label for="exampleInputEmail1">歌名</label> <input type="text"
								class="form-control" id="update_song_name" name="songName"
								placeholder="请输入歌名"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">演唱者</label> <input type="text"
								class="form-control" id="update_song_composername" name="composerName"
								placeholder="请输入演唱者"> <span class="help-block"></span>
						</div>
						
						<div class="form-group">
							<label for="exampleInputPassword1">歌曲地址</label> <input onchange="urlchange()" type="text"
								class="form-control" id="update_song_url" name="songUrl"
								placeholder="请输入歌曲地址"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">图片地址</label> <input type="text"
								class="form-control" id="update_song_imageurl" name="songImageUrl"
								placeholder="请输入图片地址"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">发布时间</label> <input type="date"
								class="form-control" id="update_song_issuedate" name="songIssueDate"
								placeholder="请输入发布时间"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">热度</label> <input type="text"
								class="form-control" id="update_song_hits" name="songHits"
								placeholder="请输入热度"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">类型</label> <input type="text"
								class="form-control" id="update_class_id" name="classId"
								placeholder="请输入类型"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">作者号</label> <input type="text"
								class="form-control" id="update_composer_id" name="composerId"
								placeholder="请输入作者号"> <span class="help-block"></span>
						</div>

					</form>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						id="user_update_btn">保存</button>
				</div>
			</div>
		</div>
</div>


<!-- -----------------------   模态框--------------------------------- -->

    

        <div>
            <div class="tpl-content-page-title">
                	所有歌曲
            </div>
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">歌曲</a></li>
                <li class="am-active">歌曲列表</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 歌曲列表
                    </div>
                    


                </div>
                <div class="tpl-block">
                    <div class="am-g">
                        <div class="am-u-sm-12 am-u-md-6">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" class="am-btn am-btn-default am-btn-success add_btn"><span class="am-icon-plus"></span> 新增</button>
                                    <button type="button" id="song_delete_all_btn" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button>
                                </div>
                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-form-group">
                                <select id="select_box" onchange="classchange();" data-am-selected="{btnSize: 'sm'}">
					              <option value="0">所有类别</option>
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
                        
                        <!-- 查询功能 -->
                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-input-group am-input-group-sm">
                                <input id="song_select" type="text" class="am-form-field">
                                <span class="am-input-group-btn">
            <button id="song_select_btn" class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="button"></button>
          </span>
                            </div>
                        </div>
                    </div>
                    <div class="am-g">
                        <div class="am-u-sm-12">
                            <form class="am-form">
                                <table id="song_table" class="am-table am-table-striped am-table-hover table-main">
                                    <thead>
                                        <tr>
                                            <th class="table-check">
                                            <input type="checkbox" id="check_all" class="tpl-table-fz-check"></th>
                                            <th class="table-id">ID</th>
                                            <th class="table-title">歌曲名称</th>
                                            <th class="table-title">演唱者</th>
                                            <th class="table-title">时长</th>
                                            <th class="table-title">发布时间</th>
                                            <th class="table-title">热度</th>
                                            <th class="table-title">类型</th>
                                            <th class="table-title">作者</th>
                                            <th class="table-set">操作</th>
                                            <th class="table-set">评论</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        	<!-- 在song_list.js中显示 -->
                                    </tbody>
                                </table>
                                <div class="am-cf">

                                    <div class="am-fr">
                                       <div id="page_nav" class="am-fr"></div>
                                    </div>
                                </div>
                                <hr>

                            </form>
                        </div>

                    </div>
                </div>
                <div class="tpl-alert"></div>
                
            </div>










        </div>

    </div>

	

    
    <!-- static/js/ -->
        <script src="static/js/cookie.js"></script>
    <script src="static/js/song_list.js"></script>
    
</body>
</html>