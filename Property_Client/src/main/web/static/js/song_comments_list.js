var pageNum;//当前页数
var total;//总页数
var songId;//查询评论的歌曲id

//启动加载函数
$(function(){
	songId = getCookie("songId");
	to_page(1,songId);

});

//跳转至第几页
function to_page(pn,songId){
	$.ajax({
		url:"http://localhost:8080/ChunYinBackGround/selectSongCommentsBySongId",
		data:"pn="+pn+"&songId="+songId,
		type:"post",
		dataType:"jsonp",
		success:function(datas){
			build_song_comments_table(datas);
			build_song_comments_info(datas);
			build_song_comments_nav(datas);
		},
		error:function(){
			
		}
	});
}

//动态创建展示列表
function build_song_comments_table(datas){
	$("#song_comments_table tbody").empty();
	
	var list = datas.data.pageInfo.list;
	$.each(list,function(index,song_comments){
		var checkbox = $("<td><input type='checkbox' class='check_item'/></td>");
		var userId = $("<td></td>").append(song_comments.userId);
		var commentContent = $("<td></td>").append(song_comments.commentContent);
		var commentTime = $("<td></td>").append(song_comments.commentTime);
		var toUid = $("<td></td>").append(song_comments.toUid);
		var songId = $("<td></td>").append(song_comments.songId);
		var commentId = $("<td></td>").append(song_comments.commentId);
		var deleteBtn = $("<button class='am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only delete_btn'><span class='am-icon-trash-o'></span> 删除</button>");
		//为删除按钮设置id
		
		deleteBtn.attr("delete_id",song_comments.commentId);
		
		
		var Btn = $("<td><div class='am-btn-toolbar'><div class='am-btn-group am-btn-group-xs'></div></div></td>").append(deleteBtn);
		$("<tr></tr>").append(checkbox).append(commentId).append(commentContent).append(userId).append(toUid).append(commentTime).append(songId).append(Btn).appendTo("#song_comments_table");
	});
}

//解析展示分页信息
function build_song_comments_info(datas){
	pageNum = datas.data.pageInfo.pageNum;
	pages = datas.data.pageInfo.pages;
	
}

//上下页码
function build_song_comments_nav(datas){
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
			to_page(1,songId);
		});
		prePageLi.click(function(){
			to_page(datas.data.pageInfo.pageNum-1,songId);
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
			to_page(item,songId);
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
			to_page(datas.data.pageInfo.pages,songId);
		});
		nextPageLi.click(function(){
			to_page(datas.data.pageInfo.pageNum+1,songId);
		});
	}
	
	ul.appendTo("#page_nav");
	
}

//评论删除按钮
$(document).on("click",".delete_btn",function(){
	var commentId = $(this).attr("delete_id");
	var name = $(this).parents("tr").find("td:eq(2)").text();
	if(confirm("确定要删除("+commentId+")"+name+"吗？")){
		$.ajax({
			url:"http://localhost:8080/ChunYinBackGround/deleteSongCommentsByCommentId",
			data:"commentId="+commentId,
			type:"post",
			dataType:"jsonp",
			success:function(){
				to_page(pageNum,songId);
			},
			error:function(){
				
			}
		});
	}
});

//批量删除
$("#song_comments_delete_all_btn").click(function(){
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
			url:"http://localhost:8080/ChunYinBackGround/deleteSongCommentsByCheckBox",
			type:"post",
			data:"ids="+ids,
			success:function(){
				to_page(pageNum,songId);
			},
			error:function(){
				
			}
		});
	}

});

//查询按钮
$("#song_comments_select_btn").click(function(){
	var string = $("#song_comments_select").val();
	songId = string;
	
	$.ajax({
		url:"http://localhost:8080/ChunYinBackGround/selectSongCommentsBySongId",
		data:"songId=" + string,
		type:"post",
		dataType:"jsonp",
		success:function(datas){
			setCookie("songId",datas.data.pageInfo.list[0].songId);
			to_page(1,datas.data.pageInfo.list[0].songId);
		
		},
		error:function(){
			
		}
	});
});


//全选按钮
$("#check_all").click(function(){
    $(".check_item").prop("checked",$(this).prop("checked"));
});

//全选状态的判断
$(document).on("click",".check_item",function(){
	var flag = $(".check_item:checked").length == $(".check_item").length;
	$("#check_all").prop("checked",flag);
});

