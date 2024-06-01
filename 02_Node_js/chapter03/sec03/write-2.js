fs = require('fs');

// ./가 현재 플젝이 열린 폴더가 됨 -> Node_JS 폴더가 현재폴더
// writeFileSync : 동기로 파일 쓰기
const data = fs.readFileSync('./chapter03/sec03/example.txt');

// fs.existsSync : 해당 타입이 존재하는지 여부를 boolean으로 반환
if (fs.existsSync('./chapter03/sec03/text-1.txt')) {
  console.log('file already exists');
} else {
  fs.writeFileSync('./chapter03/sec03/text-1.txt', data);
}
