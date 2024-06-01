//lodash를 쓰기 위해서는 위에서 패키지를 가져와야함
// require 함수 이용해서 lodash 패키지 가져오기
let _ = require('lodash');

// 기존 배열 복사의 문제점
// : 참조형이기때문에 생긴다

let arr1 = [1, 2, 3];
let arr2 = arr1;

arr2[1] = 4;

console.log(`arr1: ${arr1}`);
console.log(`arr2: ${arr2}`);

// 얕은 복사
// 전개 연산자 사용 : ... (내부데이터들을 펼쳐준다)
let shallow1 = ['a', 'b', 'c'];
let shallow2 = [...shallow1];

shallow2[1] = 4;

console.log(`shallow : ${shallow1}`);
console.log(`shallow: ${shallow2}`);

// 하지만 참조형 데이터 안에 또다른 참조형 데이터가 있다면?
let shallow3 = ['a', 'b', ['가', '나', '다']];
let shallow4 = [...shallow3];
// 배열안에 배열있는거니까 두번 접근해서 변경
shallow3[2][0] = '변경';
console.log(`shallow 3: ${shallow3}`);
console.log(`shallow 4: ${shallow4}`);

// 깊은 복사: 제일 안전한 방법
// npm i lodash 로 설치
// lodash의 cloneDeep 함수 사용
// 내부를 순환하면서 모든 데이터들을 값으로 복사해준다
let deep1 = ['a', 'b', ['가', '나', '다']];
let deep2 = _.cloneDeep(deep1);

shallow3[2][0] = '변경';
console.log(`deep1 : ${deep1}`);
console.log(`deep2: ${deep2}`);
