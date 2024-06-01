// 파라미터 받아올 때 바로 구조 분해 할당 후 받아옴
function addContact1({ name, phone, email = '이메일없음', age = 0 }) {
  console.log(name, phone, email, age);
}
addContact1({ name: '이몽룡', phone: '010-3434-8989' });

function addContact2(contact) {
  // 기본 파라미터를 넣어주는 대신 해당 값이 있는지 체크 후 속성 추가
  if (!contact.email) contact.email = '이메일 없음';
  if (!contact.age) contact.age = 0;
  // contact 변수에서 구조분해할당
  let { name, phone, email, age } = contact;
  console.log(name, phone, email, age);
}
addContact2({ name: '이몽룡', phone: '010-3434-8989' });

// 객체로 안받고 파라미터 4개로 쪼개서 받아옴
function addContact3(name, phone, email = '이메일없음', age = 0) {
  console.log(name, phone, email, age);
}
addContact3('이몽룡', '010-3434-8989');
