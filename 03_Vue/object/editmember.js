let human = {
  name: '김상형',
  age: 29,
};
//human 객체에 salary 속성 추가
human.salary = 520;
//hman 객체에 age 속성 삭제
delete human.age;

console.log(`${human.name}의 월급 : ${human.salary}`);
// human.age가 delete되었기때문에 undefined가 출력
console.log(`${human.age}의 나이 : ${human.age}`);
