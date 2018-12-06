<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="description" content="作曲人列表">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="assets/css/admin.css">
    <link rel="stylesheet" href="assets/css/app.css">
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="static/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	

</head>

<body>

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
					<h4 class="modal-title" id="myModalLabel">修改作曲人信息</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="exampleInputEmail1">姓名</label> <input type="text"
								class="form-control" id="update_composer_name" name="composerName"
								placeholder="请输入姓名" onchange="checkUpdateName()"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">性别</label> <input type="text"
								class="form-control" id="update_composer_sex" name="composerSex"
								placeholder="请输入性别"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">图片地址</label> <input type="text"
								class="form-control" id="update_composer_image_url" name="composerImageUrl"
								placeholder="请输入图片地址"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">简介</label> <input type="text"
								class="form-control" id="update_composer_introduction" name="composerIntroduction"
								placeholder="请输入简介"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">出道时间</label> <input type="text"
								class="form-control" id="update_composer_departure_time" name="composerDepartureTime"
								placeholder="请输入出道时间"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">地址</label> <input type="text"
								class="form-control" id="update_composer_address" name="composerAddress"
								placeholder="请输入地址"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">生日</label> <input type="text"
								class="form-control" id="update_composer_birthday" name="composerBirthday"
								placeholder="请输入生日"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">热度</label> <input type="text"
								class="form-control" id="update_composer_hits" name="composerHits"
								placeholder="请输入热度"> <span class="help-block"></span>
						</div>

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						id="composer_update_btn">添加</button>
				</div>
			</div>
		</div>
</div>

<!-- InsertModal -->
	<div class="modal fade" id="insert_modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加作曲人</h4>
				</div>
				<div class="modal-body">
					<form id="insert_modal_form">
						<div class="form-group">
							<label for="exampleInputEmail1">姓名</label> <input type="text"
								class="form-control" id="insert_composer_name" name="composerName"
								placeholder="请输入姓名"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">性别</label> <input type="text"
								class="form-control" id="insert_composer_sex" name="composerSex"
								placeholder="请输入性别"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">图片地址</label> <input type="text"
								class="form-control" id="insert_composer_image_url" name="composerImageUrl"
								placeholder="请输入图片地址"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">简介</label> <input type="text"
								class="form-control" id="insert_composer_introduction" name="composerIntroduction"
								placeholder="请输入生日"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">出道时间</label> <input type="text"
								class="form-control" id="insert_composer_departure_time" name="composerDepartureTime"
								placeholder="请输入出道时间"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">地址</label> <input type="text"
								class="form-control" id="insert_composer_address" name="composerAddress"
								placeholder="请输入地址"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">生日</label> <input type="text"
								class="form-control" id="insert_composer_birthday" name="composerBirthday"
								placeholder="请输入生日"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">热度</label> <input type="text"
								class="form-control" id="insert_composer_hits" name="composerHits"
								placeholder="请输入热度"> <span class="help-block"></span>
						</div>
						

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						id="composer_insert_btn">添加</button>
				</div>
			</div>
		</div>
</div>

<!-- -----------------------   模态框--------------------------------- -->


        <div>
            <div class="tpl-content-page-title">
                	所有作曲人
            </div>
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">作曲人</a></li>
                <li class="am-active">作曲人列表</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 作曲人列表
                    </div>
                 
                </div>
                <div class="tpl-block">
                    <div class="am-g">
                        <div class="am-u-sm-12 am-u-md-6">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" class="am-btn am-btn-default am-btn-success add_btn" data-toggle="modal" data-target="#insert_modal"><span class="am-icon-plus"></span> 新增</button>
                                    <button id="composer_delete_all_btn" type="button" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button>
                                </div>
                            </div>
                        </div>
                        
                        	<!-- 查询按钮 -->
                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-input-group am-input-group-sm">
                                <input type="text" id="composer_select" class="am-form-field">
                                <span class="am-input-group-btn">
            <button id="composer_select_btn" class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="button"></button>
          </span>
                            </div>
                        </div>
                    </div>
                    
                    <div class="am-g">
                        <div class="am-u-sm-12">
                            <form class="am-form">
                                <table id="composer_table" class="am-table am-table-striped am-table-hover table-main">
                                    <thead>
                                        <tr>
                                            <th class="table-check">
                                            <input id="check_all" type="checkbox" class="tpl-table-fz-check"></th>
                                            <th class="table-id">ID</th>
                                            <th class="table-title">姓名</th>
                                            <th class="table-title">性别</th>
                                            <th class="table-title">简介</th>
                                            <th class="table-title">出道时间</th>
                                            <th class="table-title">地址</th>
                                            <th class="table-title">生日</th>
                                            <th class="table-title">热度</th>
                                            <th class="table-set">操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                       <!-- 在js中循环显示 -->
                                       
                                    </tbody>
                                </table>
                                
             					      <!-- 分页 -->
                                <div class="am-cf">
                                	<div id="page_nav" class="am-fr"></div>
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



    
    
    <!-- 加载static/js -->
    <script src="static/js/composer_list.js"></script>
</body>
</html>