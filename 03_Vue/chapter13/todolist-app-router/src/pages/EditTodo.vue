<template>
  <div class="row">
    <div class="col p-3">
      <h2>할 일 추가</h2>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <div class="form-group">
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
        <textarea class="form-control" id="desc" v-model="todoItem.desc">
        </textarea>
        <div class="form-group">
          <label htmlFor="done">완료 여부 : </label>&nbsp;
          <input type="checkbox" v-model="todoItem.done" />
        </div>
        <div class="form-group">
          <button
            type="button"
            class="btn btn-primary m-1"
            @click="updateTodoHandler"
          >
            수정
          </button>
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
import { useRouter, useRoute } from 'vue-router';

const todoList = inject('todoList');
const { updateTodo } = inject('actions');
const router = useRouter();
const currentRoute = useRoute();

const matchedTodoItem = todoList.value.find(
  (item) => item.id === currentRoute.params.id
);
// 업데이트 할 대상을 찾지 못했을 경우 전체 목록 페이지로 돌아감
if (!matchedTodoItem) {
  router.push('/todos');
}
const todoItem = reactive({ ...matchedTodoItem });

const updateTodoHandler = () => {
  let { todo } = todoItem;
  if (!todo || todo.trim() === '') {
    alert('할 일은 반드시 입력해야 합니다');
    return;
  }
  // 업데이트 한 후, 전체 목록으로 돌아가기
  updateTodo({ ...todoItem }, () => {
    // console.log('updateTodo');
    router.push('/todos');
  });
};
</script>
