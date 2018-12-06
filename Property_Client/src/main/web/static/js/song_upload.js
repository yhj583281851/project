var classId = 1;//默认类型


//歌曲链接改变事件
function set_song_time(){
	$("#music_prompt").text("");
	var flag = false;
	var url = $("#song_url").val();
	//获取添加歌曲
	var x = document.getElementById("music");
	//src赋值
	$("#music").attr("src",url);
	x.load();
	x.oncanplay = function(){
		flag = true;
		var min = Math.floor(x.duration/60);
		var second = Math.floor(x.duration%60);
		var string = min + ":" + second;
		$("#music").attr("songTime",string);
		$("#music_prompt").text("歌曲链接正常");
		
	} 
}

//添加歌曲点击事件
$("#add_music").click(function(){
	var string = $("#song_upload_table").serialize() + "&songTime="+$("#music").attr("songTime") + "&classId="+classId + "&songHits=0";
	$.ajax({
		url:"http://localhost:8080/ChunYinBackGround/insertSong",
		data:string,
		type:"post",
		dataType:"jsonp",
		success:function(datas){
			alert("添加成功");
			window.location.href="song_list.jsp?#";
		},
		error:function(){
			alert("添加失败,请重新检查歌曲链接！");
		}
	});
});

//类型选择赋值
$("#class_box").change(function(){
	classId = $("#class_box").val();
});