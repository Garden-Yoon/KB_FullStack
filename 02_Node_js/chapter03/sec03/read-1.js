fs = require('fs');

// ./가 현재 플젝이 열린 폴더가 됨 -> Node_JS 폴더가 현재폴더
// 동기로 파일을 읽어온다
const data = fs.readFileSync('./chapter03/sec03/example.txt');
console.log(data);
