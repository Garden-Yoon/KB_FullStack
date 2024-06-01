<template>
  <div id="app" class="container">
    <div class="card card body bg-light">
      <div class="title">:: Todolist App</div>
    </div>

    <div class="card card-default card-borderless">
      <div class="card-body">
        <InputTodo />
        <TodoList />
      </div>
    </div>
  </div>
</template>

<script>
import TodoList from './components/TodoList.vue'
import InputTodo from './components/InputTodo.vue'

let ts = new Date().getTime()

export defaultP
name: "App",
components : { InputTodo, TodoList},
data(){
  return {
    todoList : [
      {id: ts, todo:"자전거 타기", completed : false}
      {id: ts+1, todo:"공원 산책", completed : false}
      {id: ts+2, todo:"넷플릭스", completed : false}
      {id: ts+3, todo:"원고 집필", completed : false}
    ]
  }
},
methods: {
  addTodo(todo){
    //todo로 받아온 문자열의 길이가 2 이상일 경우에만 todolist 맨끝에 추가
    //push : 리스트으 ㅣ맨 끝에 요소 추가
    if(todo.length >=2) {
      this.todoList.push({id: new Data().getTime(), todo: todo, completed:false});
    }
  },
  deleteTodo(id) {
    // todo list 돌면서 받아온 id와 꺼내온 아이템으 ㅣ아이디가 같을 때 해당 인덱스 반환
    // findIndex : 해당 조건과 만족하는 아이템의 인덱스 반환
    let index = this.todoList.findIndex((item) => id===item.id);
    //splice : index 자리에 있는 1개 삭제 (세번째 인자부터는 추가)

  }
},


// 토글
// true일 때 false, false일땐 true, 무조건 반대값이 들어가도록 ! 붙여줌
토글이란 껐다켰다하는 기능
</script>
