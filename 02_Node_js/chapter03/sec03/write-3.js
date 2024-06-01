fs = require('fs');

// ./가 현재 플젝이 열린 폴더가 됨 -> Node_JS 폴더가 현재폴더
// writeFile : 비동기로 파일 쓰기
const data = fs.readFile(
  './chapter03/sec03/example.txt',
  'utf-8',
  (err, data) => {
    if (err) {
      console.log(err);
      return;
    }

    fs.writeFile('./chapter03/sec03/text-2.txt', data, (error) => {
      if (err) {
        console.log(err);
        return;
      }
      console.log('text-2.txt is saved!');
    });
  }
);
