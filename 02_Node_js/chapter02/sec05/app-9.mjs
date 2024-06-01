// Es6 모듈 가져오기 방식 : import 키워드 사용
// from 뒤에는 가져올 파일 경로 명시
// import * as : 모듈에서 가져올 것이 많은 경우, as 뒤의 이름의 객체로 묶는다
import * as say from './greeting-1.mjs';

say.hi('윤정원');
say.goodbye('윤정원');
