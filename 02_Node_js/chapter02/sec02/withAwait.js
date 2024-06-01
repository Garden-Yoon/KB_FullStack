// fetch('https://jsonplaceholder.typicode.com/users')
//   .then((response) => response.json())
//   .then((data) => console.log(data))
//   .catch((err) => console.log(err));

//async를 쓰면 일반함수처럼 쓸 수 있다
async function init() {
  // try catch가 한 세트
  try {
    // 요청이 성공했을 때 작동
    // 나중에 실행하는 애(순서보장) 앞에 await 붙여준다
    const response = await fetch('https://jsonplaceholder.typicode.com/users');
    //위의꺼를 user에 대입
    const users = await response.json();
    console.log(users);
  } catch (err) {
    // 요청이 실패했을 때 작동
    console.error(err);
  }
}

init();
