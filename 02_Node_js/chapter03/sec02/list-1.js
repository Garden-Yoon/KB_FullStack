//fs 모듈 사용
const fs = require('fs');

// fs.readdirSync : 동기로 폴더를 읽어온다
let files = fs.readdirSync('./');
console.log(files);
