// 객체로 넘겨줬으니 객체로 받아와야함 (구조 분해 할당)
// 값 두 개를 받아올 때는 객체 구조 분해 할당을 통해 받아온다
const { user1, user2 } = require('./users-1');
const hello = require('./hello');

// console.log(user1, user2)
// user1과 user2는 변수이기때문에 따옴표로 넣으면 안된다
hello(user1);
hello(user2);
