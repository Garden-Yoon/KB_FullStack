// let getTriangle = function (base, height) {
//   return (base * height) / 2;
// };

// 화살표 함수 사용하기 (1)
// let getTriangle =  (base, height) => {
//   return (base * height) / 2;
// };

// 화살표 함수 사용하기 (2)
let getTriangle = (base, height) => (base * height) / 2;

// 객체 : 키와 중괄호를 쓴다. 화살표 함수에는 어떻게 적용?
// => 중괄호 앞에 한번 더 소괄호로 감싸줘야함 (구현부와 차이점을 두기 위해)
let getObject = () => ({ 이름: '정원' });

console.log('삼각형의 면적 : ' + getTriangle(5, 2));
// console.log('이름 : ' + getObject(이름)); => 이거 오류나는디
// 만약 터미널에서 반영이 안된다면 새로운 터미널을 열어보자
