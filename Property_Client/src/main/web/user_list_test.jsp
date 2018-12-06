<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<meta name="description" content="这是一个 index 页面">
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
    <script type="text/javascript" src="static/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script src="static/layui/layui.js"></script>

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
					<h4 class="modal-title" id="myModalLabel">修改用户信息</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="exampleInputEmail1">账号</label> <input type="text"
								class="form-control" id="insert_name" name="name"
								placeholder="请输入账号"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">密码</label> <input type="text"
								class="form-control" id="insert_password" name="password"
								placeholder="请输入密码"> <span class="help-block"></span>
						</div>

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						id="people_insert_btn">添加</button>
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
					<h4 class="modal-title" id="myModalLabel">添加用户</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="exampleInputEmail1">账号</label> <input type="text"
								class="form-control" id="insert_user_account" name="userAccount"
								placeholder="请输入账号"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">密码</label> <input type="text"
								class="form-control" id="insert_user_password" name="userPassword"
								placeholder="请输入密码"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">姓名</label> <input type="text"
								class="form-control" id="insert_user_name" name="userName"
								placeholder="请输入姓名"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">性别</label> <input type="text"
								class="form-control" id="insert_user_sex" name="userSex"
								placeholder="请输入性别"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">邮箱</label> <input type="text"
								class="form-control" id="insert_user_email" name="userEmail"
								placeholder="请输入邮箱地址"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">简介</label> <input type="text"
								class="form-control" id="insert_user_introduction" name="userIntroduction"
								placeholder="请输入个人介绍"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">电话</label> <input type="text"
								class="form-control" id="insert_user_phone" name="userPhone"
								placeholder="请输入电话号码"> <span class="help-block"></span>
						</div>
						

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						id="user_insert_btn">添加</button>
				</div>
			</div>
		</div>
</div>

<!-- -----------------------   模态框--------------------------------- -->


        <div>
            <div class="tpl-content-page-title">
                	所有用户
            </div>
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">用户</a></li>
                <li class="am-active">用户列表</li>
            </ol>
            <div >
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 用户列表
                    </div>
                    <div class="tpl-portlet-input tpl-fz-ml">
                        <div class="portlet-input input-small input-inline">
                            <div class="input-icon right">
                                <i class="am-icon-search"></i>
                                <input type="text" class="form-control form-control-solid" placeholder="搜索..."> </div>
                        </div>
                    </div>


                </div>
                <div class="tpl-block">
                    <div class="am-g">
                        <div class="am-u-sm-12 am-u-md-6">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" class="am-btn am-btn-default am-btn-success add_btn" data-toggle="modal" data-target="#insert_modal"><span class="am-icon-plus"></span> 新增</button>
                                    <button type="button" class="am-btn am-btn-default am-btn-secondary"><span class="am-icon-save"></span> 保存</button>
                                    <button type="button" class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 审核</button>
                                    <button id="user_delete_all_btn" type="button" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button>
                                </div>
                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-form-group">
                                <select data-am-selected="{btnSize: 'sm'}">
              <option value="option1">所有类别</option>
              <option value="option2">IT业界</option>
              <option value="option3">数码产品</option>
              <option value="option3">笔记本电脑</option>
              <option value="option3">平板电脑</option>
              <option value="option3">只能手机</option>
              <option value="option3">超极本</option>
            </select>
                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-input-group am-input-group-sm">
                                <input type="text" class="am-form-field">
                                <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="button"></button>
          </span>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div>
                            <form>
                                <table id="user_table" class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th class="table-check">
                                            <input id="check_all" type="checkbox" class="tpl-table-fz-check"></th>
                                            <th class="table-id">ID</th>
                                            <th class="table-title">账号</th>
                                            <th class="table-title">密码</th>
                                            <th class="table-title">姓名</th>
                                            <th class="table-title">性别</th>
                                            <th class="table-title">邮箱</th>
                                            <th class="table-title">介绍</th>
                                            <th class="table-title">电话</th>
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


    <!-- <script src="assets/js/jquery.min.js"></script> -->
    <!-- <script src="assets/js/amazeui2.min.js"></script> -->
    <!-- <script src="assets/js/app.js"></script> -->
    
    
    <!-- 加载static/js -->
    <script src="static/js/user_list.js"></script>
</body>
</html>