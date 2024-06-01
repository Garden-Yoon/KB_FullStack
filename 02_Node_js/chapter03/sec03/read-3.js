fs = require('fs');

// ./가 현재 플젝이 열린 폴더가 됨
// 기본 리턴값은 Buffer 객체이므로 인코딩을 해야 제대로 볼 수 있다
// 인코딩 지정 : utf-8
// readFile : 비동기 방식으로 파일을 읽어온다.
fs.readFile('./chapter03/sec03/example.txt', 'utf-8', (err, data) => {
  if (err) {
    console.error(err);
    return;
  }
  console.log(data);
});
