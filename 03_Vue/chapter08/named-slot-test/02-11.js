let obj = { result: 0 };
let result = 0;

obj.add = function (x, y) {
  this.result = x + y;
};

let add2 = obj.add;

console.log(add2 === obj.add);

// obj.add(3, 4);
add2(3, 4);
// console.log(obj);
console.log(result);
