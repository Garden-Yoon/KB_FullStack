let obj1 = { name: '박문수', age: 29 };
let obj2 = obj1; // obj1 객체의 주소를 복사
let obj3 = { ...obj1 }; // obj1 객체의 값을 복사
let obj4 = { ...obj1, email: 'mspark@gmail.com' }; //

obj2.age = 19;
// obj1과 obj2는 같은 주소를 가리키고 있기 때문에 값이 같이 변경된다.
console.log(obj1);
console.log(obj2);
//object3은 값만 복사했기 때문에 같이 변경되지 않는다.
console.log(obj3);
console.log(obj1 == obj2); // 같은 주소기 때문에 true
console.log(obj1 == obj3); // 다른 주소기 때문에 false

let arr1 = [100, 200, 300];
// 전개 연산자를 통해 원하는 값을 중간에 삽입 가능
let arr2 = ['hello', ...arr1, 'world'];
console.log(arr1);
console.log(arr2);

// 퀴즈
function Person(name, gender, age, address, job) {
  (this.name = name),
    (this.gender = gender),
    (this.age = age),
    (this.address = address),
    (this.job = job);
}
Person.prototype.printInfo = function () {
  return `${this.name}의 성별은 ${this.gender}이며 ${this.age}세 입니다.
주소는 ${this.address}이며 직업은 ${this.job}입니다.`;
};

let person = new Person('yura', 'f', 15, 'sky', 'angel');

console.log(person.printInfo());
