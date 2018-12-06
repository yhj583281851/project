var pageNum;//当前页数
var total;//总页数

//启动加载函数
$(function(){
	
	to_page(1);
	to_page(1);
	 

});

//跳转至第几页
function to_page(pn){
	$.ajax({
		url:"http://localhost:8080/ChunYinBackGround/selectOnePageAdmin",
		data:"pn="+pn,
		type:"post",
		dataType:"jsonp",
		success:function(datas){
			build_admin_table(datas);
			build_admin_info(datas);
			build_admin_nav(datas);
		},
		error:function(){
			
		}
	});
}

//动态创建展示列表
function build_admin_table(datas){
	$("#admin_table tbody").empty();
	
	var list = datas.data.pageInfo.list;
	
	$.each(list,function(index,admin){
		var checkbox = $("<td><input type='checkbox' class='check_item'/></td>");
		var adminId = $("<td></td>").append(admin.adminId);
		var adminAccount = $("<td></td>").append(admin.adminAccount);
		var adminPassword = $("<td></td>").append(admin.adminPassword);
		var adminName = $("<td></td>").append(admin.adminName);
		//var editBtn = $("<button class='am-btn am-btn-default am-btn-xs am-text-secondary' data-toggle='modal' data-target='#update_modal'><span class='am-icon-pencil-square-o'></span> 编辑</button>");
		var editBtn = $("<button class='am-btn am-btn-default am-btn-xs am-text-secondary edit_btn'><span class='am-icon-pencil-square-o'></span> 编辑</button>");
		
		var deleteBtn = $("<button class='am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only delete_btn'><span class='am-icon-trash-o'></span> 删除</button>");
		//为编辑和删除按钮设置id
		
		
		editBtn.attr("edit_id",admin.adminId);
		deleteBtn.attr("delete_id",admin.adminId);
		
		
		var Btn = $("<td><div class='am-btn-toolbar'><div class='am-btn-group am-btn-group-xs'></div></div></td>").append(editBtn).append(deleteBtn);
		$("<tr></tr>").append(checkbox).append(adminId).append(adminAccount).append(adminPassword).append(adminName).append(Btn).appendTo("#admin_table");
	});
}

//解析展示分页信息
function build_admin_info(datas){
	pageNum = datas.data.pageInfo.pageNum;
	pages = datas.data.pageInfo.pages;
	
}

//上下页码
function build_admin_nav(datas){
	$("#page_nav").empty();
	
	var ul = $("<ul></ul>").addClass("am-pagination tpl-pagination");
	//首页
	var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
	//上一页
	var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href", "#"));
	ul.append(firstPageLi);
	ul.append(prePageLi);
	//判断首页和上一页是否可用
	if(datas.data.pageInfo.hasPreviousPage == false){
		firstPageLi.addClass("am-disabled");
		prePageLi.addClass("am-disabled");
	}else{
		firstPageLi.click(function(){
			to_page(1);
		});
		prePageLi.click(function(){
			to_page(datas.data.pageInfo.pageNum-1);
		});
	}
	
	//循环输出1、2、3、4、5、6页
	$.each(datas.data.pageInfo.navigatepageNums,function(index,item){
		var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href","#"));
		ul.append(numLi);
		if(datas.data.pageInfo.pageNum == item){
			numLi.addClass("am-active");
		}
		numLi.click(function(){
			to_page(item);
		});
	});
	
	//尾页
	var lastPageLi = $("<li></li>").append($("<a></a>").append("尾页").attr("href","#"));
	//下一页
	var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href", "#"));
	ul.append(nextPageLi);
	ul.append(lastPageLi);
	//判断尾页和下一页是否可用
	if(datas.data.pageInfo.hasNextPage == false){
		lastPageLi.addClass("am-disabled");
		nextPageLi.addClass("am-disabled");
	}else{
		lastPageLi.click(function(){
			to_page(datas.data.pageInfo.pages);
		});
		nextPageLi.click(function(){
			to_page(datas.data.pageInfo.pageNum+1);
		});
	}
	
	ul.appendTo("#page_nav");
	
}

