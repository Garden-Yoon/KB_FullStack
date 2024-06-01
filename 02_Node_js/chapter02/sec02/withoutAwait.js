fetch('https://jsonplaceholder.typicode.com/users')
  //요청이 성공했을 때 받아온 데이터를 json 으로 변경
  .then((response) => response.json())
  //바꾼걸 콘솔창에 출력한다
  .then((data) => console.log(data))
  //에러 발생시에 띄워라
  .catch((err) => console.log(err));
