<script setup>
import boardApi from '@/api/boardApi';
import { computed, reactive, ref } from 'vue';
import { useAuthStore } from '@/stores/auth';
import { useRoute, useRouter } from 'vue-router';

const auth = useAuthStore();
const router = useRouter();

const cr = useRoute();

const files = ref(null);

// 게시글 데이터를 관리하는 반응형 객체
const article = reactive({
  writer: auth.username,
  title: '',
  files: null,
});

// 글제목이 없으면 제출버튼 비활성화
const disableSubmit = computed(() => !article.title);

const submit = async () => {
  // 팝업 떴을 때 취소 누르면 함수 종료
  if (!confirm('등록할까요?')) return;

  // 파일이 선택된 경우, 게시글 객체에 파일 추가
  if (files.value.files.length > 0) {
    // 첨부파일 선택이 있는 경우, 실제 파일을 꺼낼 때는 ref로 연결한 변수의 value 안의 files 접근
    article.files = files.value.files;
  }

  await boardApi.create(article);
  // 게시글 생성 후 전체 게시글 목록으로 이동
  router.push('/board/list');
};
</script>

<template>
  <h1><i class="fa-regular fa-pen-to-square"></i> 글 작성</h1>
  <form @submit.prevent="submit">
    <div class="mb-3 mt-3">
      <label for="title" class="form-label"> 제목 </label>
      <input type="text" class="form-control" placeholder="제목" id="title" v-model="article.title" />
    </div>
    <!-- 첨부파일 입력 필드 -->
    <div class="mb-3 mt-3">
      <label for="files" class="form-label"> 첨부파일 </label>
      <!-- 다중선택 가능하도록 multiple 처리 -->
      <input type="file" class="form-control" placeholder="첨부파일" id="files" ref="files" multiple />
    </div>
    <div class="mb-3 mt-3">
      <label for="content" class="form-label"> 내용 </label>
      <textarea class="form-control" placeholder="내용" id="content" v-model="article.content" rows="10"></textarea>
    </div>

    <!-- 제출 버튼과 목록으로 이동하는 버튼 -->
    <div class="my-5 text-center">
      <button type="submit" class="btn btn-primary me-3" :disabled="disableSubmit">
        <i class="fa-solid fa-check"></i>
        확인
      </button>

      <router-link class="btn btn-primary" :to="{ name: 'board/list', query: cr.query }">
        <i class="fa-solid fa-list"></i>
        목록
      </router-link>
    </div>
  </form>
</template>
