<template>
  <div class="row">
    <div class="col p-3">
      <h2>할 일 추가</h2>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <div class="form-group">
        <!-- 요소의 id값과 연결해준다 -->
        <label htmlFor="todo">할 일 :</label>
        <input
          type="text"
          class="form-control"
          id="todo"
          v-model="todoItem.todo"
        />
      </div>
      <div class="form-group">
        <label htmlFor="desc">설명 :</label>
        <textarea
          class="form-control"
          id="desc"
          v-model="todoItem.desc"
        ></textarea>
        <!-- 버튼 클릭 시 이 핸들러 동작 -->
        <div class="form-group">
          <button
            type="button"
            class="btn btn-primary m-1"
            @click="addTodoHandler"
          >
            추가
          </button>
          <!-- 취소 버튼 클릭 시 목록으로 돌아감 -->
          <button
            type="button"
            class="btn btn-primary m-1"
            @click="router.push('/todos')"
          >
            취소
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { inject, reactive } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

// App.vue에서 provide로 가져온 함수
const { addTodo } = inject('actions');
const todoItem = reactive({ todo: '', desc: '' });

// 넣어준 정보를 가지고 목록의 맨 뒤에 추가해줌
const addTodoHandler = () => {
  let { todo } = todoItem;
  // 아이템의 할 일 값이 비어있으면 경고창 출력
  if (!todo || todo.trim() === '') {
    alert('할 일은 반드시 입력해야 합니다');
    // 리턴을 만나면 함수 종료
    return;
  }
  addTodo({ ...todoItem });
  router.push('/todos');
};
</script>
