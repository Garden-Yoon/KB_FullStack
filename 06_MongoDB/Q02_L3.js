//numbers 컬렉션에 20,000개의 문서를 생성하세요
//num이 key고, i가 value인 문서 20,000개 생성
for(let i=0; i<20000; i++) {
    db.numbers.insert({num:i});
}

//numbers 컬렉션의 문서 개수를 출력하세요
//count로 컬렉션의 개수 출력 가능
db.numbers.count();