//根据id查询管理员信息并再update_modal模态框赋值
function select_admin_by_id(id){
	$.ajax({
		url:"http://localhost:8080/ChunYinBackGround/selectAdminById",
		type:"post",
		data:"id="+id,
		dataType:"jsonp",
		success:function(datas){
			var admin = datas.data.Admin;
			$("#update_admin_account").val(admin.adminAccount);
			$("#update_admin_password").val(admin.adminPassword);
			$("#update_admin_name").val(admin.adminName);
		},
		error:function(){
			alert("发生错误，无法根据id查询管理员账号信息");
		}
	});
}

//管理员账号编辑按钮
$(document).on("click",".edit_btn",function(){
	select_admin_by_id($(this).attr("edit_id"));
	$("#admin_update_btn").attr("edit_id",$(this).attr("edit_id"));
	$("#update_modal").modal({
		backdrop : "static"
	});
	
});

//编辑提交按钮
$("#admin_update_btn").click(function(){
	var id = $(this).attr("edit_id");
	var serialize = $("#update_modal form").serialize()
	//解决序列化中文乱码问题
	serialize = decodeURIComponent(serialize,true);
	var string = "adminId="+id+"&"+serialize;
	$.ajax({
		url:"http://localhost:8080/ChunYinBackGround/updateAdminInformation",
		data:string,
		type:"post",
		dataType:"jsonp",
		success:function(datas){
			if(datas.code == 100){
				$("#update_modal").modal("hide");
				to_page(pageNum);
			}else{
			}
			to_page(pageNum);
		},
		error:function(){
			alert("提交失败！["+string+"]");
		}
	});
});

//管理员账号删除按钮
$(document).on("click",".delete_btn",function(){
	var id = $(this).attr("delete_id");
	var name = $(this).parents("tr").find("td:eq(2)").text();
	if(confirm("确定要删除("+id+")"+name+"吗？")){
		$.ajax({
			url:"http://localhost:8080/ChunYinBackGround/deleteAdminById",
			data:"id="+id,
			type:"post",
			dataType:"jsonp",
			success:function(){
				to_page(pageNum);
			},
			error:function(){
				
			}
		});
	}
});

//批量删除
$("#admin_delete_all_btn").click(function(){
	var ids = "";
	var names = "";
	
	//循环取出checkbox名字
	$.each($(".check_item:checked"),function(index,item){
		ids += $(this).parents("tr").find("td:eq(1)").text() + "-";
		names += $(this).parents("tr").find("td:eq(2)").text() + ",";
	});
	ids = ids.substring(0,ids.length-1);
	names = names.substring(0,names.length-1);
	
	if(confirm("你确定要删除"+names+"吗？")){
		$.ajax({
			url:"http://localhost:8080/ChunYinBackGround/deleteAdminByCheckBox",
			type:"post",
			data:"ids="+ids,
			success:function(){
				to_page(pageNum);
			},
			error:function(){
				
			}
		});
	}

});

//外部增加按钮
$("#admin_insert_btn").click(function(){
	var account = $("#insert_admin_account").val();
	var flag = checkAdminAccount(account);
	//检验账号是否重复
	if(flag == 0){
		//已经存在
		alert("该用户名 "+account+" 已经存在！");
	}
	else{
		$.ajax({
			url:"http://localhost:8080/ChunYinBackGround/insertAdmin",
			type:"post",
			data:$("#insert_modal form").serialize(),
			dataType:"jsonp",
			success:function(datas){		
					$("#insert_modal").modal("hide");
					//页面跳转存在问题
					if(pages % 5 == 0){
						to_page(pages + 1);
					}else{
						to_page(pages);
					}			
			},
			error:function(){
				alert("添加出错");
			}
		});
	}
	
	
});

//添加账号，检查账号是否重复
function checkAdminAccount(account){
	var flag = 1;
	$.ajax({
		url:"http://localhost:8080/ChunYinBackGround/checkAdminAccount",
		type:"post",
		data:"account="+account,
		dataType:"jsonp",
		async: false,
		success:function(datas){
				if(datas.code == 100){
					//可以使用，返回1
					flag = 1;
				}
				else if(datas.code == 200){
					flag = 0;
				}
		},
		error:function(){
			alert("检验用户名出错");
		}
	});
	return flag;
};