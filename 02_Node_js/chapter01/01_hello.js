const c = require('ansi-colors');

function hello(name) {
  // console.log(`${name}님, 안녕하세요?`);
  console.log(name + '님, 안녕하세요? ');

  // 이름을 초록색으로 출력하기 (터미널에서만 적용)
  // console.log(`${c.green(name)}님, 안녕하세요?`);
  console.log(c.green(name) + '님, 안녕하세요? ');
}
hello('윤정원');

// npm uninstall 패키지명 : 설치한 package를 삭제
