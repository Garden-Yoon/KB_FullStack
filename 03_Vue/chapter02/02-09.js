const test1 = function (a, b) {
  return a + b;
};

// 기존 함수에서 function 키워드 생략하고 화살표 삽입
const test2 = (a, b) => {
  return a + b;
};

// return 키워드와 중괄호도 생략
const test3 = (a, b) => a + b;

console.log(test1(3, 4));
console.log(test2(3, 4));
console.log(test3(3, 4));
