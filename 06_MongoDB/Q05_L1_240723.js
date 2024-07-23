// 다음 형태의 문서 20,000건을 추가하세요
//num: 순번 (0부터 시작), name: '스마트폰 ' + 순번
use test;

// 삭제
db.products.remove({});

for(let i=0; i<20000; i++) {
    db.products.insert({num:i, name: '스마트폰'+i});
}


//product 컬렉션의 전체 문서 수를 출력하세요
db.products.count();


//product 컬렉션의 문서를 num의 내림차순으로 정렬하여 출력하세요.
// sort로 문서 정렬 가능 (mySQL의 order by와 같다)
// sort({키값 : 오름차순(1) / 내림차순(-1)})
db.products.find().sort({'num':-1})



//product 컬렉션의 문서를 num의 내림 차순으로 정렬하여 상위 10건을 출력하세요.
//limit(추출할 데이터 갯수) : 데이터를 원하는 개수만큼만 출력해준다
// 메소드체이닝의 순서는 중요하지 않다
db.products.find()
.sort({'num':-1})
.limit(10);


//product 컬렉션의 문서를 num의 내림 차순으로 정렬한 상태에서 다음을 처리하세요.
// 한 페이지당 10건 출력, 6페이지에 해당하는 문서 출력
// skip : 건너뛸 데이터의 개수, 페이지네이션에 주로 사용
// skip할 페이징 공식 : (페이지 쪽수 -1) * 한 페이지에 보여줄 데이터 개수
db.products.find()
.sort({'num':-1})
.limit(10)
.skip(5*10);


// product 컬렉션에서 num이 15미만 이거나 19995 초과인 것을 출력하세요.
// $or : 배열 중 하나라도 True라면 일치
// $lt : 미만, $gt : 초과
db.products.find(
    {'$or':[
        {num:{'$lt':15}},
        {num:{'$gt':1995}}
        ]
    }
)


// product 컬렉션에서 name이 '스마트폰 10', '스마트폰 100', '스마트폰 1000' 중에 하나이면 출력하세요.
//$in : 어떤 인수든 하나라도 해당 배열에 있으면 검색됨
db.products.find({
    'name': {
        $in: ['스마트폰10', '스마트폰100', '스마트폰1000']
    }
})


// product 컬렉션에서 num이 5보다 작은 문서를 출력하는데, name만 출력하세요. (_id 출력하면 안됨)
// find()의 두번째 파라미터 : 해당 컬럼에 0을 주면 해당 데이터는 제외하고 보여준다. 1을 주면 해당 데이터를 포함해서 보여준다
db.products.find(
 {num:{'$lt':5}}, {name:1, _id:0}
)