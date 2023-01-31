function openProfile(fid, mid) {
	let url = 'profile?fid=' + fid + '&mid=' + mid;
	let title = '프로필 보기';
	let option = 'top=40%, left=40%, width=800px, height=800px';
	window.open(url, title, option);
}

function modalClose() {
	var modal = document.getElementById('wantFModal');
	modal.style.display = 'none';
}

function changeInfo() {
	var id = document.getElementById('id').value;
	var nickname = document.getElementById('nickname').value;
	var password = document.getElementById('password').value;
	var introduce = document.getElementById('introduce').value;
	
	location.href='changeInfo?nickname=' + nickname + '&password=' + password + '&id=' + id + '&introduce=' + introduce;
}

function isPwd() {
	var chkpwd = document.getElementById('chkpwd').value
	var password = document.getElementById('roompwd');
	var roompwdinput = document.getElementById('roompwdinput')
	
	if (chkpwd == '없음') {
		roompwdinput.innerHTML = '';
	} else if (chkpwd == '있음') {
		roompwdinput.innerHTML = '<input type="password" id="roompwd" placeholder="비밀번호를 입력해주세요" name="roomPassword">';
	}
	
}

function addTodo() {
	var todo = document.getElementById('todo').value;
	var id = document.getElementById('id').value;
	
	$.ajax({
		type: 'POST',
		url: 'addTodo',
		data: {
			todo : todo,
			id : id
		},
		success: res => {
			console.log('요청 성공: ', res);
		},
		error: e => {
			console.log('요청 실패: ', e);
		}
	});	
	
}

function roomView(roomHost) {

	location.href='roomView?id=' + roomHost;
}

function findRoom() {
	document.getElementById('roomList').style.display = 'block'
}