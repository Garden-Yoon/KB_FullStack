//fs 모듈 사용
const fs = require('fs');

// fs.readdir : 비동기로 폴더를 읽어온다
// 콜백(err, files)이 들어간다
fs.readdir('./', (err, files) => {
  // 조건문으로 에러가 있는 경우를 확인한다
  if (err) {
    console.log(err);
    // return을 만나면 함수 종료
    return;
  }
  console.log(files);
});
