//데이터베이스를 tutorial로 선정하세요
use tutorial;

// users 컬렉션에 username이 smith인 문서를 저장하세요
//db 는현재 사용 중인 데이터베이스를 설정한 전역 변수
//insert() : 문서 삽입
db.users.insert({username:"smith"});
db.users.insert({username:"jones"});

//앞에서 저장한 모든 문서를 출력하세요
//find() : 문서 추출, 파라미터 없을 시엔 전체 출력, mySQL의 select문과 비슷
db.users.find();

//앞에서 저장한 문서 중 하나만 출력하세요
// findOne() : 해당하는 문서 중 하나만 출력
db.users.findOne();

//users 컬렉션에서 username이 "jones"인 문서를 찾아서 출력
//find() 내에 조건을 넣어주면 해당 조건의 문서만 출력된다
db.users.find({username:"jones"});

//users 컬렉션에서 username이 "jones" 또는 "smith"인 문서를 찾아서 출력하세요
//%or 조건 검사 : 객체 배열로 여러개의 조건을 묶어준다
//두가지 조건 중 하나만 만족해도 출력된다
db.users.find({$or:[
    {username:"smith"},
    {username:"jones"}
    ]});

//users 컬렉션에서 username이 smith인 문서에 country키가 Canada가 되도록 수정하세요
//update(찾을 문서 조건, 변경할 문서)
//이외의 파라미터는 생략 가능, 생략하면 default 값이 들어간다
//$set : 문서의 한 부분만 수정, 만약 값이 없으면 추가한다
db.users.update({username:"smith"}, {$set: {country:"Canada"}});
    
// 앞의 문서가 올바르게 수정되었는지 확인하세요
db.users.find({username:"smith"});


// users 컬렉션에서 username이 smith인 문자를 {country:"Cananda"}로 대체하고 확인
// $set이 없으면 문서 전체를 변경할 문서로 덮어씌운다
// MongoInvalidArgumentError 에러 발생 : 업데이트 연산자 힐요
//db.users.update({username:"smith"}, {country:"Canada"});


// users 컬렉션에서 username이 smith인 문서에서 country 키를 삭제하고 , 삭제 여부를 확인
//$unset : 해당하는 키값을 삭제
db.users.update({username:"smith"}, {$unset: {country:1}});
db.users.find({username:"smith"})

//데이터베이스 전체 목록을 출력
show dbs;

//현재 사용중인 데이터베이스의 컬렉션 목록을 출력
show collections;

//현재 사용중인 데이터베이스와 users 컬렉션의 상태를 출력하세요
//stats() : 상태 보는 메소드
db.stats();

//users 컬렉션애서 username이 smith인 문서를 삭제하고, 삭제여부를 확인하세요
//remove() : 조건에 해당하는 문서를 삭제, 기본적으로 조건에 해당하는 문서를 모두 삭제해줌
db.users.remove({username:"smith"});
db.users.find({username:"smith"});

//users 컬렉션의 모든 문서를 삭제하고, 삭제 여부를 확인하세요
//remove()내에 아무런 조건도 넣지 않으면 모든 문서가 삭제된다
db.users.remove({});
db.users.find();

//users 컬렉션을 삭제하세요
db.users.drop();
    