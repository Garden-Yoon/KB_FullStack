let arr1 = [1, 2, 3];
let arr2 = arr1;

arr1[0] = 10;

// 10, 10이 출력됨
console.log(arr1[0], arr2[0]);

arr[1] = 20;

//20 20이 출력됨
console.log(arr1[1], arr2[1]);
