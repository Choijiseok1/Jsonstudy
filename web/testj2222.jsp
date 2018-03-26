<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jquery로 </title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#test1").click(function(){
	//컨트롤러로  서비스 요청하고, 결과로 문자열을 받을 경우.
	//첫번째, jquery.get("요청url",{전달이름:전달값},return받아서 처리할 콜백함수명,"리턴받는 값의 자료형");
		$.get("test1.do",function(date){
			$("#p1").text(date)	
			});

	});
	//두번째, jquery.ajax();를 사용하는 방법.
	$("#test2").click(function(){
		$.ajax({
		url:"test1.do",
		type:"get",
		success:function(date){
			$("#p2").text($("#p2").text()+date)
		    }
		})
			
	});	
	//jquery.get()와 사용가능하.
	$("#test3").click(function(){
		$.get("test2.do",{ id:$('#id').val(), pw:$("#pw").val()
			},
			function(date){
			$("#p3").text($("#p3").text()+date)
		})
	})	
	// jquery.ajax()둘다 사용가능하.
	$("#test4").click(function(){
		$.ajax({
			url:"test2.do",
			data:{ id:$('#id1').val(), pw:$("#pw1").val() },
			type:"get",
			success:function(date){
				$("#p4").text($("#p4").text()+date)
			}
		})
	})
	$("#test5").click(function(){
		//post 방식의 전송시에는 jquery.post 와 jquery.ajax 두가지중 선택.
		//$.post()사용.
		$.post("test3.do",{title:$("#title").val(),writer:$("#writer").val(),content:$("#content").val()})
		
	})
	$("#test6").click(function(){
		//post 방식의 전송시에는 jquery.post 와 jquery.ajax 두가지중 선택.
		//$.ajax()사용.
		$.ajax({
		url:"test3.do",
		data:{title:$("#title1").val(),writer:$("#writer1").val(),content:$("#content1").val()},
		type:"post"
		})
	
		
	})
	$("#test7").click(function(){
		$.getJSON("test4.do", {no : "12"}, function(data){
			//data 는 한 개의 json 객체임
		console.log(typeof(data) + "\n" + data);
		$("#p5").text(data.userid+","+data.userpwd+","+decodeURIComponent(data.username)+","+data.age+","+data.email+","+data.phone)	
			
		});
		
	})
	$("#test8").click(function(){
		$.ajax({
			url:"test4.do",
			data:{no:"77"},
			type:"get",
			dataType:"json",
			success: function(data){
				$("#p6").html($("#p6").text()+"<Br>"+data.userid+","+data.userpwd+","+decodeURIComponent(data.username)+","+data.age+","+data.email+","+data.phone)
			}
			
			
		})
	})
	$("#test9").click(function(){
		//get방식 일경우, $get.json 과 $ajax()
		//post방식일 경우 $ajax()만 사용가능함.
		
		//get.json사용
		$.getJSON("test5.do",{no:"33"},function(data){
			
		})
		//$.ajax사용
		$.ajax({
			url:"test5.do",
			data:{nl:"55"},
			type:"get",
			dataType:"json",
			success:function(data){
				
			}
			
		})
		
	})
	
});
</script>
</head>
<body>
<h1>test jquery Ajax</h1>
<h2> 1. 서버로 보내는 값은 없고 결과로 문자열을 받아서 출력하는 방법. : get 방식</h2>
<p id="p1" style="width:300px;height:50px;border: 1px solid red;"></p>
<button id="test1">테스트1</button><br>
<hr>
<h2> 2. 서버로 보내는 값은 없고 결과로 문자열을 받아서 출력하는 방법. : ajax 방식</h2>
<p id="p2" style="width:300px;height:50px;border: 1px solid red;"></p>
<button id="test2">테스트2</button><br>
<hr>
<h2> 3. 서버로 보내는 값은 있다. 결과로 문자열을 받아서 출력하는 방법. : get 방식</h2>
아이디:<input type="text" id="id"><br>
비  번:<input type="password" id="pw"><br>
<p id="p3" style="width:300px;height:50px;border: 1px solid red;"></p>
<button id="test3">테스트3</button><br>
<hr>
<h2> 4. 서버로 보내는 값은 있다. 결과로 문자열을 받아서 출력하는 방법. : ajax 방식</h2>
아이디:<input type="text" id="id1"><br>
비  번:<input type="password" id="pw1"><br>
<p id="p4" style="width:300px;height:50px;border: 1px solid red;"></p>
<button id="test4">테스트4</button><br>
<hr>
<h2> 5. 서버로 값을 전송하지만 결과를 받지는 않음. : post 방식</h2>
제목:<input type="text" id="title"><br>
작성자:<input type="text" id="writer"><br>
내용:<textarea rows="5" cols="50" id="content"></textarea><br>
<button id="test5">테스트5</button><br>
<h2> 6. 서버로 값을 전송하지만 결과를 받지는 않음. : post 방식</h2>
제목:<input type="text" id="title1"><br>
작성자:<input type="text" id="writer1"><br>
내용:<textarea rows="5" cols="50" id="content1"></textarea><br>
<button id="test6">테스트6</button><br>
<h2> 7. 서버로 값없이 요청만 하고 서버에서 결과로 보낸 json객체를 받아서 출력함. : json 방식</h2>
<p id="p5" style="width:300px;height:50px;border: 1px solid red;"></p>
<button id="test7">테스트7</button><br>
<h2> 7. 서버로 값없이 요청만 하고 서버에서 결과로 보낸 ajax로. : ajax 방식</h2>
<p id="p6" style="width:300px;height:50px;border: 1px solid red;"></p>
<button id="test8">테스트8</button><br>
<hr>
<h2> 8. 서버로 요청하고, 결과나 리스트나 맵을 제이슨배열로 바꿔 전송</h2>
<p id="p7" style="width:300px;height:50px;border: 1px solid red;"></p>
<button id="test9">테스트9</button><br>
</body>
</html>