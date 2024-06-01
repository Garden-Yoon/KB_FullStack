// Es6 모듈 가져오기 방식 : import 키워드 사용
// from 뒤에는 가져올 파일 경로 명시
// import as : 가져온 함수 및 변수를 원하는 이름으로 사용 가능

import { hi as hello, goodbye as bye } from './greeting-1.mjs';

hello('윤정원');
bye('윤정원');
