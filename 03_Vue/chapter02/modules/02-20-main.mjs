// export default 로 가져올 수 있는 것은 1개
// export default로 가져오는건 이름을 무엇으로 넣든 상관 X,
// export 로 가져오는 것은 이름 그대로 가져와야함

// import, export 키워드를 사용하기 위해서는
// 1) 확장자를 mjs로 사용하거나
// 2) package.json에 "type : module" 설정 추가할 것
import getBase, { add } from './02-20-module.mjs';

console.log(add(4));
// default 키워드로 가져온 함수는 이름을 마음대로 지정 가능
console.log(getBase());
