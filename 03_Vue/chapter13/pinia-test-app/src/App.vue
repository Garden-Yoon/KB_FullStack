<template>
  <div>
    <h2>TodoList 테스트 (Composition API)</h2>
    <hr />
    할 일 추가 :
    <input type="text" v-model="todo" />
    <button @click="addTodoHandler">추가</button>
    <hr />
    <ul>
      <li v-for="todoItem in todoList">
        <span stule="cursor: pointer" @click="toggleDone(todoItem.id)"
          >{{ todoItem.todo }} {{ todoItem.done ? '(완료)' : '' }}</span
        >
        &nbsp;&nbsp;&nbsp;
        <button @click="deleteTodo(todoItem.id)">삭제</button>
      </li>
    </ul>
    <!-- 스토어의 doneCount에 접근해서 계산된 속성으로 만들어줌 -->
    <div>완료된 할일 수 : {{ doneCount }}</div>
  </div>
</template>

<script setup>
import { useTodoListStore } from '@/stores/todoList';
import { ref, computed } from 'vue';
// 값형데이터기 때문에 ref로 반응성 추가
const todo = ref('');

const todoListStore = useTodoListStore();
// 분해 할당으로 스토어 내에서 리턴한 데이터를 직접 가져옴
const { todoList, addTodo, deleteTodo, toggleDone } = todoListStore;

// 분해할당으로 받아오지 않은 값은 스토어명으로 접근해야 함
const doneCount = computed(() => todoListStore.doneCount);

const addTodoHandler = () => {
  // ref 데이터 접근 시에는 무조건 value로 접근
  addTodo(todo.value);
  // 추가적인 기능이 있을 때는 새로 핸들러를 만들어줌
  todo.value = '';
};
</script>
