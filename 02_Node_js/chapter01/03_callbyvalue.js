function swap(x, y) {
  let temp = x;
  x = y;
  y = temp;
  // 함수안에서는 적용이 잘 된다
  console.log(`swap 함수 안 -> a : ${x}, ${y}`);
}

let a = 100;
let b = 200;

// 호출 전
console.log(`swap 호출 전 -> a : ${a}, ${b}`);

// 호출 후
swap(a, b);
// 값만 복사되기 때문에 100, 200이 변경없이 그대로 출력된다
console.log(`swap 호출 후 -> a : ${a}, ${b}`);
