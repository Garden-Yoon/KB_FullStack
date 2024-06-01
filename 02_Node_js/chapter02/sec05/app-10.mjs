// Es6 모듈 가져오기 방식 : import 키워드 사용
// from 뒤에는 가져올 파일 경로 명시
// 객체로 받아온 것을 say로 정의 후 .을 써서 접근
import say from './greeting-2.mjs';

// 안쪽의 변수나 함수를 접근할 때는 .을 써서 접근
say.hi('윤정원');
say.goodbye('윤정원');
