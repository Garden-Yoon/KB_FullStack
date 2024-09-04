<script setup>
import { useRoute, useRouter } from 'vue-router';
import api from '@/api/boardApi';
import { ref } from 'vue';
import moment from 'moment';
import { useAuthStore } from '@/stores/auth';
import { downloadFile } from '@/util/download';

const auth = useAuthStore();
const cr = useRoute();
const router = useRouter();

// 현재 게시글에서 no 추출
const no = cr.params.no;
const article = ref({});

// 뒤로가기 함수
const back = () => {
  router.push({ name: 'board/list', query: cr.query });
};

// 게시글 수정
const update = () => {
  // 경로이동하며 params도 같이 넘겨준다
  router.push({ name: 'board/update', params: { no: no } });
};

// 게시글 삭제
const remove = async () => {
  if (!confirm('삭제할까요?')) return;
  await api.delete(no);
  router.push({ name: 'board/list' });
};

// 게시글 데이터 불러오기
const load = async () => {
  // 실제 받아온 게시물 저장
  article.value = await api.get(no);
};

// 파일 다운로드 함수
const download = async (no) => {
  const URL = '/api/board/download/' + no;
  await downloadFile(URL);
};

load();
</script>

<template>
  <h1>{{ article.title }}</h1>
  <div class="my-3 d-flex justify-content-between">
    <div>
      <i class="fa-solid fa-user"></i>
      {{ article.writer }}
    </div>
    <div>
      <i class="fa-regular fa-clock"></i>
      {{ moment(article.updateDate).format('YYYY-MM-DD HH:mm') }}
    </div>
  </div>
  <hr />
  <!-- 첨부 파일 목록 -->
  <div class="text-end">
    <!-- 게시글에 있는 첨부파일을 BoardAttachmentVO 형태로 하나씩 가져온다 -->
    <div v-for="file in article.attaches" :key="file.no" class="attach">
      <span @click="download(file.no)">
        <i class="fa-solid fa-paperclip"></i>
        {{ file.filename }}
      </span>
    </div>
  </div>
  <div class="content">{{ article.content }}</div>
  <div class="my-5">
    <button class="btn btn-primary me-2" @click="back"><i class="fa-solid fa-list"></i> 목록</button>
    <!-- 로그인 사용자와 작성자가 같은 경우에만 수정, 삭제 버튼 표시 -->
    <template v-if="auth.username == article.writer">
      <button class="btn btn-primary me-2" @click="update"><i class="fa-regular fa-pen-to-square"></i> 수정</button>
      <button class="btn btn-danger" @click="remove"><i class="fa-solid fa-trash-can"></i> 삭제</button>
    </template>
  </div>
</template>

<style scoped>
.attach {
  font-size: 0.8rem;
  cursor: pointer;
}

.content {
  /* 입력한 엔터를 그대로 출력시켜주겠다 */
  white-space: pre-line;
}
</style>
