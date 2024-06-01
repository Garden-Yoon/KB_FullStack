// Es6 모듈 내보내기 방식 : export 키워드 사용
// export default : export 뒤에 default를 붙이면 하나만 내보낼 수 있다.
const goodbye = (name) => {
  console.log(`${name}님 안녕히가세요`);
};

export default goodbye;
