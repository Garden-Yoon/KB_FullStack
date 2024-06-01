function swap(numbers) {
  // numbers 는 함수 안에서만 사용 가능하다
  let temp = numbers[0];
  numbers[0] = numbers[1];
  numbers[1] = temp;
  console.log(`swap 함수 안 -> numbers : ${numbers}`);
}

let arr = [100, 200];

console.log(`swap 호출 전 -> a : ${arr}`);

swap(arr);
// 실제 데이터가 저장되어있는 주소값에 접근해서 변경했기 때문에
// 200, 100이 출력된다.
// 참조 타입(reference)이기 때문에
console.log(`swap 호출 후 -> a : ${arr}`);
