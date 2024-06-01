let p = new Promise((resolve, reject) => {
  resolve('first');
});

p.then((msg) => {
  console.log(msg); // First
  //throw는 에러를 강제로 발생시킨다
  //   throw new Error('## 에러');
  return 'second';
})
  // 그 전에 return된 값을 이엇 ㅓ받음
  .then((msg) => {
    console.log(msg);
    return 'third'; //second
  })
  .then((msg) => {
    console.log(msg); //third
  })
  .catch((error) => {
    console.log('오류 발생 ==>' + error);
  });
