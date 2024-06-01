// 비동기 방식 : 순서대로가 아닌, 급한 순으로 처리해준다.
// 만약 B 실행 후 C가 실행되어야한다면, 콜백함수를 넣어준다.
function displayA() {
  console.log('A');
}

// 콜백함수를 이용하면 원하는대로 순서를 보장할 수 있다.
// 하지만 콜백함수를 계속 쓰면 콜백 지옥에 빠질 수 있다
// -> 그래서 promise, asink/await를 쓴다
function displayB(callback) {
  setTimeout(() => {
    // 두줄일때는 중괄호 생략 못한다. (한줄일때만 생략 가능)
    console.log('B');
    callback();
  }, 2000);
}

function displayC() {
  console.log('C');
}

displayA();
displayB(displayC);
