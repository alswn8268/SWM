function alertMsg() {

    let alertMsg1 = document.getElementById('alertMsg1')
    let alertMsg2 = document.getElementById('alertMsg2')
    let alertMsg3 = document.getElementById('alertMsg3')
    let id = document.getElementsByName('id')[0].value.trim()
    let password = document.getElementsByName('password')[0].value.trim()
    let repassword = document.getElementsByName('repassword')[0].value.trim()
    let nickname = document.getElementsByName('nickname')[0].value.trim()

    // 중복된 아이디인지 확인한다.
	$.ajax({
		type: 'POST',
		url: 'idExists',
		data: {
            id: id
		},
		success: res => {
            if (res == 1) {
                alertMsg1.innerHTML = '중복된 아이디입니다.'
                return false
            } else {
                alertMsg1.innerHTML = ''
            }
		},
		error: e => {
			console.log(e)
		}
	});

    // 비밀번호 일치 여부를 확인한다.
    if (password != repassword) {
        alertMsg2.innerHTML = '비밀번호가 일치하지 않습니다.'
        return false
    } else {

    }
    
	$.ajax({
		type: 'POST',
		url: 'nicknameExists',
		data: {
            nickname: nickname
		},
		success: res => {
            // 중복된 닉네임인지 확인한다.
            if (res == 1) {
                alertMsg3.innerHTML = '중복된 닉네임입니다.'
                return false
            } else {
                alertMsg3.innerHTML = ''
            }
		},
		error: e => {
			console.log(e)
		}
	});

}
