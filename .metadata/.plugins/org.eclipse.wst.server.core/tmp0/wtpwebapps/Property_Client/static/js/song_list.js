var pageNum;//当前页数
var pages;//总页数
var type;

//启动加载函数
$(function(){
	type=0;
	to_page(1,type);
	
});

//跳转至第几页
function to_page(pn,type){
	//0代表查询所有，1代表按分类查询
	if(type == 0){
		$.ajax({
			url:"http://localhost:8080/ChunYinBackGround/selectOnePageSong",
			data:"pn="+pn,
			type:"post",
			dataType:"jsonp",
			success:function(datas){
				build_user_table(datas);
				build_user_info(datas);
				build_user_nav(datas);
			},
			error:function(){
				
			}
		});
	}else{
		$.ajax({
			url:"http://localhost:8080/ChunYinBackGround/selectSongByClassAndOrderByHits",
			data:"id="+type,
			type:"post",
			dataType:"jsonp",
			success:function(datas){
				build_user_table(datas);
				build_user_info(datas);
				build_user_nav_class(datas);
			},
			error:function(){
				
			}
		});
	}
}

//动态创建展示列表
function build_user_table(datas){
	$("#song_table tbody").empty();
	
	var list = datas.data.pageInfo.list;
	
	$.each(list,function(index,song){
		var checkbox = $("<td><input type='checkbox' class='check_item'/></td>");
		var songId = $("<td></td>").append(song.songId);
		var songName = $("<td></td>").append(song.songName);
		var composerName = $("<td></td>").append(song.composerName);
		var songTime = $("<td></td>").append(song.songTime);
		var songIssueDate = $("<td></td>").append(song.songIssueDate);
		var songHits = $("<td></td>").append(song.songHits);
		var classId = $("<td></td>").append(song.classId);
		var composerId = $("<td></td>").append(song.composerId);
		
		var editBtn = $("<button class='am-btn am-btn-default am-btn-xs am-text-secondary edit_btn'><span class='am-icon-pencil-square-o'></span> 编辑</button>");
		var deleteBtn = $("<button class='am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only delete_btn'><span class='am-icon-trash-o'></span> 删除</button>");
		var commentsBtn = $("<button onclick='gocomments("+song.songId+")' class='am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only'><span class='am-icon-trash-o'></span> 评论</button>");
		//为编辑和删除按钮设置id
		editBtn.attr("edit_id",song.songId);
		deleteBtn.attr("delete_id",song.songId);
		commentsBtn.attr("song_id",song.songId);
		
		var Btn = $("<td><div class='am-btn-toolbar'><div class='am-btn-group am-btn-group-xs'></div></div></td>").append(editBtn).append(deleteBtn);
		var Btn2 = $("<td><div class='am-btn-toolbar'><div class='am-btn-group am-btn-group-xs'></div></div></td>").append(commentsBtn);
		$("<tr></tr>").append(checkbox).append(songId).append(songName).append(composerName).append(songTime).append(songIssueDate).append(songHits).append(classId).append(composerId).append(Btn).append(Btn2).appendTo("#song_table");
	});
}

//解析展示分页信息
function build_user_info(datas){
	pageNum = datas.data.pageInfo.pageNum;
	pages = datas.data.pageInfo.pages;
}

//上下页码
function build_user_nav(datas){
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
			to_page(1,type);
		});
		prePageLi.click(function(){
			to_page(datas.data.pageInfo.pageNum-1,type);
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
			to_page(item,type);
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
			to_page(datas.data.pageInfo.pages,type);
		});
		nextPageLi.click(function(){
			to_page(datas.data.pageInfo.pageNum+1,type);
		});
	}
	
	ul.appendTo("#page_nav");
	
}

//外部增加按钮
$(".add_btn").click(function(){
	window.location.href="song_upload.jsp";
});

