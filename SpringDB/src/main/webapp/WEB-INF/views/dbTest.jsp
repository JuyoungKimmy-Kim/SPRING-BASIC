<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>DB Test (using JSON)</h1>
	<button id="btnEmpDetail">Emp 상세</button>
	<button id="btnEmpList">Emp 목록</button>
	<br>
	<button id="btnEmpInsert">Emp 등록</button>
	<button id="btnEmpUpdate">Emp 수정</button>
	<button id="btnEmpDelete">Emp 삭제</button>
	
	
	<script>
		window.onload = function() {
			document.querySelector("#btnEmpDetail").onclick = async function() {
				try {
					let response = await fetch("/mydb/empDetail/1501");
					let data = await response.json();
					console.log(data);
				} catch(error) {
					console.log(error);
				}
			}
			
			document.querySelector("#btnEmpList").onclick = async function() {
				try {
					let response = await fetch("/mydb/empList");
					let data = await response.json();
					console.log(data);
				} catch(error) {
					console.log(error);
				}
			}
			
			// 자바스크립트 객체
			var empInsertData = {
					employeeId: 1600,
					firstName: '길동',
					lastName: '유',
					email: "you@gildong.com",
					hireDate: '2022-10-20'
			}
			
			document.querySelector("#btnEmpInsert").onclick = async function() {
				let urlParams = new URLSearchParams(empInsertData);
				let fetchOptions = {
						method: 'POST',
						body: urlParams
				}
				try {
					let response = await fetch("/mydb/empInsert", fetchOptions);
					let data = await response.json();
					console.log(data);
				} catch(error) {
					console.log(error);
				}
			}
			
			// 자바스크립트 객체
			var empUpdateData = {
					employeeId: 1600,
					firstName: '재석',
					lastName: '유',
					email: "you@jae.com",
					hireDate: '2022-10-20'
			}
			document.querySelector("#btnEmpUpdate").onclick = async function() {
				let urlParams = new URLSearchParams(empUpdateData);
				let fetchOptions = {
						method: 'POST',
						body: urlParams
				}
				try {
					let response = await fetch("/mydb/empUpdate", fetchOptions);
					let data = await response.json();
					console.log(data);
				} catch(error) {
					console.log(error);
				}
			}
			
			document.querySelector("#btnEmpDelete").onclick = async function() {
		
				try {
					let response = await fetch("/mydb/empDelete/1501");
					let data = await response.json();
					console.log(data);
				} catch(error) {
					console.log(error);
				}
			}
		}
	</script>
</body>
</html>