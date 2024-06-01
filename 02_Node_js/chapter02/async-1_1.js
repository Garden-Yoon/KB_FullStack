// 비동기 방식 : 순서대로가 아닌, 급한 순으로 처리해준다.
function displayA() {
  console.log('A');
}

function displayB() {
  //파라미터가 0개일때는 괄호 생략 불가
  setTimeout(() => {
    console.log('B');
  }, 2000);
}

function displayC() {
  console.log('C');
}

displayA();
displayB();
displayC();