//歌曲删除按钮
$(document).on("click",".delete_btn",function(){
	var id = $(this).attr("delete_id");
	var name = $(this).parents("tr").find("td:eq(2)").text();
	if(confirm("确定要删除("+id+")"+name+"吗？")){
		$.ajax({
			url:"http://localhost:8080/ChunYinBackGround/deleteSongById",
			data:"id="+id,
			type:"post",
			dataType:"jsonp",
			success:function(){
				to_page(pageNum,type);
			},
			error:function(){
				
			}
		});
	}
});

//批量删除
$("#song_delete_all_btn").click(function(){
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
			url:"http://localhost:8080/ChunYinBackGround/deleteSongByCheckBox",
			type:"post",
			data:"ids="+ids,
			success:function(){
				to_page(pageNum,type);
			},
			error:function(){
				
			}
		});
	}

});

//点击评论跳转
function gocomments(songId){
	setCookie("songId",songId);
	window.location.href="song_comments_list.jsp";
	window.event.returnValue=false;
	
}

//查询按钮
$("#song_select_btn").click(function(){
	var string = $("#song_select").val();
	$.ajax({
		url:"http://localhost:8080/ChunYinBackGround/selectSongByName",
		data:"name=" + string,
		type:"post",
		dataType:"jsonp",
		success:function(datas){
			build_user_table(datas);
			build_user_info(datas);
			build_user_nav(datas);
		
		},
		error:function(){
			
		}
	});
});

//根据id查询歌曲信息并再update_modal模态框赋值
function select_song_by_id(id){
	$.ajax({
		url:"http://localhost:8080/ChunYinBackGround/selectSongById",
		type:"post",
		data:"id="+id,
		dataType:"jsonp",
		success:function(datas){
			var song = datas.data.song;
			$("#update_song_name").val(song.songName);
			$("#update_song_composername").val(song.composerName);
			$("#update_song_issuedate").val(song.songIssueDate);
			$("#update_song_url").val(song.songUrl);
			$("#update_song_imageurl").val(song.songImageUrl);
			$("#update_song_hits").val(song.songHits);
			$("#update_class_id").val(song.classId);
			$("#update_composer_id").val(song.composerId);
		},
		error:function(){
			
		}
	});
}

//用户编辑按钮
$(document).on("click",".edit_btn",function(){
	select_song_by_id($(this).attr("edit_id"));
	$("#user_update_btn").attr("edit_id",$(this).attr("edit_id"));
	$("#update_modal").modal({
		backdrop : "static"
	});
	
});

//编辑提交按钮
$("#user_update_btn").click(function(){
	var id = $(this).attr("edit_id");
	var serialize = $("#update_modal form").serialize();
	var songTime = $("#music").attr("songTime");
	//解决序列化中文乱码问题
	serialize = decodeURIComponent(serialize,true);
	var string = "songId="+id+"&"+serialize+"&songTime="+songTime;
	$.ajax({
		url:"http://localhost:8080/ChunYinBackGround/updateSongInfo",
		data:string,
		type:"post",
		dataType:"jsonp",
		success:function(datas){
			if(datas.code == 100){
				$("#update_modal").modal("hide");
				to_page(pageNum,type);
			}else{
			}
			to_page(pageNum,type);
		},
		error:function(){
			alert("提交失败！["+string+"]");
		}
	});
});

//歌曲地址输入onchagne事件
function urlchange(){
	var url = $("#update_song_url").val();
	$("#music").attr("src",url);
	var x = document.getElementById("music");
	x.load();
	x.oncanplay = function(){
		var min = Math.floor(x.duration/60);
		var second = Math.floor(x.duration%60);
		var string = min + ":" + second;
		$("#music").attr("songTime",string);
	}
}

//类型选择
function classchange(){
	var classId = $("#select_box").val();
	type=classId;
	to_page(1,type);
}



//全选按钮
$("#check_all").click(function(){
    $(".check_item").prop("checked",$(this).prop("checked"));
});

//全选状态的判断
$(document).on("click",".check_item",function(){
	var flag = $(".check_item:checked").length == $(".check_item").length;
	$("#check_all").prop("checked",flag);
});