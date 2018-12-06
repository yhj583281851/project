//设置cookie（变量名，变量值，日期（天））
function setCookie(c_name, value, expiredays) {
	var exdate = new Date()
	exdate.setDate(exdate.getDate() + expiredays)
	document.cookie = c_name + "=" + escape(value)
			+ ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString())
}

// 获取cookie（变量名）
function getCookie(c_name) {
	if (document.cookie.length > 0) {
		c_start = document.cookie.indexOf(c_name + "=")
		if (c_start != -1) {
			c_start = c_start + c_name.length + 1
			c_end = document.cookie.indexOf(";", c_start)
			if (c_end == -1)
				c_end = document.cookie.length
			return unescape(document.cookie.substring(c_start, c_end))
		}
	}
	return ""
}

// 检查cookie是否存在
function checkCookie() {
	account = getCookie('account')
	if (username != null && username != "") {
		alert('Welcome again ' + username + '!')
	} else {
		/*
		 * username=prompt('Please enter your name:',"") if (username!=null &&
		 * username!="") { setCookie('username',username,365) }
		 */
		alert("未登录");
	}
}

// 删除cookie
function delCookie(name)
{
var exp = new Date();
exp.setTime(exp.getTime() - 1);
var cval=getCookie(name);
if(cval!=null)
document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}