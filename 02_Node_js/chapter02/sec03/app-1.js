// user.js에서 user 가져오기
const user = require('./user');

// hello.js에서 hello 가져오기
const hello = require('./hello');

console.log(user);
console.log(hello);

//hello 를 실행하면서 user가 안에 나온다.
hello(user);
