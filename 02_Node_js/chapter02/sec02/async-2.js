// 왜 likePizza에 false를 넣어도 피자주문이 나올까? => if 문 뒤를 중괄호로 묶는 실수를 해서 그랬따...

let likePizza = false;
const pizza = new Promise((resolve, reject) => {
  //if(likePizza === true와 동일한 코드 (true면 생략 가능)
  if (likePizza)
    // resolve : 작업이 성공했을 때 실행되는 함수
    resolve('피자를 주문!');
  // reject : 작업이 실패했을 때 실행되는 함수
  else reject('피자 주문안해');
});

//promise는 뒤에 .을 붙일수있다.
//finally : 실패하든 성공ㄹ하든 실행되는 코드~

// then : 작업이 성공했을 때 실행되는 코드 (resolve 값을 받아옴)
// pizza.then((result) => console.log(result));

// catch : 작업이 실패했을 때 실행되는 코드 (reject 값을 받아옴)
// pizza.catch((err) => console.log(err));

pizza.then((result) => console.log(result)).catch((err) => console.log(err));
