// 상수형 변수에 객체 할당
// const는 상수 값으로, 메모리 주소 변경이 불가능
const p1 = { name: 'John', age: 20 };
// 객체의 속성값 변경
p1.age = 22;
// 객체 출력
// 메모리 주소는 그대로이지만 안의 값이 변경되는 것은 가능
console.log(p1);

// 상수형 변수에 할당된 객체 자체를 변경 시도
// 직접 p1을 변경하면 메모리 주소가 변경되기 때문에 오류 발생
p1 = { name: 'lee', age: 25 };
