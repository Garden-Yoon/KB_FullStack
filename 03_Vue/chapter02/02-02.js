// 전역 변수 선언 : msg 변수에 'GLOBAL'
let msg = 'GLOBAL';
// 함수 선언
function outer() {
  // 지역 변수 선언 : msg 변수에 'OUTER'
  // scope 내에서 가장 가까이 있는 변수 값을 먼저 찾는다.
  // 같은 scope 내에 변수가 없으면 더 넓은 스코프로 이동
  let msg = 'OUTER'; // OUTER 출력됨
  // 콘솔 로그에 변수 출력
  console.log(msg);
  // 항상 수행되는 조건문
  if (true) {
    // 지역 변수 선언 : msg 변수에 'BLOCK'
    let msg = 'BLOCK'; //BLOCK 출력됨
    console.log(msg);
  }
}
// 함수 호출
outer();
